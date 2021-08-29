package iRyKits.Command;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TogglePvP implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
            return true;
        }
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("togglepvp") || (!p.hasPermission("iry.togglepvp") && !p.isOp())) {
            return true;
        }
        if (p.getWorld().getPVP()) {
            p.getWorld().setPVP(false);
            Bukkit.getServer().broadcastMessage("§cPvP Desativado");
            return true;
        }
        p.getWorld().setPVP(true);
        Bukkit.getServer().broadcastMessage("§2PvP Ativado");
        return true;
    }
}
