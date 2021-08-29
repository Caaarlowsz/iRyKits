package iRyKits.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Sniper implements Listener, CommandExecutor {
	public static HashMap<String, Long> cooldown;
	public static HashMap<String, Arrow> tiros;
	public static Main plugin;

	static {
		Sniper.cooldown = new HashMap<String, Long>();
		Sniper.tiros = new HashMap<String, Arrow>();
	}

	public Sniper(final Main main) {
		Sniper.plugin = main;
	}

	public Sniper() {
	}

	@EventHandler
	public void disparar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.IRON_BARDING && Arrays.Sniper.contains(p.getName())) {
			final WorldGuardPlugin worldGuard = Main.getWorldGuard();
			final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
			final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
			if (set.allows(DefaultFlag.PVP)) {
				if (!Sniper.cooldown.containsKey(p.getName())
						|| Sniper.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
					e.setCancelled(true);
					p.updateInventory();
					final Arrow tiro = (Arrow) p.launchProjectile(Arrow.class);
					final Vector vec = p.getLocation().getDirection();
					tiro.setVelocity(
							new Vector(vec.getX() * 1.0 * 3.5, vec.getY() * 1.0 * 4.0, vec.getZ() * 1.0 * 3.5));
					Sniper.tiros.put(p.getName(), tiro);
					Sniper.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
					p.sendMessage(ChatColor.GOLD + "Dardo disparado!");
					p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
					return;
				}
				p.sendMessage(ChatColor.RED + "Cooldown");
			} else {
				p.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
			}
		}
	}

	@EventHandler
	public void aplicar(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
			final Arrow tiro = (Arrow) e.getDamager();
			if (tiro.getShooter() instanceof Player) {
				final Player shooter = (Player) tiro.getShooter();
				if (Sniper.tiros.containsKey(shooter.getName()) && tiro == Sniper.tiros.get(shooter.getName())) {
					e.setDamage(50.0);
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("sniper")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.sniper")) {
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
			final ItemStack snip = new ItemStack(Material.IRON_BARDING);
			final ItemMeta ksnip = snip.getItemMeta();
			ksnip.setDisplayName("§aSniper");
			snip.setItemMeta(ksnip);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cSniper", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cSniper");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, snip);
			Habilidade.setAbility(p, "Sniper");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Sniper.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
