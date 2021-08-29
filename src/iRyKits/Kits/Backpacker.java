package iRyKits.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Backpacker implements Listener, CommandExecutor {
	public static HashMap<String, Long> cooldown;
	public static Main plugin;

	static {
		Backpacker.cooldown = new HashMap<String, Long>();
	}

	public Backpacker(final Main main) {
		Backpacker.plugin = main;
	}

	public Backpacker() {
	}

	@EventHandler
	public void disparar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.LEATHER && Arrays.Backpacker.contains(p.getName())) {
			if (!Backpacker.cooldown.containsKey(p.getName())
					|| Backpacker.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				final Inventory sopas = Bukkit.createInventory((InventoryHolder) p, 9, "§6BackFiller");
				final ItemStack sopas2 = new ItemStack(Material.MUSHROOM_SOUP);
				final ItemMeta sopas3 = sopas2.getItemMeta();
				sopas3.setDisplayName("§3--> §6Sopas §3<--");
				sopas2.setItemMeta(sopas3);
				sopas.setItem(0, sopas2);
				sopas.setItem(1, sopas2);
				sopas.setItem(2, sopas2);
				sopas.setItem(3, sopas2);
				sopas.setItem(4, sopas2);
				sopas.setItem(5, sopas2);
				sopas.setItem(6, sopas2);
				sopas.setItem(7, sopas2);
				sopas.setItem(8, sopas2);
				Backpacker.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
				p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
				p.openInventory(sopas);
				return;
			}
			p.sendMessage(ChatColor.RED + "Cooldown");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("backpacker")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.backpacker")) {
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
			final ItemStack bp = new ItemStack(Material.LEATHER);
			final ItemMeta kbp = bp.getItemMeta();
			kbp.setDisplayName("§aRefil");
			bp.setItemMeta(kbp);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cBackpacker", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cBackpacker");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, bp);
			Habilidade.setAbility(p, "Backpacker");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Backpacker.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
