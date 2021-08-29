package iRyKits.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import iRyKits.Strings;

public class Suicide implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Label.equalsIgnoreCase("suicide")) {
			p.setHealth(0);
			p.sendMessage(Strings.SuicideMsg);
		}
		return false;
	}
}
