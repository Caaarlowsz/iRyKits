package iRyKits.Event;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import iRyKits.*;
import org.bukkit.event.*;

public class AntiSpam implements Listener
{
    public static HashMap<Player, Long> chat;
    
    static {
        AntiSpam.chat = new HashMap<Player, Long>();
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void aAntiSpam(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (!AntiSpam.chat.containsKey(p)) {
            final int zeitconfig = 2000;
            final long time = System.currentTimeMillis() + zeitconfig;
            if (p.hasPermission("iry.spam")) {
                return;
            }
            AntiSpam.chat.put(p, time);
        }
        else if (AntiSpam.chat.get(p) <= System.currentTimeMillis()) {
            if (p.hasPermission("iry.spam")) {
                return;
            }
            final int zeitconfig = 2000;
            final long time = System.currentTimeMillis() + zeitconfig;
            AntiSpam.chat.put(p, time);
        }
        else {
            if (AntiSpam.chat.get(p) < System.currentTimeMillis() || p.hasPermission("iry.spam")) {
                return;
            }
            p.sendMessage(Strings.MsgAntiSpam);
            e.setCancelled(true);
        }
    }
}
