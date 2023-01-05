package vn.sunext.chatmanager.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import vn.sunext.chatmanager.ChatManager;

public class ChatBlocked implements Listener {

	@EventHandler
	public void chatBlocked(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (p.hasPermission("rbantichat.admin") || p.isOp())
			return;

		if (!ChatManager.getInstance().getConfig().getBoolean("Chat.is-enabled")) {
			e.setCancelled(true);
			p.sendMessage(("&8[&cRBAntiChat&8] &aChat đang được tắt!").replace("&", "§"));
		}
	}

}
