package iRyKits.Kits;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.potion.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Fujao implements Listener, CommandExecutor
{
    public static Main plugin;
    static List<Player> cooldown;
    
    static {
        Fujao.cooldown = new ArrayList<Player>();
    }
    
    public Fujao(final Main main) {
        Fujao.plugin = main;
    }
    
    public void onRemove(final PlayerRespawnEvent e) {
        Fujao.cooldown.remove(e.getPlayer().getName());
    }
    
    public void onRemove1(final PlayerJoinEvent e) {
        Fujao.cooldown.remove(e.getPlayer().getName());
    }
    
    public Fujao() {
    }
    
    @EventHandler
    public void powerBush(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getType() == Material.SLIME_BALL && Arrays.Fujao.contains(e.getPlayer().getName())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                e.setCancelled(true);
            }
            if (Fujao.cooldown.contains(p)) {
                p.sendMessage(ChatColor.RED + "Cooldown");
                return;
            }
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 2));
            Fujao.cooldown.add(p);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Fujao.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Fujao.cooldown.remove(p);
                    p.sendMessage(ChatColor.GREEN + "O Cooldown Acabo!");
                }
            }, 780L);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("fujao")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.fujao")) {
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
            final ItemStack sl = new ItemStack(Material.SLIME_BALL);
            final ItemMeta ksl = sl.getItemMeta();
            ksl.setDisplayName("�aFujao");
            sl.setItemMeta(ksl);
            BarAPI.setMessage(p, "�6Voc\u00ea Pegou o Kit >> �cFujao", 2);
            p.sendMessage("�6Voc\u00ea Pegou o Kit >> �cFuj\u00e3o");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(1, sl);
            p.getInventory().setItem(0, espada);
            Habilidade.setAbility(p, "Fujao");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Fujao.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}