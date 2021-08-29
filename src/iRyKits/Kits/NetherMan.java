package iRyKits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class NetherMan implements Listener, CommandExecutor {
	public NetherMan(final Main main) {
	}

	@EventHandler
	public void RunSand(final PlayerMoveEvent e) {
		if (e.isCancelled() || e.getFrom().getBlock().getLocation() != e.getTo().getBlock().getLocation()) {
			final Player p = e.getPlayer();
			final Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
			if (Arrays.NetherMan.contains(p.getName()) && block.getType() == Material.NETHERRACK) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 1));
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("netherman")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.netherman")) {
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
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cNetherMan", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cNetherMan");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "NetherMan");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.NetherMan.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
