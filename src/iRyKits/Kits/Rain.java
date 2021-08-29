package iRyKits.Kits;

import java.util.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Rain implements CommandExecutor, Listener
{
    public static ArrayList<String> rain;
    public static List<Player> cooldownm;
    public static Main plugin;
    
    static {
        Rain.rain = new ArrayList<String>();
        Rain.cooldownm = new ArrayList<Player>();
    }
    
    public Rain(final Main main) {
        Rain.plugin = main;
    }
    
    @EventHandler
    public void onHit(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
            e.setDamage(7.0);
        }
    }
    
    @EventHandler
    public void RainClick(final PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p1 = event.getPlayer();
        final Player r = (Player)event.getRightClicked();
        if (p1.getItemInHand().getType() == Material.ARROW) {
            if (Arrays.Rain.contains(p1.getName()) && Rain.cooldownm.contains(p1)) {
                p1.sendMessage("§cCooldown");
                return;
            }
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc = r.getLocation();
                    loc.setY(loc.getY() + 3.0);
                    final Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
                }
            }, 40L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc2 = r.getLocation();
                    loc2.setY(loc2.getY() + 3.0);
                    final Entity arrow3 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc2, EntityType.ARROW);
                }
            }, 35L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc3 = r.getLocation();
                    loc3.setY(loc3.getY() + 3.0);
                    final Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
                }
            }, 30L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc3 = r.getLocation();
                    loc3.setY(loc3.getY() + 3.0);
                    final Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
                }
            }, 25L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc3 = r.getLocation();
                    loc3.setY(loc3.getY() + 3.0);
                    final Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
                }
            }, 20L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc4 = r.getLocation();
                    loc4.setY(loc4.getY() + 3.0);
                    final Entity arrow5 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc4, EntityType.ARROW);
                }
            }, 5L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc6 = r.getLocation();
                    loc6.setY(loc6.getY() + 3.0);
                    final Entity arrow6 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc6, EntityType.ARROW);
                }
            }, 3L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc5 = r.getLocation();
                    loc5.setY(loc5.getY() + 3.0);
                }
            }, 2L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    Rain.rain.remove(p1.getName());
                }
            }, 50L);
            Rain.cooldownm.add(p1);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    Rain.cooldownm.remove(p1);
                    p1.sendMessage("§aVoc\u00ea ja pode usar novamente seu rain");
                    p1.getWorld().playSound(p1.getLocation(), Sound.BURP, 5.0f, 5.0f);
                }
            }, 700L);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("rain")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.rain")) {
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
            final ItemStack rain = new ItemStack(Material.ARROW);
            final ItemMeta krain = rain.getItemMeta();
            krain.setDisplayName("§aRain");
            rain.setItemMeta(krain);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cRain", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cRain");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, rain);
            Habilidade.setAbility(p, "Rain");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Rain.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
