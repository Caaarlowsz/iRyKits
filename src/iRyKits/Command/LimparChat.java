package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import iRyKits.SemPerm;

public class LimparChat implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Label.equalsIgnoreCase("cc")) {
			if (!p.hasPermission("iry.cc")) {
				SemPerm.semPermiassao((Player) Sender);
				return true;
			}
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("                   ?1?lChat Limpo Por: ?f?l" + p.getDisplayName());
		}
		return false;
	}
}
