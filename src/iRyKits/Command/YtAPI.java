package iRyKits.Command;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class YtAPI implements CommandExecutor
{
    public YtAPI(final Main main) {
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (Label.equalsIgnoreCase("req")) {
            final Player p = (Player)Sender;
            if (Args[0].toLowerCase().equalsIgnoreCase("yt")) {
                p.sendMessage("§3§l==========[YOUTUBER]==========");
                p.sendMessage("§3§lInscritos: §4§l400.");
                p.sendMessage("§3§lVideo: §b§lUm Video No Server.");
                p.sendMessage("§3§lLikes: §b§l50.");
                p.sendMessage("§3§lVisualiza\u00e7\u00f5es: §b§l300");
                p.sendMessage("§3§l==========[YOUTUBER]==========");
            }
            if (Args[0].toLowerCase().equalsIgnoreCase("pro")) {
                p.sendMessage("§6§l============[PRO]============");
                p.sendMessage("§6§lInscritos: §6§l250.");
                p.sendMessage("§6§lVideo: §e§lUm Video No Server.");
                p.sendMessage("§6§lLikes: §e§l25 Likes.");
                p.sendMessage("§6§lVisualiza\u00e7\u00f5es: §e§l100.");
                p.sendMessage("§6§l============[PRO]============");
            }
        }
        return false;
    }
}
