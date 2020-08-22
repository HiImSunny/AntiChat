package me.sunny.rbantichat.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import me.sunny.rbantichat.EventsManager;
import me.sunny.rbantichat.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Ad implements Listener {
	

	@EventHandler
	public void adChat(AsyncPlayerChatEvent e) throws InterruptedException {
		Player p = e.getPlayer();
		if (p.hasPermission("rbantichat.admin") || p.isOp())
			return;
		if (!EventsManager.getChat(e.getPlayer(), e.getMessage())) {
			e.setMessage("§cTôi vừa quảng cáo, §d" + EventsManager.randomAnum(7));
			EventsManager.onParticles1(p);
			p.sendMessage(("&8[&cRBAntiChat&8] &aĐừng có quảng cáo bạn ơi!").replace("&", "§"));
			p.sendTitle("§c§o(( Đừng có quảng cáo bạn ơi ))", "", 10, 10, 10);
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c§o(( Đừng có quảng cáo bạn ơi ))"));
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
					b.sendMessage(("&8[&cRBAntiChat&8] &e" + name + " &avừa quảng cáo &f[&e&o" + chat + "&f]")
							.replace("&", "§"));
				}
			}
			return;
		}
	}

	@EventHandler
	public void adSign(SignChangeEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("rbantichat.admin") && p.isOp())
			return;
		byte b;
		int i;
		String[] arrayOfString;
		for (i = (arrayOfString = e.getLines()).length, b = 0; b < i;) {
			String word = arrayOfString[b];
			if (!EventsManager.getChat(p, word.toLowerCase())) {
				if (e.getLine(0).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(0, "§4§l" + EventsManager.randomAnum(15));
				}
				if (e.getLine(1).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(1, "§4§l" + EventsManager.randomAnum(15));
				}
				if (e.getLine(2).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(2, "§4§l" + EventsManager.randomAnum(15));
				}
				if (e.getLine(3).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(3, "§4§l" + EventsManager.randomAnum(15));
				}
			}
			b++;
		}
	}

}
