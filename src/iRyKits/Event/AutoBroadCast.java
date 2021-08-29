package iRyKits.Event;

import org.bukkit.*;
import iRyKits.*;
import java.util.*;
import org.bukkit.plugin.*;

public class AutoBroadCast
{
    private static Main main;
    
    public AutoBroadCast(final Main pl) {
        AutoBroadCast.main = pl;
    }
    
    public static void start() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)AutoBroadCast.main, (Runnable)new Runnable() {
            String[] msg = { String.valueOf(Strings.NomeServer) + " §8: " + Strings.Men1, String.valueOf(Strings.NomeServer) + " §8: " + Strings.Men2, String.valueOf(Strings.NomeServer) + " §8: " + Strings.Men3, String.valueOf(Strings.NomeServer) + " §8: " + Strings.Men4 };
            
            @Override
            public void run() {
                Bukkit.getServer().broadcastMessage(this.msg[new Random().nextInt(this.msg.length)]);
            }
        }, 0L, 1250L);
    }
}
