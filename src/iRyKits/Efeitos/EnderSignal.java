package iRyKits.Efeitos;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class EnderSignal implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public EnderSignal(final Main main) {
        EnderSignal.plugin = main;
    }
    
    public EnderSignal() {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("efeito2") && p.hasPermission("iry.efeitos")) {
            if (Main.Efeitos.contains(p.getName())) {
                p.sendMessage("�4Voc\u00ea ja esta a utilizar um efeito use /removerefeito para escolher outro!");
                return true;
            }
            Main.Efeitos.add(p.getName());
            Main.Ender.add(p.getName());
            p.sendMessage("�bEfeito >> ENDER_SIGNAL << Ativado!");
            p.sendMessage("�bRemova o efeito usando /removerefeito");
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (Main.Ender.contains(p.getName())) {
                        p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 200, 200);
                        p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 0.9, 0.0), Effect.ENDER_SIGNAL, 200, 200);
                        p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 1.1, 0.0), Effect.ENDER_SIGNAL, 200, 200);
                        p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 200, 200);
                        p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 0.9, 0.0), Effect.ENDER_SIGNAL, 200, 200);
                        p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0, 1.1, 0.0), Effect.ENDER_SIGNAL, 200, 200);
                    }
                }
            }, 0L, 20L);
        }
        else {
            p.sendMessage("�4Voc\u00ea n\u00e3o tem permiss\u00e3o para usar efeitos!");
            p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0f, 1.0f);
        }
        return false;
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = e.getEntity();
            Main.Ender.remove(p);
            Main.Efeitos.remove(p);
        }
    }
    
    @EventHandler
    public void QuandoQuitar(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        Main.Ender.remove(p);
        Main.Efeitos.remove(p);
    }
}
