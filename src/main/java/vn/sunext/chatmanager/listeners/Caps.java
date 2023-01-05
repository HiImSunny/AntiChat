package vn.sunext.chatmanager.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import vn.sunext.chatmanager.ChatManager;

public class Caps implements Listener {

	int maxcaps = ChatManager.getInstance().getConfig().getInt("Caps.max-caps");

	@EventHandler
	public void onCaps(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("rbantichat.admin") || p.isOp())
			return;
		String m = e.getMessage();
		long caps = countCaps(m);
		if (caps > maxcaps) {
			e.setMessage(m.toLowerCase());
			return;
		}
	}

	public long countCaps(String string) {
		return string.codePoints().filter(c -> (c >= 65 && c <= 90)).count();
	}

}
