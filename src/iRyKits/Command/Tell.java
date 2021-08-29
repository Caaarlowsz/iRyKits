package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import iRyKits.Main;

public class Tell implements CommandExecutor {

	public Tell(final Main plugin) {
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		if (!cmd.equalsIgnoreCase("tell") && !cmd.equalsIgnoreCase("msg")) {
			return false;
		}
		if (args.length < 2) {
			p.sendMessage("§cUse: /tell <Jogador> <Msg>");
			return true;
		}
		int i = 1;
		final int para = args.length;
		String MSG = "";
		while (i < para) {
			MSG = String.valueOf(MSG) + args[i] + " ";
			++i;
		}
		final Player target = Bukkit.getPlayerExact(args[0]);
		if (target != null) {
			target.sendMessage("§3[" + p.getName() + " -> eu]§7 " + MSG);
			p.sendMessage("§3[Eu -> " + p.getName() + "] §7" + MSG);
		} else {
			p.sendMessage("§cPlayer offline.");
		}
		return false;
	}
}
