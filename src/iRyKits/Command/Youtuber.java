package iRyKits.Command;

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

public class Youtuber implements Listener, CommandExecutor {
	public Youtuber(final Main main) {
	}

	@EventHandler
	public void onClick(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§6§lRequisitos [§a§l1§6§l]")) {
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lTag Pro")) {
					p.chat("/req pro");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4§lTag Youtuber")) {
					p.chat("/req yt");
					p.closeInventory();
				}
			}
		}
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (Cmd.getName().equalsIgnoreCase("youtuber")) {
			final Player p = (Player) Sender;
			final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27,
					"§6§lRequisitos [§a§l1§6§l]");
			final ItemStack vidro = new ItemStack(Material.THIN_GLASS, 1, (short) 3);
			final ItemMeta metav = vidro.getItemMeta();
			metav.setDisplayName("§f-");
			vidro.setItemMeta(metav);
			final ItemStack lava = new ItemStack(Material.DIAMOND_BLOCK, 1);
			final ItemMeta lavak = lava.getItemMeta();
			lavak.setDisplayName("§4§lTag Youtuber");
			lava.setItemMeta(lavak);
			final ItemStack mdr = new ItemStack(Material.GOLD_BLOCK, 1);
			final ItemMeta kmdr = mdr.getItemMeta();
			kmdr.setDisplayName("§6§lTag Pro");
			mdr.setItemMeta(kmdr);
			final ItemStack escada = new ItemStack(Material.VINE);
			final ItemMeta kescada = escada.getItemMeta();
			kescada.setDisplayName("§f-");
			escada.setItemMeta(kescada);
			final ItemStack v = new ItemStack(Material.REDSTONE);
			final ItemMeta kv = v.getItemMeta();
			kv.setDisplayName("§f» §cVoltar §f«");
			v.setItemMeta(kv);
			inv.setItem(0, escada);
			inv.setItem(1, vidro);
			inv.setItem(2, escada);
			inv.setItem(3, vidro);
			inv.setItem(4, escada);
			inv.setItem(5, vidro);
			inv.setItem(6, escada);
			inv.setItem(7, vidro);
			inv.setItem(8, escada);
			inv.setItem(9, vidro);
			inv.setItem(10, vidro);
			inv.setItem(11, lava);
			inv.setItem(12, vidro);
			inv.setItem(13, vidro);
			inv.setItem(14, vidro);
			inv.setItem(15, mdr);
			inv.setItem(16, vidro);
			inv.setItem(17, vidro);
			inv.setItem(18, v);
			inv.setItem(19, vidro);
			inv.setItem(20, escada);
			inv.setItem(21, vidro);
			inv.setItem(22, escada);
			inv.setItem(23, vidro);
			inv.setItem(24, escada);
			inv.setItem(25, vidro);
			inv.setItem(26, v);
			p.openInventory(inv);
			return true;
		}
		return false;
	}

	@EventHandler
	public void playerCliqueNaRedstone(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.REDSTONE) {
			p.closeInventory();
			p.chat("/menu");
		}
	}
}
