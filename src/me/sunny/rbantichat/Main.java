package me.sunny.rbantichat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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
		this.getServer().getPluginManager().registerEvents(new Events(), this);
		stop();
		Bukkit.getConsoleSender().sendMessage(
				("&8[&cRBAntiChat&8] &aĐã khởi động thành công &f&o[&e&o" + getlastStoppedTime() + "s&f&o]")
						.replace("&", "§"));
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.hasPermission("rbantichat.admin")) {
				p.sendMessage(("&8[&cRBAntiChat&8] &aĐã khởi động thành công &f&o[&e&o" + getlastStoppedTime() + "s&f&o]").replace("&", "§"));
				return;
			}
		}
		
	}

	public static Main getPlugin() {
		return (Main) getPlugin(Main.class);
	}

}
