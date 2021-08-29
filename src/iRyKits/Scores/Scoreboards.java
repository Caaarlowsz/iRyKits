package iRyKits.Scores;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import iRyKits.*;
import org.bukkit.*;
import iRyKits.Event.*;
import org.bukkit.scoreboard.*;

public class Scoreboards implements Listener
{
    public static void scoreboard(final Player p) {
        final Scoreboard score = Main.plugin.getServer().getScoreboardManager().getNewScoreboard();
        final Objective objetivo = score.registerNewObjective("PvP", "iRyKits");
        objetivo.setDisplayName("§b§kii §7" + p.getName() + " §b§kii");
        objetivo.setDisplaySlot(DisplaySlot.SIDEBAR);
        final Score a23 = objetivo.getScore(Bukkit.getOfflinePlayer("§7\u25bc Kills \u25bc"));
        a23.setScore(23);
        final Score a24 = objetivo.getScore(Bukkit.getOfflinePlayer("§a" + Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills")));
        a24.setScore(22);
        final Score a25 = objetivo.getScore(Bukkit.getOfflinePlayer("§k           "));
        a25.setScore(21);
        final Score a26 = objetivo.getScore(Bukkit.getOfflinePlayer("§7\u25bc Deaths \u25bc"));
        a26.setScore(20);
        final Score a27 = objetivo.getScore(Bukkit.getOfflinePlayer("§c" + Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes")));
        a27.setScore(19);
        final Score a28 = objetivo.getScore(Bukkit.getOfflinePlayer("§o           "));
        a28.setScore(18);
        final Score a29 = objetivo.getScore(Bukkit.getOfflinePlayer("§7\u25bc Kit \u25bc"));
        a29.setScore(17);
        final Score a30 = objetivo.getScore(Bukkit.getOfflinePlayer("§3" + Habilidade.getAbility(p)));
        a30.setScore(16);
        final Score a31 = objetivo.getScore(Bukkit.getOfflinePlayer("§l           "));
        a31.setScore(15);
        final Score a32 = objetivo.getScore(Bukkit.getOfflinePlayer("§7\u25bc Online \u25bc"));
        a32.setScore(10);
        final Score a33 = objetivo.getScore(Bukkit.getOfflinePlayer("§6" + Bukkit.getServer().getOnlinePlayers().length));
        a33.setScore(9);
        p.setScoreboard(score);
    }
}
