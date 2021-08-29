package iRyKits.Kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Specialist implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Specialist(final Main main) {
        Specialist.plugin = main;
    }
    
    public Specialist() {
    }
    
    @EventHandler
    public void onIasnteract(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Arrays.Specialist.contains(p.getName()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.ENCHANTED_BOOK) {
            p.openEnchanting((Location)null, true);
        }
    }
    
    @EventHandler
    public void onVampire(final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player killed = (Player)event.getEntity();
            if (killed.getKiller() instanceof Player) {
                final Player player = event.getEntity().getKiller();
                if (Arrays.Specialist.contains(player.getName())) {
                    player.setLevel(1);
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("specialist")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.specialist")) {
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
            final ItemStack spe = new ItemStack(Material.ENCHANTED_BOOK);
            final ItemMeta kspe = spe.getItemMeta();
            kspe.setDisplayName("§aSpecialist");
            spe.setItemMeta(kspe);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cSpecialist", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cSpecialist");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, spe);
            Habilidade.setAbility(p, "Specialist");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Specialist.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
