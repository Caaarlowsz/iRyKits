package iRyKits.Kits;

import java.util.*;
import org.bukkit.entity.*;
import java.util.concurrent.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Hulk implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Hulk.cooldown = new HashMap<String, Long>();
    }
    
    public Hulk(final Main main) {
        Hulk.plugin = main;
    }
    
    public Hulk() {
    }
    
    @EventHandler
    public void pegar(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player r = (Player)e.getRightClicked();
            if (Arrays.Hulk.contains(p.getName())) {
                if (!Hulk.cooldown.containsKey(p.getName()) || Hulk.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                    if (p.getItemInHand().getType() == Material.SADDLE) {
                        e.setCancelled(true);
                        p.updateInventory();
                        p.setPassenger((Entity)r);
                        Hulk.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
                        p.sendMessage(ChatColor.GOLD + "Voc\u00ea pegou o player: " + ChatColor.WHITE + r.getName());
                        r.sendMessage(ChatColor.GOLD + "Voc\u00ea foi pego pelo Hulk: " + ChatColor.WHITE + p.getName());
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED + "Cooldown");
                }
            }
        }
    }
    
    @EventHandler
    public static void playerInteract(final PlayerInteractEvent event) {
        if (!event.getAction().equals((Object)Action.LEFT_CLICK_AIR)) {
            return;
        }
        final Player player = event.getPlayer();
        if (player.getPassenger() == null || !(player.getPassenger() instanceof Player)) {
            return;
        }
        final Player pass = (Player)player.getPassenger();
        player.eject();
        pass.damage(0.0, (Entity)player);
        pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0, pass.getVelocity().getZ()));
        pass.sendMessage(ChatColor.RED + "Voc\u00ea foi jogado por " + ChatColor.DARK_RED + player.getName());
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("hulk")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.hulk")) {
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
            final ItemStack hulk = new ItemStack(Material.SADDLE);
            final ItemMeta khulk = hulk.getItemMeta();
            khulk.setDisplayName("§aHulk");
            hulk.setItemMeta(khulk);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cHulk", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cHulk");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, hulk);
            Habilidade.setAbility(p, "Hulk");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Hulk.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
