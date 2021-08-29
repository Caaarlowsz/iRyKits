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

public class Snail implements Listener, CommandExecutor
{
    public Snail(final Main main) {
    }
    
    @EventHandler
    public void onSnail(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Player d = (Player)e.getDamager();
        if (!Arrays.Snail.contains(d.getName())) {
            return;
        }
        if (Math.random() > 0.4 && Math.random() > 0.1) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 0));
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("snail")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.snail")) {
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
            BarAPI.setMessage(p, "�6Voc\u00ea Pegou o Kit >> �cSnail", 2);
            p.sendMessage("�6Voc\u00ea Pegou o Kit >> �cSnail");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            Habilidade.setAbility(p, "Snail");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Snail.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
