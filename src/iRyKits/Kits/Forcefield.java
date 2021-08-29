package iRyKits.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Forcefield implements Listener, CommandExecutor {
	public static List<Player> cooldownm;
	public static Main plugin;

	static {
		Forcefield.cooldownm = new ArrayList<Player>();
	}

	public Forcefield(final Main main) {
		Forcefield.plugin = main;
	}

	public Forcefield() {
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.IRON_FENCE
				&& Arrays.Forcefield.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Forcefield.cooldownm.contains(p)) {
				p.sendMessage("§cCooldown");
				return;
			}
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 0.5f, 0.5f);
			Forcefield.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Arrays.Forcefielddano.add(p.getName());
					p.sendMessage("§aVoc\u00ea Ativou O FF");
				}
			}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Arrays.Forcefielddano.remove(p.getName());
				}
			}, 50L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Forcefield.cooldownm.remove(p);
					p.sendMessage("§aVoc\u00ea pode usar novamente seu ff!");
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 0.5f, 0.5f);
				}
			}, 500L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (Arrays.Forcefielddano.contains(p.getName())) {
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					if (Arrays.Forcefield.contains(p.getName())) {
						((Player) pertos).damage(3.0);
					}
					pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, 10L);
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("forcefield")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.forcefield")) {
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
			final ItemStack ff = new ItemStack(Material.IRON_FENCE);
			final ItemMeta kff = ff.getItemMeta();
			kff.setDisplayName("§aForcefield");
			ff.setItemMeta(kff);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cForcefield", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cForcefield");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, ff);
			Habilidade.setAbility(p, "ForceField");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Forcefield.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
