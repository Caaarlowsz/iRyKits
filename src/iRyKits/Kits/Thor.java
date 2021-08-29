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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Thor implements Listener, CommandExecutor {
	public static Main plugin;
	static List<Player> cooldown;

	static {
		Thor.cooldown = new ArrayList<Player>();
	}

	public Thor(final Main main) {
		Thor.plugin = main;
	}

	public Thor() {
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Arrays.Thor.contains(p.getName())
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			final WorldGuardPlugin worldGuard = Main.getWorldGuard();
			final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
			final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
			if (set.allows(DefaultFlag.PVP)) {
				final ItemStack hand = p.getItemInHand();
				if (hand.getType() == Material.GOLD_AXE) {
					if (Thor.cooldown.contains(p)) {
						p.sendMessage(ChatColor.RED + "Cooldown");
					} else {
						final Location loc = p.getTargetBlock(null, 20).getLocation();
						p.getWorld().strikeLightning(loc);
						Thor.cooldown.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Thor.plugin,
								(Runnable) new Runnable() {
									@Override
									public void run() {
										Thor.cooldown.remove(p);
										p.sendMessage("§aO Cooldown Acabou!");
									}
								}, 120L);
					}
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("thor")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.thor")) {
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
			final ItemStack oi = new ItemStack(Material.GOLD_AXE);
			final ItemMeta koi = oi.getItemMeta();
			koi.setDisplayName("§aThor");
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cThor", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cThor");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(1, oi);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Thor");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Thor.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
