package iRyKits.Event;

import org.bukkit.event.player.*;
import org.bukkit.*;
import iRyKits.*;
import org.bukkit.entity.*;
import org.bukkit.help.*;
import org.bukkit.event.*;

public class NoCommand implements Listener
{
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final String cmd = event.getMessage().split(" ")[0];
            final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
            if (topic == null) {
                player.sendMessage(Strings.NoCommand);
                event.setCancelled(true);
            }
        }
    }
}
