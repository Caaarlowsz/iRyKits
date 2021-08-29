package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import iRyKits.Main;
import iRyKits.Strings;

public class Tpall implements CommandExecutor {

	public Tpall(final Main plugin) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("tpall") && p.hasPermission("iry.tpall")) {
			p.sendMessage(Strings.MsgTpall);
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player all = onlinePlayers[i];
				all.teleport((Entity) p);
			}
		}
		return false;
	}
}
