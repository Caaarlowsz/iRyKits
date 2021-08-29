package iRyKits.Command;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Main;

public class Admin implements Listener, CommandExecutor {
	public static ArrayList<String> admin;
	public static HashMap<String, ItemStack[]> salvarinv;

	static {
		Admin.admin = new ArrayList<String>();
		Admin.salvarinv = new HashMap<String, ItemStack[]>();
	}

	@EventHandler
	public void onAdminAbririnv(final PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p1 = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if (Admin.admin.contains(p1.getName()) && p1.getItemInHand().getType() == Material.AIR) {
			p1.openInventory((Inventory) r.getInventory());
		}
	}

	@EventHandler
	public void onAdminFF(final PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p1 = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if (Admin.admin.contains(p1.getName()) && p1.getItemInHand().getType() == Material.SKULL_ITEM) {
			p1.chat("/f " + r.getName());
		}
	}

	@EventHandler
	public void onAdminCrash(final PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p1 = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if (Admin.admin.contains(p1.getName()) && p1.getItemInHand().getType() == Material.BONE) {
			p1.chat("/crash " + r.getName());
		}
	}

	@EventHandler
	public void onAdminNoFall(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (Admin.admin.contains(p.getName()) && p.getItemInHand().getType() == Material.FEATHER) {
			final Player p2 = (Player) event.getRightClicked();
			if (p2 != null) {
				p2.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.AIR);
				p2.getLocation().add(0.0, 40.0, 1.0).getBlock().setType(Material.AIR);
				p2.getLocation().add(1.0, 40.0, 0.0).getBlock().setType(Material.AIR);
				p2.getLocation().add(0.0, 40.0, -1.0).getBlock().setType(Material.AIR);
				p2.getLocation().add(-1.0, 40.0, 0.0).getBlock().setType(Material.AIR);
				p2.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.AIR);
				p2.teleport(p2.getLocation().add(0.0, 11.0, -0.05));
			}
		}
	}

	@EventHandler
	public void onAdminArena(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (Admin.admin.contains(p.getName()) && p.getItemInHand().getType() == Material.IRON_FENCE) {
			final Player p2 = (Player) event.getRightClicked();
			if (p2 != null) {
				p2.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.teleport(p2.getLocation().add(0.0, 11.0, -0.05));
			}
		}
	}

	@EventHandler
	public void onPlayerInfo(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (Admin.admin.contains(p.getName()) && p.getItemInHand().getType() == Material.BOOK) {
			final Damageable hp;
			final Player p2 = (Player) (hp = (Damageable) e.getRightClicked());
			p.sendMessage("§aInforma\u00e7oes do player §c§l" + p2.getName());
			p.sendMessage("§aVida: §c§l" + (int) hp.getHealth());
			p.sendMessage("§aSopas: §c§l" + getAmount(p2, Material.MUSHROOM_SOUP));
			p.sendMessage("§aGamemode: §c§l" + p2.getGameMode());
			p.sendMessage("§aIp: §c§l" + p2.getAddress().getHostName());
		}
	}

	public static int getAmount(final Player p, final Material m) {
		int amount = 0;
		ItemStack[] contents;
		for (int length = (contents = p.getInventory().getContents()).length, i = 0; i < length; ++i) {
			final ItemStack item = contents[i];
			if (item != null && item.getType() == m && item.getAmount() > 0) {
				amount += item.getAmount();
			}
		}
		return amount;
	}

	@EventHandler
	public void aoInteragir(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Admin.admin.contains(p.getName())
				&& (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) {
			if (p.getItemInHand().getType() == Material.REDSTONE) {
				p.chat("/admin");
			}
			if (p.getItemInHand().getType() == Material.MAGMA_CREAM) {
				p.chat("/admin");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						p.chat("/admin");
					}
				}, 10L);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bVoce precisa estar online para dar o comando!");
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("admin")) {
			if (!p.hasPermission("iry.admin")) {
				return true;
			}
			if (Admin.admin.contains(p.getName())) {
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
					final Player all = arrayOfPlayer[i];
					all.showPlayer(p);
					if (all.hasPermission("iry.admin")) {
						all.sendMessage("§7O Player §c§l" + p.getName() + "§7 Saiu Do Modo §c§lADMIN");
					} else {
						all.sendMessage(" ");
					}
				}
				p.setGameMode(GameMode.CREATIVE);
				for (int i2 = 0; i2 < 10; ++i2) {
					p.sendMessage(" ");
				}
				p.sendMessage("§7Modo Admin §c§lOFF");
				p.sendMessage("§7Voc\u00ea Esta Visivel Para Todos!");
				Bukkit.broadcastMessage("§7[ §2+ §7] §3 " + p.getDisplayName());
				Admin.admin.remove(p.getName());
				p.getInventory().setContents((ItemStack[]) Admin.salvarinv.get(p.getName()));
				p.updateInventory();
			} else {
				Admin.admin.add(p.getName());
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
					final Player all = arrayOfPlayer[i];
					all.hidePlayer(p);
					if (all.hasPermission("iry.admin")) {
						all.sendMessage("§7O Player \u279f §a§l" + p.getName() + " §7 Entrou No Modo §a§lADMIN");
					} else {
						all.sendMessage(" ");
					}
				}
				p.setGameMode(GameMode.CREATIVE);
				for (int i2 = 0; i2 < 10; ++i2) {
					p.sendMessage("");
				}
				p.sendMessage("§7Modo Admin §a§lON");
				p.sendMessage("§7Voc\u00ea Esta Invisivel Para Todos!");
				Bukkit.broadcastMessage("§7[ §c- §7] §3" + p.getDisplayName());
				Admin.salvarinv.put(p.getName(), p.getInventory().getContents());
				p.getInventory().clear();
				this.darItem(p, Material.REDSTONE, "§7Sair Do Modo §c§lADMIN", 1);
				this.darItem(p, Material.BOOK, "§7Informacoes Do §c§lPLAYER", 2);
				this.darItem(p, Material.SKULL_ITEM, "§7Testar §c§lFF", 4);
				this.darItem(p, Material.IRON_FENCE, "§7Criar §c§lARENA", 5);
				this.darItem(p, Material.BONE, "§7Crashar §c§lPLAYER", 6);
				this.darItem(p, Material.FEATHER, "§7Testar §c§lNOFALL", 8);
				this.darItem(p, Material.MAGMA_CREAM, "§7Testar §c§lKILL-AURA", 9);
			}
		}
		return true;
	}

	public void darItem(final Player p, final Material material, final String nome, final int slot) {
		final ItemStack l = new ItemStack(material);
		final ItemMeta metal = l.getItemMeta();
		metal.setDisplayName(nome);
		l.setItemMeta(metal);
		p.getInventory().setItem(slot - 1, l);
	}
}
