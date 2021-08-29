package iRyKits.Kits;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Cactus implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Cactus(final Main main) {
        Cactus.plugin = main;
    }
    
    public Cactus() {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("cactus")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.cactus")) {
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
            final ItemStack cacts = new ItemStack(Material.CACTUS);
            final ItemMeta cactsmeta = cacts.getItemMeta();
            cactsmeta.setDisplayName("§aCactus");
            cactsmeta.addEnchant(Enchantment.THORNS, 3, true);
            cacts.setItemMeta(cactsmeta);
            p.getInventory().setHelmet(cacts);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cCactus", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cCactus");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setHelmet(cacts);
            Habilidade.setAbility(p, "Cactus");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Cactus.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
