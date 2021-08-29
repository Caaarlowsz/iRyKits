package iRyKits.Command;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import java.util.*;

public class Surprise implements CommandExecutor
{
    public Surprise(final Main main) {
    }
    
    public Surprise() {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("surprise") && p.hasPermission("kit.surprise")) {
            final Random random = new Random();
            final List randomCommands = Arrays.asList("Anchor", "infernor", "Thresh", "Gladiator", "Sonic", "DeshFire", "Endermage", "Backpacker", "C4", "Barbarian", "BlackOut", "Cactus", "Camel", "CheckPoint", "CookieMonster", "Critical", "Ebola", "Fireman", "Flash", "Forcefield", "Frosty", "Fujao", "Ghoul", "Goku", "Grandpa", "Grappler", "Grenadier", "HotPotato", "Hulk", "Indio", "IronMan", "Kangaroo", "Launcher", "Leopardo", "Lobisomen", "Milkman", "Monk", "Morf", "NetherMan", "Ninja", "Poseidon", "PvP", "Resouper", "Ryu", "Snail", "Sniper", "Specialist", "Stomper", "Switcher", "Thor", "Titan", "Trocador", "Urgal", "Viking", "Viper", "Wither", "SpiderMan", "Rider", "Phantom", "Reaper");
            final int index = random.nextInt(randomCommands.size());
            final String command = randomCommands.get(index);
            p.performCommand(command);
        }
        return false;
    }
}
