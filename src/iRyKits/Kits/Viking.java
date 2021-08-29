package iRyKits.Kits;

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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Viking implements Listener, CommandExecutor {
	public static Main plugin;

	public Viking(final Main main) {
		Viking.plugin = main;
	}

	public Viking() {
	}

	@EventHandler
	public void dano(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player d = (Player) e.getDamager();
			if (Arrays.Viking.contains(d.getName()) && (d.getItemInHand().getType() == Material.WOOD_AXE
					|| d.getItemInHand().getType() == Material.STONE_AXE
					|| p.getItemInHand().getType() == Material.GOLD_AXE
					|| p.getItemInHand().getType() == Material.IRON_AXE
					|| p.getItemInHand().getType() == Material.DIAMOND_AXE)) {
				e.setDamage(e.getDamage() * 2.0);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("viking")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.viking")) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> §cSem Permiss\u00e3o!");
				return true;
			}
			if (Arrays.Used.contains(p.getName())) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> " + "§c1 Kit Por Vida");
				return true;
			}
			final ItemStack espada = new ItemStack(Material.WOOD_AXE);
			final ItemMeta kespada = espada.getItemMeta();
			kespada.setDisplayName("§5Viking");
			espada.setItemMeta(kespada);
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cViking", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cViking");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Viking");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Viking.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
