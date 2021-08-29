package iRyKits.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TagEntrar implements Listener {
	@EventHandler
	public void aoEntrarTag(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("tag.membro")) {
			p.chat("/tag membro");
		}
	}
}
