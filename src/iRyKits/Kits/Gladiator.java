package iRyKits.Kits;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.block.*;
import org.bukkit.potion.*;
import org.bukkit.event.player.*;
import org.bukkit.scheduler.*;
import org.bukkit.plugin.*;
import org.bukkit.event.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Gladiator implements Listener, CommandExecutor
{
    public static Main plugin;
    public ArrayList<String> inPvP;
    public Map<String, Location> local;
    
    public Gladiator(final Main main) {
        this.inPvP = new ArrayList<String>();
        this.local = new HashMap<String, Location>();
        Gladiator.plugin = main;
    }
    
    @EventHandler
    public void removeOnTp(final PlayerTeleportEvent e) {
        final Player player = e.getPlayer();
        if (this.inPvP.contains(player.getName())) {
            this.inPvP.remove(player.getName());
        }
    }
    
    public void limpar(final Location loc) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (x = -7; x < 7; ++x) {
            for (z = -7; z < 7; ++z) {
                for (y = 0; y < 7; ++y) {
                    final Block b = loc.clone().add((double)x, 0.0, (double)z).getBlock();
                    final Block b2 = loc.clone().add((double)x, 7.0, (double)z).getBlock();
                    final Block b3 = loc.clone().add(-7.0, (double)y, (double)z).getBlock();
                    final Block b4 = loc.clone().add((double)x, (double)y, -7.0).getBlock();
                    final Block b5 = loc.clone().add((double)x, (double)y, 7.0).getBlock();
                    final Block b6 = loc.clone().add(7.0, (double)y, (double)z).getBlock();
                    b.setType(Material.AIR);
                    b2.setType(Material.AIR);
                    b3.setType(Material.AIR);
                    b4.setType(Material.AIR);
                    b5.setType(Material.AIR);
                    b6.setType(Material.AIR);
                }
            }
        }
    }
    
    public void generateArena(final Location loc, final Player gladiator, final Player target) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (x = -7; x < 7; ++x) {
            for (z = -7; z < 7; ++z) {
                for (y = 0; y < 7; ++y) {
                    final Block b = loc.clone().add((double)x, 0.0, (double)z).getBlock();
                    final Block b2 = loc.clone().add((double)x, 7.0, (double)z).getBlock();
                    final Block b3 = loc.clone().add(-7.0, (double)y, (double)z).getBlock();
                    final Block b4 = loc.clone().add((double)x, (double)y, -7.0).getBlock();
                    final Block b5 = loc.clone().add((double)x, (double)y, 7.0).getBlock();
                    final Block b6 = loc.clone().add(7.0, (double)y, (double)z).getBlock();
                    b.setType(Material.GLASS);
                    b2.setType(Material.GLASS);
                    b3.setType(Material.GLASS);
                    b4.setType(Material.GLASS);
                    b5.setType(Material.GLASS);
                    b6.setType(Material.GLASS);
                }
            }
        }
        gladiator.teleport(loc.clone().add((double)(x - 1), (double)(y - 2), -4.0));
        gladiator.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
        target.sendMessage("§aBoa Sorte");
        target.teleport(loc.clone().add(-4.0, (double)(y - 4), (double)(z - 1)));
        target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
        gladiator.sendMessage("§aBoa Sorte !");
    }
    
    @EventHandler
    public void PlayerInteractEntityEvent(final PlayerInteractEntityEvent event) {
        final Player player = event.getPlayer();
        if (player.getItemInHand().getType() == Material.IRON_FENCE && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aGladiator")) {
            final Player player2 = (Player)event.getRightClicked();
            final Location pLoc = player.getLocation();
            if (!Main.areaPvP(player)) {
                player.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
                return;
            }
            if (!Main.areaPvP(player2)) {
                player2.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
                return;
            }
            if (!this.inPvP.contains(player.getName()) && !this.inPvP.contains(player2.getName())) {
                this.local.put(player.getName(), pLoc);
                this.local.put(player2.getName(), player2.getLocation());
                final Location GladLoc = player.getLocation();
                final Location GladiatorA = new Location(player.getWorld(), (double)GladLoc.getBlockX(), (double)(GladLoc.getWorld().getHighestBlockYAt(GladLoc) + 120), (double)GladLoc.getBlockZ());
                this.generateArena(GladiatorA, player2, player);
                new BukkitRunnable() {
                    int tempo = 120;
                    
                    public void run() {
                        --this.tempo;
                        if (!Gladiator.this.inPvP.contains(player.getName())) {
                            Gladiator.this.inPvP.add(player.getName());
                        }
                        if (!Gladiator.this.inPvP.contains(player2.getName())) {
                            Gladiator.this.inPvP.add(player2.getName());
                        }
                        if (player.isDead() || player2.isDead() || !player.isOnline() || !player2.isOnline() || !Gladiator.this.inPvP.contains(player.getName()) || !Gladiator.this.inPvP.contains(player2.getName())) {
                            Gladiator.this.inPvP.remove(player.getName());
                            Gladiator.this.inPvP.remove(player2.getName());
                            Gladiator.this.limpar(GladiatorA);
                            this.cancel();
                            if (player.isOnline()) {
                                player.teleport((Location)Gladiator.this.local.get(player.getName()));
                                Gladiator.this.local.remove(player.getName());
                                if (player.hasPotionEffect(PotionEffectType.WITHER)) {
                                    player.removePotionEffect(PotionEffectType.WITHER);
                                }
                            }
                            if (player2.isOnline()) {
                                player2.teleport((Location)Gladiator.this.local.get(player2.getName()));
                                Gladiator.this.local.remove(player2.getName());
                                if (player2.hasPotionEffect(PotionEffectType.WITHER)) {
                                    player2.removePotionEffect(PotionEffectType.WITHER);
                                }
                            }
                        }
                        else {
                            if (this.tempo == 60) {
                                if (!player.isDead() && player.isOnline() && Gladiator.this.inPvP.contains(player.getName())) {
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 5));
                                }
                                if (!player2.isDead() && player2.isOnline() && Gladiator.this.inPvP.contains(player2.getName())) {
                                    player2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 5));
                                }
                            }
                            if (this.tempo == 0) {
                                Gladiator.this.inPvP.remove(player.getName());
                                Gladiator.this.inPvP.remove(player2.getName());
                                Gladiator.this.limpar(GladiatorA);
                                this.cancel();
                                if (!player.isDead() && player.isOnline()) {
                                    player.teleport((Location)Gladiator.this.local.get(player.getName()));
                                    if (player.hasPotionEffect(PotionEffectType.WITHER)) {
                                        player.removePotionEffect(PotionEffectType.WITHER);
                                    }
                                    Gladiator.this.local.remove(player2);
                                }
                                if (!player2.isDead() && player2.isOnline()) {
                                    player2.teleport((Location)Gladiator.this.local.get(player2.getName()));
                                    if (player2.hasPotionEffect(PotionEffectType.WITHER)) {
                                        player2.removePotionEffect(PotionEffectType.WITHER);
                                    }
                                    Gladiator.this.local.remove(player2);
                                }
                            }
                        }
                    }
                }.runTaskTimer((Plugin)Gladiator.plugin, 0L, 20L);
            }
        }
    }
    
    @EventHandler
    public void death(final PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = e.getEntity();
            if (p.getKiller() instanceof Player) {
                final Player killer = p.getKiller();
                if (this.inPvP.contains(p.getName())) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
                    killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
                    this.inPvP.remove(p.getName());
                    if (this.inPvP.contains(killer.getName())) {
                        this.inPvP.remove(killer.getName());
                    }
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("gladiator")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.gladiator")) {
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
            final ItemStack glad = new ItemStack(Material.IRON_FENCE);
            final ItemMeta kglad = glad.getItemMeta();
            kglad.setDisplayName("§aGladiator");
            glad.setItemMeta(kglad);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cGladiator", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cGladiator");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, glad);
            Habilidade.setAbility(p, "Gladiator");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Gladiator.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
