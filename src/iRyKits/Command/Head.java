package iRyKits.Command;

import org.bukkit.event.*;
import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Head implements Listener, CommandExecutor
{
    private Main plugin;
    
    public Head(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.equalsIgnoreCase("head") && p.hasPermission("iry.head")) {
            if (args.length == 0) {
                p.sendMessage("§cUse: /head <Jogador>");
                return true;
            }
            final ItemStack s = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            final SkullMeta smeta = (SkullMeta)s.getItemMeta();
            smeta.setOwner(args[0]);
            s.setItemMeta((ItemMeta)smeta);
            p.getInventory().addItem(new ItemStack[] { s });
            p.updateInventory();
            p.sendMessage("§5Voc\u00ea pegou uma cabe\u00e7a");
        }
        return false;
    }
}
