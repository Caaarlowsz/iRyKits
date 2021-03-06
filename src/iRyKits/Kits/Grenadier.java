package iRyKits.Kits;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Grenadier implements Listener, CommandExecutor {
	public static Main plugin;

	public Grenadier(final Main main) {
		Grenadier.plugin = main;
	}

	public Grenadier() {
	}

	@EventHandler
	public void lancar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)
				|| !Arrays.Grenadier.contains(p.getName()) || p.getItemInHand().getType() != Material.FLINT_AND_STEEL) {
			return;
		}
		final WorldGuardPlugin worldGuard = Main.getWorldGuard();
		final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
		final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
		if (set.allows(DefaultFlag.PVP)) {
			e.setCancelled(true);
			p.updateInventory();
			p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.FLINT_AND_STEEL, 1) });
			final Snowball granada = (Snowball) p.launchProjectile(Snowball.class);
			granada.setMetadata("granadier", (MetadataValue) new FixedMetadataValue(Main.plugin, (Object) true));
			p.playSound(p.getLocation(), Sound.FUSE, 1.0f, 1.0f);
			p.sendMessage(ChatColor.GOLD + "Granada jogada!");
			return;
		}
		p.sendMessage("?cVoc\u00ea pode usar sua habilidade somente em PvP");
	}

	@EventHandler
	public void explosao(final ProjectileHitEvent e) {
		if (e.getEntity() instanceof Snowball) {
			final Snowball b = (Snowball) e.getEntity();
			if (b.hasMetadata("granadier")) {
				b.getWorld().createExplosion(b.getLocation(), 3.0f);
			}
		}
	}

	@EventHandler
	public void dano(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION
					&& Arrays.Grenadier.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("grenadier")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.grenadier")) {
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
			final ItemStack grenadier = new ItemStack(Material.FLINT_AND_STEEL, 3);
			final ItemMeta kgrenadier = grenadier.getItemMeta();
			grenadier.setItemMeta(kgrenadier);
			BarAPI.setMessage(p, "?6Voc\u00ea Pegou o Kit >> ?cGrenadier", 2);
			p.sendMessage("?6Voc\u00ea Pegou o Kit >> ?cGrenadier");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, grenadier);
			Habilidade.setAbility(p, "Grenadier");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Grenadier.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
