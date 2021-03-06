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

public class Morf implements Listener, CommandExecutor {
	public static HashMap<String, Long> cooldown;
	public static Main plugin;

	static {
		Morf.cooldown = new HashMap<String, Long>();
	}

	public Morf(final Main main) {
		Morf.plugin = main;
	}

	public Morf() {
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Arrays.Morf.contains(p.getName()) && p.getItemInHand().getType() == Material.BLAZE_POWDER) {
			if (!Morf.cooldown.containsKey(p.getName())
					|| Morf.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				p.sendMessage(ChatColor.AQUA + "žlMorfando...");
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 250, 0));
				p.playSound(p.getLocation(), Sound.BAT_IDLE, 1.0f, 1.0f);
				Morf.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Cooldown");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("morf")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.morf")) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "že >> žcSem Permiss\u00e3o!");
				return true;
			}
			if (Arrays.Used.contains(p.getName())) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "že >> " + "žc1 Kit Por Vida");
				return true;
			}
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta kespada = espada.getItemMeta();
			kespada.setDisplayName("ž5Espada");
			espada.setItemMeta(kespada);
			final ItemStack mf = new ItemStack(Material.BLAZE_POWDER);
			final ItemMeta kmf = mf.getItemMeta();
			kmf.setDisplayName("žaMorf");
			mf.setItemMeta(kmf);
			BarAPI.setMessage(p, "ž6Voc\u00ea Pegou o Kit >> žcMorf", 2);
			p.sendMessage("ž6Voc\u00ea Pegou o Kit >> žcMorf");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, mf);
			Habilidade.setAbility(p, "Morf");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Morf.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
