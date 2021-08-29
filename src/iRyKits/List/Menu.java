package iRyKits.List;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class Menu implements Listener, CommandExecutor
{
    public Menu(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String CommandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("menu")) {
            final Inventory menu = Bukkit.createInventory((InventoryHolder)p, 27, "§6§lMenu [§a§l1§6§l]");
            p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
            final ItemStack vidro = new ItemStack(Material.THIN_GLASS);
            final ItemMeta kvidro = vidro.getItemMeta();
            kvidro.setDisplayName("§f-");
            vidro.setItemMeta(kvidro);
            final ItemStack shop = new ItemStack(Material.EMERALD);
            final ItemMeta kshop = shop.getItemMeta();
            kshop.setDisplayName("§2Loja De Kits");
            shop.setItemMeta(kshop);
            final ItemStack yt = new ItemStack(Material.DIAMOND);
            final ItemMeta kyt = yt.getItemMeta();
            kyt.setDisplayName("§bYoutuber");
            yt.setItemMeta(kyt);
            final ItemStack formu = new ItemStack(Material.PAPER);
            final ItemMeta kformu = formu.getItemMeta();
            kformu.setDisplayName("§dFormul\u00e1rio");
            formu.setItemMeta(kformu);
            final ItemStack efeitos = new ItemStack(Material.FIREWORK);
            final ItemMeta kefeitos = efeitos.getItemMeta();
            kefeitos.setDisplayName("§4Efeitos");
            efeitos.setItemMeta(kefeitos);
            final ItemStack escada = new ItemStack(Material.VINE);
            final ItemMeta kescada = escada.getItemMeta();
            kescada.setDisplayName("§f-");
            escada.setItemMeta(kescada);
            menu.setItem(0, escada);
            menu.setItem(1, vidro);
            menu.setItem(2, escada);
            menu.setItem(3, vidro);
            menu.setItem(4, escada);
            menu.setItem(5, vidro);
            menu.setItem(6, escada);
            menu.setItem(7, vidro);
            menu.setItem(8, escada);
            menu.setItem(9, vidro);
            menu.setItem(10, yt);
            menu.setItem(11, vidro);
            menu.setItem(12, formu);
            menu.setItem(13, vidro);
            menu.setItem(14, shop);
            menu.setItem(15, vidro);
            menu.setItem(16, efeitos);
            menu.setItem(17, vidro);
            menu.setItem(18, escada);
            menu.setItem(19, vidro);
            menu.setItem(20, escada);
            menu.setItem(21, vidro);
            menu.setItem(22, escada);
            menu.setItem(23, vidro);
            menu.setItem(24, escada);
            menu.setItem(25, vidro);
            menu.setItem(26, escada);
            p.openInventory(menu);
        }
        return false;
    }
    
    @EventHandler
    public void clickevent(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§6§lMenu [§a§l1§6§l]")) {
            e.getCurrentItem();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bYoutuber")) {
                p.closeInventory();
                p.chat("/youtuber");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dFormul\u00e1rio")) {
                p.closeInventory();
                p.chat("/formulario");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Loja De Kits")) {
                p.closeInventory();
                p.chat("/shop");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Efeitos")) {
                p.closeInventory();
                p.chat("/efeitos");
            }
        }
    }
}
