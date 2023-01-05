package vn.sunext.chatmanager.functions;

import java.util.HashMap;
import java.util.UUID;

public class MuteSystem {

    public HashMap<UUID, Integer> muteList = new HashMap<>();

    public int getMute(UUID p) {
        return muteList.getOrDefault(p, 0);
    }

    public void addMute(UUID p) {
        int mute = muteList.getOrDefault(p, 0) + 1;

        muteList.put(p, mute);
    }

    public void clearMute(UUID p) {
        muteList.clear();
    }

}
