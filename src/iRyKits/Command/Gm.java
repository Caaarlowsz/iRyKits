package iRyKits.Command;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm implements CommandExecutor {

	public Gm() {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("gm") && sender.hasPermission("iry.gm")) {
			if (args.length != 1) {
				player.sendMessage("§cUse: /gm [0/1/2]");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("0")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage("§3Seu gamemode agora est\u00e1 em " + ChatColor.RED + "Sobrevivencia!");
				}
				if (args[0].equalsIgnoreCase("1")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage("§3Seu gamemode agora est\u00e1 em " + ChatColor.RED + "Criativo!");
				}
				if (args[0].equalsIgnoreCase("2")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage("§3Seu gamemode agora est\u00e1 em " + ChatColor.RED + "Aventura!");
				}
				return true;
			}
		}
		return false;
	}
}
