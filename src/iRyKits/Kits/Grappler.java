package iRyKits.Kits;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.util.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.craftbukkit.v1_7_R1.entity.*;
import net.minecraft.server.v1_7_R1.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Grappler implements Listener, CommandExecutor
{
    Map<Player, CopyOfFishingHook> hooks;
    public static Main plugin;
    
    public Grappler(final Main main) {
        this.hooks = new HashMap<Player, CopyOfFishingHook>();
        Grappler.plugin = main;
    }
    
    public Grappler() {
        this.hooks = new HashMap<Player, CopyOfFishingHook>();
    }
    
    @EventHandler
    public void onSlot(final PlayerItemHeldEvent e) {
        if (!Arrays.Grappler.contains(e) && this.hooks.containsKey(e.getPlayer())) {
            this.hooks.get(e.getPlayer()).remove();
            this.hooks.remove(e.getPlayer());
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        if (!Arrays.Grappler.contains(e) && this.hooks.containsKey(e.getPlayer()) && !e.getPlayer().getItemInHand().getType().equals((Object)Material.LEASH)) {
            this.hooks.get(e.getPlayer()).remove();
            this.hooks.remove(e.getPlayer());
        }
    }
    
    @EventHandler
    public void onLeash(final PlayerLeashEntityEvent e) {
        final Player p = e.getPlayer();
        if (!Arrays.Grappler.contains(p) && e.getPlayer().getItemInHand().getType().equals((Object)Material.LEASH) && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrappler")) {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            e.setCancelled(true);
            if (!this.hooks.containsKey(p)) {
                return;
            }
            if (!this.hooks.get(p).isHooked()) {
                return;
            }
            final double t;
            final double d = t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
            final double v_x = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
            final double v_y = (1.0 + 0.03 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
            final double v_z = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
            final Vector v = p.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            p.setVelocity(v);
        }
    }
    
    @EventHandler
    public void onDamageByFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player player = (Player)e.getEntity();
            if (!Arrays.Grappler.contains(player)) {
                if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
                    return;
                }
                if (!this.hooks.containsKey(player)) {
                    return;
                }
                if (this.hooks.get(player).isHooked()) {
                    e.setDamage(e.getDamage() / 10.0);
                }
            }
        }
    }
    
    @EventHandler
    public void onClick(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (!Arrays.Grappler.contains(p) && e.getPlayer().getItemInHand().getType().equals((Object)Material.LEASH) && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrappler")) {
            e.setCancelled(true);
            if (e.getAction() == Action.LEFT_CLICK_AIR || (e.getAction() == Action.LEFT_CLICK_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrappler"))) {
                if (this.hooks.containsKey(p)) {
                    this.hooks.get(p).remove();
                }
                final CopyOfFishingHook nmsHook = new CopyOfFishingHook(p.getWorld(), (EntityHuman)((CraftPlayer)p).getHandle());
                nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
                nmsHook.move(p.getLocation().getDirection().getX() * 5.0, p.getLocation().getDirection().getY() * 5.0, p.getLocation().getDirection().getZ() * 5.0);
                this.hooks.put(p, nmsHook);
            }
            else {
                if (!this.hooks.containsKey(p)) {
                    return;
                }
                if (!this.hooks.get(p).isHooked()) {
                    return;
                }
                final double t;
                final double d = t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
                final double v_x = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
                final double v_y = (1.0 + 0.03 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
                final double v_z = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
                final Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                p.setVelocity(v);
                p.playSound(p.getLocation(), Sound.STEP_GRAVEL, 5.0f, 1.0f);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("grappler")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.grappler")) {
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
            final ItemStack grappler = new ItemStack(Material.LEASH);
            final ItemMeta kgrappler = grappler.getItemMeta();
            kgrappler.setDisplayName("§aGrappler");
            grappler.setItemMeta(kgrappler);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cGrappler", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cGrappler");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, grappler);
            Habilidade.setAbility(p, "Grappler");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Grappler.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
