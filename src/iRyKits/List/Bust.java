package iRyKits.List;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import iRyKits.Arrays;
import iRyKits.Main;

public class Bust implements Listener {
	public static ArrayList<String> jump;
	ArrayList<String> nofalldamage;
	ArrayList<String> nofalldamagewait;

	static {
		Bust.jump = new ArrayList<String>();
	}

	public Bust(final Main main) {
		this.nofalldamage = new ArrayList<String>();
		this.nofalldamagewait = new ArrayList<String>();
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
			Bust.jump.remove(p.getName());
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(10);
			p.setVelocity(sponge);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
			Bust.jump.add(p.getName());
			Bust.jump.remove(p.getName());
			Bust.jump.add(p.getName());
		}
	}

	@EventHandler
	public void onPlayerDamageCoisaBugada(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Bust.jump.contains(p.getName())) {
			Bust.jump.remove(p.getName());
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponge(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getEntity();
		final Location loc = player.getLocation();
		final Location below = loc.subtract(0.0, 3.0, 0.0);
		final Block blockBelow = below.getBlock();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (blockBelow.getType() == Material.SPONGE) {
			Bust.jump.add(player.getName());
			event.setDamage(0.0);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerSpongeDamage(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Bust.jump.contains(p.getName())) {
			Bust.jump.remove(p.getName());
			e.setDamage(0.0);
		}
	}

	@EventHandler
	public void onPlayerFrente(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() != Material.REDSTONE_BLOCK) {
			return;
		}
		if (!Arrays.Used.contains(p.getName())) {
			p.sendMessage("§cVoc\u00ea n\u00e3o escolheu nenhum kit, Dando Kit PvP !");
			p.getInventory().clear();
			p.chat("/pvp");
			return;
		}
		final Location loc = e.getTo().getBlock().getLocation();
		p.playSound(loc, Sound.ENDERDRAGON_HIT, 6.0f, 1.0f);
		p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, (Object) null);
		final Vector sponge = p.getLocation().getDirection().multiply(3.5).setY(0.35);
		p.setVelocity(sponge);
		Bust.jump.add(p.getName());
	}

	@EventHandler
	public void onPlayerDamageSponge1(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Bust.jump.contains(p.getName())) {
			Bust.jump.remove(p.getName());
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponge1(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getEntity();
		final Location loc = player.getLocation();
		final Location below = loc.subtract(0.0, 1.0, 0.0);
		final Block blockBelow = below.getBlock();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (blockBelow.getType() == Material.SPONGE) {
			Bust.jump.add(player.getName());
			event.setDamage(0.0);
		}
	}

	@EventHandler
	public void onPlayerJumpBaixo(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PISTON_BASE) {
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
			p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 999));
			p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
			p.setVelocity(sponge);
			if (!this.nofalldamage.contains(p.getName())) {
				this.nofalldamage.add(p.getName());
			}
		}
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player player = (Player) event.getEntity();
			if (this.nofalldamage.contains(player.getName())
					&& event.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)) {
				event.setCancelled(true);
				this.nofalldamage.remove(player.getName());
			}
		}
	}
}
