package vn.sunext.chatmanager.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import vn.sunext.chatmanager.ChatManager;
import vn.sunext.chatmanager.functions.ColorSystem;
import vn.sunext.chatmanager.functions.ConfigSystem;
import vn.sunext.chatmanager.functions.MessageSystem;
import vn.sunext.chatmanager.functions.PermissionSystem;
import vn.sunext.chatmanager.managers.PathManager;

public class MainCommand implements TabExecutor {

    private final ChatManager plugin = ChatManager.getInstance();

    private final PermissionSystem permissionSystem = plugin.getPermissionSystem();
    private final MessageSystem messageSystem = plugin.getMessageSystem();
    private final ConfigSystem configSystem = plugin.getConfigSystem();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        switch (args.length) {
            case 0:
                sender.sendMessage("");
                messageSystem.sendMessage(sender, "&cAntiChat Recoded &fversion &e" + plugin.getDescription().getVersion());
                messageSystem.sendMessage(sender, "&7&oFrom Sunny With Love");
                sender.sendMessage("");
                break;
            case 1:
                switch (args[0]) {
                    case "help":
                        messageSystem.sendMessage(sender, "&c> &6/rbantichat reload &fDùng để reload lại plugin");
                        messageSystem.sendMessage(sender, "&c> &6/rbantichat toggle &fDùng để tắt / mở chat");
                        break;
                    case "reload":
                        if (permissionSystem.havePermission(sender, PathManager.RELOAD_PERMISSION)) {
                            plugin.getPathManager().register();
                            messageSystem.sendMessage(sender, "&aReload lại config thành công!");
                        }

                        break;
                    case "toggle":
                        if (sender.hasPermission(PathManager.TOGGLE_CHAT_PERMISSION)) {
                            if (PathManager.IS_CHAT_ENABLED) {

                                configSystem.changeConfigValue("chat.is-enabled", false);

                                messageSystem.broadcastMessage("&cChat đã bị tắt!");

                            } else {

                                configSystem.changeConfigValue("chat.is-enabled", true);

                                messageSystem.broadcastMessage("&aChat đã được bật!");

                            }
                            break;
                        }

                        break;
                }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmd, String alias, String[] args) {
        List<String> arguments = new ArrayList<>();

        arguments.add("reload");
        arguments.add("toggle");

        List<String> result = new ArrayList<>();
        if (args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        }
        return null;
    }

}
