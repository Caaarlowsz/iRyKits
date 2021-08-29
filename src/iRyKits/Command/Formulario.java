package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;

public class Formulario implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("formulario")) {
            p.sendMessage(Strings.MsgFormulario);
        }
        return false;
    }
}
