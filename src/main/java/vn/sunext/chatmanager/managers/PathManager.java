package vn.sunext.chatmanager.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.chatmanager.ChatManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PathManager {

    private final ChatManager plugin = ChatManager.getInstance();

    public static String PREFIX = "";

    public static String ADMIN_PERMISSION = "";
    public static String RELOAD_PERMISSION = "";
    public static String TOGGLE_CHAT_PERMISSION = "";

    public static Boolean IS_CHAT_ENABLED = false;
    public static Integer CHAT_COOL_DOWN = 0;
    public static Integer CHAT_MAX_CAPS = 0;

    public static List<String> NORMAL_SWEAR = new ArrayList<>();
    public static List<String> SERVER_SWEAR = new ArrayList<>();

    public static List<String> WHITELIST_DOMAIN = new ArrayList<>();

    public static List<String> BLOCKED_COMMANDS = new ArrayList<>();

    public void register() {
        File config_file = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(config_file);

        PREFIX = config.getString("prefix");

        ADMIN_PERMISSION = config.getString("permissions.admin");
        RELOAD_PERMISSION = config.getString("permissions.reload");
        TOGGLE_CHAT_PERMISSION = config.getString("permissions.toggle-chat");

        IS_CHAT_ENABLED = config.getBoolean("chat.is-enabled");
        CHAT_COOL_DOWN = config.getInt("chat.cooldown");
        CHAT_MAX_CAPS = config.getInt("chat.max-caps");

        NORMAL_SWEAR = config.getStringList("swear.normal");
        SERVER_SWEAR = config.getStringList("swear.server");

        WHITELIST_DOMAIN = config.getStringList("domain.whitelist");

        BLOCKED_COMMANDS = config.getStringList("blocked-commands");
    }

}
