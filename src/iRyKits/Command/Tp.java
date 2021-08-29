package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {
	public String[] aliases;
	public String description;

	public Tp() {
		this.aliases = new String[] { "tp" };
		this.description = "Sistema de teleporte.";
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
			return false;
		}
		final Player p = (Player) sender;
		if (p.hasPermission("iry.teleport")) {
			if (args.length == 0) {
				p.sendMessage("§cUse: /tp <Jogador> <Alvo>");
			} else if (args.length == 1) {
				final Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					p.teleport(target.getLocation());
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player p2 = onlinePlayers[i];
						if (p2.hasPermission("iry.teleport") || p2.isOp()) {
							p2.sendMessage(ChatColor.GRAY + p.getName() + " foi teleportado para " + target.getName());
						}
					}
				} else {
					p.sendMessage("§cO jogador " + args[0] + " n\u00e3o esta online.");
				}
			} else if (args.length == 2) {
				final Player target = p.getServer().getPlayer(args[0]);
				final Player starget = p.getServer().getPlayer(args[1]);
				if (target != null) {
					if (starget != null) {
						target.teleport(starget.getLocation());
						Player[] onlinePlayers2;
						for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length,
								j = 0; j < length2; ++j) {
							final Player p3 = onlinePlayers2[j];
							if (p3.hasPermission("iry.teleport") || p3.isOp()) {
								p3.sendMessage(ChatColor.GRAY + target.getName() + " foi teleportado para "
										+ starget.getName());
							}
						}
					} else {
						p.sendMessage("§cO jogador " + args[1] + " n\u00e3o esta online.");
					}
				} else {
					p.sendMessage("§cO jogador " + args[0] + " n\u00e3o esta online.");
				}
			} else if (args.length == 3) {
				final double x2 = args[0].startsWith("~")
						? (p.getLocation().getX() + Integer.parseInt(args[0].substring(1)))
						: Integer.parseInt(args[0]);
				final double y2 = args[1].startsWith("~")
						? (p.getLocation().getY() + Integer.parseInt(args[1].substring(1)))
						: Integer.parseInt(args[1]);
				final double z2 = args[2].startsWith("~")
						? (p.getLocation().getZ() + Integer.parseInt(args[2].substring(1)))
						: Integer.parseInt(args[2]);
				if (x2 > 3.0E7 || y2 > 3.0E7 || z2 > 3.0E7 || x2 < -3.0E7 || y2 < -3.0E7 || z2 < -3.0E7) {
					return true;
				}
				final Location locpos = new Location(p.getWorld(), x2, y2, z2, p.getLocation().getYaw(),
						p.getLocation().getPitch());
				p.teleport(locpos);
				Player[] onlinePlayers3;
				for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
					final Player p4 = onlinePlayers3[k];
					if (p4.hasPermission("iry.teleport") || p4.isOp()) {
						p4.sendMessage(ChatColor.GRAY + p.getName() + " foi teleportado para X:" + locpos.getBlockX()
								+ " Y:" + locpos.getBlockY() + " Z:" + locpos.getBlockZ() + " .");
					}
				}
			} else if (args.length == 4) {
				final Player target = p.getServer().getPlayer(args[0]);
				final double x3 = args[1].startsWith("~")
						? (target.getLocation().getX() + Integer.parseInt(args[0].substring(1)))
						: Integer.parseInt(args[1]);
				final double y3 = args[2].startsWith("~")
						? (target.getLocation().getY() + Integer.parseInt(args[1].substring(1)))
						: Integer.parseInt(args[2]);
				final double z3 = args[3].startsWith("~")
						? (target.getLocation().getZ() + Integer.parseInt(args[2].substring(1)))
						: Integer.parseInt(args[3]);
				if (x3 > 3.0E7 || y3 > 3.0E7 || z3 > 3.0E7 || x3 < -3.0E7 || y3 < -3.0E7 || z3 < -3.0E7
						|| target == null) {
					return true;
				}
				final Location locpos2 = new Location(p.getWorld(), x3, y3, z3, target.getLocation().getYaw(),
						target.getLocation().getPitch());
				target.teleport(locpos2);
				Player[] onlinePlayers4;
				for (int length4 = (onlinePlayers4 = Bukkit.getOnlinePlayers()).length, l = 0; l < length4; ++l) {
					final Player p5 = onlinePlayers4[l];
					if (p5.hasPermission("iry.teleport") || p5.isOp()) {
						p5.sendMessage(
								ChatColor.GRAY + target.getName() + " foi teleportado para X:" + locpos2.getBlockX()
										+ " Y:" + locpos2.getBlockY() + " Z:" + locpos2.getBlockZ() + " .");
					}
				}
			}
		}
		return false;
	}
}
