package me.sunny.rbantichat;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class Commands implements TabExecutor {

	List<String> arguments = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			cs.sendMessage("");
			cs.sendMessage(("&cRBAntiChat &fversion &e" + Main.getPlugin().getDescription().getVersion()).replace("&", "§"));
			cs.sendMessage(("&7&oFrom Sunny With Love").replace("&", "§"));
			cs.sendMessage("");
			return true;
		}
		if (args[0].equalsIgnoreCase("help")) {
			cs.sendMessage(("&c> &6/rbantichat reload &fDùng để reload lại plugin").replace("&", "§"));
			cs.sendMessage(("&c> &6/rbantichat toggle &fDùng để tắt / mở chat").replace("&", "§"));
		}
		if (args[0].equalsIgnoreCase("reload")) {
			if (cs.hasPermission("rbantichat.admin")) {
				Main.getPlugin().reloadConfig();
				cs.sendMessage(("&8[&cRBAntiChat&8] &aReload lại config thành công!").replace("&", "§"));
				for (Player a : Bukkit.getOnlinePlayers()) {
					if (a.hasPermission("rbantichat.admin")) {
						a.sendMessage(("&8[&cRBAntiChat&8] &aReload lại config thành công &f&o[&e&o"
								+ Main.getlastStoppedTime() + "s&f&o]").replace("&", "§"));
					}
				}
				return true;
			}
			cs.sendMessage(("&8[&cRBAntiChat&8] &aBạn không có quyền sử dụng lệnh này!").replace("&", "§"));
			return true;
		}
		if (args[0].equalsIgnoreCase("toggle")) {
			if (cs.hasPermission("rbantichat.admin")) {
				if (Main.getPlugin().getConfig().getBoolean("Chat.is-enabled")) {
					Main.getPlugin().getConfig().set("Chat.is-enabled", Boolean.valueOf(false));
					Main.getPlugin().saveConfig();
					Bukkit.broadcastMessage(("&8[&cRBAntiChat&8] &aChat đã được tắt!").replace("&", "§"));
					return true;
				} else {
					Main.getPlugin().getConfig().set("Chat.is-enabled", Boolean.valueOf(true));
					Main.getPlugin().saveConfig();
					Bukkit.broadcastMessage(("&8[&cRBAntiChat&8] &aChat đã được bật!").replace("&", "§"));
				}
				return true;
			}
			cs.sendMessage(("&8[&cRBAntiChat&8] &aBạn không có quyền sử dụng lệnh này!").replace("&", "§"));
			return true;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender cs, Command cmd, String alias, String[] args) {
		if (arguments.isEmpty()) {
			arguments.add("reload");
			arguments.add("toggle");
		}
		List<String> result = new ArrayList<String>();
		if (args.length == 1) {
			for (String a : arguments) {
				if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
					result.add(a);
				}
			}
			return result;
		}
		return null;
	}

}
