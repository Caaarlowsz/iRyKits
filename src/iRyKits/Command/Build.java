package iRyKits.Command;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.*;

public class Build implements CommandExecutor
{
    public static ArrayList<Player> Build;
    
    static {
        iRyKits.Command.Build.Build = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (Label.equalsIgnoreCase("Build")) {
            final Player p = (Player)Sender;
            if (Args.length == 0) {
                Sender.sendMessage("§cUse: /build [on/off]");
                return true;
            }
            if (!p.hasPermission("iry.build")) {
                SemPerm.semPermiassao((Player)Sender);
                return true;
            }
            if (Args[0].equalsIgnoreCase("On")) {
                p.sendMessage(ChatColor.GREEN + "Modo Build: §2Ativado");
                iRyKits.Command.Build.Build.add(p);
            }
            if (Args[0].equalsIgnoreCase("Off")) {
                p.sendMessage(ChatColor.GREEN + "Modo Build: §cDesativado");
                iRyKits.Command.Build.Build.remove(p);
            }
        }
        return false;
    }
}
