package vn.sunext.chatmanager.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import vn.sunext.chatmanager.ChatManager;

public class Swear implements Listener {

	public BossBar bar;

	@EventHandler
	public void swearChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String m = e.getMessage();
		if (p.hasPermission("rbantichat.admin") || p.isOp())
			return;
		byte b;
		int i;
		String[] arrayOfString;
		for (i = (arrayOfString = m.split(" ")).length, b = 0; b < i;) {
			String word = arrayOfString[b];
			List<String> getChat = ChatManager.getInstance().getConfig().getStringList("Swear.normal");
			List<String> getChat2 = ChatManager.getInstance().getConfig().getStringList("Swear.server");
			if (getChat.contains(word.toLowerCase())) {
				String name = e.getPlayer().getDisplayName();
				String chat = e.getMessage();
				for (Player c : Bukkit.getOnlinePlayers()) {
					if (c.hasPermission("rbantichat.admin")) {
						c.sendMessage(("&8[&cRBAntiChat&8] &e" + name + " &avừa chửi tục &f[&e&o" + chat + "&f]")
								.replace("&", "§"));
					}
				}
				e.setMessage("§cTôi là bê đê");
				EventsManager.onParticles1(p);
				p.sendMessage(("&8[&cRBAntiChat&8] &aĐừng chửi thề bạn ơi!").replace("&", "§"));
				p.sendTitle("§c§o(( Đừng có chửi thề bạn ơi ))", "", 10, 10, 10);
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
						new TextComponent("§c§o(( Đừng có chửi thề bạn ơi ))"));
				new BukkitRunnable() {
					public void run() {
						p.addPotionEffect((new PotionEffect(PotionEffectType.BLINDNESS, 60, 10)));
						p.addPotionEffect((new PotionEffect(PotionEffectType.SLOW, 50, 10)));
					}
				}.runTaskLater(ChatManager.getInstance(), 1L);
				return;
			}
			if (getChat2.contains(word.toLowerCase())) {
				e.setCancelled(true);
				p.sendMessage(
						("&8[&cRBAntiChat&8] &aNếu bạn có ý định chửi server thì out giúp mình!").replace("&", "§"));
				return;
			}
			b++;
		}
	}

}
