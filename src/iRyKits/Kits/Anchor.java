package iRyKits.Kits;

import org.bukkit.Bukkit;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Anchor implements Listener, CommandExecutor {
	public static Main plugin;

	public Anchor(final Main main) {
		Anchor.plugin = main;
	}

	public Anchor() {
	}

	@EventHandler
	public void AnchorEvent(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player d = (Player) e.getDamager();
			if (Arrays.Anchor.contains(d.getName())) {
				p.setVelocity(new Vector());
				Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask((Plugin) Anchor.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								p.setVelocity(new Vector());
							}
						}, 1L);
			}
		}
	}

	@EventHandler
	public void AnchorKiller(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (Arrays.Anchor.contains(p.getName())) {
				p.setVelocity(new Vector());
				Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask((Plugin) Anchor.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								p.setVelocity(new Vector());
							}
						}, 1L);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("anchor")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.anchor")) {
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
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cAnchor", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cAnchor");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Anchor");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Anchor.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
