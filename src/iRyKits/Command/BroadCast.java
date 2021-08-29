package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import iRyKits.*;

public class BroadCast implements CommandExecutor
{
    public BroadCast(final Main main) {
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] args) {
        final Player p = (Player)Sender;
        if (Label.equalsIgnoreCase("bc")) {
            if (p.hasPermission("iry.bc")) {
                if (args.length >= 1) {
                    String bcast = "";
                    for (int x = 0; x < args.length; ++x) {
                        bcast = String.valueOf(bcast) + args[x] + " ";
                    }
                    bcast = ChatColor.translateAlternateColorCodes('&', bcast);
                    Bukkit.broadcastMessage(String.valueOf(Strings.Aviso) + "§e >> " + "§6" + bcast);
                }
            }
            else {
                SemPerm.semPermiassao((Player)Sender);
            }
        }
        return false;
    }
}
