package iRyKits.Event;

import org.bukkit.event.server.*;
import iRyKits.*;
import org.bukkit.event.*;

public class Motd implements Listener
{
    @EventHandler
    public void Listar(final ServerListPingEvent e) {
        e.setMotd(Strings.Motd);
    }
}
