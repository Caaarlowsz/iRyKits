package iRyKits.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import iRyKits.Strings;

public class Motd implements Listener {
	@EventHandler
	public void Listar(final ServerListPingEvent e) {
		e.setMotd(Strings.Motd);
	}
}
