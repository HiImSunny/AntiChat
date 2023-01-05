package vn.sunext.chatmanager.functions;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import vn.sunext.chatmanager.ChatManager;
import vn.sunext.chatmanager.managers.PathManager;

public class PermissionSystem {

    private final ChatManager plugin = ChatManager.getInstance();

    public Boolean havePermission(CommandSender sender, String permission) {
        if (!(sender instanceof Player)) return true;

        if (sender.isOp() || sender.hasPermission(PathManager.ADMIN_PERMISSION)) return true;

        if (sender.hasPermission(permission))
            return true;

        noPermission(sender);
        return false;
    }

    private void noPermission(CommandSender sender) {
        plugin.getMessageSystem().sendPrefixMessage(sender, "&aBạn không có quyền sử dụng lệnh này!");
    }

}
