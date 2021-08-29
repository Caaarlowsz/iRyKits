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
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Launcher implements Listener, CommandExecutor {
	public static Main plugin;

	public Launcher(final Main main) {
		Launcher.plugin = main;
	}

	public Launcher() {
	}

	@EventHandler
	public void onPlayerHitFishingrodThrower(final PlayerFishEvent event) {
		final Player player = event.getPlayer();
		if (Arrays.Launcher.contains(player.getName()) && event.getCaught() instanceof Player) {
			final Player caught = (Player) event.getCaught();
			if (player.getItemInHand().getType() == Material.FISHING_ROD) {
				caught.setVelocity(new Vector(0, 2, 0));
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("launcher")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.launcher")) {
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
			final ItemStack launcher = new ItemStack(Material.FISHING_ROD);
			final ItemMeta klauncher = launcher.getItemMeta();
			klauncher.setDisplayName("§aLauncher");
			launcher.setItemMeta(klauncher);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cLauncher", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cLauncher");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, launcher);
			Habilidade.setAbility(p, "Launcher");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Launcher.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
