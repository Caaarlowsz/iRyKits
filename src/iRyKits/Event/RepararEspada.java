package iRyKits.Event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RepararEspada implements Listener {
	@EventHandler
	public void onEntityDamageByEntity1(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			final Player d = (Player) e.getDamager();
			if (d.getItemInHand().getType() == Material.DIAMOND_SWORD
					|| d.getItemInHand().getType() == Material.WOOD_SWORD
					|| d.getItemInHand().getType() == Material.STONE_SWORD
					|| d.getItemInHand().getType() == Material.FISHING_ROD
					|| d.getItemInHand().getType() == Material.STONE_AXE || d.getItemInHand().getType() == Material.BOW
					|| d.getItemInHand().getType() == Material.IRON_SWORD
					|| d.getItemInHand().getType() == Material.DIAMOND_AXE) {
				d.getItemInHand().setDurability((short) 0);
			}
		}
	}
}
