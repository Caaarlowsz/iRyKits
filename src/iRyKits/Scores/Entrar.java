package iRyKits.Scores;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import iRyKits.Main;

public class Entrar implements Listener {
	@EventHandler
	void aoEntrar(final PlayerJoinEvent evento) {
		final Player jogador = evento.getPlayer();
		Main.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				Scoreboards.scoreboard(jogador);
			}
		}, 0L, 20L);
	}
}
