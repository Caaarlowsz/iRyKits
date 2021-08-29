package iRyKits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Switcher implements Listener, CommandExecutor {
	public long cooldownLenght;
	public static Main plugin;

	public Switcher(final Main main) {
		this.cooldownLenght = 0L;
		Switcher.plugin = main;
	}

	public Switcher() {
		this.cooldownLenght = 0L;
	}

	@EventHandler
	public void snowball(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
			final Snowball s = (Snowball) e.getDamager();
			final Player shooter = (Player) s.getShooter();
			if (s.getShooter() instanceof Player && Arrays.Switcher.contains(shooter.getName())) {
				if (this.hasCooldown1()) {
					shooter.sendMessage("§cAguarde " + this.cooldownTimeRemaining1());
					return;
				}
				final Location shooterLoc = shooter.getLocation();
				shooter.teleport(e.getEntity().getLocation());
				e.getEntity().teleport(shooterLoc);
				this.addCooldown1(shooter, 10);
			}
		}
	}

	public void addCooldown1(final Player player, final int seconds) {
		this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
	}

	public String cooldownTimeRemaining1() {
		final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
		if (faltam < 60L) {
			return String.valueOf(faltam) + " segundos restantes";
		}
		return String.valueOf(faltam) + " minutos restantes";
	}

	public boolean hasCooldown1() {
		return this.cooldownLenght > System.currentTimeMillis();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("switcher")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.switcher")) {
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
			final ItemStack switcher = new ItemStack(Material.SNOW_BALL, 32);
			final ItemMeta kswitcher = switcher.getItemMeta();
			kswitcher.setDisplayName("§aSwitcher");
			switcher.setItemMeta(kswitcher);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cSwitcher", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cSwitcher");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, switcher);
			Habilidade.setAbility(p, "Switcher");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Switcher.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
