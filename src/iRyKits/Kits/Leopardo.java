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

public class Leopardo implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Leopardo.cooldown = new HashMap<String, Long>();
    }
    
    public Leopardo(final Main main) {
        Leopardo.plugin = main;
    }
    
    public Leopardo() {
    }
    
    @EventHandler
    public void interact(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Arrays.Leopardo.contains(p.getName()) && p.getItemInHand().getType() == Material.MONSTER_EGG) {
            if (!Leopardo.cooldown.containsKey(p.getName()) || Leopardo.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                p.sendMessage(ChatColor.RED + "Modo leopardo ativado!");
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
                p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0f, 1.0f);
                Leopardo.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(50L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Cooldown");
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("leopardo")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.leopardo")) {
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
            final ItemStack leop = new ItemStack(Material.MONSTER_EGG);
            final ItemMeta kleop = leop.getItemMeta();
            kleop.setDisplayName("§aLeopardo");
            leop.setItemMeta(kleop);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cLeopardo", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cLeopardo");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, leop);
            Habilidade.setAbility(p, "Leopardo");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Leopardo.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
