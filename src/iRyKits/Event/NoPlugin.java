package iRyKits.Event;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class NoPlugin implements Listener
{
    @EventHandler
    public void onPlugin(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (!p.hasPermission("iry.plugins") && (event.getMessage().toLowerCase().startsWith("/pl") || event.getMessage().toLowerCase().startsWith("/plugins") || event.getMessage().toLowerCase().startsWith("/bukkit:plugins"))) {
            event.setCancelled(true);
            p.sendMessage("§fPlugins (0): ");
        }
    }
}
