package iRyKits.Event;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.event.block.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;

public class PlacaDeSopa implements Listener
{
    private PlacaDeSopa plugin;
    
    public PlacaDeSopa(final PlacaDeSopa instance) {
        this.plugin = instance;
    }
    
    public PlacaDeSopa() {
    }
    
    @EventHandler
    public void onSignChange(final SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("sopa")) {
            e.setLine(0, "§4=-=()=-=");
            e.setLine(1, "§2Gratis");
            e.setLine(2, "§bSopas!");
            e.setLine(3, "§4=-=()=-=");
        }
    }
    
    @EventHandler
    public void inv(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta ksopas = sopas.getItemMeta();
        ksopas.setDisplayName("§3--> §6Sopa §3<--");
        sopas.setItemMeta(ksopas);
        final Inventory inve = Bukkit.getServer().createInventory((InventoryHolder)p, 36, "§bSopas");
        inve.setItem(0, sopas);
        inve.setItem(1, sopas);
        inve.setItem(2, sopas);
        inve.setItem(3, sopas);
        inve.setItem(4, sopas);
        inve.setItem(5, sopas);
        inve.setItem(6, sopas);
        inve.setItem(7, sopas);
        inve.setItem(8, sopas);
        inve.setItem(9, sopas);
        inve.setItem(10, sopas);
        inve.setItem(11, sopas);
        inve.setItem(12, sopas);
        inve.setItem(13, sopas);
        inve.setItem(14, sopas);
        inve.setItem(15, sopas);
        inve.setItem(16, sopas);
        inve.setItem(17, sopas);
        inve.setItem(18, sopas);
        inve.setItem(19, sopas);
        inve.setItem(20, sopas);
        inve.setItem(21, sopas);
        inve.setItem(22, sopas);
        inve.setItem(23, sopas);
        inve.setItem(24, sopas);
        inve.setItem(25, sopas);
        inve.setItem(26, sopas);
        inve.setItem(27, sopas);
        inve.setItem(28, sopas);
        inve.setItem(29, sopas);
        inve.setItem(30, sopas);
        inve.setItem(31, sopas);
        inve.setItem(32, sopas);
        inve.setItem(33, sopas);
        inve.setItem(34, sopas);
        inve.setItem(35, sopas);
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)) {
            final Sign s = (Sign)e.getClickedBlock().getState();
            final String[] lines = s.getLines();
            if (lines.length > 0 && lines[0].equals("§4=-=()=-=") && lines.length > 1 && lines[1].equals("§2Gratis") && lines.length > 2 && lines[2].equals("§bSopas!") && lines.length > 3 && lines[3].equals("§4=-=()=-=")) {
                p.openInventory(inve);
            }
        }
    }
    
    @EventHandler
    public void onPlayerColor(final SignChangeEvent e) {
        if (e.getLine(0).contains("&")) {
            e.setLine(0, e.getLine(0).replace("&", "§"));
        }
        if (e.getLine(1).contains("&")) {
            e.setLine(1, e.getLine(1).replace("&", "§"));
        }
        if (e.getLine(2).contains("&")) {
            e.setLine(2, e.getLine(2).replace("&", "§"));
        }
        if (e.getLine(3).contains("&")) {
            e.setLine(3, e.getLine(3).replace("&", "§"));
        }
    }
}
