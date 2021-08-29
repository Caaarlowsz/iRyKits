package iRyKits.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import iRyKits.Main;
import iRyKits.Strings;

public class Clear implements CommandExecutor {

	public Clear(final Main plugin) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("clear") && args.length == 0 && (p.hasPermission("iry.clear") || p.isOp())) {
			final Inventory inv = (Inventory) p.getInventory();
			inv.clear();
			p.sendMessage(Strings.MsgClear);
		}
		return false;
	}
}
