package me.sunny.rbantichat;

import org.bukkit.plugin.Plugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class TabBlocked extends PacketAdapter {

	public TabBlocked(Plugin plugin, PacketType... types) {
		super(plugin, types);
	}

	public void onPacketReceiving(PacketEvent e) {
		PacketType packetType = e.getPacketType();

		if (packetType.equals(PacketType.Play.Client.TAB_COMPLETE)) {

			if (e.getPlayer().hasPermission("rbantichat.admin"))
				return;
		          e.setCancelled(true);
		}
	}

}
