package iRyKits;

import org.bukkit.event.*;
import org.bukkit.entity.*;

public class SemPerm implements Listener
{
    public SemPerm StaffChat;
    public SemPerm StaffReceiveChat;
    
    public SemPerm(final String string) {
        this.StaffChat = new SemPerm("iry.perm");
        this.StaffReceiveChat = new SemPerm("iry.perm");
    }
    
    public static void semPermiassao(final Player player) {
        player.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
    }
}
