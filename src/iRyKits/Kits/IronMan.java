package iRyKits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class IronMan implements Listener, CommandExecutor {
	public static Main plugin;

	public IronMan(final Main main) {
		IronMan.plugin = main;
	}

	public IronMan() {
	}

	@EventHandler
	public void death13112(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		final Player k = e.getEntity().getKiller();
		if (!(k instanceof Player)) {
			return;
		}
//        if (k == null) {
//            return;
//        }
		if (Arrays.IronMan.contains(k.getName())) {
			final ItemStack pot = new ItemStack(Material.IRON_INGOT);
			k.getInventory().setItem(2, pot);
			k.updateInventory();
			k.sendMessage("§aVoc\u00ea recebeu um ferro por matar §b" + p.getName());
		}
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Arrays.IronMan.contains(p.getName()) && p.getItemInHand().getType() == Material.WORKBENCH) {
			p.openWorkbench((Location) null, true);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("ironman")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.ironman")) {
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
			final ItemStack ironman = new ItemStack(Material.WORKBENCH);
			final ItemMeta kironman = ironman.getItemMeta();
			kironman.setDisplayName("§aBancada De Trabalho");
			ironman.setItemMeta(kironman);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cIronMan", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cIronMan");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, ironman);
			Habilidade.setAbility(p, "IronMan");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.IronMan.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
