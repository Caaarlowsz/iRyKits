package iRyKits.Kits;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.ChatColor;
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
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Monk implements Listener, CommandExecutor {
	public int cooldown;
	public String monkCooldownMessage;
	public String monkedMessage;
	public int monkItemId;
	public String monkItemName;
	private transient HashMap<ItemStack, Long> monkStaff;
	public boolean sendThroughInventory;
	public static Main plugin;

	public Monk(final Main main) {
		this.cooldown = 15;
		this.monkCooldownMessage = ChatColor.BLUE + "Voc\u00ea so pode usa depois de %s segundos!";
		this.monkedMessage = ChatColor.GREEN + "Monkado!";
		this.monkItemId = Material.BLAZE_ROD.getId();
		this.monkItemName = "§aMonk";
		this.monkStaff = new HashMap<ItemStack, Long>();
		this.sendThroughInventory = true;
		Monk.plugin = main;
	}

	public Monk() {
		this.cooldown = 15;
		this.monkCooldownMessage = ChatColor.BLUE + "Voc\u00ea so pode usa depois de %s segundos!";
		this.monkedMessage = ChatColor.GREEN + "Monkado!";
		this.monkItemId = Material.BLAZE_ROD.getId();
		this.monkItemName = "§aMonk";
		this.monkStaff = new HashMap<ItemStack, Long>();
		this.sendThroughInventory = true;
	}

	@EventHandler
	public void onRightClick(final PlayerInteractEntityEvent event) {
		final ItemStack item = event.getPlayer().getItemInHand();
		final Player Player = (Player) ((Entity) event.getPlayer());
		if (Arrays.Monk.contains(Player.getName()) && Player.getItemInHand().getType() == Material.BLAZE_ROD) {
			long lastUsed = 0L;
			if (this.monkStaff.containsKey(item)) {
				lastUsed = this.monkStaff.get(item);
			}
			if (lastUsed + 1000 * this.cooldown > System.currentTimeMillis()) {
				event.getPlayer().sendMessage(String.format(this.monkCooldownMessage,
						-((System.currentTimeMillis() - (lastUsed + 1000 * this.cooldown)) / 1000L)));
			} else {
				final PlayerInventory inv = ((Player) event.getRightClicked()).getInventory();
				final int slot = new Random().nextInt(this.sendThroughInventory ? 36 : 9);
				ItemStack replaced = inv.getItemInHand();
				if (replaced == null) {
					replaced = new ItemStack(0);
				}
				ItemStack replacer = inv.getItem(slot);
				if (replacer == null) {
					replacer = new ItemStack(0);
				}
				inv.setItemInHand(replacer);
				inv.setItem(slot, replaced);
				this.monkStaff.put(item, System.currentTimeMillis());
				event.getPlayer().sendMessage(this.monkedMessage);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("monk")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.monk")) {
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
			final ItemStack monk = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta kmonk = monk.getItemMeta();
			kmonk.setDisplayName("§aMonk");
			monk.setItemMeta(kmonk);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cMonk", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cMonk");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, monk);
			Habilidade.setAbility(p, "Monk");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Monk.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
