package iRyKits.Kits;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import com.sk89q.worldguard.protection.flags.*;
import org.bukkit.inventory.*;
import com.sk89q.worldguard.bukkit.*;
import com.sk89q.worldguard.protection.managers.*;
import com.sk89q.worldguard.protection.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import iRyKits.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.inventory.meta.*;

public class HotPotato implements Listener, CommandExecutor
{
    public static ArrayList<Player> cooldown;
    public static Main plugin;
    
    static {
        HotPotato.cooldown = new ArrayList<Player>();
    }
    
    public HotPotato(final Main main) {
        HotPotato.plugin = main;
    }
    
    public HotPotato() {
    }
    
    @EventHandler
    public void clikacabeca(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        final Player clikou = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player clikado = (Player)e.getRightClicked();
            if (Arrays.HotPotato.contains(p.getName()) && clikou.getItemInHand().getType() == Material.POTATO_ITEM) {
                final WorldGuardPlugin worldGuard = Main.getWorldGuard();
                final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
                final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
                if (set.allows(DefaultFlag.PVP)) {
                    e.setCancelled(true);
                    if (!HotPotato.cooldown.contains(clikou)) {
                        HotPotato.cooldown.add(clikou);
                        clikou.sendMessage("§cVoc\u00ea Colou A TNT No §4§l" + clikado.getName());
                        clikado.sendMessage("§cUm HotPotato Colocou Um Bomba Na Sua");
                        clikado.sendMessage("§cCabe\u00e7a Retire Em 10 Segundos! Se Nao Voc\u00ea Explode!");
                        clikado.getInventory().setHelmet(new ItemStack(Material.TNT));
                        if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                            return;
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                if (clikado.getInventory().getHelmet().getType() != Material.TNT) {}
                            }
                        }, 100L);
                        if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                            clikado.sendMessage("§aA Batata Foi Desarmada!");
                            return;
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                clikado.sendMessage("§cVoc\u00ea Tem 5 Segundos Para Tirar a TNT!");
                                if (clikado.getInventory().getHelmet().getType() != Material.TNT) {}
                            }
                        }, 120L);
                        if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                            clikado.sendMessage("§aA Batata Foi Desarmada!");
                            return;
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                clikado.sendMessage("§cVoc\u00ea Tem 4 Segundos Para Tirar a TNT!");
                                if (clikado.getInventory().getHelmet().getType() != Material.TNT) {}
                            }
                        }, 140L);
                        if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                            clikado.sendMessage("§aA Batata Foi Desarmada!");
                            return;
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                clikado.sendMessage("§cVoc\u00ea Tem 3 Segundos Para Tirar a TNT!");
                                if (clikado.getInventory().getHelmet().getType() != Material.TNT) {}
                            }
                        }, 160L);
                        if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                            clikado.sendMessage("§aA Batata Foi Desarmada!");
                            return;
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                clikado.sendMessage("§cVoc\u00ea Tem 2 Segundos Para Tirar a TNT!");
                                if (clikado.getInventory().getHelmet().getType() != Material.TNT) {}
                            }
                        }, 180L);
                        if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                            clikado.sendMessage("§4§l[§c§l!§4§l] §a§lA Batata Foi Desarmada!");
                            return;
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                clikado.sendMessage("§cVoc\u00ea Tem 1 Segundos Para Tirar a TNT!");
                                if (clikado.getInventory().getHelmet().getType() != Material.TNT) {}
                            }
                        }, 180L);
                        if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                            clikado.sendMessage("§aA Batata Foi Desarmada!");
                            return;
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                clikado.sendMessage("§cKabum!");
                                if (clikado.getInventory().getHelmet().getType() != Material.TNT) {
                                    return;
                                }
                                final Location lol = clikado.getLocation();
                                clikado.getWorld().createExplosion(lol, 5.0f, false);
                                HotPotato.cooldown.remove(clikado);
                                clikado.getInventory().setHelmet(new ItemStack(Material.AIR));
                            }
                        }, 200L);
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                HotPotato.cooldown.remove(clikou);
                                clikou.sendMessage("§aVoc\u00ea Ja Pode Usar Seu Kit Novamente!");
                            }
                        }, 600L);
                    }
                    else {
                        clikou.sendMessage("§cCooldown");
                    }
                }
                else {
                    p.sendMessage("§cVoc\u00ea pode usar sua habilidade somente em PvP");
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] Args) {
        if (label.equalsIgnoreCase("hotpotato")) {
            final Player p = (Player)sender;
            if (!p.hasPermission("kit.hotpotato")) {
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
            final ItemStack hp = new ItemStack(Material.POTATO_ITEM);
            final ItemMeta khp = hp.getItemMeta();
            khp.setDisplayName("§aHotPotato");
            hp.setItemMeta(khp);
            BarAPI.setMessage(p, "§6Voc\u00ea Pegou o Kit >> §cHotPotato", 2);
            p.sendMessage("§6Voc\u00ea Pegou o Kit >> §cHotPotato");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            p.getInventory().setItem(0, espada);
            p.getInventory().setItem(1, hp);
            Habilidade.setAbility(p, "HotPotato");
            Arrays.sopa(p);
            Arrays.recraft(p);
            Arrays.HotPotato.add(p.getName());
            Arrays.Used.add(p.getName());
        }
        return false;
    }
}
