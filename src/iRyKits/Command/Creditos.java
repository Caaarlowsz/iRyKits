package iRyKits.Command;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class Creditos implements CommandExecutor
{
    public Creditos(final Main main) {
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (Label.equalsIgnoreCase("creditos")) {
            final Player p = (Player)Sender;
            p.sendMessage("§7=====================");
            p.sendMessage(" ");
            p.sendMessage("§3NPCRecraft: Kadas2");
            p.sendMessage("§3NPCSopa: Kadas2");
            p.sendMessage("§3Efeitos: Kadas2");
            p.sendMessage("§cTae Os Creditos :/");
            p.sendMessage(" ");
            p.sendMessage("§7=====================");
        }
        return false;
    }
}
