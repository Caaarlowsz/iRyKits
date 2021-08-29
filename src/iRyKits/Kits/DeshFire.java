package iRyKits.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.Vector;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class DeshFire implements Listener, CommandExecutor {
	public int boost;
	public static ArrayList<String> Deshfire;
	ArrayList<String> fall;
	public static List<Player> cooldownm;
	public static HashMap<String, ItemStack[]> Armadura;
	public static Main plugin;

	static {
		DeshFire.Deshfire = new ArrayList<String>();
		DeshFire.cooldownm = new ArrayList<Player>();
		DeshFire.Armadura = new HashMap<String, ItemStack[]>();
	}

	public DeshFire(final Main main) {
		this.boost = 6;
		this.fall = new ArrayList<String>();
		DeshFire.plugin = main;
	}

	public DeshFire() {
		this.boost = 6;
		this.fall = new ArrayList<String>();
	}

	@EventHandler
	public void VelotrolClick(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.REDSTONE_BLOCK
				&& Arrays.DeshFire.contains(event.getPlayer().getName())) {
			final WorldGuardPlugin worldGuard = Main.getWorldGuard();
			final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
			final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
			if (set.allows(DefaultFlag.PVP)) {
				if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_AIR) {
					event.setCancelled(true);
				}
				if (DeshFire.cooldownm.contains(p)) {
					p.sendMessage("§cCooldown");
					return;
				}
				DeshFire.cooldownm.add(p);
				p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
				p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 10, 0);
				for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
					if (pertos instanceof Player) {
						((Player) pertos).damage(10.0);
						pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
						((Player) pertos).setFireTicks(150);
					}
				}
				final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
				final LeatherArmorMeta kCapacete = (LeatherArmorMeta) Capacete.getItemMeta();
				kCapacete.setColor(Color.RED);
				Capacete.setItemMeta((ItemMeta) kCapacete);
				final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
				final LeatherArmorMeta kPeitoral = (LeatherArmorMeta) Peitoral.getItemMeta();
				kPeitoral.setColor(Color.RED);
				Peitoral.setItemMeta((ItemMeta) kPeitoral);
				final ItemStack Cal\u00e7a = new ItemStack(Material.LEATHER_LEGGINGS);
				final LeatherArmorMeta kCal\u00e7a = (LeatherArmorMeta) Cal\u00e7a.getItemMeta();
				kCal\u00e7a.setColor(Color.RED);
				Cal\u00e7a.setItemMeta((ItemMeta) kCal\u00e7a);
				final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
				final LeatherArmorMeta kBota = (LeatherArmorMeta) Capacete.getItemMeta();
				kBota.setColor(Color.RED);
				Bota.setItemMeta((ItemMeta) kBota);
				DeshFire.Armadura.put(p.getName(), p.getInventory().getArmorContents());
				p.getInventory().setHelmet(Capacete);
				p.getInventory().setChestplate(Peitoral);
				p.getInventory().setLeggings(Cal\u00e7a);
				p.getInventory().setBoots(Bota);
				p.updateInventory();
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						p.getInventory().setHelmet((ItemStack) null);
						p.getInventory().setChestplate((ItemStack) null);
						p.getInventory().setLeggings((ItemStack) null);
						p.getInventory().setBoots((ItemStack) null);
						p.updateInventory();
					}
				}, 50L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						DeshFire.cooldownm.remove(p);
						Arrays.DeshFire.remove(p.getName());
						p.sendMessage("§aVoc\u00ea pode usar novamente!");
						p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
					}
				}, 700L);
			} else {
				p.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
			}
		}
	}

	@EventHandler
	public void onTomarDano(final EntityDamageEvent event) {
		final Entity e = event.getEntity();
		if (e instanceof Player) {
			final Player player = (Player) e;
			if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL
					&& player.getInventory().contains(Material.REDSTONE_BLOCK) && event.getDamage() >= 7.0) {
				event.setDamage(7.0);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("deshfire")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.deshfire")) {
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
			final ItemStack desh = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta kdesh = desh.getItemMeta();
			kdesh.setDisplayName("§aDeshFire");
			desh.setItemMeta(kdesh);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cDeshFire", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cDeshFire");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, desh);
			Habilidade.setAbility(p, "DeshFire");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.DeshFire.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
