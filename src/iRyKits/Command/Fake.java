package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Fake implements CommandExecutor
{
    public void onEnable() {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("fake") && p.hasPermission("fake.usar")) {
            if (args.length == 0) {
                p.sendMessage("§5=====================================================");
                p.sendMessage("§cUse: /fake [nick], Para deixar voc\u00ea como fake");
                p.sendMessage("§cUse: /desfake Para ficar com nick normal");
                p.sendMessage("§5=====================================================");
                return true;
            }
            String nicks = args[0];
            nicks = nicks.replaceAll("&", "§");
            p.setPlayerListName(nicks);
            p.setDisplayName(nicks);
            p.sendMessage("§3\u2738 Nick alterado com sucesso para: " + ChatColor.RESET + ChatColor.GRAY + nicks);
            p.chat("/disguise player " + nicks);
        }
        if (cmd.getName().equalsIgnoreCase("desfake")) {
            if (p.hasPermission("desfake.resetar")) {
                p.setPlayerListName(p.getName());
                p.setDisplayName(p.getName());
                p.sendMessage("§5\u2738 Seu nick voltou ao normal!");
                p.chat("/undisguise");
            }
            else {
                p.sendMessage("§4\u2716 Voce n\u00e3o tem Permiss\u00e3o.");
            }
        }
        return false;
    }
}
