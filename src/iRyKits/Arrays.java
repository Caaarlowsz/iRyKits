package iRyKits;

import org.bukkit.event.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Arrays implements Listener
{
    public static ArrayList<String> reload;
    public static ArrayList<String> Used;
    public static ArrayList<String> PvP;
    public static ArrayList<String> Snail;
    public static ArrayList<String> Viper;
    public static ArrayList<String> Anchor;
    public static ArrayList<String> BlackOut;
    public static ArrayList<String> Camel;
    public static ArrayList<String> Frosty;
    public static ArrayList<String> Urgal;
    public static ArrayList<String> CookieMonster;
    public static ArrayList<String> Fujao;
    public static ArrayList<String> Poseidon;
    public static ArrayList<String> Stomper;
    public static ArrayList<String> Kangaroo;
    public static ArrayList<String> Thor;
    public static ArrayList<String> Grandpa;
    public static ArrayList<String> Trocador;
    public static ArrayList<String> Sniper;
    public static ArrayList<String> Switcher;
    public static ArrayList<String> Grappler;
    public static ArrayList<String> Titan;
    public static ArrayList<String> Monk;
    public static ArrayList<String> monkStaff;
    public static ArrayList<String> Indio;
    public static ArrayList<String> CheckPoint;
    public static ArrayList<String> Resouper;
    public static ArrayList<String> Barbarian;
    public static ArrayList<String> Fisherman;
    public static ArrayList<String> IronMan;
    public static ArrayList<String> Critical;
    public static ArrayList<String> Specialist;
    public static ArrayList<String> Hulk;
    public static ArrayList<String> NetherMan;
    public static ArrayList<String> Backpacker;
    public static ArrayList<String> Ninja;
    public static ArrayList<String> Lobisomen;
    public static ArrayList<String> Launcher;
    public static ArrayList<String> Leopardo;
    public static ArrayList<String> Wither;
    public static ArrayList<String> Forcefield;
    public static ArrayList<String> Forcefielddano;
    public static ArrayList<String> Cactus;
    public static ArrayList<String> Grenadier;
    public static ArrayList<String> Ryu;
    public static ArrayList<String> Goku;
    public static ArrayList<String> Viking;
    public static ArrayList<String> Ghoul;
    public static ArrayList<String> HotPotato;
    public static ArrayList<String> Ebola;
    public static ArrayList<String> Fireman;
    public static ArrayList<String> Milkman;
    public static ArrayList<String> Flash;
    public static ArrayList<String> Morf;
    public static ArrayList<String> SpiderMan;
    public static ArrayList<String> Rider;
    public static ArrayList<String> Phantom;
    public static ArrayList<String> Reaper;
    public static ArrayList<String> C4;
    public static ArrayList<String> Endermage;
    public static ArrayList<String> Sonic;
    public static ArrayList<String> DeshFire;
    public static ArrayList<String> Thresh;
    public static ArrayList<String> InfernoHab;
    public static ArrayList<String> Inferno;
    public static ArrayList<String> Gladiator;
    public static ArrayList<String> Tower;
    public static ArrayList<String> Binladem;
    public static ArrayList<String> Rain;
    
    static {
        Arrays.reload = new ArrayList<String>();
        Arrays.Used = new ArrayList<String>();
        Arrays.PvP = new ArrayList<String>();
        Arrays.Snail = new ArrayList<String>();
        Arrays.Viper = new ArrayList<String>();
        Arrays.Anchor = new ArrayList<String>();
        Arrays.BlackOut = new ArrayList<String>();
        Arrays.Camel = new ArrayList<String>();
        Arrays.Frosty = new ArrayList<String>();
        Arrays.Urgal = new ArrayList<String>();
        Arrays.CookieMonster = new ArrayList<String>();
        Arrays.Fujao = new ArrayList<String>();
        Arrays.Poseidon = new ArrayList<String>();
        Arrays.Stomper = new ArrayList<String>();
        Arrays.Kangaroo = new ArrayList<String>();
        Arrays.Thor = new ArrayList<String>();
        Arrays.Grandpa = new ArrayList<String>();
        Arrays.Trocador = new ArrayList<String>();
        Arrays.Sniper = new ArrayList<String>();
        Arrays.Switcher = new ArrayList<String>();
        Arrays.Grappler = new ArrayList<String>();
        Arrays.Titan = new ArrayList<String>();
        Arrays.Monk = new ArrayList<String>();
        Arrays.monkStaff = new ArrayList<String>();
        Arrays.Indio = new ArrayList<String>();
        Arrays.CheckPoint = new ArrayList<String>();
        Arrays.Resouper = new ArrayList<String>();
        Arrays.Barbarian = new ArrayList<String>();
        Arrays.Fisherman = new ArrayList<String>();
        Arrays.IronMan = new ArrayList<String>();
        Arrays.Critical = new ArrayList<String>();
        Arrays.Specialist = new ArrayList<String>();
        Arrays.Hulk = new ArrayList<String>();
        Arrays.NetherMan = new ArrayList<String>();
        Arrays.Backpacker = new ArrayList<String>();
        Arrays.Ninja = new ArrayList<String>();
        Arrays.Lobisomen = new ArrayList<String>();
        Arrays.Launcher = new ArrayList<String>();
        Arrays.Leopardo = new ArrayList<String>();
        Arrays.Wither = new ArrayList<String>();
        Arrays.Forcefield = new ArrayList<String>();
        Arrays.Forcefielddano = new ArrayList<String>();
        Arrays.Cactus = new ArrayList<String>();
        Arrays.Grenadier = new ArrayList<String>();
        Arrays.Ryu = new ArrayList<String>();
        Arrays.Goku = new ArrayList<String>();
        Arrays.Viking = new ArrayList<String>();
        Arrays.Ghoul = new ArrayList<String>();
        Arrays.HotPotato = new ArrayList<String>();
        Arrays.Ebola = new ArrayList<String>();
        Arrays.Fireman = new ArrayList<String>();
        Arrays.Milkman = new ArrayList<String>();
        Arrays.Flash = new ArrayList<String>();
        Arrays.Morf = new ArrayList<String>();
        Arrays.SpiderMan = new ArrayList<String>();
        Arrays.Rider = new ArrayList<String>();
        Arrays.Phantom = new ArrayList<String>();
        Arrays.Reaper = new ArrayList<String>();
        Arrays.C4 = new ArrayList<String>();
        Arrays.Endermage = new ArrayList<String>();
        Arrays.Sonic = new ArrayList<String>();
        Arrays.DeshFire = new ArrayList<String>();
        Arrays.Thresh = new ArrayList<String>();
        Arrays.InfernoHab = new ArrayList<String>();
        Arrays.Inferno = new ArrayList<String>();
        Arrays.Gladiator = new ArrayList<String>();
        Arrays.Tower = new ArrayList<String>();
        Arrays.Binladem = new ArrayList<String>();
        Arrays.Rain = new ArrayList<String>();
    }
    
    public static void remove(final Player p) {
        Arrays.Grandpa.remove(p.getName());
        Arrays.reload.remove(p.getName());
        Arrays.Used.remove(p.getName());
        Arrays.Thor.remove(p.getName());
        Arrays.Stomper.remove(p.getName());
        Arrays.PvP.remove(p.getName());
        Arrays.Snail.remove(p.getName());
        Arrays.Viper.remove(p.getName());
        Arrays.Anchor.remove(p.getName());
        Arrays.BlackOut.remove(p.getName());
        Arrays.Camel.remove(p.getName());
        Arrays.Frosty.remove(p.getName());
        Arrays.Urgal.remove(p.getName());
        Arrays.CookieMonster.remove(p.getName());
        Arrays.Fujao.remove(p.getName());
        Arrays.Poseidon.remove(p.getName());
        Arrays.Trocador.remove(p.getName());
        Arrays.Sniper.remove(p.getName());
        Arrays.Switcher.remove(p.getName());
        Arrays.Grappler.remove(p.getName());
        Arrays.Titan.remove(p.getName());
        Arrays.Monk.remove(p.getName());
        Arrays.Indio.remove(p.getName());
        Arrays.CheckPoint.remove(p.getName());
        Arrays.Resouper.remove(p.getName());
        Arrays.Barbarian.remove(p.getName());
        Arrays.Fisherman.remove(p.getName());
        Arrays.IronMan.remove(p.getName());
        Arrays.Critical.remove(p.getName());
        Arrays.Specialist.remove(p.getName());
        Arrays.Hulk.remove(p.getName());
        Arrays.NetherMan.remove(p.getName());
        Arrays.Backpacker.remove(p.getName());
        Arrays.Ninja.remove(p.getName());
        Arrays.Lobisomen.remove(p.getName());
        Arrays.Launcher.remove(p.getName());
        Arrays.Leopardo.remove(p.getName());
        Arrays.Wither.remove(p.getName());
        Arrays.Forcefield.remove(p.getName());
        Arrays.Forcefielddano.remove(p.getName());
        Arrays.Cactus.remove(p.getName());
        Arrays.Grenadier.remove(p.getName());
        Arrays.Ryu.remove(p.getName());
        Arrays.Goku.remove(p.getName());
        Arrays.Viking.remove(p.getName());
        Arrays.Ghoul.remove(p.getName());
        Arrays.HotPotato.remove(p.getName());
        Arrays.Ebola.remove(p.getName());
        Arrays.Fireman.remove(p.getName());
        Arrays.Milkman.remove(p.getName());
        Arrays.Flash.remove(p.getName());
        Arrays.Morf.remove(p.getName());
        Arrays.monkStaff.remove(p.getName());
        Arrays.SpiderMan.remove(p.getName());
        Arrays.Rider.remove(p.getName());
        Arrays.Phantom.remove(p.getName());
        Arrays.Reaper.remove(p.getName());
        Arrays.C4.remove(p.getName());
        Arrays.Endermage.remove(p.getName());
        Arrays.Sonic.remove(p.getName());
        Arrays.DeshFire.remove(p.getName());
        Arrays.Thresh.remove(p.getName());
        Arrays.InfernoHab.remove(p.getName());
        Arrays.Inferno.remove(p.getName());
        Arrays.Gladiator.remove(p.getName());
        Arrays.Tower.remove(p.getName());
        Arrays.Binladem.remove(p.getName());
        Arrays.Rain.remove(p.getName());
    }
    
    public static void sopa(final Player p) {
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta ksopa = sopa.getItemMeta();
        ksopa.setDisplayName("�3--> �6Sopa �3<--");
        sopa.setItemMeta(ksopa);
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
    }
    
    public static void recraft(final Player p) {
        final ItemStack sopas = new ItemStack(Material.BOWL, 64);
        final ItemMeta ksopas = sopas.getItemMeta();
        ksopas.setDisplayName("�3--> �7Pote �3<--");
        sopas.setItemMeta(ksopas);
        final ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
        final ItemMeta kcogur = cogur.getItemMeta();
        kcogur.setDisplayName("�3--> �cVermelho �3<--");
        cogur.setItemMeta(kcogur);
        final ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
        final ItemMeta kcogum = cogum.getItemMeta();
        kcogum.setDisplayName("�3--> �8Marrom �3<--");
        cogum.setItemMeta(kcogum);
        p.getInventory().setItem(13, sopas);
        p.getInventory().setItem(14, cogur);
        p.getInventory().setItem(15, cogum);
    }
}
