package iRyKits.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import iRyKits.Arrays;
import iRyKits.Main;
import iRyKits.Strings;
import iRyKits.Event.Habilidade;
import me.confuser.barapi.BarAPI;

public class Tower implements Listener, CommandExecutor {
	static List<Player> cooldownm;
	public Main plugin;

	static {
		Tower.cooldownm = new ArrayList<Player>();
	}

	public Tower(final Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlace(final PlayerInteractEvent event) {
		final ItemStack item = event.getItem();
		final Player p2 = event.getPlayer();
		final Player p3 = event.getPlayer();
		if ((event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.LEFT_CLICK_BLOCK)
				|| item == null || !Arrays.Tower.contains(p2.getName()) || event.getMaterial() != Material.PORTAL) {
			return;
		}
		event.setCancelled(true);
		final Block b = event.getClickedBlock();
		if (Arrays.Tower.contains(p2.getName()) && b.getTypeId() == 120) {
			return;
		}
		final WorldGuardPlugin worldGuard = Main.getWorldGuard();
		final RegionManager regionManager = worldGuard.getRegionManager(p3.getWorld());
		final ApplicableRegionSet set = regionManager.getApplicableRegions(p3.getLocation());
		if (set.allows(DefaultFlag.PVP)) {
			item.setAmount(0);
			if (item.getAmount() == 0) {
				event.getPlayer().setItemInHand(new ItemStack(0));
			}
			final Location portal = b.getLocation().clone().add(0.5, 0.5, 0.5);
			final Material material = b.getType();
			final byte dataValue = b.getData();
			portal.getBlock().setTypeId(120);
			final Player mager = event.getPlayer();
			for (int i = 0; i <= 5; ++i) {
				final int no = i;
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								Player[] arrayOfPlayer;
								for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
									final Player p = arrayOfPlayer[i];
									if (b.getTypeId() == 120 && Arrays.Tower.contains(p.getName())
											&& p != mager.getPlayer()
											&& Tower.this.isEnderable(portal, p.getLocation())) {
										final Location teleport = portal.clone().add(0.0, 0.5, 0.0);
										if (p.getLocation().distance(portal) > 3.0) {
											mager.getPlayer().sendMessage("§a§lJogador Puxado!");
											mager.getPlayer().sendMessage(
													"§4§lVoc\u00ea tem 5 segundos de invencibilidade, se prepare, ou fuja!");
											mager.addPotionEffect(
													new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));
											p.addPotionEffect(
													new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));
											p.sendMessage("§4§lVoce Foi Puxado!");
											p.sendMessage(ChatColor.RED + "Voc\u00ea tem " + ChatColor.RED
													+ "5 segundos de invencibilidade, se prepare, ou fuja!");
											p.setNoDamageTicks(100);
											mager.getPlayer().setNoDamageTicks(100);
											mager.getPlayer().teleport(teleport);
											p.teleport(teleport);
											final ItemStack endermage = new ItemStack(Material.PORTAL, 1);
											final ItemMeta name = endermage.getItemMeta();
											name.setDisplayName("§aEndermage");
											endermage.setItemMeta(name);
											mager.getInventory().addItem(new ItemStack[] { endermage });
										}
										portal.getBlock().setTypeIdAndData(material.getId(), dataValue, true);
									}
								}
								if (no == 5) {
									final ItemStack endermage2 = new ItemStack(Material.PORTAL, 1);
									final ItemMeta name2 = endermage2.getItemMeta();
									name2.setDisplayName("§aEndermage");
									endermage2.setItemMeta(name2);
									mager.getInventory().addItem(new ItemStack[] { endermage2 });
									portal.getBlock().setTypeIdAndData(material.getId(), dataValue, true);
								}
							}
						}, (long) (i * 20));
			}
			return;
		}
		p2.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
	}

	private boolean isEnderable(final Location portal, final Location player) {
		return Math.abs(portal.getX() - player.getX()) < 2.0 && Math.abs(portal.getZ() - player.getZ()) < 2.0
				&& Math.abs(portal.getY() - player.getY()) > 1.0;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerStomp(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Arrays.Tower.contains(p.getName())) {
			for (final Entity ent : p.getNearbyEntities(4.0, 1.5, 4.0)) {
				if (ent instanceof Player) {
					final Player plr = (Player) ent;
					if (e.getDamage() <= 4.0) {
						e.setCancelled(true);
						return;
					}
					if (plr.isSneaking()) {
						plr.damage(6.0, (Entity) p);
						plr.sendMessage("§a§oVoc\u00ea foi stompado por:§c§o " + p.getName());
					} else {
						plr.damage(e.getDamage(), (Entity) p);
						plr.sendMessage("§a§oVoc\u00ea foi stompado por:§c§o " + p.getName());
					}
				}
			}
			e.setDamage(4.0);
		}
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE
				&& Arrays.Tower.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Tower.cooldownm.contains(p)) {
				p.sendMessage("§cCooldown");
				return;
			}
			final Vector vector = p.getEyeLocation().getDirection();
			vector.multiply(0.0f);
			vector.setY(6.0f);
			p.setVelocity(vector);
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.DIG_WOOL, 5.0f, -5.0f);
			Tower.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Tower.cooldownm.remove(p);
					p.sendMessage(ChatColor.GREEN + "O Cooldown Acabou!");
				}
			}, 1000L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
		if (label.equalsIgnoreCase("tower")) {
			final Player p = (Player) sender;
			if (!p.hasPermission("kit.tower")) {
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
			final ItemStack ender = new ItemStack(Material.PORTAL);
			final ItemMeta kender = ender.getItemMeta();
			kender.setDisplayName("§aEndermage");
			ender.setItemMeta(kender);
			BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cTower", 2);
			p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cTower");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, ender);
			Habilidade.setAbility(p, "Tower");
			Arrays.sopa(p);
			Arrays.recraft(p);
			Arrays.Tower.add(p.getName());
			Arrays.Used.add(p.getName());
		}
		return false;
	}
}
