package iRyKits.Kits;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Milkman implements Listener, CommandExecutor
{
    private transient HashMap<ItemStack, Integer> cooldown;
    public int maxUses;
    public String milkbucketName;
    public String[] potionEffects;
    public static Main plugin;
    
    public Milkman(final Main main) {
        this.cooldown = new HashMap<ItemStack, Integer>();
        this.maxUses = 5;
        this.milkbucketName = "Milkman's Bucket";
        this.potionEffects = new String[] { "REGENERATION 900 0", "FIRE_RESISTANCE 900 0", "SPEED 900 0" };
        Milkman.plugin = main;
    }
    
    public Milkman() {
        this.cooldown = new HashMap<ItemStack, Integer>();
        this.maxUses = 5;
        this.milkbucketName = "Milkman's Bucket";
        this.potionEffects = new String[] { "REGENERATION 900 0", "FIRE_RESISTANCE 900 0", "SPEED 900 0" };
    }
    
    @EventHandler
    public void onConsume(final PlayerItemConsumeEvent event) {
        final ItemStack item = event.getItem();
        final Player p = event.getPlayer();
        if (Arrays.Milkman.contains(p.getName())) {
            String[] potionEffects;
            for (int length = (potionEffects = this.potionEffects).length, i = 0; i < length; ++i) {
                final String string = potionEffects[i];
                final String[] effect = string.split(" ");
                final PotionEffect potionEffect = new PotionEffect(PotionEffectType.getByName(effect[0].toUpperCase()), Integer.parseInt(effect[1]), Integer.parseInt(effect[2]));
                p.addPotionEffect(potionEffect, true);
            }
            if (!this.cooldown.containsKey(item)) {
                this.cooldown.put(item, 0);
            }
            this.cooldown.put(item, this.cooldown.get(item) + 1);
            if (this.cooldown.get(item) == this.maxUses) {
                this.cooldown.remove(item);
                event.setCancelled(true);
                p.setItemInHand(new ItemStack(Material.BUCKET, item.getAmount(), item.getDurability()));
            }
            else {
                event.setCancelled(true);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("milkman")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.milkman")) {
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
            final ItemStack mk = new ItemStack(Material.MILK_BUCKET);
            final ItemMeta kmk = mk.getItemMeta();
            kmk.setDisplayName("§aMilkman");
            mk.setItemMeta(kmk);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cMilkman", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cMilkman");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, mk);
            Habilidade.setAbility(p, "Milkman");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Milkman.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
