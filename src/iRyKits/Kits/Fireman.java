package iRyKits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Fireman implements Listener, CommandExecutor {
	public static Main plugin;

	public Fireman(final Main main) {
		Fireman.plugin = main;
	}

	public Fireman() {
	}

	@EventHandler
	public void damage(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (Arrays.Fireman.contains(p.getName()) && (e.getCause() == EntityDamageEvent.DamageCause.LAVA
					|| e.getCause() == EntityDamageEvent.DamageCause.FIRE
					|| e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void stonemanEvent(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (!event.getFrom().getBlock().getLocation().equals((Object) event.getTo().getBlock().getLocation())) {
			return;
		}
		final Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
		if (block.getType() == Material.STATIONARY_WATER && Arrays.Fireman.contains(player.getName())) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
		}
	}

	@EventHandler
	public void Fogo(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (Arrays.Fireman.contains(p.getName()) && p.getInventory().getItemInHand() != null
					&& p.getInventory().getItemInHand().getType() == Material.STONE_SWORD
					&& e.getEntity() instanceof LivingEntity) {
				final LivingEntity en = (LivingEntity) e.getEntity();
				if (en.isDead()) {
					return;
				}
				en.setFireTicks(100);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("fireman")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.fireman")) {
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
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cFireman", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cFireman");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Fireman");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Fireman.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
