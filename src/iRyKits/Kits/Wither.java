package iRyKits.Kits;

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

public class Wither implements Listener, CommandExecutor {
	public static Main plugin;

	public Wither(final Main main) {
		Wither.plugin = main;
	}

	public Wither() {
	}

	@EventHandler(ignoreCancelled = true)
	public void Snail(final EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player) {
			final Player damager = (Player) event.getDamager();
			if (damager.getInventory().getItemInHand().getType() == Material.NETHER_STAR
					&& Arrays.Wither.contains(damager.getName()) && Math.random() < 0.5) {
				((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 300, 0));
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("wither")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.wither")) {
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
			final ItemStack wither = new ItemStack(Material.NETHER_STAR);
			final ItemMeta kwither = wither.getItemMeta();
			kwither.setDisplayName("§aWither-Boss");
			wither.setItemMeta(kwither);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cWhiter", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cWhiter");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, wither);
			Habilidade.setAbility(p, "Wither");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Wither.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
