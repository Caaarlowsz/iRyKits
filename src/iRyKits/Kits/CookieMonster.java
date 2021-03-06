package iRyKits.Kits;

import java.util.ArrayList;
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
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class CookieMonster implements Listener, CommandExecutor {
	public static Main plugin;
	static List<Player> cooldown;

	static {
		CookieMonster.cooldown = new ArrayList<Player>();
	}

	public void onRemove(final PlayerRespawnEvent e) {
		CookieMonster.cooldown.remove(e.getPlayer());
	}

	public void onRemove1(final PlayerJoinEvent e) {
		CookieMonster.cooldown.remove(e.getPlayer());
	}

	public CookieMonster(final Main main) {
		CookieMonster.plugin = main;
	}

	public CookieMonster() {
	}

	@EventHandler
	public void powerBush(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType() == Material.COOKIE
				&& Arrays.CookieMonster.contains(e.getPlayer().getName())) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
			}
			if (CookieMonster.cooldown.contains(p)) {
				p.sendMessage(ChatColor.RED + "Cooldown");
				return;
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0));
			CookieMonster.cooldown.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) CookieMonster.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							CookieMonster.cooldown.remove(p);
							p.sendMessage(ChatColor.GREEN + "O Cooldown Acabo!");
						}
					}, 700L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("cookiemonster")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.cookiemonster")) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "?e >> ?cSem Permiss\u00e3o!");
				return true;
			}
			if (Arrays.Used.contains(p.getName())) {
				p.sendMessage(String.valueOf(Strings.NomeServer) + "?e >> " + "?c1 Kit Por Vida");
				return true;
			}
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta kespada = espada.getItemMeta();
			kespada.setDisplayName("?5Espada");
			espada.setItemMeta(kespada);
			final ItemStack coo = new ItemStack(Material.COOKIE);
			final ItemMeta kcoo = coo.getItemMeta();
			kcoo.setDisplayName("?aCookieMonster");
			coo.setItemMeta(kcoo);
			BarAPI.setMessage(p, "?6Voc\u00ea Pegou o Kit >> ?cCookieMonster", 2);
			p.sendMessage("?6Voc\u00ea Pegou o Kit >> ?cCookieMonster");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, coo);
			Habilidade.setAbility(p, "CookieMonster");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.CookieMonster.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
