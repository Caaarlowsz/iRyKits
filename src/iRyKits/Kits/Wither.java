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

public class Wither implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Wither(final Main main) {
        Wither.plugin = main;
    }
    
    public Wither() {
    }
    
    @EventHandler(ignoreCancelled = true)
    public void Snail(final EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player) {
            final Player damager = (Player)event.getDamager();
            if (damager.getInventory().getItemInHand().getType() == Material.NETHER_STAR && Arrays.Wither.contains(damager.getName()) && Math.random() < 0.5) {
                ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 300, 0));
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("wither")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.wither")) {
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
            final ItemStack wither = new ItemStack(Material.NETHER_STAR);
            final ItemMeta kwither = wither.getItemMeta();
            kwither.setDisplayName("§aWither-Boss");
            wither.setItemMeta(kwither);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cWhiter", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cWhiter");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, wither);
            Habilidade.setAbility(p, "Wither");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Wither.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
