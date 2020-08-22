package me.sunny.rbantichat;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class WarnsManager {

	public static HashMap<Player, Integer> warns = new HashMap<>();
	public static HashMap<UUID, Integer> mute = new HashMap<>();

	public static int addWarn(Player p) {
		int warns = ((Integer) WarnsManager.warns.getOrDefault(p, Integer.valueOf(0))).intValue() + 1;

		WarnsManager.warns.put(p, Integer.valueOf(warns));

		return warns;
	}

	public static void clearWarns(Player p) {
		WarnsManager.warns.clear();
	}

	public static int addMute(UUID p) {
		int mute = ((Integer) WarnsManager.mute.getOrDefault(p, Integer.valueOf(0))).intValue() + 1;

		WarnsManager.mute.put(p, Integer.valueOf(mute));

		return mute;
	}

	public static void clearMute(UUID p) {
		WarnsManager.mute.clear();
	}

	public static int getMute(UUID p) {
		return ((Integer) WarnsManager.mute.getOrDefault(p, Integer.valueOf(0))).intValue();
	}

}
