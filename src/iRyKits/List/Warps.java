package iRyKits.List;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class Warps implements Listener, CommandExecutor
{
    public Warps(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String CommandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("warps")) {
            final Inventory warps = Bukkit.createInventory((InventoryHolder)p, 27, "§6§lWarps [§a§l1§6§l]");
            p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
            final ItemStack vidro = new ItemStack(Material.THIN_GLASS);
            final ItemMeta kvidro = vidro.getItemMeta();
            kvidro.setDisplayName("§f-");
            vidro.setItemMeta(kvidro);
            final ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
            final ItemMeta klava = lava.getItemMeta();
            klava.setDisplayName("§aLava Challenge");
            lava.setItemMeta(klava);
            final ItemStack fps = new ItemStack(Material.getMaterial(95));
            final ItemMeta kfps = fps.getItemMeta();
            kfps.setDisplayName("§aFps");
            fps.setItemMeta(kfps);
            final ItemStack umv1 = new ItemStack(Material.BLAZE_ROD);
            final ItemMeta kumv1 = umv1.getItemMeta();
            kumv1.setDisplayName("§a1v1");
            umv1.setItemMeta(kumv1);
            final ItemStack main = new ItemStack(Material.DIAMOND_SWORD);
            final ItemMeta kmain = main.getItemMeta();
            kmain.setDisplayName("§aMain");
            main.setItemMeta(kmain);
            final ItemStack mdr = new ItemStack(Material.MUSHROOM_SOUP);
            final ItemMeta kmdr = mdr.getItemMeta();
            kmdr.setDisplayName("§aMdr");
            mdr.setItemMeta(kmdr);
            final ItemStack rdm = new ItemStack(Material.CAKE);
            final ItemMeta krdm = rdm.getItemMeta();
            krdm.setDisplayName("§aRdm");
            rdm.setItemMeta(krdm);
            final ItemStack escada = new ItemStack(Material.VINE);
            final ItemMeta kescada = escada.getItemMeta();
            kescada.setDisplayName("§f-");
            escada.setItemMeta(kescada);
            warps.setItem(0, escada);
            warps.setItem(1, vidro);
            warps.setItem(2, escada);
            warps.setItem(3, vidro);
            warps.setItem(4, mdr);
            warps.setItem(5, vidro);
            warps.setItem(6, escada);
            warps.setItem(7, vidro);
            warps.setItem(8, escada);
            warps.setItem(9, vidro);
            warps.setItem(10, umv1);
            warps.setItem(11, vidro);
            warps.setItem(12, fps);
            warps.setItem(13, vidro);
            warps.setItem(14, lava);
            warps.setItem(15, vidro);
            warps.setItem(16, main);
            warps.setItem(17, vidro);
            warps.setItem(18, escada);
            warps.setItem(19, vidro);
            warps.setItem(20, escada);
            warps.setItem(21, vidro);
            warps.setItem(22, rdm);
            warps.setItem(23, vidro);
            warps.setItem(24, escada);
            warps.setItem(25, vidro);
            warps.setItem(26, escada);
            p.openInventory(warps);
        }
        return false;
    }
    
    @EventHandler
    public void clickevent(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§6§lWarps [§a§l1§6§l]")) {
            e.getCurrentItem();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFps")) {
                p.closeInventory();
                p.chat("/fps");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLava Challenge")) {
                p.closeInventory();
                p.chat("/challenge");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a1v1")) {
                p.closeInventory();
                p.chat("/1v1");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMain")) {
                p.closeInventory();
                p.chat("/main");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMdr")) {
                p.closeInventory();
                p.chat("/mdr");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRdm")) {
                p.closeInventory();
                p.chat("/rdm");
            }
        }
    }
}
