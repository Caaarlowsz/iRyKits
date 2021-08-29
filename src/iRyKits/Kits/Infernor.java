package iRyKits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Infernor implements Listener, CommandExecutor {
	public static Main plugin;

	public Infernor(final Main main) {
		Infernor.plugin = main;
	}

	public Infernor() {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("infernor")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.infernor")) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> §cSem Permiss\u00e3o!");
				return true;
			}
			if (Arrays.Used.contains(p.getName())) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> " + "§c1 Kit Por Vida");
				return true;
			}
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta kespada = espada.getItemMeta();
			kespada.setDisplayName("§5Espada");
			espada.setItemMeta(kespada);
			final ItemStack inf = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta kinf = inf.getItemMeta();
			kinf.setDisplayName("§aInfernor");
			inf.setItemMeta(kinf);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cInfernor", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cInfernor");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, inf);
			Habilidade.setAbility(p, "Infernor");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Inferno.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
