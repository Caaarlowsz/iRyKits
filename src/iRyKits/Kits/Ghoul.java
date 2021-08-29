package iRyKits.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.potion.*;
import java.util.concurrent.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Ghoul implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Ghoul.cooldown = new HashMap<String, Long>();
    }
    
    public Ghoul(final Main main) {
        Ghoul.plugin = main;
    }
    
    public Ghoul() {
    }
    
    @EventHandler
    public void interact(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Arrays.Ghoul.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE) {
            if (!Ghoul.cooldown.containsKey(p.getName()) || Ghoul.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                p.sendMessage(ChatColor.RED + "Minha fome n\u00e3o pode ser saciada!");
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 3));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 500, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
                p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1.0f, 1.0f);
                Ghoul.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Cooldown");
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("ghoul")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.ghoul")) {
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
            final ItemStack gh = new ItemStack(Material.REDSTONE);
            final ItemMeta kgh = gh.getItemMeta();
            kgh.setDisplayName("§aGhoul");
            gh.setItemMeta(kgh);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cGhoul", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cGhoul");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, gh);
            Habilidade.setAbility(p, "Ghoul");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Ghoul.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
