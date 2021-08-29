package iRyKits.Kits;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Ninja implements Listener, CommandExecutor {
	public static HashMap<Player, Player> a;
	public static HashMap<Player, Long> b;
	public static List<Player> cooldownbk;
	public static Main plugin;

	static {
		Ninja.a = new HashMap<Player, Player>();
		Ninja.b = new HashMap<Player, Long>();
		Ninja.cooldownbk = new ArrayList<Player>();
	}

	public Ninja(final Main main) {
		Ninja.plugin = main;
	}

	public Ninja() {
	}

	@EventHandler
	public void a(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (paramEntityDamageByEntityEvent.getDamager() instanceof Player
				&& paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			final Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (Arrays.Ninja.contains(localPlayer1.getName())) {
				Ninja.a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Ninja.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								Ninja.cooldownbk.remove(localPlayer1);
							}
						}, 200L);
			}
		}
	}

	@EventHandler
	public void a(final PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		final Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		if (paramPlayerToggleSneakEvent.isSneaking() && Arrays.Ninja.contains(localPlayer1.getName())
				&& Ninja.a.containsKey(localPlayer1)) {
			final Player localPlayer2 = Ninja.a.get(localPlayer1);
			if (localPlayer2 != null && !localPlayer2.isDead()) {
				String str = null;
				if (Ninja.b.get(localPlayer1) != null) {
					final long l = Ninja.b.get(localPlayer1) - System.currentTimeMillis();
					final DecimalFormat localDecimalFormat = new DecimalFormat("##");
					final int i = (int) l / 1000;
					str = localDecimalFormat.format(i);
				}
				if (Ninja.b.get(localPlayer1) == null || Ninja.b.get(localPlayer1) < System.currentTimeMillis()) {
					if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0) {
						localPlayer1.teleport(localPlayer2.getLocation());
						localPlayer1.sendMessage(ChatColor.GREEN + "Teleportado");
						Ninja.b.put(localPlayer1, System.currentTimeMillis() + 1500L);
					} else {
						localPlayer1.sendMessage(ChatColor.RED + "O Ultimo jogador hitado esta muito longe!");
					}
				} else {
					localPlayer1.sendMessage("§cEspere §f> §6" + str + " segundos §cpara usar novamente !");
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("ninja")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.ninja")) {
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
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cNinja", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cNinja");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Ninja");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Ninja.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
