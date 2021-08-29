package iRyKits.Kits;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.player.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class C4L implements Listener
{
    private ArrayList<Player> cooldown;
    public static Main plugin;
    private Map<Player, Item> inbomb;
    
    public C4L(final Main main) {
        this.cooldown = new ArrayList<Player>();
        this.inbomb = new HashMap<Player, Item>();
        C4L.plugin = main;
    }
    
    @EventHandler
    public void a(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.AIR) {
            return;
        }
        if (p.getInventory().getItemInHand().getType() != Material.WOOD_BUTTON) {
            return;
        }
        if (e.getAction().name().contains("RIGHT")) {
            if (this.inbomb.containsKey(p) && Arrays.C4.contains(p.getName())) {
                return;
            }
            if (this.cooldown.contains(p)) {
                p.sendMessage("§cCooldown");
                return;
            }
            final Item C4bomb = p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.TNT));
            C4bomb.setVelocity(e.getPlayer().getEyeLocation().getDirection().multiply(0.6));
            C4bomb.setPickupDelay(999999);
            C4bomb.getItemStack().getItemMeta().setDisplayName("§aC4");
            this.inbomb.put(p, C4bomb);
            this.cooldown.add(p);
        }
        else if (this.inbomb.containsKey(p)) {
            final Item C4bomb = this.inbomb.get(p);
            p.getWorld().createExplosion(C4bomb.getLocation(), 3.0f, true);
            this.inbomb.remove(p);
            C4bomb.remove();
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)C4L.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    C4L.this.cooldown.remove(p);
                    p.sendMessage("§aVoc\u00ea ja pode usar o C4");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 20.0f, 1.0f);
                }
            }, 1000L);
        }
        else {
            p.sendMessage("§cA Bomba ainda n\u00e3o foi plantada");
        }
    }
}
