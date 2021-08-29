package iRyKits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Fisherman implements Listener, CommandExecutor {
	public static Main plugin;

	public Fisherman(final Main main) {
		Fisherman.plugin = main;
	}

	public Fisherman() {
	}

	@EventHandler
	public void onPlayerFish(final PlayerFishEvent event) {
		final Entity caught = event.getCaught();
		final Block block = event.getHook().getLocation().getBlock();
		if (caught != null && caught != block && Arrays.Fisherman.contains(event.getPlayer().getName())) {
			caught.teleport(event.getPlayer().getLocation());
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("fisherman")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.fisherman")) {
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
			final ItemStack fisher = new ItemStack(Material.FISHING_ROD);
			final ItemMeta kfisher = fisher.getItemMeta();
			kfisher.setDisplayName("§aFisherman");
			fisher.setItemMeta(kfisher);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cFisherman", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cFisherman");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, fisher);
			Habilidade.setAbility(p, "Fisherman");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Fisherman.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
