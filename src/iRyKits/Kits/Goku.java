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

public class Goku implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Goku.cooldown = new HashMap<String, Long>();
    }
    
    public Goku(final Main main) {
        Goku.plugin = main;
    }
    
    public Goku() {
    }
    
    @EventHandler
    public void hadouken(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Arrays.Goku.contains(p.getName()) && p.getItemInHand().getType() == Material.GOLD_BLOCK) {
            if (!Goku.cooldown.containsKey(p.getName()) || Goku.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Location location = p.getEyeLocation();
                final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
                while (blocksToAdd.hasNext()) {
                    final Location blockToAdd = blocksToAdd.next().getLocation();
                    p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object)Material.SPONGE, 20);
                    p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0f, 3.0f);
                }
                final Snowball h = (Snowball)p.launchProjectile((Class)Snowball.class);
                final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
                h.setVelocity(velo1);
                h.setMetadata("hadouken", (MetadataValue)new FixedMetadataValue(Main.plugin, (Object)true));
                Goku.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
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
            if (Arrays.Goku.contains(p.getName()) && s.hasMetadata("hadouken")) {
                e.setDamage(e.getDamage() + 9.0);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("goku")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.goku")) {
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
            final ItemStack goku = new ItemStack(Material.GOLD_BLOCK);
            final ItemMeta kgoku = goku.getItemMeta();
            kgoku.setDisplayName("�aKamehameha");
            goku.setItemMeta(kgoku);
            BarAPI.setMessage(p, "�6Voc\u00ea Pegou o Kit >> �cGoku", 2);
            p.sendMessage("�6Voc\u00ea Pegou o Kit >> �cGoku");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, goku);
            Habilidade.setAbility(p, "Goku");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Goku.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
