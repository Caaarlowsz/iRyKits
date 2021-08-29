package iRyKits.Event;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.Plugin;

import iRyKits.Main;

public class Drop implements Listener {
	private Main plugin;

	public Drop(final Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
				e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.ENDER_SIGNAL, 10);
			}
		}, 20L);
	}

	@EventHandler
	public void onPickup(final PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}
}
