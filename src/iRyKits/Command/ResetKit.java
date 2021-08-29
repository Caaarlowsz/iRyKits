package iRyKits.Command;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.Event.*;
import iRyKits.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class ResetKit implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (Label.equalsIgnoreCase("resetkit")) {
            final Player p = (Player)Sender;
            if (!p.hasPermission("iry.resetkit")) {
                p.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            p.teleport(p.getWorld().getSpawnLocation());
            Habilidade.removeAbility(p);
            Arrays.remove(p);
            p.sendMessage(Strings.Resetkit);
            p.getInventory().clear();
            for (final PotionEffect effect : p.getActivePotionEffects()) {
                p.removePotionEffect(effect.getType());
            }
        }
        final Player p = (Player)Sender;
        final ItemStack kit = new ItemStack(Material.CHEST);
        final ItemMeta kkit = kit.getItemMeta();
        kkit.setDisplayName("§f» §6Kits §f«");
        kit.setItemMeta(kkit);
        final ItemStack warp = new ItemStack(Material.NAME_TAG);
        final ItemMeta kwarp = warp.getItemMeta();
        kwarp.setDisplayName("§f» §6Warps §f«");
        warp.setItemMeta(kwarp);
        final ItemStack shop = new ItemStack(Material.PAPER);
        final ItemMeta kshop = shop.getItemMeta();
        kshop.setDisplayName("§f» §6Menu §f«");
        shop.setItemMeta(kshop);
        final ItemStack buycraft = new ItemStack(Material.EMERALD);
        final ItemMeta kbuycraft = buycraft.getItemMeta();
        kbuycraft.setDisplayName("§f» §6Loja §f«");
        buycraft.setItemMeta(kbuycraft);
        final ItemStack grade = new ItemStack(Material.VINE);
        final ItemMeta kgrade = grade.getItemMeta();
        kgrade.setDisplayName(Strings.NomeServer);
        grade.setItemMeta(kgrade);
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
        p.getInventory().setItem(0, grade);
        p.getInventory().setItem(1, kit);
        p.getInventory().setItem(2, grade);
        p.getInventory().setItem(3, warp);
        p.getInventory().setItem(4, grade);
        p.getInventory().setItem(5, shop);
        p.getInventory().setItem(6, grade);
        p.getInventory().setItem(7, buycraft);
        p.getInventory().setItem(8, grade);
        return false;
    }
}
