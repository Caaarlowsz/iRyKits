package iRyKits.Efeitos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Main;

public class Selector implements Listener, CommandExecutor {
	public Selector(final Main main) {
	}

	@EventHandler
	public void onClickKits(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§6§lEfeitos [§a§l1§6§l]")) {
			if (e.getCurrentItem() == null) {
				return;
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: FLAME")) {
				p.closeInventory();
				p.chat("/efeito1");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: ENDER_SIGNAL")) {
				p.closeInventory();
				p.chat("/efeito2");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: SMOKE")) {
				p.closeInventory();
				p.chat("/efeito3");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: REDSTONE_BLOCK")) {
				p.closeInventory();
				p.chat("/efeito4");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: DIAMOND_BLOCK")) {
				p.closeInventory();
				p.chat("/efeito5");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: WATER")) {
				p.closeInventory();
				p.chat("/efeito6");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: POTION_BREAK")) {
				p.closeInventory();
				p.chat("/efeito7");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: RAINBOW")) {
				p.closeInventory();
				p.chat("/efeito8");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§l-> RemoverEfeito <-")) {
				p.closeInventory();
				p.chat("/removerefeito");
				p.chat("/efeitos");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f» §cVoltar §f«")) {
				p.closeInventory();
				p.chat("/menu");
			}
		}
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (Cmd.getName().equalsIgnoreCase("efeitos")) {
			final Player p = (Player) Sender;
			final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27,
					"§6§lEfeitos [§a§l1§6§l]");
			final ItemStack vidro = new ItemStack(Material.THIN_GLASS, 1, (short) 3);
			final ItemMeta metav = vidro.getItemMeta();
			metav.setDisplayName("§f-");
			vidro.setItemMeta(metav);
			final ItemStack flame = new ItemStack(Material.BLAZE_POWDER);
			final ItemMeta flamek = flame.getItemMeta();
			flamek.setDisplayName("§b§lEfeito: FLAME");
			flame.setItemMeta(flamek);
			final ItemStack ender = new ItemStack(Material.EYE_OF_ENDER);
			final ItemMeta kender = ender.getItemMeta();
			kender.setDisplayName("§b§lEfeito: ENDER_SIGNAL");
			ender.setItemMeta(kender);
			final ItemStack smoke = new ItemStack(Material.FIREWORK_CHARGE);
			final ItemMeta ksmoke = smoke.getItemMeta();
			ksmoke.setDisplayName("§b§lEfeito: SMOKE");
			smoke.setItemMeta(ksmoke);
			final ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta kredstone = redstone.getItemMeta();
			kredstone.setDisplayName("§b§lEfeito: REDSTONE_BLOCK");
			redstone.setItemMeta(kredstone);
			final ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);
			final ItemMeta kdiamond = diamond.getItemMeta();
			kdiamond.setDisplayName("§b§lEfeito: DIAMOND_BLOCK");
			diamond.setItemMeta(kdiamond);
			final ItemStack water = new ItemStack(Material.WATER);
			final ItemMeta kwater = water.getItemMeta();
			kwater.setDisplayName("§b§lEfeito: WATER");
			water.setItemMeta(kwater);
			final ItemStack potion = new ItemStack(Material.POTION);
			final ItemMeta kpotion = potion.getItemMeta();
			kpotion.setDisplayName("§b§lEfeito: POTION_BREAK");
			potion.setItemMeta(kpotion);
			final ItemStack rainbow = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);
			final ItemMeta krainbow = rainbow.getItemMeta();
			krainbow.setDisplayName("§b§lEfeito: RAINBOW");
			rainbow.setItemMeta(krainbow);
			final ItemStack remover = new ItemStack(Material.REDSTONE_TORCH_ON);
			final ItemMeta kremover = remover.getItemMeta();
			kremover.setDisplayName("§c§l-> RemoverEfeito <-");
			remover.setItemMeta(kremover);
			final ItemStack v = new ItemStack(Material.REDSTONE);
			final ItemMeta kv = v.getItemMeta();
			kv.setDisplayName("§f» §cVoltar §f«");
			v.setItemMeta(kv);
			final ItemStack escada = new ItemStack(Material.VINE);
			final ItemMeta kescada = escada.getItemMeta();
			kescada.setDisplayName("§f-");
			escada.setItemMeta(kescada);
			inv.setItem(0, escada);
			inv.setItem(1, flame);
			inv.setItem(2, escada);
			inv.setItem(3, ender);
			inv.setItem(4, escada);
			inv.setItem(5, smoke);
			inv.setItem(6, escada);
			inv.setItem(7, redstone);
			inv.setItem(8, escada);
			inv.setItem(9, remover);
			inv.setItem(10, vidro);
			inv.setItem(11, vidro);
			inv.setItem(12, vidro);
			inv.setItem(13, v);
			inv.setItem(14, vidro);
			inv.setItem(15, vidro);
			inv.setItem(16, vidro);
			inv.setItem(17, remover);
			inv.setItem(18, escada);
			inv.setItem(19, diamond);
			inv.setItem(20, escada);
			inv.setItem(21, water);
			inv.setItem(22, escada);
			inv.setItem(23, potion);
			inv.setItem(24, escada);
			inv.setItem(25, rainbow);
			inv.setItem(26, escada);
			p.openInventory(inv);
			return true;
		}
		return false;
	}
}
