package me.sunny.rbantichat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketListener;

import me.sunny.rbantichat.Events.Ad;
import me.sunny.rbantichat.Events.Caps;
import me.sunny.rbantichat.Events.Command;
import me.sunny.rbantichat.Events.Cooldown;
import me.sunny.rbantichat.Events.Swear;
import me.sunny.rbantichat.Events.Toggle;

public class Main extends JavaPlugin {

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
		ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new TabBlocked(Main.getPlugin(), new PacketType[] { PacketType.Play.Client.TAB_COMPLETE }));
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
