package me.sunny.rbantichat;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener {

	Map<Player, Long> getPlayerNeedCooldown = new HashMap<>();

	@EventHandler
	public void cooldownChat(final AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		int c = Main.getPlugin().getConfig().getInt("ChatCoolDown");
		long t = System.currentTimeMillis();
		Long a = (Long) getPlayerNeedCooldown.get(p);
		if (p.hasPermission("rbantichat.admin"))
			return;
		
		if (a != null && !p.isOp()) {
			long b = a.longValue() + c * 1000;
			if (t < b) {
				int f = (int) ((b - t) / 1000L) + 1;
				p.sendMessage(("&8[&cRBAntiChat&8] &aBạn cần đợi &e&o" + f + "s &ađể chat tiếp").replace("&", "§"));
				e.setCancelled(true);
				return;
			}
		}
		getPlayerNeedCooldown.put(p, Long.valueOf(t));
	}

}
