package iRyKits.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Resouper implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Resouper(final Main main) {
        Resouper.plugin = main;
    }
    
    public Resouper() {
    }
    
    @EventHandler
    public void onKill(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player k = e.getEntity().getKiller();
            if (Arrays.Resouper.contains(k.getName())) {
                k.getInventory().remove(Material.BOWL);
                try {
                    for (int i = 0; i < 36; ++i) {
                        k.getInventory().setItem(k.getInventory().firstEmpty(), new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }
                catch (ArrayIndexOutOfBoundsException ex) {}
                k.sendMessage(ChatColor.GREEN + "Seu inventario est\u00e1 cheio de sopas!");
                k.playSound(k.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("resouper")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.resouper")) {
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
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cResouper", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cResouper");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            Habilidade.setAbility(p, "Resouper");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Resouper.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
