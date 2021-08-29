package iRyKits.Event;

import iRyKits.Command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public class BuildEvent implements Listener
{
    @EventHandler
    public void Break(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (Build.Build.contains(p)) {
            e.setCancelled(false);
            return;
        }
        e.setCancelled(true);
    }
    
    @EventHandler
    public void Place(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (Build.Build.contains(p)) {
            e.setCancelled(false);
            return;
        }
        e.setCancelled(true);
    }
}
