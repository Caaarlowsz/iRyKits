package iRyKits.Efeitos;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import iRyKits.Main;

public class RedstoneBlock implements Listener, CommandExecutor {
	public static Main plugin;

	public RedstoneBlock(final Main main) {
		RedstoneBlock.plugin = main;
	}

	public RedstoneBlock() {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("efeito4") && p.hasPermission("iry.efeitos")) {
			if (Main.Efeitos.contains(p.getName())) {
				p.sendMessage("?4Voc\u00ea ja esta a utilizar um efeito use /removerefeito para escolher outro!");
				return true;
			}
			Main.Efeitos.add(p.getName());
			Main.Redstone.add(p.getName());
			p.sendMessage("?bEfeito >> REDSTONE_BLOCK << Ativado!");
			p.sendMessage("?bRemova o efeito usando /removerefeito");
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Main.Redstone.contains(p.getName())) {
						p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 10000000);
						p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 0.9, 0.0), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 200);
						p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 10000000);
						p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 0.9, 0.0), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 200);
						p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 1.1, 0.0), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 200);
						p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 10000000);
						p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 0.9, 0.0), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 200);
						p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 1.1, 0.0), Effect.STEP_SOUND,
								(Object) Material.REDSTONE_BLOCK, 200);
					}
				}
			}, 0L, 20L);
		} else {
			p.sendMessage("?4Voc\u00ea n\u00e3o tem permiss\u00e3o para usar efeitos!");
			p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0f, 1.0f);
		}
		return false;
	}

	@EventHandler
	public void onDeath(final PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = e.getEntity();
			Main.Redstone.remove(p.getName());
			Main.Efeitos.remove(p.getName());
		}
	}

	@EventHandler
	public void QuandoQuitar(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		Main.Redstone.remove(p.getName());
		Main.Efeitos.remove(p.getName());
	}
}
