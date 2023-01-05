package vn.sunext.chatmanager.functions;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class WarningSystem {

	public HashMap<Player, Integer> warningList = new HashMap<>();

	public Integer getWarns(Player p) {
		return warningList.getOrDefault(p, 0);
	}

	public void addWarn(Player p) {
		int warns = warningList.getOrDefault(p, 0) + 1;

		warningList.put(p, warns);
	}

	public void clearWarns(Player p) {
		warningList.clear();
	}

}
