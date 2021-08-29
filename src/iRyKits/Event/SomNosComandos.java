package iRyKits.Event;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SomNosComandos implements Listener {
	@EventHandler
	public void digitarComando(final PlayerCommandPreprocessEvent e) {
		e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
	}
}
