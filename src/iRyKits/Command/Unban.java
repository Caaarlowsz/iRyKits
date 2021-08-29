package iRyKits.Command;

import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.*;

public class Unban implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (Cmd.getName().equalsIgnoreCase("unban")) {
            if (!Sender.hasPermission("iry.unban")) {
                Sender.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            if (Args.length == 0) {
                Sender.sendMessage("§cUse: /unban <Jogador>");
                return true;
            }
            final OfflinePlayer t = Bukkit.getOfflinePlayer(Args[0]);
            if (!t.isBanned()) {
                Sender.sendMessage("§7O Jogador: §c" + t.getName() + " §7N\u00e3o esta banido!");
                return true;
            }
            if (t.isBanned()) {
                t.setBanned(false);
                Bukkit.broadcastMessage("§7O Jogador: §c" + t.getName() + " §7Foi desbanido");
            }
        }
        return false;
    }
}
