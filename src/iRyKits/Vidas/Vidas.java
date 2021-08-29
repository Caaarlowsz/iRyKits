package iRyKits.Vidas;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;

public class Vidas implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar esse comando!");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("vida")) {
            if (!p.hasPermission("iry.vida")) {
                p.sendMessage(String.valueOf(Strings.NomeServer) + "§e>> §cSem Permiss\u00e3o!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§cUse: /Vida 10/20/30/40/50/60/70/80/90/100");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("10")) {
                    p.setHealthScale(10.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 5 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("20")) {
                    p.setHealthScale(20.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 10 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("30")) {
                    p.setHealthScale(30.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 15 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("40")) {
                    p.setHealthScale(40.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 20 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("50")) {
                    p.setHealthScale(50.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 25 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("60")) {
                    p.setHealthScale(60.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 30 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("70")) {
                    p.setHealthScale(70.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 35 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("80")) {
                    p.setHealthScale(80.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 40 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("90")) {
                    p.setHealthScale(90.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 45 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("100")) {
                    p.setHealthScale(100.0);
                    p.setHealth(20);
                    p.sendMessage("§aSetado 50 Cora\u00e7\u00f5es");
                }
                if (args[0].equalsIgnoreCase("reset")) {
                    p.setHealthScale(20.0);
                    p.setHealth(20);
                    p.sendMessage("§aVida Resetada");
                }
            }
        }
        return false;
    }
}
