package iRyKits.Kits;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Grandpa implements CommandExecutor
{
    public Grandpa(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("grandpa")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.grandpa")) {
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
            final ItemStack kpiru = new ItemStack(Material.STICK);
            kpiru.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
            final ItemMeta kkpiru = kpiru.getItemMeta();
            kkpiru.setDisplayName("§aGrandpa");
            kpiru.setItemMeta(kkpiru);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cGrandpa", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cGrandpa");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(1, kpiru);
            p.getInventory().setItem(0, espada);
            Habilidade.setAbility(p, "Grandpa");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Grandpa.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
