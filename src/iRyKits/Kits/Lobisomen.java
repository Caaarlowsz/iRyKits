package iRyKits.Kits;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Lobisomen implements Listener, CommandExecutor {
	public static HashMap<String, Long> cooldown;
	public static Main plugin;

	static {
		Lobisomen.cooldown = new HashMap<String, Long>();
	}

	public Lobisomen(final Main main) {
		Lobisomen.plugin = main;
	}

	public Lobisomen() {
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Arrays.Lobisomen.contains(p.getName()) && p.getItemInHand().getType() == Material.MONSTER_EGG) {
			if (!Lobisomen.cooldown.containsKey(p.getName())
					|| Lobisomen.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				final Wolf w = (Wolf) p.getWorld().spawnEntity(new Location(p.getWorld(), p.getLocation().getX() + 2.0,
						p.getLocation().getY(), p.getLocation().getZ()), EntityType.WOLF);
				final Wolf w2 = (Wolf) p.getWorld().spawnEntity(new Location(p.getWorld(), p.getLocation().getX(),
						p.getLocation().getY(), p.getLocation().getZ() + 2.0), EntityType.WOLF);
				final Wolf w3 = (Wolf) p.getWorld().spawnEntity(new Location(p.getWorld(), p.getLocation().getX() + 2.0,
						p.getLocation().getY(), p.getLocation().getZ() + 2.0), EntityType.WOLF);
				w.setAngry(true);
				w.setOwner((AnimalTamer) p);
				w2.setAngry(true);
				w2.setOwner((AnimalTamer) p);
				w3.setAngry(true);
				w3.setOwner((AnimalTamer) p);
				final List<Entity> nearby = (List<Entity>) p.getNearbyEntities(5.0, 5.0, 5.0);
				for (final Entity en : nearby) {
					if (en instanceof Player) {
						final Player s = (Player) en;
						w.setTarget((LivingEntity) s);
						w2.setTarget((LivingEntity) s);
						w3.setTarget((LivingEntity) s);
					}
				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
				p.playSound(p.getLocation(), Sound.WOLF_HOWL, 1.0f, 1.0f);
				Lobisomen.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Cooldown");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("lobisomen")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.lobisomen")) {
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
			final ItemStack l = new ItemStack(Material.MONSTER_EGG);
			final ItemMeta kl = l.getItemMeta();
			kl.setDisplayName("§aLobisomen");
			l.setItemMeta(kl);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cLobisomen", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cLobisomen");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, l);
			Habilidade.setAbility(p, "Lobisomen");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Lobisomen.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
