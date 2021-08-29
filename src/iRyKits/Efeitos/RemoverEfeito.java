package iRyKits.Efeitos;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import iRyKits.Main;

public class RemoverEfeito implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("removerefeito") && p.hasPermission("iry.efeitos")) {
			p.sendMessage("§bEfeitos Removidos Com Sucesso!");
			p.playSound(p.getLocation(), Sound.SPLASH, 1.0f, 1.0f);
			Main.Flames.remove(p.getName());
			Main.Efeitos.remove(p.getName());
			Main.Ender.remove(p.getName());
			Main.Smoke.remove(p.getName());
			Main.Redstone.remove(p.getName());
			Main.Rainbow.remove(p.getName());
			Main.Diamond.remove(p.getName());
			Main.Water.remove(p.getName());
			Main.Potion.remove(p.getName());
		} else {
			p.sendMessage("§4Voc\u00ea n\u00e3o tem permiss\u00e3o para remover efeitos!");
			p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0f, 1.0f);
		}
		return false;
	}
}
