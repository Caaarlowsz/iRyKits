package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import iRyKits.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;

public class Ban implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public Ban(final Main main) {
        Ban.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("ban")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Console nao pode usar esse comando");
                return true;
            }
            final Player p = (Player)sender;
            if (p.hasPermission("iry.ban")) {
                if (args.length == 0) {
                    p.sendMessage("§cUse: /ban <Jogador> <Motivo>");
                }
                else if (args.length == 1) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    if (targetPlayer == null) {
                        p.sendMessage("§cEste jogador esta offline!");
                    }
                    else {
                        p.sendMessage("§cUse: /ban <Jogador> <Motivo>");
                    }
                }
                else if (args.length > 1) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    if (targetPlayer == null) {
                        p.sendMessage("§cEste jogador esta offline!");
                    }
                    else {
                        String message = "";
                        for (int i = 1; i < args.length; ++i) {
                            message = String.valueOf(message) + args[i] + " ";
                        }
                        targetPlayer.setBanned(true);
                        targetPlayer.kickPlayer("§7Voc\u00ea foi banido pelo Jogador: §c" + p.getName() + "\n §7Motivo: §c" + message);
                        Bukkit.broadcastMessage("§c" + targetPlayer.getName() + " §7Foi banido pelo Jogador: §c" + p.getName() + " §7Motivo: §c" + message);
                    }
                }
            }
            else {
                p.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
            }
        }
        return false;
    }
    
    @EventHandler
    public void aoEntrar(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (p.isBanned()) {
            e.setKickMessage(Ban.plugin.getConfig().getString("Msg_Banido").replace("&", "§"));
        }
    }
}
