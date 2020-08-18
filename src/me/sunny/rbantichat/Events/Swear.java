package me.sunny.rbantichat.Events;

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

import me.sunny.rbantichat.EventsManager;
import me.sunny.rbantichat.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Swear implements Listener {

	public BossBar bar;

	@EventHandler
	public void swearChat(AsyncPlayerChatEvent e) throws InterruptedException {
		Player p = e.getPlayer();
		if (p.hasPermission("rbantichat.admin") && p.isOp())
			return;
		List<String> getChat = Main.getPlugin().getConfig().getStringList("Swear.normal");
		List<String> getChat2 = Main.getPlugin().getConfig().getStringList("Swear.server");
		for (String gc : getChat) {
			if (e.getMessage().toLowerCase().contains(gc)) {
				e.setCancelled(true);
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
				}.runTaskLater(Main.getPlugin(), 1L);
				String name = e.getPlayer().getDisplayName();
				String chat = e.getMessage();
				for (Player b : Bukkit.getOnlinePlayers()) {
					if (b.hasPermission("rbantichat.admin")) {
						b.sendMessage(("&8[&cRBAntiChat&8] &e" + name + " &avừa chửi tục &f[&e&o" + chat + "&f]")
								.replace("&", "§"));
					}
				}
				return;
			}
		}
		for (String gc : getChat2) {
			if (e.getMessage().toLowerCase().contains(gc)) {
				e.setCancelled(true);
				p.sendMessage(("&8[&cRBAntiChat&8] &aNếu bạn có ý định chửi server thì out giúp mình!").replace("&", "§"));
				return;
			}
		}
	}

}
