package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class NPCRecraft implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("recraft") && p.hasPermission("iry.recraft")) {
            final Villager vill = (Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            vill.setCustomName("§9Recraft");
            vill.setCustomNameVisible(true);
            vill.setProfession(Villager.Profession.BUTCHER);
        }
        return false;
    }
    
    @EventHandler
    public void onQuest(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager) {
            final ItemStack Recraft = new ItemStack(Material.BOWL, 64);
            final ItemMeta kRecraft = Recraft.getItemMeta();
            kRecraft.setDisplayName(ChatColor.GRAY + "§3--> §7Pote §3<--");
            Recraft.setItemMeta(kRecraft);
            final ItemStack Recraft2 = new ItemStack(Material.RED_MUSHROOM, 64);
            final ItemMeta kRecraft2 = Recraft2.getItemMeta();
            kRecraft2.setDisplayName(ChatColor.GRAY + "§3--> §cVermelho §3<--");
            Recraft2.setItemMeta(kRecraft2);
            final ItemStack Recraft3 = new ItemStack(Material.BROWN_MUSHROOM, 64);
            final ItemMeta kRecraft3 = Recraft3.getItemMeta();
            kRecraft3.setDisplayName(ChatColor.GRAY + "§3--> §8Marrom §3<--");
            Recraft3.setItemMeta(kRecraft3);
            final Player p = e.getPlayer();
            final Villager vill = (Villager)e.getRightClicked();
            if (vill.getCustomName().equals("§9Recraft")) {
                e.setCancelled(true);
                final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 27, "§9Recraft");
                for (int i = 0; i < inv.getSize(); ++i) {
                    inv.addItem(new ItemStack[] { new ItemStack(Recraft) });
                    inv.addItem(new ItemStack[] { new ItemStack(Recraft2) });
                    inv.addItem(new ItemStack[] { new ItemStack(Recraft3) });
                }
                p.openInventory(inv);
            }
        }
    }
    
    @EventHandler
    public void onQuest2(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Villager && e.getDamager() instanceof Player) {
            final Villager vill = (Villager)e.getEntity();
            if (vill.getCustomName().equals("§9Recraft")) {
                e.setCancelled(true);
            }
        }
    }
}
