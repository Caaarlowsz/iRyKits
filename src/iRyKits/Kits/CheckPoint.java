package iRyKits.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class CheckPoint implements Listener, CommandExecutor {
	public HashMap<String, Location> local;
	public List<String> cooldown;
	public static Main plugin;

	public CheckPoint(final Main main) {
		this.local = new HashMap<String, Location>();
		this.cooldown = new ArrayList<String>();
		CheckPoint.plugin = main;
	}

	public CheckPoint() {
		this.local = new HashMap<String, Location>();
		this.cooldown = new ArrayList<String>();
	}

	@EventHandler
	public void Flor(final BlockPlaceEvent e) {
		final Block b = e.getBlock();
		final Player player = e.getPlayer();
		if (b.getType() == Material.FLOWER_POT || b.getType() == Material.FLOWER_POT_ITEM) {
			e.setCancelled(true);
			if (!this.local.containsKey(player.getName())) {
				player.sendMessage("§4Selecione o local antes de usar!");
				return;
			}
			player.teleport((Location) this.local.get(player.getName()));
			player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5.0f, 100.0f);
		}
	}

	@EventHandler
	public void Check(final BlockPlaceEvent event) {
		final Player player = event.getPlayer();
		final Block block = event.getBlockPlaced();
		if (Arrays.CheckPoint.contains(player.getName()) && block.getType().equals((Object) Material.NETHER_FENCE)) {
			event.setCancelled(true);
			if (this.cooldown.contains(player.getName())) {
				player.sendMessage(CheckPoint.plugin.getConfig().getString("§cCooldown"));
				return;
			}
			this.local.put(player.getName(), block.getLocation());
			player.getWorld().strikeLightningEffect(block.getLocation());
			player.sendMessage("§aLugar registrado!");
			player.updateInventory();
		}
	}

	@EventHandler
	public void Check2(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		final Player player = event.getPlayer();
		final Block block = event.getClickedBlock();
		if (Arrays.CheckPoint.contains(p.getName())) {
			if (player.getItemInHand().getType().equals((Object) Material.FLOWER_POT_ITEM)
					&& event.getAction() == Action.RIGHT_CLICK_AIR) {
				if (!this.local.containsKey(player.getName())) {
					player.sendMessage("§4Selecione o local antes de usar!");
					return;
				}
				player.teleport((Location) this.local.get(player.getName()));
				player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5.0f, 100.0f);
			}
		} else if (event.getAction() == Action.LEFT_CLICK_BLOCK
				&& block.getType().equals((Object) Material.NETHER_FENCE) && this.local.containsKey(player.getName())) {
			player.getWorld().createExplosion(block.getLocation().add(0.0, 1.0, 0.0), 0.0f);
			player.getWorld().createExplosion(block.getLocation().add(0.0, 1.0, 0.0), 0.0f);
			block.setType(Material.AIR);
			player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.NETHER_FENCE) });
			this.local.remove(player.getName());
		}
	}

	@EventHandler
	public void morrer(final PlayerDeathEvent event) {
		final Player player = event.getEntity();
		if (!(player instanceof Player) || Arrays.CheckPoint.add(player.getName())) {
		}
		this.local.remove(player.getName());
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("checkpoint")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.checkpoint")) {
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
			final ItemStack teleportcp = new ItemStack(Material.FLOWER_POT_ITEM);
			final ItemMeta kteleportcp = teleportcp.getItemMeta();
			kteleportcp.setDisplayName("§aTeleporte");
			teleportcp.setItemMeta(kteleportcp);
			final ItemStack checkpoint = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta kcheckpoint = checkpoint.getItemMeta();
			kcheckpoint.setDisplayName("§aCheckPoint");
			checkpoint.setItemMeta(kcheckpoint);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cCheckPoint", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cCheckPoint");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, checkpoint);
			p.getInventory().setItem(2, teleportcp);
			Habilidade.setAbility(p, "CheckPoint");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.CheckPoint.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
