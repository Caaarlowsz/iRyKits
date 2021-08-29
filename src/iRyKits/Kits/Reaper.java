package iRyKits.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Reaper implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Reaper(final Main main) {
        Reaper.plugin = main;
    }
    
    public Reaper() {
    }
    
    @EventHandler
    public void OnClick(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player damager = (Player)e.getDamager();
            final Player victim = (Player)e.getEntity();
            if (Arrays.Reaper.contains(damager.getName())) {
                Arrays.Reaper.add(damager.getName());
                if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("reaper")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.reaper")) {
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
            final ItemStack r = new ItemStack(Material.WOOD_HOE);
            final ItemMeta kr = r.getItemMeta();
            kr.setDisplayName("§aReaper");
            r.setItemMeta(kr);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cReaper", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cReaper");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, r);
            Habilidade.setAbility(p, "Reaper");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Reaper.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
