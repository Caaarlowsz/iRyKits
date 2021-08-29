package iRyKits.Event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chating implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public void replaceChat(final AsyncPlayerChatEvent e) {
		String msg = e.getMessage();
		msg = msg.replace("&", "§");
		msg = msg.replace(":/", "\u32db ");
		msg = msg.replace("<3", ChatColor.RED + "\u2764" + ChatColor.RESET);
		msg = msg.replace("-->", "\u27a1");
		msg = msg.replace("(y)", "\u2714");
		msg = msg.replace("(n)", "\u2716");
		msg = msg.replace("(copyright)", "©");
		msg = msg.replace("(tm)", "\u2122");
		msg = msg.replace("(flocon)", "\u2746");
		msg = msg.replace("(star)", "\u2730");
		msg = msg.replace("(music)", "\u266b");
		msg = msg.replace("(!)", "\u26a0");
		msg = msg.replace("ez", "GG");
		msg = msg.replace("%", "\u26a0");
		msg = msg.replace(":)", "\u263a");
		msg = msg.replace(":(", "\u2639");
		e.setMessage(msg);
	}
}
