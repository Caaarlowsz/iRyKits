package iRyKits.Event;

import iRyKits.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class Drop implements Listener
{
    private Main plugin;
    
    public Drop(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onItemDrop(final ItemSpawnEvent e) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().remove();
                e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.ENDER_SIGNAL, 10);
            }
        }, 20L);
    }
    
    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }
}
