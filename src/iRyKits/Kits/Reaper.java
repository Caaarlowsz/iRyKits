package iRyKits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Reaper implements Listener, CommandExecutor {
	public static Main plugin;

	public Reaper(final Main main) {
		Reaper.plugin = main;
	}

	public Reaper() {
	}

	@EventHandler
	public void OnClick(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player damager = (Player) e.getDamager();
			final Player victim = (Player) e.getEntity();
			if (Arrays.Reaper.contains(damager.getName())) {
				Arrays.Reaper.add(damager.getName());
				if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("reaper")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.reaper")) {
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
			final ItemStack r = new ItemStack(Material.WOOD_HOE);
			final ItemMeta kr = r.getItemMeta();
			kr.setDisplayName("§aReaper");
			r.setItemMeta(kr);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cReaper", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cReaper");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, r);
			Habilidade.setAbility(p, "Reaper");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Reaper.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
