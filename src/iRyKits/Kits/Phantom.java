package iRyKits.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import java.util.concurrent.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Phantom implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static Main plugin;
    
    static {
        Phantom.cooldown = new HashMap<String, Long>();
    }
    
    public Phantom(final Main main) {
        Phantom.plugin = main;
    }
    
    public Phantom() {
    }
    
    @EventHandler
    public void voar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction().name().contains("RIGHT") && p.getItemInHand().getType() == Material.FEATHER) {
            e.setCancelled(true);
            p.updateInventory();
            if (Arrays.Phantom.contains(p.getName())) {
                if (!Phantom.cooldown.containsKey(p.getName()) || Phantom.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(ChatColor.BLUE + "Agora voc\u00ea pode voar por 5 segundos!");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.setFlying(false);
                            p.setAllowFlight(false);
                            p.sendMessage(ChatColor.RED + "Hora de cortar as asas desse passarinho!");
                        }
                    }, 100L);
                    Phantom.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
                }
                else {
                    p.sendMessage(ChatColor.RED + "Cooldown");
                }
            }
        }
    }
    
    @EventHandler
    public void onTomarDano(final EntityDamageEvent event) {
        final Entity e = event.getEntity();
        if (e instanceof Player) {
            final Player player = (Player)e;
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getInventory().contains(Material.FEATHER) && event.getDamage() >= 0.0) {
                event.setDamage(0.0);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("phantom")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.phantom")) {
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
            final ItemStack ph = new ItemStack(Material.FEATHER);
            final ItemMeta kph = ph.getItemMeta();
            kph.setDisplayName("§aPhantom");
            ph.setItemMeta(kph);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cPhantom", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cPhantom");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, ph);
            Habilidade.setAbility(p, "Phantom");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Phantom.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
