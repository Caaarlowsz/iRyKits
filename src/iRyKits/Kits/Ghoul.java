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
import org.bukkit.entity.Player;
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

public class Ghoul implements Listener, CommandExecutor {
	public static HashMap<String, Long> cooldown;
	public static Main plugin;

	static {
		Ghoul.cooldown = new HashMap<String, Long>();
	}

	public Ghoul(final Main main) {
		Ghoul.plugin = main;
	}

	public Ghoul() {
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Arrays.Ghoul.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE) {
			if (!Ghoul.cooldown.containsKey(p.getName())
					|| Ghoul.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				p.sendMessage(ChatColor.RED + "Minha fome n\u00e3o pode ser saciada!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 3));
				p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 500, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
				p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1.0f, 1.0f);
				Ghoul.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Cooldown");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("ghoul")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.ghoul")) {
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
			final ItemStack gh = new ItemStack(Material.REDSTONE);
			final ItemMeta kgh = gh.getItemMeta();
			kgh.setDisplayName("§aGhoul");
			gh.setItemMeta(kgh);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cGhoul", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cGhoul");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, gh);
			Habilidade.setAbility(p, "Ghoul");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Ghoul.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
