package iRyKits.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import iRyKits.*;
import org.bukkit.inventory.*;

public class Clear implements CommandExecutor
{
    private Main plugin;
    
    public Clear(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("clear") && args.length == 0 && (p.hasPermission("iry.clear") || p.isOp())) {
            final Inventory inv = (Inventory)p.getInventory();
            inv.clear();
            p.sendMessage(Strings.MsgClear);
        }
        return false;
    }
}
