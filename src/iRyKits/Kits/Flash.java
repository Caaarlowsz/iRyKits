package iRyKits.Kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import java.util.*;
import java.util.concurrent.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Flash implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Flash.cooldown = new HashMap<String, Long>();
    }
    
    public Flash(final Main main) {
        Flash.plugin = main;
    }
    
    public Flash() {
    }
    
    @EventHandler
    public void flash(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Arrays.Flash.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
            if (!Flash.cooldown.containsKey(p.getName()) || Flash.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Block b = p.getTargetBlock((HashSet)null, 100).getRelative(BlockFace.UP);
                p.teleport(b.getLocation());
                p.sendMessage("§aTeleportei :)");
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10.0f, 10.0f);
                Flash.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Cooldown");
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("flash")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.flash")) {
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
            final ItemStack f = new ItemStack(Material.REDSTONE_TORCH_ON);
            final ItemMeta kf = f.getItemMeta();
            kf.setDisplayName("§aFlash");
            f.setItemMeta(kf);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cFlash", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cFlash");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, f);
            Habilidade.setAbility(p, "Flash");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Flash.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
