package iRyKits.Kits;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
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

public class Ebola implements Listener, CommandExecutor {
	public static Main plugin;

	public Ebola(final Main main) {
		Ebola.plugin = main;
	}

	public Ebola() {
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player) || !(e.getEntity() instanceof LivingEntity)) {
			return;
		}
		final LivingEntity entity = (LivingEntity) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (!Arrays.Ebola.contains(p.getName())) {
			return;
		}
		final Random rand = new Random();
		final int percent = rand.nextInt(100);
		if (percent <= 9) {
			entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
			entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
			entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
			p.sendMessage("§bVoc\u00ea transmitiu sua doen\u00e7a para um jogador.");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("ebola")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.ebola")) {
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
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cEbola", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cEbola");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Ebola");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Ebola.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
