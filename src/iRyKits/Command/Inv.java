package iRyKits.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import iRyKits.Main;

public class Inv implements CommandExecutor {

	public Inv(final Main plugin) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String tag, final String[] args) {
		final Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
			return false;
		}
		if (cmd.getName().equalsIgnoreCase("inv") && p.hasPermission("iry.inv")) {
			if (args.length == 1) {
				final Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					p.openInventory((Inventory) target.getInventory());
					p.sendMessage("§3Voc\u00ea est\u00e1 vendo o invent\u00e1rio de: §f" + target.getName());
				} else {
					p.sendMessage("§cJogador offline.");
				}
			} else {
				p.sendMessage("§cUse: /inv <Jogador>");
			}
		}
		return false;
	}
}
