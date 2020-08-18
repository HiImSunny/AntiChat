package me.sunny.rbantichat.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.sunny.rbantichat.Main;

public class Toggle implements Listener {
	
	@EventHandler
	public void toggleChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("rbantichat.admin") && p.isOp()) 
			return;
		if (!Main.getPlugin().getConfig().getBoolean("Chat.is-enabled")) {
			e.setCancelled(true);
			p.sendMessage(("&8[&cRBAntiChat&8] &aChat đang được tắt!").replace("&", "§"));
			return;
		}
	}

}
