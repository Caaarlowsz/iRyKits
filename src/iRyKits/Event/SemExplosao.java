package iRyKits.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class SemExplosao implements Listener {
	@EventHandler
	public void semExplosao(final EntityExplodeEvent e) {
		e.setCancelled(true);
	}
}
