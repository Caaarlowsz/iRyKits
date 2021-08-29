package iRyKits.Kits;

import java.util.*;
import org.bukkit.event.block.*;
import org.bukkit.block.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Kangaroo implements Listener, CommandExecutor
{
    ArrayList<String> jumpa;
    private HashMap<String, Integer> inta;
    
    public Kangaroo() {
        this.jumpa = new ArrayList<String>();
        this.inta = new HashMap<String, Integer>();
    }
    
    public Kangaroo(final Main main) {
        this.jumpa = new ArrayList<String>();
        this.inta = new HashMap<String, Integer>();
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final Block b = p.getLocation().getBlock();
        if (p.getItemInHand().getType() == Material.FIREWORK) {
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR) {
                if (b.getType() == Material.AIR && b.getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    this.jumpa.contains(p.getName());
                }
                if (this.inta.get(p.getName()) == 1 && p.isSneaking()) {
                    final Vector v1 = p.getLocation().getDirection().multiply(1.5).setY(0.45);
                    p.setVelocity(v1);
                    this.inta.put(p.getName(), 0);
                }
                this.jumpa.contains(p.getName());
                if (this.inta.get(p.getName()) == 1 && !p.isSneaking()) {
                    final Vector v2 = p.getLocation().getDirection().multiply(0.35).setY(0.9);
                    p.setVelocity(v2);
                    this.inta.put(p.getName(), 0);
                }
            }
        }
    }
    
    @EventHandler
    public void onTomarDano(final EntityDamageEvent event) {
        final Entity e = event.getEntity();
        if (e instanceof Player) {
            final Player player = (Player)e;
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getInventory().contains(Material.FIREWORK) && event.getDamage() >= 7.0) {
                event.setDamage(7.0);
            }
        }
    }
    
    @EventHandler
    public void fly(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Block b = p.getLocation().getBlock();
        if (b.getRelative(BlockFace.DOWN).getType() == Material.AIR) {
            this.jumpa.add(p.getName());
        }
        else if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
            this.inta.put(p.getName(), 1);
            this.jumpa.remove(p.getName());
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("kangaroo")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.kangaroo")) {
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
            final ItemStack sl = new ItemStack(Material.FIREWORK);
            final ItemMeta ksl = sl.getItemMeta();
            ksl.setDisplayName("§aKangaroo - DoubleJump");
            sl.setItemMeta(ksl);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cKangaroo", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cKangaroo");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(1, sl);
            p.getInventory().setItem(0, espada);
            Habilidade.setAbility(p, "Kangaroo");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Kangaroo.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
