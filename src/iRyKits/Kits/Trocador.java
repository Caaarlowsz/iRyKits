package iRyKits.Kits;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Trocador implements Listener, CommandExecutor {
	private HashMap<String, ItemStack[]> armors;
	public static Main plugin;

	public Trocador(final Main main) {
		this.armors = new HashMap<String, ItemStack[]>();
		Trocador.plugin = main;
	}

	public Trocador() {
		this.armors = new HashMap<String, ItemStack[]>();
	}

	@EventHandler
	public void Tartaruga(final PlayerToggleSneakEvent e) {
		final Player p = e.getPlayer();
		if (!Arrays.Trocador.contains(p.getName())) {
			return;
		}
		if (p.isSneaking()) {
			if (this.armors.containsKey(p.getName())) {
				p.getEquipment().setArmorContents((ItemStack[]) this.armors.get(p.getName()));
				this.armors.remove(p.getName());
			}
		} else {
			this.armors.put(p.getName(), p.getEquipment().getArmorContents());
			p.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
			p.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.sendMessage("§3Uffa Estou Forte.");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("trocador")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.trocador")) {
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
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cTrocador", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cTrocador");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			Habilidade.setAbility(p, "Trocador");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Trocador.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
