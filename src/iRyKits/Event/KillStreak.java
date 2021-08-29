package iRyKits.Event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

import iRyKits.Main;

public class KillStreak implements Listener {
	Main plugin;

	public KillStreak(final Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onKillLevel(final PlayerDeathEvent event) {
		if (!(event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		if (event.getEntity().getKiller() == null) {
			return;
		}
		final Player p = event.getEntity();
		final Player k = p.getKiller();
		k.setLevel(k.getLevel() + 1);
		p.setLevel(0);
	}

	@EventHandler
	public void onLevel(final PlayerLevelChangeEvent e) {
		final Player p = e.getPlayer();
		if (e.getNewLevel() == 5) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c5§7!");
			p.sendMessage("§aVoc\u00ea ganhou um capacete de couro por conseguiur um killstreak de 5 !");
			p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
		}
		if (e.getNewLevel() == 10) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c10§7!");
			p.sendMessage("§aVoc\u00ea ganhou um peitoral de ouro por conseguiur um killstreak de 10 !");
			p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
		}
		if (e.getNewLevel() == 15) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c15§6!");
			p.sendMessage("§aVoc\u00ea ganhou uma cal\u00e7a de couro por conseguiur um killstreak de 15 !");
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		}
		if (e.getNewLevel() == 20) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c20§7!");
			p.sendMessage("§aVoc\u00ea ganhou uma bota de ferro por conseguiur um killstreak de 20 !");
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
		}
		if (e.getNewLevel() == 30) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c30§7!");
		}
		if (e.getNewLevel() == 40) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c40§7!");
		}
		if (e.getNewLevel() == 50) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c50§7!");
			p.getInventory().setBoots(new ItemStack(Material.IRON_CHESTPLATE));
			p.sendMessage("§aVoc\u00ea ganhou um peitoral de ferro por conseguiur um killstreak de 50 !");
		}
		if (e.getNewLevel() == 60) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c60§7!");
		}
		if (e.getNewLevel() == 70) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c70§7!");
		}
		if (e.getNewLevel() == 80) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c80§7!");
		}
		if (e.getNewLevel() == 90) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c90§7!");
		}
		if (e.getNewLevel() == 100) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c100§7!");
		}
		if (e.getNewLevel() == 150) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c150§7!");
		}
		if (e.getNewLevel() == 200) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c200§7!");
		}
		if (e.getNewLevel() == 250) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c250§7!");
		}
		if (e.getNewLevel() == 300) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c300§7!");
		}
		if (e.getNewLevel() == 350) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c350§7!");
		}
		if (e.getNewLevel() == 400) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c400§7!");
		}
		if (e.getNewLevel() == 450) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c450§7!");
		}
		if (e.getNewLevel() == 500) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c500§7!");
		}
		if (e.getNewLevel() == 1000) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c1000§7!");
		}
		if (e.getNewLevel() == 1500) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c1500§7!");
		}
		if (e.getNewLevel() == 2000) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c2000§7!");
		}
	}
}
