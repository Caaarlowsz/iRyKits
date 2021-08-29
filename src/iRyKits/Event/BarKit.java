package iRyKits.Event;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import iRyKits.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class BarKit implements Listener
{
    public Main plugin;
    
    public BarKit(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void JogadorKIT(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player t = (Player)e.getEntity();
        final Player p = (Player)e.getDamager();
        if (Arrays.PvP.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - PvP");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Kangaroo.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Kangaroo");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Poseidon.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Poseidon");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Frosty.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Frosty");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Camel.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Camel");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Grandpa.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Grandpa");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Stomper.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Stomper");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Anchor.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Anchor");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.CookieMonster.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - CookieMonster");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.BlackOut.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - BlackOut");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Snail.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Snail");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Viper.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Viper");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Urgal.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Urgal");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Trocador.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Trocador");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Thor.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Thor");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Sniper.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Sniper");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Switcher.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Switcher");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Grappler.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Grappler");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Titan.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Titan");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Monk.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Monk");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Fujao.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Fuj\u00e3o");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Indio.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Indio");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.CheckPoint.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - CheckPoint");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Resouper.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Resouper");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Barbarian.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Barbarian");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Fisherman.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Fisherman");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.IronMan.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - IronMan");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Critical.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Critical");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Specialist.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Specialist");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Hulk.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Hulk");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.NetherMan.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - NetherMan");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Backpacker.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Backpacker");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Ninja.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Ninja");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Lobisomen.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Lobisomen");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Launcher.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Launcher");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Leopardo.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Leopardo");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Wither.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Wither");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Forcefield.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Forcefield");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Cactus.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Cactus");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Grenadier.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Grenadier");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Ryu.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Ryu");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Goku.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Goku");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Ghoul.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Ghoul");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.HotPotato.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - HotPotato");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Ebola.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Ebola");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Milkman.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Milkman");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Flash.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Flash");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Morf.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Morf");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.SpiderMan.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - SpiderMan");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Rider.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Rider");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Phantom.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Phantom");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Reaper.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Reaper");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.C4.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - C4");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Endermage.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Endermage");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Sonic.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Sonic");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.DeshFire.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - DeshFire");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Inferno.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Infernor");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Gladiator.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Gladiator");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Thresh.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Thresh");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Tower.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Tower");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (Arrays.Binladem.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Binladem");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
            return;
        }
        if (!Arrays.Used.contains(t.getName())) {
            BarAPI.setMessage(p, String.valueOf(t.getName()) + " - Sem Kit");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BarAPI.removeBar(p);
                }
            }, 100L);
        }
    }
}
