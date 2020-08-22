package me.sunny.rbantichat;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.reflect.FieldAccessException;

import me.sunny.rbantichat.Events.Ad;
import me.sunny.rbantichat.Events.Caps;
import me.sunny.rbantichat.Events.Command;
import me.sunny.rbantichat.Events.Cooldown;
import me.sunny.rbantichat.Events.Swear;
import me.sunny.rbantichat.Events.Toggle;

public class Main extends JavaPlugin {

	ProtocolManager prm;

	public static long currentTime = 0L;
	public static double lastStoppedTime = 0.0D;

	public static void start() {
		currentTime = System.currentTimeMillis();
	}

	public static void stop() {
		lastStoppedTime = (System.currentTimeMillis() - currentTime) / 1000.0D;
		int temp = (int) (lastStoppedTime * 1000.0D);
		lastStoppedTime = temp;
		lastStoppedTime /= 1000.0D;
	}

	public static double getlastStoppedTime() {
		return lastStoppedTime;
	}

	@Override
	public void onEnable() {
		start();
		saveDefaultConfig();
		this.getCommand("RBAntiChat").setExecutor(new Commands());
		this.prm = ProtocolLibrary.getProtocolManager();
		this.prm.addPacketListener((PacketListener) new PacketAdapter(Main.getPlugin(), ListenerPriority.NORMAL,
				new PacketType[] { PacketType.Play.Client.TAB_COMPLETE }) {
			public void onPacketReceiving(PacketEvent event) {
				if (event.getPacketType() == PacketType.Play.Client.TAB_COMPLETE) {
					try {
						if (event.getPlayer().hasPermission("rbantichat.admin") || event.getPlayer().isOp())
							return;
						PacketContainer packet = event.getPacket();
						String message = ((String) packet.getSpecificModifier(String.class).read(0)).toLowerCase();

						if (message.startsWith("/") && !message.contains(" ")) {
							event.setCancelled(true);
						}
					} catch (FieldAccessException e) {

						Main.getPlugin().getLogger().log(Level.SEVERE, "Couldn't access field.", (Throwable) e);
					}
				}
			}
		});
		registerEvents();
		stop();
		Bukkit.getConsoleSender().sendMessage(
				("&8[&cRBAntiChat&8] &aĐã khởi động thành công &f&o[&e&o" + getlastStoppedTime() + "s&f&o]")
						.replace("&", "§"));
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.hasPermission("rbantichat.admin")) {
				p.sendMessage(
						("&8[&cRBAntiChat&8] &aĐã khởi động thành công &f&o[&e&o" + getlastStoppedTime() + "s&f&o]")
								.replace("&", "§"));
				return;
			}
		}

	}

	public static Main getPlugin() {
		return (Main) getPlugin(Main.class);
	}

	public void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new Cooldown(), this);
		this.getServer().getPluginManager().registerEvents(new Swear(), this);
		this.getServer().getPluginManager().registerEvents(new Ad(), this);
		this.getServer().getPluginManager().registerEvents(new Caps(), this);
		this.getServer().getPluginManager().registerEvents(new Toggle(), this);
		this.getServer().getPluginManager().registerEvents(new Command(), this);
	}
}
