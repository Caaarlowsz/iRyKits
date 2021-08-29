package iRyKits.Command;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;
import org.bukkit.*;

public class Check implements CommandExecutor, Listener
{
    public Check(final Main main) {
    }
    
    public Check() {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar esse comando!");
            return true;
        }
        final Player player = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("check")) {
            if (!player.hasPermission("iry.check")) {
                SemPerm.semPermiassao((Player)sender);
                return true;
            }
            if (args.length == 0) {
                player.sendMessage("§cUse: /check <Jogador>");
                return true;
            }
            if (args.length == 1) {
                final Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    player.sendMessage("§3Jogador §6>> §7" + target.getName());
                    player.sendMessage("§8-------------------------------------------");
                }
                player.sendMessage("§3IP §6>> §7" + target.getAddress().getHostString());
                player.sendMessage("§8------------------------------------------");
                player.sendMessage("§3Geoip §6>> §7http://www.geoiptool.com/pt/?ip=" + target.getAddress().getHostString());
                player.sendMessage("§8-------------------------------------------");
                player.sendMessage("§3Fome §6>> §7" + target.getFoodLevel());
                player.sendMessage("§8-------------------------------------------");
                player.sendMessage("§3Gamemode §6>> §7" + target.getGameMode());
                player.sendMessage("§8-------------------------------------------");
            }
        }
        return false;
    }
}
