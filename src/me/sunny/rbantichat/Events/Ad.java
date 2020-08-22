package me.sunny.rbantichat.Events;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
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
			e.setMessage("§cTôi vừa quảng cáo");
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
		String name = e.getPlayer().getDisplayName();
		if (p.hasPermission("rbantichat.admin") && p.isOp())
			return;
		byte b;
		int i;
		String[] arrayOfString;
		for (i = (arrayOfString = e.getLines()).length, b = 0; b < i;) {
			String word = arrayOfString[b];
			String a = p.getName();
			if (!EventsManager.getChat(p, word.toLowerCase())) {
				Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + a + " add essentials.chat.color");
				if (e.getLine(0).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(0, "§4§l" + EventsManager.randomAnum(15));
					p.sendTitle("§c§o(( Đừng có quảng cáo bạn ơi ))", "", 10, 20, 10);
					Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"sudo " + a + " c:§cTôi vừa quảng cáo sign ở đảo nè!");
				}
				if (e.getLine(1).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(1, "§4§l" + EventsManager.randomAnum(15));
					p.sendTitle("§c§o(( Đừng có quảng cáo bạn ơi ))", "", 10, 20, 10);
					Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"sudo " + a + " c:§cTôi vừa quảng cáo sign ở đảo nè!");
				}
				if (e.getLine(2).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(2, "§4§l" + EventsManager.randomAnum(15));
					p.sendTitle("§c§o(( Đừng có quảng cáo bạn ơi ))", "", 10, 20, 10);
					Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"sudo " + a + " c:§cTôi vừa quảng cáo sign ở đảo nè!");
				}
				if (e.getLine(3).equalsIgnoreCase(word.toLowerCase())) {
					e.setLine(3, "§4§l" + EventsManager.randomAnum(15));
					p.sendTitle("§c§o(( Đừng có quảng cáo bạn ơi ))", "", 10, 20, 10);
					Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"sudo " + a + " c:§cTôi vừa quảng cáo sign ở đảo nè!");
				}
				Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + a + " remove essentials.chat.color");
				for (Player c : Bukkit.getOnlinePlayers()) {
					if (c.hasPermission("rbantichat.admin")) {
						c.sendMessage(("&8[&cRBAntiChat&8] &e" + name + " &avừa quảng cáo trên tấm bảng &e&o[ &a&o"
								+ p.getLocation().getX() + "&f&o/&a&o" + p.getLocation().getY() + "&f&o/&a&o"
								+ p.getLocation().getZ() + " &e&o]").replace("&", "§"));
					}
				}
			}
			b++;
		}
	}

}
