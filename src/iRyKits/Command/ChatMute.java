package iRyKits.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMute implements CommandExecutor, Listener {
	public static boolean b;

	static {
		ChatMute.b = false;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Apenas jogadores podem dar este comando!");
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("chatclose") && p.hasPermission("iry.chatmute")) {
			if (!ChatMute.b) {
				Bukkit.broadcastMessage("§cchat foi desabilitado Por >> §7" + p.getName());
				ChatMute.b = true;
			} else if (ChatMute.b) {
				Bukkit.broadcastMessage("§aO chat foi habilitado Por >> §7" + p.getName());
				ChatMute.b = false;
			}
		}
		return false;
	}

	@EventHandler
	public void a(final AsyncPlayerChatEvent event) {
		final Player player = event.getPlayer();
		if (!player.hasPermission("iry.chatmute") && ChatMute.b) {
			event.setCancelled(true);
			player.sendMessage("§cChat Esta Desativado !");
		}
	}
}
