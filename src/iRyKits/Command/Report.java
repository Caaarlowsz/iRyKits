package iRyKits.Command;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import java.util.*;
import org.apache.commons.lang.*;
import org.bukkit.*;
import org.bukkit.plugin.*;

public class Report implements CommandExecutor
{
    public static ArrayList<String> reported;
    private Main plugin;
    
    static {
        Report.reported = new ArrayList<String>();
    }
    
    public Report(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoce nao e um jogador!");
            return false;
        }
        if (commandLabel.equalsIgnoreCase("report")) {
            if (args.length >= 2) {
                final Player target = p.getServer().getPlayer(args[0]);
                if (target != null) {
                    if (Report.reported.contains(p.getName())) {
                        p.sendMessage("§cCalma extressado , ja tem um staff olhando");
                        return true;
                    }
                    final String reportMsg = StringUtils.join((Object[])Arrays.copyOfRange(args, 1, args.length), " ");
                    Report.reported.add(p.getName());
                    p.sendMessage("§aVoc\u00ea reportou o §7" + target.getName() + "§a por§7: " + reportMsg);
                    p.sendMessage("§3Report Enviado !");
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player s = onlinePlayers[i];
                        if (s.hasPermission("iry.report")) {
                            s.sendMessage("§c[=-=-=-=-=-=-=-=-=-=-=-=]");
                            s.sendMessage("§6      - HACK REPORT -");
                            s.sendMessage("      §cREPORTADO: §7" + target.getName());
                            s.sendMessage("      §cMOTIVO: §7" + reportMsg);
                            s.sendMessage("      §cREPORTER: §7 " + p.getName());
                            s.sendMessage("§c[=-=-=-=-=-=-=-=-=-=-=-=]");
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                                @Override
                                public void run() {
                                    Report.reported.remove(p.getName());
                                }
                            }, 250L);
                        }
                    }
                }
                else {
                    p.sendMessage("§cJogador " + args[0] + " n\u00e3o est\u00e1 online.");
                }
            }
            else {
                p.sendMessage("§cUse: /" + commandLabel + " <Jogador> <Motivo>");
            }
        }
        return false;
    }
}
