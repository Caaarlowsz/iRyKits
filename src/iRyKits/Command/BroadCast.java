package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import iRyKits.Main;
import iRyKits.SemPerm;
import iRyKits.Strings;

public class BroadCast implements CommandExecutor {
	public BroadCast(final Main main) {
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] args) {
		final Player p = (Player) Sender;
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
			} else {
				SemPerm.semPermiassao((Player) Sender);
			}
		}
		return false;
	}
}
