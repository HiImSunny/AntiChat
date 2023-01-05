package vn.sunext.chatmanager.functions;

import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.chatmanager.ChatManager;

import java.io.File;

public class ConfigSystem {

    private final ChatManager plugin = ChatManager.getInstance();

    @SneakyThrows
    public void changeConfigValue(String key, Object value) {
        File config_file = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(config_file);

        config.set(key, value);

        config.save(config_file);

        plugin.getPathManager().register();
    }

}
