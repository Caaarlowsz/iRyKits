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

public class Titan implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Titan.cooldown = new HashMap<String, Long>();
    }
    
    public Titan(final Main main) {
        Titan.plugin = main;
    }
    
    public Titan() {
    }
    
    @EventHandler
    public void interact(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getType() == Material.BEDROCK && Arrays.Titan.contains(e.getPlayer().getName()) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            e.setCancelled(true);
            if (!Titan.cooldown.containsKey(p.getName()) || Titan.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                p.sendMessage(ChatColor.RED + "§lArmadura em §a100%");
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 3));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 3));
                p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 1.0f, 1.0f);
                Titan.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Armadura em §a0%");
            p.sendMessage(ChatColor.RED + "Cooldown");
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("titan")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.titan")) {
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
            final ItemStack titan = new ItemStack(Material.BEDROCK);
            final ItemMeta ktitan = titan.getItemMeta();
            ktitan.setDisplayName("§aTitan");
            titan.setItemMeta(ktitan);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cTitan", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cTitan");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, titan);
            Habilidade.setAbility(p, "Titan");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Titan.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
