package iRyKits.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Stomper implements Listener, CommandExecutor {
	public static Main plugin;
	static List<Player> cooldownm;

	static {
		Stomper.cooldownm = new ArrayList<Player>();
	}

	public Stomper(final Main main) {
		Stomper.plugin = main;
	}

	public Stomper() {
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerStomp(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Arrays.Stomper.contains(p.getName())) {
			for (final Entity ent : p.getNearbyEntities(4.0, 1.5, 4.0)) {
				if (ent instanceof Player) {
					final Player plr = (Player) ent;
					if (e.getDamage() <= 4.0) {
						e.setCancelled(true);
						return;
					}
					if (plr.isSneaking()) {
						plr.damage(6.0, (Entity) p);
						plr.sendMessage("§a§oVoc\u00ea foi stompado por:§c§o " + p.getName());
					} else {
						plr.damage(e.getDamage(), (Entity) p);
						plr.sendMessage("§a§oVoc\u00ea foi stompado por:§c§o " + p.getName());
					}
				}
			}
			e.setDamage(4.0);
		}
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE
				&& Arrays.Stomper.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Stomper.cooldownm.contains(p)) {
				p.sendMessage("§cCooldown");
				return;
			}
			final Vector vector = p.getEyeLocation().getDirection();
			vector.multiply(0.0f);
			vector.setY(6.0f);
			p.setVelocity(vector);
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.DIG_WOOL, 5.0f, -5.0f);
			Stomper.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Stomper.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Stomper.cooldownm.remove(p);
							p.sendMessage(ChatColor.GREEN + "O Cooldown Acabou!");
						}
					}, 1000L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("stomper")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.stomper")) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> §cSem Permiss\u00e3o!");
				return true;
			}
			if (Arrays.Used.contains(p.getName())) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> " + "§c1 Kit Por Vida");
				return true;
			}
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta kespada = espada.getItemMeta();
			kespada.setDisplayName("§5Espada");
			espada.setItemMeta(kespada);
			final ItemStack sl = new ItemStack(Material.GOLDEN_APPLE);
			final ItemMeta ksl = sl.getItemMeta();
			ksl.setDisplayName("§aStomper - Bust");
			sl.setItemMeta(ksl);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cStomper", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cStomper");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(1, sl);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Stomper");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Stomper.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
