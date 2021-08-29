package iRyKits.Kits;

import org.bukkit.event.player.*;
import org.bukkit.potion.*;
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

public class Camel implements Listener, CommandExecutor
{
    public Camel(final Main main) {
    }
    
    @EventHandler
    public void RunSand(final PlayerMoveEvent e) {
        if (e.isCancelled() || e.getFrom().getBlock().getLocation() != e.getTo().getBlock().getLocation()) {
            final Player p = e.getPlayer();
            final Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
            if (Arrays.Camel.contains(p.getName()) && block.getType() == Material.SAND) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 1));
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("Camel")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.camel")) {
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
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cCamel", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cCamel");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            Habilidade.setAbility(p, "Camel");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Camel.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
