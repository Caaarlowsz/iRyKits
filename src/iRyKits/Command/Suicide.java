package iRyKits.Command;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;

public class Suicide implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Label.equalsIgnoreCase("suicide")) {
            p.setHealth(0);
            p.sendMessage(Strings.SuicideMsg);
        }
        return false;
    }
}
