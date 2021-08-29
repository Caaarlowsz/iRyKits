package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import iRyKits.SemPerm;

public class NoFall implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
		final Player p = (Player) sender;
		if (p.hasPermission("iry.nofall") && cmd.getName().equalsIgnoreCase("nofall")) {
			if (args.length == 0) {
				p.sendMessage("§cUse: /nofall <Jogador>");
			}
			if (args.length == 1) {
				final Player o = Bukkit.getPlayer(args[0]);
				if (o != null) {
					o.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.AIR);
					o.getLocation().add(0.0, 40.0, 1.0).getBlock().setType(Material.AIR);
					o.getLocation().add(1.0, 40.0, 0.0).getBlock().setType(Material.AIR);
					o.getLocation().add(0.0, 40.0, -1.0).getBlock().setType(Material.AIR);
					o.getLocation().add(-1.0, 40.0, 0.0).getBlock().setType(Material.AIR);
					o.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.AIR);
					o.teleport(o.getLocation().add(0.0, 11.0, -0.05));
					p.sendMessage("§aJogador Testado Com Sucesso!");
				} else {
					p.sendMessage("§cJogador Off");
				}
			}
		} else {
			SemPerm.semPermiassao((Player) sender);
		}
		return false;
	}
}
