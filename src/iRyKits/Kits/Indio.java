package iRyKits.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import com.sk89q.worldguard.protection.flags.*;
import org.bukkit.util.*;
import java.util.concurrent.*;
import org.bukkit.entity.*;
import com.sk89q.worldguard.bukkit.*;
import com.sk89q.worldguard.protection.managers.*;
import com.sk89q.worldguard.protection.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;
import org.bukkit.command.*;
import iRyKits.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class Indio implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    public static HashMap<String, Arrow> tiros;
    public static Main plugin;
    
    static {
        Indio.cooldown = new HashMap<String, Long>();
        Indio.tiros = new HashMap<String, Arrow>();
    }
    
    public Indio(final Main main) {
        Indio.plugin = main;
    }
    
    public Indio() {
    }
    
    @EventHandler
    public void disparar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.PUMPKIN_SEEDS && Arrays.Indio.contains(p.getName())) {
            final WorldGuardPlugin worldGuard = Main.getWorldGuard();
            final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
            final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
            if (set.allows(DefaultFlag.PVP)) {
                if (!Indio.cooldown.containsKey(p.getName()) || Indio.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                    e.setCancelled(true);
                    p.updateInventory();
                    final Arrow tiro = (Arrow)p.launchProjectile((Class)Arrow.class);
                    final Vector vec = p.getLocation().getDirection();
                    tiro.setVelocity(new Vector(vec.getX() * 1.0 * 3.5, vec.getY() * 1.0 * 4.0, vec.getZ() * 1.0 * 3.5));
                    Indio.tiros.put(p.getName(), tiro);
                    Indio.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                    p.sendMessage(ChatColor.GOLD + "Dardo disparado!");
                    p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
                    return;
                }
                p.sendMessage(ChatColor.RED + "Cooldown");
            }
            else {
                p.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
            }
        }
    }
    
    @EventHandler
    public void aplicar(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
            final Player p = (Player)e.getEntity();
            final Arrow tiro = (Arrow)e.getDamager();
            if (tiro.getShooter() instanceof Player) {
                final Player shooter = (Player)tiro.getShooter();
                if (Indio.tiros.containsKey(shooter.getName()) && tiro == Indio.tiros.get(shooter.getName())) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 300, 0));
                    p.sendMessage(ChatColor.BLUE + "Voc\u00ea foi atingido por um dardo do Patax\u00f3 " + ChatColor.DARK_PURPLE + shooter.getName());
                    p.playSound(p.getLocation(), Sound.BURP, 1.0f, 1.0f);
                    shooter.sendMessage(ChatColor.YELLOW + "O Sol conspira ao seu favor! " + ChatColor.DARK_PURPLE + p.getName() + ChatColor.YELLOW + " foi acertado pelo seu dardo!");
                    shooter.playSound(shooter.getLocation(), Sound.CAT_PURR, 1.0f, 1.0f);
                    Indio.tiros.remove(shooter.getName());
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("indio")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.indio")) {
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
            final ItemStack indio = new ItemStack(Material.PUMPKIN_SEEDS);
            final ItemMeta kindio = indio.getItemMeta();
            kindio.setDisplayName("§aCapetinha");
            indio.setItemMeta(kindio);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cIndio", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cIndio");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, indio);
            Habilidade.setAbility(p, "Indio");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.Indio.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
