package iRyKits.Event;

import iRyKits.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

public class Players implements Listener
{
    public Players(final Main main) {
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        e.setJoinMessage("§7[ §2+ §7] §3 " + p.getDisplayName());
        Habilidade.removeAbility(p);
        Arrays.remove(p);
        p.teleport(p.getWorld().getSpawnLocation());
        p.sendMessage("§7Bem Vindo Ao " + Strings.NomeServer);
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
    }
    
    @EventHandler
    public void onRespawn(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        Habilidade.removeAbility(p);
        Arrays.remove(p);
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
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        e.setDeathMessage((String)null);
        final Player p = e.getEntity();
        if (p.getKiller() instanceof Player) {
            final Player k = p.getKiller();
            final Location l = k.getLocation();
            final Location lp = p.getLocation();
            p.sendMessage(ChatColor.GRAY + "Voc\u00ea foi morto por: " + ChatColor.RED + ChatColor.ITALIC + k.getName());
            k.sendMessage(ChatColor.GRAY + "Voc\u00ea matou: " + ChatColor.GREEN + ChatColor.ITALIC + p.getName());
            k.playSound(l, Sound.FIREWORK_LAUNCH, 10.0f, 1.0f);
            p.playSound(lp, Sound.CREEPER_DEATH, 10.0f, 1.0f);
        }
    }
    
    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        e.setQuitMessage("§7[ §c- §7] §3" + p.getDisplayName());
        Habilidade.removeAbility(p);
    }
    
    @EventHandler
    public void onChat(final PlayerChatEvent e) {
        final Player p = e.getPlayer();
        e.setFormat(String.valueOf(p.getDisplayName()) + " §7\u279f §7§o " + e.getMessage());
    }
    
    @EventHandler
    public void KitSelector(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.CHEST && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§f» §6Kits §f«")) {
            p.chat("/kits");
        }
    }
    
    @EventHandler
    public void Warps(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.NAME_TAG && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§f» §6Warps §f«")) {
            p.chat("/warps");
        }
    }
    
    @EventHandler
    public void Menu(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.PAPER && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§f» §6Menu §f«")) {
            p.chat("/menu");
        }
    }
    
    @EventHandler
    public void BuyCraft(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.EMERALD && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§f» §6Loja §f«")) {
            p.chat("/buycraft");
        }
    }
}
