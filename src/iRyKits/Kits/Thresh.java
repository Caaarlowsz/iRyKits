package iRyKits.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;
import java.util.concurrent.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Thresh implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static HashMap<String, Snowball> tiros;
    public static Main plugin;
    
    static {
        Thresh.cooldown = new HashMap<String, Long>();
        Thresh.tiros = new HashMap<String, Snowball>();
    }
    
    public Thresh(final Main main) {
        Thresh.plugin = main;
    }
    
    public Thresh() {
    }
    
    @EventHandler
    public void disparar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.LEASH && Arrays.Thresh.contains(p.getName())) {
            if (!Thresh.cooldown.containsKey(p.getName()) || Thresh.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Snowball tiro = (Snowball)p.launchProjectile((Class)Snowball.class);
                final Vector vec = p.getLocation().getDirection();
                tiro.setVelocity(new Vector(vec.getX() * 1.0 * 3.5, vec.getY() * 1.0 * 4.0, vec.getZ() * 1.0 * 3.5));
                Thresh.tiros.put(p.getName(), tiro);
                Thresh.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
                p.sendMessage("§aVoc\u00ea lan\u00e7ou seu Thresh!");
                return;
            }
            p.sendMessage("§cCooldown");
        }
    }
    
    @EventHandler
    public void onEntityDamagerByEntity(final EntityDamageByEntityEvent e) {
        final Entity ent = e.getEntity();
        final Entity damager = e.getDamager();
        if (ent instanceof Player) {
            final Player hit = (Player)ent;
            if (damager instanceof Snowball) {
                final Snowball snowball = (Snowball)damager;
                if (snowball.getShooter() instanceof Player) {
                    final Player shooter = (Player)snowball.getShooter();
                    if (!Arrays.Thresh.contains(shooter.getName())) {
                        return;
                    }
                    final Location ploc = shooter.getLocation();
                    final Location hitloc = hit.getLocation();
                    hit.teleport(ploc);
                    hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                    hit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
                    hit.sendMessage("§cOPS: Alguem Usou o Kit Thresh Em Voc\u00ea!");
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("thresh")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.thresh")) {
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
            final ItemStack resh = new ItemStack(Material.LEASH);
            final ItemMeta kresh = resh.getItemMeta();
            kresh.setDisplayName("§aThresh");
            resh.setItemMeta(kresh);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cThresh", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cThresh");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, resh);
            Habilidade.setAbility(p, "Thresh");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Thresh.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
