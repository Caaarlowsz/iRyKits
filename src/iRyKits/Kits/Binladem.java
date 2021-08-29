package iRyKits.Kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Binladem implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Binladem(final Main main) {
        Binladem.plugin = main;
    }
    
    public Binladem() {
    }
    
    @EventHandler
    public void onTntLaunch(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() != Material.TNT) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            e.setCancelled(true);
            final int tntleft = p.getItemInHand().getAmount();
            if (tntleft == 1) {
                p.setItemInHand(new ItemStack(Material.AIR));
            }
            else {
                p.getItemInHand().setAmount(tntleft - 1);
            }
            final Location loc = p.getLocation();
            loc.setY(loc.getY() + 1.0);
            final Entity tnt = Bukkit.getServer().getWorld(p.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.PRIMED_TNT);
            tnt.setVelocity(p.getEyeLocation().getDirection().multiply(2.0));
        }
    }
    
    @EventHandler
    public void boomboom(final EntityExplodeEvent e) {
        if (e.getEntityType() == EntityType.PRIMED_TNT) {
            e.blockList().clear();
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("binladem")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.binladem")) {
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
            final ItemStack binlada = new ItemStack(Material.TNT, 5);
            final ItemMeta kbinlada = binlada.getItemMeta();
            kbinlada.setDisplayName("§aBinladem");
            binlada.setItemMeta(kbinlada);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cBinladem", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cBinladem");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, binlada);
            Habilidade.setAbility(p, "Binladem");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Binladem.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
