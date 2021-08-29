package iRyKits.Event;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class SomNosComandos implements Listener
{
    @EventHandler
    public void digitarComando(final PlayerCommandPreprocessEvent e) {
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
    }
}
