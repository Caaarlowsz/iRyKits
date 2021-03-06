package iRyKits.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class SpiderMan implements Listener, CommandExecutor {
	public static HashMap<String, Long> cooldown;
	public static HashMap<String, Snowball> teias;
	public static Main plugin;

	static {
		SpiderMan.cooldown = new HashMap<String, Long>();
		SpiderMan.teias = new HashMap<String, Snowball>();
	}

	public SpiderMan(final Main main) {
		SpiderMan.plugin = main;
	}

	public SpiderMan() {
	}

	@EventHandler
	public void lancar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Arrays.SpiderMan.contains(p.getName()) && p.getItemInHand().getType() == Material.STRING) {
			e.setCancelled(true);
			p.updateInventory();
			if (!SpiderMan.cooldown.containsKey(p.getName())
					|| SpiderMan.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				final WorldGuardPlugin worldGuard = Main.getWorldGuard();
				final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
				final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
				if (set.allows(DefaultFlag.PVP)) {
					final Snowball teia = (Snowball) p.launchProjectile(Snowball.class);
					SpiderMan.teias.put(p.getName(), teia);
					SpiderMan.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10L));
					p.sendMessage(ChatColor.DARK_PURPLE + "Teia lan\u00e7ada!");
					p.playSound(p.getLocation(), Sound.IRONGOLEM_THROW, 1.0f, 1.0f);
					return;
				}
				p.sendMessage(ChatColor.RED + "Voc\u00ea pode usar esta habilidade apenas em areas com PVP");
			} else {
				p.sendMessage(ChatColor.RED + "Cooldown");
			}
		}
	}

	@EventHandler
	public void teia(final ProjectileHitEvent e) {
		if (e.getEntity() instanceof Snowball && e.getEntity().getShooter() instanceof Player) {
			final Snowball teia = (Snowball) e.getEntity();
			final Player p = (Player) e.getEntity().getShooter();
			if (SpiderMan.teias.containsKey(p.getName()) && teia == SpiderMan.teias.get(p.getName())) {
				SpiderMan.teias.remove(p.getName());
				final Block b = teia.getLocation().getBlock();
				b.setType(Material.WEB);
				new BukkitRunnable() {
					public void run() {
						if (b.getType() == Material.WEB) {
							b.setType(Material.AIR);
						}
					}
				}.runTaskLater(Main.plugin, 100L);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("spiderman")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.spiderman")) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "?e >> ?cSem Permiss\u00e3o!");
				return true;
			}
			if (Arrays.Used.contains(p.getName())) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "?e >> " + "?c1 Kit Por Vida");
				return true;
			}
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta kespada = espada.getItemMeta();
			kespada.setDisplayName("?5Espada");
			espada.setItemMeta(kespada);
			final ItemStack spider = new ItemStack(Material.STRING);
			final ItemMeta kspider = espada.getItemMeta();
			kspider.setDisplayName("?aSpider");
			spider.setItemMeta(kspider);
			BarAPI.setMessage(p, "?6Voc\u00ea Pegou o Kit >> ?cSpiderMan", 2);
			p.sendMessage("?6Voc\u00ea Pegou o Kit >> ?cSpiderMan");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, spider);
			Habilidade.setAbility(p, "SpiderMan");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.SpiderMan.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
