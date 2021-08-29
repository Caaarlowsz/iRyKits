package iRyKits.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Critical implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Critical(final Main main) {
        Critical.plugin = main;
    }
    
    public Critical() {
    }
    
    @EventHandler
    public void dano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (Arrays.Critical.contains(d.getName())) {
                final Random r = new Random();
                final int c = r.nextInt(100);
                if (c <= 30) {
                    if (Arrays.Critical.contains(p.getName())) {
                        e.setDamage(e.getDamage() + 4.0);
                    }
                    p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, (Object)Material.REDSTONE_BLOCK, 10);
                    p.sendMessage(ChatColor.RED + "Voc\u00ea recebeu um golpe critico de " + ChatColor.DARK_RED + d.getName());
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("critical")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.critical")) {
                p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> §cSem Permiss\u00e3o!");
                return true;
            }
            if (Arrays.Used.contains(p.getName())) {
                p.sendMessage(String.valueOf(Strings.NomeServer) + "§e >> " + "§c1 Kit Por Vida");
                return true;
            }
            final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta kespada = espada.getItemMeta();
            kespada.setDisplayName("§5Espada");
            espada.setItemMeta(kespada);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cCritical", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cCritical");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            Habilidade.setAbility(p, "Critical");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Critical.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
