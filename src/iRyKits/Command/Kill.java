package iRyKits.Command;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;

public class Kill implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Label.equalsIgnoreCase("kill")) {
            p.sendMessage(Strings.KillMsg);
        }
        return false;
    }
}
