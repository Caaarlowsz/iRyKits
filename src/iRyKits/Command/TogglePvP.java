package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TogglePvP implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
			return true;
		}
		final Player p = (Player) sender;
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
