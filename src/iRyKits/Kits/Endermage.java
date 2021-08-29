package iRyKits.Kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import com.sk89q.worldguard.protection.flags.*;
import org.bukkit.inventory.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.*;
import com.sk89q.worldguard.bukkit.*;
import com.sk89q.worldguard.protection.managers.*;
import com.sk89q.worldguard.protection.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;

public class Endermage implements Listener, CommandExecutor
{
    public Main plugin;
    
    public Endermage(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlace(final PlayerInteractEvent event) {
        final ItemStack item = event.getItem();
        final Player p2 = event.getPlayer();
        final Player p3 = event.getPlayer();
        if ((event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.LEFT_CLICK_BLOCK) || item == null || !Arrays.Endermage.contains(p2.getName()) || event.getMaterial() != Material.PORTAL) {
            return;
        }
        event.setCancelled(true);
        final Block b = event.getClickedBlock();
        if (Arrays.Endermage.contains(p2.getName()) && b.getTypeId() == 120) {
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
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Player[] arrayOfPlayer;
                        for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                            final Player p = arrayOfPlayer[i];
                            if (b.getTypeId() == 120 && !Arrays.Endermage.contains(p.getName()) && p != mager.getPlayer() && Endermage.this.isEnderable(portal, p.getLocation())) {
                                final Location teleport = portal.clone().add(0.0, 0.5, 0.0);
                                if (p.getLocation().distance(portal) > 3.0) {
                                    mager.getPlayer().sendMessage("§a§lJogador Puxado!");
                                    mager.getPlayer().sendMessage("§4§lVoc\u00ea tem 5 segundos de invencibilidade, se prepare, ou fuja!");
                                    mager.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));
                                    p.sendMessage("§4§lVoce Foi Puxado!");
                                    p.sendMessage(ChatColor.RED + "Voc\u00ea tem " + ChatColor.RED + "5 segundos de invencibilidade, se prepare, ou fuja!");
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
                }, (long)(i * 20));
            }
            return;
        }
        p2.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
    }
    
    private boolean isEnderable(final Location portal, final Location player) {
        return Math.abs(portal.getX() - player.getX()) < 2.0 && Math.abs(portal.getZ() - player.getZ()) < 2.0 && Math.abs(portal.getY() - player.getY()) > 1.0;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("endermage")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.endermage")) {
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
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cEndermage", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cEndermage");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, ender);
            Habilidade.setAbility(p, "Endermage");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Endermage.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
