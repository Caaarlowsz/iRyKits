package iRyKits.Command;

import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class Tpall implements CommandExecutor
{
    private Main plugin;
    
    public Tpall(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("tpall") && p.hasPermission("iry.tpall")) {
            p.sendMessage(Strings.MsgTpall);
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player all = onlinePlayers[i];
                all.teleport((Entity)p);
            }
        }
        return false;
    }
}
