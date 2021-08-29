package iRyKits.Scores;

import org.bukkit.event.player.*;
import iRyKits.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Status implements Listener
{
    @EventHandler
    void aoLogar(final PlayerJoinEvent evento) {
        final Player jogador = evento.getPlayer();
        if (Main.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null) {
            Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object)0);
            Main.plugin.saveConfig();
        }
        if (Main.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".mortes") == null) {
            Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object)0);
            Main.plugin.saveConfig();
        }
    }
    
    @EventHandler
    void aoMatar(final PlayerDeathEvent evento) {
        if (evento.getEntity().getKiller() instanceof Player) {
            final Player jogador = evento.getEntity().getKiller();
            final int kills = Main.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".kills");
            Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object)(kills + 1));
            Main.plugin.saveConfig();
        }
    }
    
    @EventHandler
    void aoMorrer(final PlayerDeathEvent evento) {
        if (evento.getEntity() instanceof Player) {
            final Player jogador = evento.getEntity();
            final int mortes = Main.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".mortes");
            Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object)(mortes + 1));
            Main.plugin.saveConfig();
        }
    }
}
