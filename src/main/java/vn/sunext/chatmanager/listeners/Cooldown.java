package vn.sunext.chatmanager.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import vn.sunext.chatmanager.ChatManager;
import vn.sunext.chatmanager.functions.WarningSystem;

public class Cooldown implements Listener {

	Map<Player, Long> getPlayerNeedCooldown = new HashMap<>();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void cooldownChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		UUID uuid = p.getUniqueId();
		if (p.hasPermission("rbantichat.admin") || p.isOp())
			return;
		int c = ChatManager.getInstance().getConfig().getInt("ChatCoolDown");
		long t = System.currentTimeMillis();
		Long a = (Long) getPlayerNeedCooldown.get(p);
		if (a != null && !p.isOp()) {
			long b = a.longValue() + c * 1000;
			if (t < b) {
				int f = (int) ((b - t) / 1000L) + 1;
				int warns = WarningSystem.addWarn(p), maxwarns = 3;
				int mute = WarningSystem.getMute(uuid), maxmute = 3;
				p.sendMessage(("&8[&cRBAntiChat&8] &aBạn cần đợi &e&o" + f + "s &ađể chat tiếp").replace("&", "§"));
				p.sendTitle("§c§lĐừng Spam Bạn Ơi!", "§8[ §a" + warns + "/3 §8] §f/ §8[ §e" + mute + "/3 §8]", 10, 20,
						10);
				e.setCancelled(true);
				if (warns >= maxwarns && maxwarns > 0) {
					Bukkit.getScheduler().runTask(ChatManager.getInstance(), () -> {
						String j = p.getName();
						Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
								"kick " + j + " Đừng Spam bạn ơi!");
					});
					WarningSystem.clearWarns(p);
					WarningSystem.addMute(uuid);
				}
				if (mute >= maxmute && maxmute > 0) {
					Bukkit.getScheduler().runTask(ChatManager.getInstance(), () -> {
						String j = p.getName();
						Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
								"tempmute " + j + " 30m Kick 3 lần vẫn cố spam");
					});
					WarningSystem.clearMute(uuid);
				}
				return;
			}
		}
		getPlayerNeedCooldown.put(p, Long.valueOf(t));
	}

}
