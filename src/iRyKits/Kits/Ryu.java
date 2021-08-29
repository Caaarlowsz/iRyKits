package iRyKits.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.metadata.*;
import java.util.concurrent.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Ryu implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Ryu.cooldown = new HashMap<String, Long>();
    }
    
    public Ryu(final Main main) {
        Ryu.plugin = main;
    }
    
    public Ryu() {
    }
    
    @EventHandler
    public void hadouken(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Arrays.Ryu.contains(p.getName()) && p.getItemInHand().getType() == Material.BEACON && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("�aHadouken")) {
            if (!Ryu.cooldown.containsKey(p.getName()) || Ryu.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Location location = p.getEyeLocation();
                final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
                while (blocksToAdd.hasNext()) {
                    final Location blockToAdd = blocksToAdd.next().getLocation();
                    p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object)Material.DIAMOND_BLOCK, 20);
                    p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0f, 3.0f);
                }
                final Snowball h = (Snowball)p.launchProjectile((Class)Snowball.class);
                final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
                h.setVelocity(velo1);
                h.setMetadata("hadouken", (MetadataValue)new FixedMetadataValue(Main.plugin, (Object)true));
                Ryu.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Cooldown");
        }
    }
    
    @EventHandler
    public void dano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
            final Player p = (Player)e;
            final Snowball s = (Snowball)e.getDamager();
            if (s.hasMetadata("hadouken") && Arrays.Ryu.contains(p.getName())) {
                e.setDamage(e.getDamage() + 8.0);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("ryu")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.ryu")) {
                p.sendMessage(String.valueOf(Strings.NomeServer) + "�e >> �cSem Permiss\u00e3o!");
                return true;
            }
            if (Arrays.Used.contains(p.getName())) {
                p.sendMessage(String.valueOf(Strings.NomeServer) + "�e >> " + "�c1 Kit Por Vida");
                return true;
            }
            final ItemStack espada = new ItemStack(Material.STONE_SWORD);
            final ItemMeta kespada = espada.getItemMeta();
            kespada.setDisplayName("�5Espada");
            espada.setItemMeta(kespada);
            final ItemStack ryu = new ItemStack(Material.BEACON);
            final ItemMeta kryu = ryu.getItemMeta();
            kryu.setDisplayName("�aHadouken");
            ryu.setItemMeta(kryu);
            BarAPI.setMessage(p, "�6Voc\u00ea Pegou o Kit >> �cRyu", 2);
            p.sendMessage("�6Voc\u00ea Pegou o Kit >> �cRyu");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, ryu);
            Habilidade.setAbility(p, "Ryu");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Ryu.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
