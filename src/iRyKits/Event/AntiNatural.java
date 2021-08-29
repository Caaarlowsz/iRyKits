package iRyKits.Event;

import iRyKits.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.weather.*;
import org.bukkit.event.*;

public class AntiNatural implements Listener
{
    public AntiNatural(final Main main) {
    }
    
    @EventHandler
    public void onFome(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onChuva(final WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
}
