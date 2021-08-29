package iRyKits.Event;

import org.bukkit.event.entity.*;
import org.bukkit.event.*;

public class SemExplosao implements Listener
{
    @EventHandler
    public void semExplosao(final EntityExplodeEvent e) {
        e.setCancelled(true);
    }
}
