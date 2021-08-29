package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class NPCSopa implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("sopa") && p.hasPermission("iry.sopa")) {
            final Villager vill = (Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            vill.setCustomName("§bSopas");
            vill.setCustomNameVisible(true);
            vill.setProfession(Villager.Profession.BUTCHER);
        }
        return false;
    }
    
    @EventHandler
    public void onQuest(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager) {
            final ItemStack Pote = new ItemStack(Material.MUSHROOM_SOUP);
            final ItemMeta kPote = Pote.getItemMeta();
            kPote.setDisplayName(ChatColor.GRAY + "§3--> §6Sopa §3<--");
            Pote.setItemMeta(kPote);
            final Player p = e.getPlayer();
            final Villager vill = (Villager)e.getRightClicked();
            if (vill.getCustomName().equals("§bSopas")) {
                e.setCancelled(true);
                final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 54, "§bSopas");
                for (int i = 0; i < inv.getSize(); ++i) {
                    inv.addItem(new ItemStack[] { new ItemStack(Pote) });
                }
                p.openInventory(inv);
            }
        }
    }
    
    @EventHandler
    public void onQuest2(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Villager && e.getDamager() instanceof Player) {
            final Villager vill = (Villager)e.getEntity();
            if (vill.getCustomName().equals("§bSopas")) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void SemTomarDano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Villager) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void SemTomarDanoExplosion(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Villager) {
            e.setCancelled(true);
        }
    }
}
