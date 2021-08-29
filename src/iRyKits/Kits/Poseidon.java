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

public class Poseidon implements Listener, CommandExecutor {
	public Poseidon(final Main main) {
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (p.getLocation().getBlock().isLiquid() && p.getLocation().getBlock().getType() == Material.STATIONARY_WATER
				&& Arrays.Poseidon.contains(p.getName())) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 80, 0));
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("poseidon")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.poseidon")) {
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
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cPoseidon", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cPoseidon");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Poseidon");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Poseidon.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
