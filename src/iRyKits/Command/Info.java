package iRyKits.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Info implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Label.equalsIgnoreCase("help")) {
			if (p.hasPermission("iry.help")) {
			}
			if (Args[0].equalsIgnoreCase("iRyKits")) {
				p.sendMessage("§3Comando /Admin §f- §9Permiss\u00e3o iry.admin");
				p.sendMessage("§3Comando /Bc §f- §9Permiss\u00e3o iry.bc");
				p.sendMessage("§3Comando /Build §f- §9Permiss\u00e3o iry.build");
				p.sendMessage("§3Comando /Crash §f- §9Permiss\u00e3o iry.crash");
				p.sendMessage("§3Comando /Creditos §f- §9Permiss\u00e3o ?");
				p.sendMessage("§3Comando /Gm §f- §9Permiss\u00e3o iry.gm");
				p.sendMessage("§3Comando /Kill §f- §9Permiss\u00e3o ?");
				p.sendMessage("§3Comando /Cc §f- §9Permiss\u00e3o iry.cc");
				p.sendMessage("§3Comando /Nofall §f- §9Permiss\u00e3o iry.nofall");
				p.sendMessage("§3Comando /Resetkit §f- §9Permiss\u00e3o iry.resetkit");
				p.sendMessage("§3Comando /Suicide §f- §9Permiss\u00e3o ?");
				p.sendMessage("§3Comando /Tag §f- §9Permiss\u00e3o tag.nomedatag");
				p.sendMessage("§3Comando /Tp §f- §9Permiss\u00e3o iry.teleport");
				p.sendMessage("§3Comando /Youtuber §f- §9Permiss\u00e3o ?");
				p.sendMessage("§3Comando /Report §f- §9Permiss\u00e3o iry.report §f- §3Obs: Ver o report !");
				p.sendMessage("§3Comando /help iRyKits §f- §9Permiss\u00e3o iry.help");
				p.sendMessage("§3Permiss\u00e3o Kit §f- §9kit.[NomeDoKit]");
				p.sendMessage("§3Comando /Recraft §f- §9Permiss\u00e3o iry.recraft");
				p.sendMessage("§3Comando /Sopa §f- §9Permiss\u00e3o iry.sopa");
				p.sendMessage("§3Comando /TogglePvP §f- §9Permiss\u00e3o iry.togglepvp");
				p.sendMessage("§3Comando /Clear §f- §9Permiss\u00e3o iry.clear");
				p.sendMessage("§3Comando /Check §f- §9Permiss\u00e3o iry.check");
				p.sendMessage("§3Comando /Head §f- §9Permiss\u00e3o iry.head");
				p.sendMessage("§3Comando /Ban §f- §9Permiss\u00e3o iry.ban");
				p.sendMessage("§3Comando /Kick §f- §9Permiss\u00e3o iry.kick");
				p.sendMessage("§3Comando /Skit §f- §9Permiss\u00e3o iry.skit");
				p.sendMessage("§3Comando /Tell §f- §9Permiss\u00e3o ?");
				p.sendMessage("§3Comando /Tpall §f- §9Permiss\u00e3o iry.tpall");
				p.sendMessage("§3Comando /Fly §f- §9Permiss\u00e3o iry.fly");
				p.sendMessage("§3Comando /Vida §f- §9Permiss\u00e3o iry.vida");
				p.sendMessage("§3Comando /Efeito §f- §9Permiss\u00e3o iry.efeitos");
				p.sendMessage("§3Comando /Inv §f- §9Permiss\u00e3o iry.inv");
				p.sendMessage("§3Comando /Upi §f- §9Permiss\u00e3o iry.upi");
				p.sendMessage("§3Comando /Set[MDR,FPS,CHALLENGE,MAIN,RDM] §9Permiss\u00e3o set.warps");
				p.sendMessage("§3Comando /Chatclose §9Permiss\u00e3o iry.chatmute");
				p.sendMessage("§3Comando /Vis §9Permiss\u00e3o iry.vis");
				p.sendMessage("§3Comando /Invis §9Permiss\u00e3o iry.invis");
				p.sendMessage("§cCriador: iRyaaNziN");
			}
		}
		return false;
	}
}
