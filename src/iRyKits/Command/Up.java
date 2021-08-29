package iRyKits.Command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import iRyKits.Main;
import iRyKits.SemPerm;

public class Up implements CommandExecutor {
	public Up plugin;

	public Up(final Up instance) {
		this.plugin = instance;
	}

	public Up(final Main fight) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("upi")) {
			if (args.length == 1) {
				if (sender.hasPermission("iry.upi")) {
					if (sender instanceof Player) {
						if (!args[0].replaceAll("[\\D]", "").isEmpty()) {
							final int blocks = Integer.parseInt(args[0].replaceAll("[\\D]", ""));
							final Location loc = ((Player) sender).getLocation().add(0.0, (double) blocks, 0.0);
							((Player) sender).teleport(loc);
							if (((Player) sender).getWorld().getBlockAt(loc.add(0.0, -1.0, 0.0)).getType()
									.equals((Object) Material.AIR)) {
								((Player) sender).getWorld().getBlockAt(loc).setType(Material.GLASS);
								loc.add(0.0, 1.0, 0.0);
							}
							if (!((Player) sender).getWorld().getBlockAt(loc).getType().equals((Object) Material.AIR)) {
								((Player) sender).getWorld().getBlockAt(loc).setType(Material.AIR);
							}
							if (!((Player) sender).getWorld().getBlockAt(loc.add(0.0, 1.0, 0.0)).getType()
									.equals((Object) Material.AIR)) {
								((Player) sender).getWorld().getBlockAt(loc).setType(Material.AIR);
								loc.add(0.0, -1.0, 0.0);
							}
							sender.sendMessage("§aBloco Colocado!");
						} else if (sender instanceof Player) {
							sender.sendMessage("§cUse: /upi <blocos>");
						} else {
							sender.sendMessage("§cUse: /upi <blocos>");
						}
					} else {
						sender.sendMessage("§aNao console!");
					}
				} else if (sender instanceof Player) {
					SemPerm.semPermiassao((Player) sender);
				} else {
					SemPerm.semPermiassao((Player) sender);
				}
			} else if (sender instanceof Player) {
				sender.sendMessage("§cUse: /upi <blocos>");
			} else {
				sender.sendMessage("§cUse: /upi <blocos>");
			}
		}
		return false;
	}
}
