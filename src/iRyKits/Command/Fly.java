package iRyKits.Command;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class Fly implements CommandExecutor
{
    private Main plugin;
    
    public Fly(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("fly") && p.hasPermission("iry.fly")) {
            if (args.length == 0) {
                if (!p.getAllowFlight()) {
                    p.setAllowFlight(true);
                    p.sendMessage("§2Fly Ativado Para: §9" + p.getName());
                }
                else {
                    p.setAllowFlight(false);
                    p.sendMessage("§cFly Desativado Para: §9" + p.getName());
                }
            }
            else {
                final Player t = p.getServer().getPlayer(args[0]);
                if (t != null) {
                    if (!t.getAllowFlight()) {
                        t.setAllowFlight(true);
                        t.sendMessage("§2Fly Ativado Para: §9" + t.getName());
                    }
                    else {
                        t.setAllowFlight(false);
                        t.sendMessage("§cFly Desativado Para: §9" + t.getName());
                    }
                }
                else {
                    p.sendMessage("§cJogador offline.");
                }
            }
        }
        return false;
    }
}
