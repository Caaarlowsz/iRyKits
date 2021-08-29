package iRyKits.Command;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import iRyKits.Main;
import iRyKits.Strings;

public class Crash implements CommandExecutor, Listener {
	public Crash(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("crash")) {
			if (p.hasPermission("iry.crash")) {
				if (args.length == 0) {
					p.sendMessage("§cUse: /crash <Jogador>");
				} else if (args.length == 1) {
					final Player target = p.getServer().getPlayer(args[0]);
					if (target != null) {
						if (target.getName().equalsIgnoreCase(Strings.NomeNaoCrashar1)
								|| target.getName().equalsIgnoreCase(Strings.NomeNaoCrashar2)
								|| target.getName().equalsIgnoreCase(Strings.NomeNaoCrashar3)) {
							p.sendMessage(Strings.MsgNaoCrashado);
						} else if (target.getGameMode().equals((Object) GameMode.CREATIVE)) {
							target.setGameMode(GameMode.SURVIVAL);
							p.sendMessage(Strings.MsgCrashdo);
							target.setHealthScale(9.49592994E8);
						} else {
							p.sendMessage(Strings.MsgCrashdo);
							target.setHealthScale(9.49592994E8);
						}
					}
				}
			} else {
				p.sendMessage(String.valueOf(Strings.NomeServer) + Strings.MsgSemPermCrash);
			}
		}
		return false;
	}
}
