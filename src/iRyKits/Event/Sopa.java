package iRyKits.Event;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Main;

public class Sopa implements Listener {
	public Sopa(final Main main) {
	}

	@EventHandler
	public void onSoup(final PlayerInteractEvent e) {
		final ItemStack pote = new ItemStack(Material.BOWL, 1);
		final ItemMeta kpote = pote.getItemMeta();
		kpote.setDisplayName("§3--> §7Pote §3<--");
		pote.setItemMeta(kpote);
		final Damageable hp;
		final Player p = (Player) (hp = (Damageable) e.getPlayer());
		if (hp.getHealth() != 20.0) {
			final int sopa = 7;
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getTypeId() == 282) {
				p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
				p.getItemInHand().setType(Material.BOWL);
				p.getItemInHand().setItemMeta(kpote);
				p.getItemInHand().setType(Material.BOWL);
				p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
			}
		}
	}
}
