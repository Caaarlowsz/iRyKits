package iRyKits.Scores;

import org.bukkit.event.player.*;
import iRyKits.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Entrar implements Listener
{
    @EventHandler
    void aoEntrar(final PlayerJoinEvent evento) {
        final Player jogador = evento.getPlayer();
        Main.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Scoreboards.scoreboard(jogador);
            }
        }, 0L, 20L);
    }
}
