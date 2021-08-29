package iRyKits.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class NoPlugin implements Listener {
	@EventHandler
	public void onPlugin(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		if (!p.hasPermission("iry.plugins") && (event.getMessage().toLowerCase().startsWith("/pl")
				|| event.getMessage().toLowerCase().startsWith("/plugins")
				|| event.getMessage().toLowerCase().startsWith("/bukkit:plugins"))) {
			event.setCancelled(true);
			p.sendMessage("§fPlugins (0): ");
		}
	}
}
