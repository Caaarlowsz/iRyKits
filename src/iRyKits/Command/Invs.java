package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Invs implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem dar este comando!");
			return true;
		}
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("vis")) {
			if (p.hasPermission("iry.vis")) {
				p.sendMessage("§aVoc\u00ea Esta Visivel Para Todos!");
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player todos = onlinePlayers[i];
					todos.showPlayer(p);
				}
			}
		} else if (label.equalsIgnoreCase("invis") && p.hasPermission("iry.invis")) {
			p.sendMessage("§cVoc\u00ea esta invisivel Para Jogadores!");
			Player[] onlinePlayers2;
			for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
				final Player todos = onlinePlayers2[j];
				todos.hidePlayer(p);
			}
		}
		return false;
	}
}
