package iRyKits.Event;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class TagEntrar implements Listener
{
    @EventHandler
    public void aoEntrarTag(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if (p.hasPermission("tag.membro")) {
            p.chat("/tag membro");
        }
    }
}
