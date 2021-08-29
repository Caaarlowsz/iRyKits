package iRyKits.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Tag implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("tag")) {
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(
						"§eTAG's §7Membro §aVip §9Mvp §6Pro §bYoutuber §1Builder §dTrial §5Mod §3Coder §cAdmin §4Dono");
				return false;
			}
			if (args[0].equalsIgnoreCase("membro")) {
				if (p.hasPermission("tag.membro")) {
					p.sendMessage("§7TAG Alterada Para §7Membro");
					p.setDisplayName("§7§lMEMBRO_ §7" + p.getName());
					p.setPlayerListName("§7" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			}
			if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("tag.builder")) {
					p.sendMessage("§7TAG Alterada Para §1Builder");
					p.setDisplayName("§1§lBUILDER_ §1" + p.getName());
					p.setPlayerListName("§1" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("tag.pro")) {
					p.sendMessage("§7TAG Alterada Para §6Pro");
					p.setDisplayName("§6§lPRO_ §6" + p.getName());
					p.setPlayerListName("§6" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("tag.youtuber")) {
					p.sendMessage("§7TAG Alterada Para §bYoutuber");
					p.setDisplayName("§b§lYTB_ §b" + p.getName());
					p.setPlayerListName("§b" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("vip")) {
				if (p.hasPermission("tag.vip")) {
					p.sendMessage("§7TAG Alterada Para §aVip");
					p.setDisplayName("§a§lVIP_ §a" + p.getName());
					p.setPlayerListName("§a" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
					p.sendMessage("§7TAG Alterada Para §dTrial");
					p.setDisplayName("§d§lTRIAL_ §d" + p.getName());
					p.setPlayerListName("§d" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("mvp")) {
				if (p.hasPermission("tag.mvp")) {
					p.sendMessage("§7TAG Alterada Para §9Mvp");
					p.setDisplayName("§9§lMVP_ §9" + p.getName());
					p.setPlayerListName("§9" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
					p.sendMessage("§7TAG Alterada Para §5Mod");
					p.setDisplayName("§5§lMOD_ §5" + p.getName());
					p.setPlayerListName("§5" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("coder")) {
				if (p.hasPermission("tag.coder")) {
					p.sendMessage("§7TAG Alterada Para §3Coder");
					p.setDisplayName("§3§lCODER_ §3" + p.getName());
					p.setPlayerListName("§3" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
					p.sendMessage("§7TAG Alterada Para §cAdmin");
					p.setDisplayName("§c§lADMIN_ §c" + p.getName());
					p.setPlayerListName("§c" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			} else if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("tag.dono")) {
					p.sendMessage("§7TAG Alterada Para §4Dono");
					p.setDisplayName("§4§lDONO_ §4" + p.getName());
					p.setPlayerListName("§4" + p.getName());
				} else {
					p.sendMessage("§7§l[§c§l!§7§l] §7Voc\u00ea N\u00e3o Possui Este Rank!");
				}
			}
		}
		return false;
	}

	public static String getShortStr(final String s) {
		if (s.length() == 16) {
			final String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 15) {
			final String shorts = s.substring(0, s.length() - 3);
			return shorts;
		}
		if (s.length() == 14) {
			final String shorts = s.substring(0, s.length() - 2);
			return shorts;
		}
		if (s.length() == 14) {
			final String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		if (s.length() == 13) {
			final String shorts = s.substring(0, s.length() - 0);
			return shorts;
		}
		if (s.length() == 13) {
			final String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		return s;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(final PlayerJoinEvent event) {
		final Player p = event.getPlayer();
		if (p.hasPermission("tag.normal")) {
			p.setPlayerListName(ChatColor.GREEN + getShortStr(p.getName()) + ChatColor.WHITE);
			p.setDisplayName(ChatColor.GREEN + p.getName() + ChatColor.WHITE);
			if (p.hasPermission("tag.vip")) {
				p.setPlayerListName(ChatColor.GREEN + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.GREEN + p.getName() + ChatColor.WHITE);
			}
			if (p.hasPermission("tag.mvp")) {
				p.setPlayerListName(ChatColor.YELLOW + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.YELLOW + p.getName() + ChatColor.WHITE);
			}
			if (p.hasPermission("tag.pro")) {
				p.setPlayerListName(ChatColor.GOLD + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.GOLD + p.getName() + ChatColor.WHITE);
			} else if (p.hasPermission("tag.youtuber")) {
				p.setPlayerListName(ChatColor.AQUA + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.AQUA + p.getName() + ChatColor.WHITE);
			} else if (p.hasPermission("tag.trial")) {
				p.setPlayerListName(ChatColor.LIGHT_PURPLE + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE);
			} else if (p.hasPermission("tag.mod")) {
				p.setPlayerListName(ChatColor.LIGHT_PURPLE + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE);
			} else if (p.hasPermission("tag.admin")) {
				p.setPlayerListName(ChatColor.RED + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.RED + p.getName() + ChatColor.WHITE);
			} else if (p.hasPermission("tag.coder")) {
				p.setPlayerListName(ChatColor.RED + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.RED + p.getName() + ChatColor.WHITE);
			} else if (p.hasPermission("tag.dono")) {
				p.setPlayerListName(ChatColor.DARK_RED + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.DARK_RED + p.getName() + ChatColor.WHITE);
			} else if (p.hasPermission("tag.builder")) {
				p.setPlayerListName(ChatColor.WHITE + getShortStr(p.getName()) + ChatColor.WHITE);
				p.setDisplayName(ChatColor.DARK_RED + p.getName() + ChatColor.WHITE);
			} else {
				p.setPlayerListName(p.getName());
				p.setDisplayName(p.getName());
			}
		}
	}
}
