package iRyKits.Kits;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Barbarian implements Listener, CommandExecutor {
	public static Main plugin;

	public Barbarian(final Main main) {
		Barbarian.plugin = main;
	}

	public Barbarian() {
	}

	@EventHandler
	public void onKill(final PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			final Player k = e.getEntity().getKiller();
			if (Arrays.Barbarian.contains(k.getName())) {
				if (k.getItemInHand().getType() == Material.WOOD_SWORD) {
					k.setItemInHand(new ItemStack(Material.STONE_SWORD));
					k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
					k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "1");
				} else if (k.getItemInHand().getType() == Material.STONE_SWORD) {
					k.setItemInHand(new ItemStack(Material.IRON_SWORD));
					k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
					k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "2");
				} else if (k.getItemInHand().getType() == Material.IRON_SWORD) {
					k.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
					k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
					k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "3");
				} else if (k.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					final int max = 5;
					if (k.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
						final int lvl = k.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL);
						if (lvl + 1 <= max) {
							k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
							k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, lvl + 1);
							k.updateInventory();
							k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
							if (lvl + 1 == 2) {
								k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "5");
							} else if (lvl + 1 == 3) {
								k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "6");
							} else if (lvl + 1 == 4) {
								k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "7");
							} else if (lvl + 1 == 5) {
								k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "8");
							}
						} else {
							k.sendMessage(ChatColor.GOLD + "Voc\u00ea esta no level maximo!");
						}
					} else {
						k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
						k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
						k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "4");
					}
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("barbarian")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.barbarian")) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> §cSem Permiss\u00e3o!");
				return true;
			}
			if (Arrays.Used.contains(p.getName())) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> " + "§c1 Kit Por Vida");
				return true;
			}
			final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
			final ItemMeta kespada = espada.getItemMeta();
			kespada.setDisplayName("§5Espada");
			espada.setItemMeta(kespada);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cBarbarian", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cBarbarian");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Barbarian");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Barbarian.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
