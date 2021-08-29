package iRyKits.Event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import iRyKits.Strings;

public class NoCommand implements Listener {
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
