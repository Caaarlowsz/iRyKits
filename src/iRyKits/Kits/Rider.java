package iRyKits.Kits;

import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Rider implements Listener, CommandExecutor {
	public static ItemStack[] armorContents;
	public static ItemStack[] inventoryContents;
	public int horseHealth;
	public String horseName;
	public double jumpStrength;
	public boolean modifyHorseStats;
	public boolean nameHorse;
	public boolean preventOthersFromUsing;
	public long cooldownLenght;
	private HashMap<Player, Horse> horses;
	public double runSpeed;
	public static Main plugin;

	public Rider(final Main main) {
		this.horseHealth = 40;
		this.horseName = "%s";
		this.jumpStrength = 1.0;
		this.modifyHorseStats = true;
		this.nameHorse = true;
		this.preventOthersFromUsing = true;
		this.cooldownLenght = 0L;
		this.horses = new HashMap<Player, Horse>();
		this.runSpeed = 1.0;
		Rider.plugin = main;
	}

	public Rider() {
		this.horseHealth = 40;
		this.horseName = "%s";
		this.jumpStrength = 1.0;
		this.modifyHorseStats = true;
		this.nameHorse = true;
		this.preventOthersFromUsing = true;
		this.cooldownLenght = 0L;
		this.horses = new HashMap<Player, Horse>();
		this.runSpeed = 1.0;
	}

	@EventHandler
	public void onClick888(final InventoryClickEvent event) {
		if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.SADDLE
				&& event.getWhoClicked().getVehicle() != null
				&& this.horses.containsValue(event.getWhoClicked().getVehicle())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEntityDeath(final EntityDeathEvent event) {
		if (this.horses.containsValue(event.getEntity())) {
			event.setDroppedExp(0);
			final Iterator<Player> itel = this.horses.keySet().iterator();
			while (itel.hasNext()) {
				if (this.horses.get(itel.next()) == event.getEntity()) {
					itel.remove();
				}
			}
		}
	}

	@EventHandler
	public void onInteract4(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR && p.getItemInHand().getType() == Material.SADDLE
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aRider")) {
			if (this.horses.containsKey(p)) {
				final Horse horse = this.horses.remove(p);
				if (!horse.isDead()) {
					horse.eject();
					horse.leaveVehicle();
					horse.remove();
				}
			} else {
				final Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
				this.horses.put(p, horse);
				if (this.nameHorse) {
					horse.setCustomName(String.format(this.horseName, "§4Cavalo de §a" + p.getName()));
					horse.setCustomNameVisible(true);
				}
				horse.setBreed(false);
				horse.setTamed(true);
				horse.setDomestication(horse.getMaxDomestication());
				horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
				horse.setOwner((AnimalTamer) p);
				if (this.modifyHorseStats) {
					horse.setJumpStrength(this.jumpStrength);
					horse.setMaxHealth(this.horseHealth);
					horse.setHealth(this.horseHealth);
					horse.setColor(Horse.Color.WHITE);
				}
			}
		}
	}

	@EventHandler
	public void onRightClick1(final PlayerInteractEntityEvent event) {
		if (this.preventOthersFromUsing && this.horses.containsValue(event.getRightClicked())) {
			for (final Player p : this.horses.keySet()) {
				if (this.horses.get(p) == event.getRightClicked() && event.getPlayer() != p) {
					event.setCancelled(true);
					break;
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("rider")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.rider")) {
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
			final ItemStack r = new ItemStack(Material.SADDLE);
			final ItemMeta kr = espada.getItemMeta();
			kr.setDisplayName("§aRider");
			r.setItemMeta(kr);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cRider", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cRider");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, r);
			Habilidade.setAbility(p, "Rider");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Rider.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
