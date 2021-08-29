package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;

public class Tempo implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("tempo")) {
            if (!p.hasPermission("iry.tempo")) {
                p.sendMessage(String.valueOf(Strings.NomeServer) + "§e>> §cSem Permiss\u00e3o!");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage("§cUse: /tempo [Dia/Noite]");
                return true;
            }
            if (Args.length == 1) {
                if (Args[0].equalsIgnoreCase("dia")) {
                    p.chat("/time set day");
                    p.sendMessage("§3Voc\u00ea colocou de: §a§lDIA");
                }
                if (Args[0].equalsIgnoreCase("noite")) {
                    p.chat("/time set 18000");
                    p.sendMessage("§3Voc\u00ea colocou de: §c§lNOITE");
                }
            }
        }
        return false;
    }
}
