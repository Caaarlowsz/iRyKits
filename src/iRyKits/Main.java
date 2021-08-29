package iRyKits;

import org.bukkit.plugin.java.*;
import org.bukkit.entity.*;
import com.sk89q.worldguard.protection.flags.*;
import com.sk89q.worldguard.protection.*;
import org.bukkit.event.*;
import iRyKits.List.*;
import iRyKits.Scores.*;
import iRyKits.Event.*;
import org.bukkit.plugin.*;
import iRyKits.Vidas.*;
import iRyKits.Efeitos.*;
import iRyKits.Kits.*;
import iRyKits.Command.*;
import com.sk89q.worldguard.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.potion.*;
import org.bukkit.enchantments.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Main extends JavaPlugin
{
    private AutoBroadCast AutoMessanger;
    public static Plugin plugin;
    public static Main instance;
    public static final List<Player> warping;
    public static final List<Player> delay;
    public static ArrayList<String> Flames;
    public static ArrayList<String> Ender;
    public static ArrayList<String> Redstone;
    public static ArrayList<String> Diamond;
    public static ArrayList<String> Water;
    public static ArrayList<String> Efeitos;
    public static ArrayList<String> Smoke;
    public static ArrayList<String> EXTINGUISH;
    public static ArrayList<String> Potion;
    public static ArrayList<String> Rainbow;
    
    static {
        warping = new ArrayList<Player>();
        delay = new ArrayList<Player>();
        Main.Flames = new ArrayList<String>();
        Main.Ender = new ArrayList<String>();
        Main.Redstone = new ArrayList<String>();
        Main.Diamond = new ArrayList<String>();
        Main.Water = new ArrayList<String>();
        Main.Efeitos = new ArrayList<String>();
        Main.Smoke = new ArrayList<String>();
        Main.EXTINGUISH = new ArrayList<String>();
        Main.Potion = new ArrayList<String>();
        Main.Rainbow = new ArrayList<String>();
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
    public static Plugin getPlugin() {
        return Main.plugin;
    }
    
    public void onEnable() {
        Main.instance = this;
        Main.plugin = (Plugin)this;
        getWorldGuard();
        this.getConfig().options().copyDefaults(true);
        this.getConfig().options().copyHeader(true);
        this.saveConfig();
        this.AutoMessanger = new AutoBroadCast(this);
        AutoBroadCast.start();
        this.onRegisterEvents();
        this.onRegisterCommands();
        this.saveDefaultConfig();
    }
    
    public void onDisable() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player all = onlinePlayers[i];
            all.kickPlayer(Strings.MsgFechandoServer);
        }
    }
    
    public static boolean areaPvP(final Player p) {
        final ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
        return region.allows(DefaultFlag.PVP);
    }
    
    public void onRegisterEvents() {
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents((Listener)new AntiNatural(this), (Plugin)this);
        pm.registerEvents((Listener)new Specialist(), (Plugin)this);
        pm.registerEvents((Listener)new Players(this), (Plugin)this);
        pm.registerEvents((Listener)new NoDrop(this), (Plugin)this);
        pm.registerEvents((Listener)new Sopa(this), (Plugin)this);
        pm.registerEvents((Listener)new DeshFire(), (Plugin)this);
        pm.registerEvents((Listener)new Fisherman(), (Plugin)this);
        pm.registerEvents((Listener)new Bust(this), (Plugin)this);
        pm.registerEvents((Listener)new Indio(), (Plugin)this);
        pm.registerEvents((Listener)new Lobisomen(), (Plugin)this);
        pm.registerEvents((Listener)new Fireman(), (Plugin)this);
        pm.registerEvents((Listener)new Rider(), (Plugin)this);
        pm.registerEvents((Listener)new Nearf(), (Plugin)this);
        pm.registerEvents((Listener)new BarKit(this), (Plugin)this);
        pm.registerEvents((Listener)new Kits(this), (Plugin)this);
        pm.registerEvents((Listener)new Kits2(this), (Plugin)this);
        pm.registerEvents((Listener)new KillStreak(this), (Plugin)this);
        pm.registerEvents((Listener)new NoCommand(), (Plugin)this);
        pm.registerEvents((Listener)new Goku(), (Plugin)this);
        pm.registerEvents((Listener)new Tag(), (Plugin)this);
        pm.registerEvents((Listener)new Ryu(), (Plugin)this);
        pm.registerEvents((Listener)new NoPlugin(), (Plugin)this);
        pm.registerEvents((Listener)new Sonic(), (Plugin)this);
        pm.registerEvents((Listener)new Reaper(), (Plugin)this);
        pm.registerEvents((Listener)new Warps(this), (Plugin)this);
        pm.registerEvents((Listener)new Ghoul(), (Plugin)this);
        pm.registerEvents((Listener)new Grenadier(), (Plugin)this);
        pm.registerEvents((Listener)new Viking(), (Plugin)this);
        pm.registerEvents((Listener)new Cactus(), (Plugin)this);
        pm.registerEvents((Listener)new NPCSopa(), (Plugin)this);
        pm.registerEvents((Listener)new NPCRecraft(), (Plugin)this);
        pm.registerEvents((Listener)new Morf(), (Plugin)this);
        pm.registerEvents((Listener)new Flash(), (Plugin)this);
        pm.registerEvents((Listener)new Endermage(this), (Plugin)this);
        pm.registerEvents((Listener)new Menu(this), (Plugin)this);
        pm.registerEvents((Listener)new Phantom(), (Plugin)this);
        pm.registerEvents((Listener)new Admin(), (Plugin)this);
        pm.registerEvents((Listener)new SpiderMan(), (Plugin)this);
        pm.registerEvents((Listener)new Selector(this), (Plugin)this);
        pm.registerEvents((Listener)new Sniper(), (Plugin)this);
        pm.registerEvents((Listener)new HotPotato(), (Plugin)this);
        pm.registerEvents((Listener)new NetherMan(this), (Plugin)this);
        pm.registerEvents((Listener)new C4L(this), (Plugin)this);
        pm.registerEvents((Listener)new Grappler(), (Plugin)this);
        pm.registerEvents((Listener)new RepararEspada(), (Plugin)this);
        pm.registerEvents((Listener)new Ebola(), (Plugin)this);
        pm.registerEvents((Listener)new BuildEvent(), (Plugin)this);
        pm.registerEvents((Listener)new Launcher(), (Plugin)this);
        pm.registerEvents((Listener)new PlacaDeRecraft(), (Plugin)this);
        pm.registerEvents((Listener)new PlacaDeSopa(), (Plugin)this);
        pm.registerEvents((Listener)new Drop(this), (Plugin)this);
        pm.registerEvents((Listener)new Wither(), (Plugin)this);
        pm.registerEvents((Listener)new SemExplosao(), (Plugin)this);
        pm.registerEvents((Listener)new Forcefield(), (Plugin)this);
        pm.registerEvents((Listener)new Ninja(), (Plugin)this);
        pm.registerEvents((Listener)new Critical(), (Plugin)this);
        pm.registerEvents((Listener)new Trocador(), (Plugin)this);
        pm.registerEvents((Listener)new Milkman(), (Plugin)this);
        pm.registerEvents((Listener)new Switcher(), (Plugin)this);
        pm.registerEvents((Listener)new Urgal(this), (Plugin)this);
        pm.registerEvents((Listener)new Motd(), (Plugin)this);
        pm.registerEvents((Listener)new Resouper(), (Plugin)this);
        pm.registerEvents((Listener)new Chating(), (Plugin)this);
        pm.registerEvents((Listener)new Ban(this), (Plugin)this);
        pm.registerEvents((Listener)new Rain(this), (Plugin)this);
        pm.registerEvents((Listener)new Binladem(), (Plugin)this);
        pm.registerEvents((Listener)new Backpacker(), (Plugin)this);
        pm.registerEvents((Listener)new IronMan(), (Plugin)this);
        pm.registerEvents((Listener)new Youtuber(this), (Plugin)this);
        pm.registerEvents((Listener)new Thor(this), (Plugin)this);
        pm.registerEvents((Listener)new Leopardo(), (Plugin)this);
        pm.registerEvents((Listener)new Kangaroo(this), (Plugin)this);
        pm.registerEvents((Listener)new Stomper(this), (Plugin)this);
        pm.registerEvents((Listener)new Poseidon(this), (Plugin)this);
        pm.registerEvents((Listener)new Fujao(this), (Plugin)this);
        pm.registerEvents((Listener)new Camel(this), (Plugin)this);
        pm.registerEvents((Listener)new ChatMute(), (Plugin)this);
        pm.registerEvents((Listener)new Frosty(this), (Plugin)this);
        pm.registerEvents((Listener)new BlackOut(this), (Plugin)this);
        pm.registerEvents((Listener)new Anchor(this), (Plugin)this);
        pm.registerEvents((Listener)new Viper(this), (Plugin)this);
        pm.registerEvents((Listener)new Barbarian(), (Plugin)this);
        pm.registerEvents((Listener)new Snail(this), (Plugin)this);
        pm.registerEvents((Listener)new AntiSpam(), (Plugin)this);
        pm.registerEvents((Listener)new CheckPoint(), (Plugin)this);
        pm.registerEvents((Listener)new Habilidade(), (Plugin)this);
        pm.registerEvents((Listener)new Entrar(), (Plugin)this);
        pm.registerEvents((Listener)new Scoreboards(), (Plugin)this);
        pm.registerEvents((Listener)new Status(), (Plugin)this);
        pm.registerEvents((Listener)new Hulk(), (Plugin)this);
        pm.registerEvents((Listener)new Tower(this), (Plugin)this);
        pm.registerEvents((Listener)new SomNosComandos(), (Plugin)this);
        pm.registerEvents((Listener)new Titan(), (Plugin)this);
        pm.registerEvents((Listener)new Monk(), (Plugin)this);
        pm.registerEvents((Listener)new CookieMonster(this), (Plugin)this);
        pm.registerEvents((Listener)new TagEntrar(), (Plugin)this);
        pm.registerEvents((Listener)new InfernorHab(this), (Plugin)this);
        pm.registerEvents((Listener)new Gladiator(this), (Plugin)this);
        pm.registerEvents((Listener)new Thresh(), (Plugin)this);
    }
    
    public void onRegisterCommands() {
        this.getCommand("camel").setExecutor((CommandExecutor)new Camel(this));
        this.getCommand("blackout").setExecutor((CommandExecutor)new BlackOut(this));
        this.getCommand("anchor").setExecutor((CommandExecutor)new Anchor(this));
        this.getCommand("checkpoint").setExecutor((CommandExecutor)new CheckPoint());
        this.getCommand("viper").setExecutor((CommandExecutor)new Viper(this));
        this.getCommand("pvp").setExecutor((CommandExecutor)new PvP(this));
        this.getCommand("snail").setExecutor((CommandExecutor)new Snail(this));
        this.getCommand("lobisomen").setExecutor((CommandExecutor)new Lobisomen());
        this.getCommand("cookiemonster").setExecutor((CommandExecutor)new CookieMonster(this));
        this.getCommand("chatclose").setExecutor((CommandExecutor)new ChatMute());
        this.getCommand("trocador").setExecutor((CommandExecutor)new Trocador(this));
        this.getCommand("sniper").setExecutor((CommandExecutor)new Sniper(this));
        this.getCommand("inv").setExecutor((CommandExecutor)new Inv(this));
        this.getCommand("netherman").setExecutor((CommandExecutor)new NetherMan(this));
        this.getCommand("cc").setExecutor((CommandExecutor)new LimparChat());
        this.getCommand("tp").setExecutor((CommandExecutor)new Tp());
        this.getCommand("cactus").setExecutor((CommandExecutor)new Cactus());
        this.getCommand("crash").setExecutor((CommandExecutor)new Crash(this));
        this.getCommand("fireman").setExecutor((CommandExecutor)new Fireman());
        this.getCommand("kits2").setExecutor((CommandExecutor)new Kits2(this));
        this.getCommand("kits").setExecutor((CommandExecutor)new Kits(this));
        this.getCommand("warps").setExecutor((CommandExecutor)new Warps(this));
        this.getCommand("menu").setExecutor((CommandExecutor)new Menu(this));
        this.getCommand("viking").setExecutor((CommandExecutor)new Viking());
        this.getCommand("c4").setExecutor((CommandExecutor)new C4());
        this.getCommand("vis").setExecutor((CommandExecutor)new Invs());
        this.getCommand("invis").setExecutor((CommandExecutor)new Invs());
        this.getCommand("phantom").setExecutor((CommandExecutor)new Phantom());
        this.getCommand("rider").setExecutor((CommandExecutor)new Rider());
        this.getCommand("endermage").setExecutor((CommandExecutor)new Endermage(this));
        this.getCommand("reaper").setExecutor((CommandExecutor)new Reaper());
        this.getCommand("admin").setExecutor((CommandExecutor)new Admin());
        this.getCommand("ban").setExecutor((CommandExecutor)new Ban(this));
        this.getCommand("specialist").setExecutor((CommandExecutor)new Specialist());
        this.getCommand("spiderman").setExecutor((CommandExecutor)new SpiderMan());
        this.getCommand("ryu").setExecutor((CommandExecutor)new Ryu());
        this.getCommand("tower").setExecutor((CommandExecutor)new Tower(this));
        this.getCommand("formulario").setExecutor((CommandExecutor)new Formulario());
        this.getCommand("sonic").setExecutor((CommandExecutor)new Sonic());
        this.getCommand("goku").setExecutor((CommandExecutor)new Goku());
        this.getCommand("unban").setExecutor((CommandExecutor)new Unban());
        this.getCommand("togglepvp").setExecutor((CommandExecutor)new TogglePvP());
        this.getCommand("switcher").setExecutor((CommandExecutor)new Switcher());
        this.getCommand("morf").setExecutor((CommandExecutor)new Morf());
        this.getCommand("check").setExecutor((CommandExecutor)new Check());
        this.getCommand("deshfire").setExecutor((CommandExecutor)new DeshFire());
        this.getCommand("fake").setExecutor((CommandExecutor)new Fake());
        this.getCommand("binladem").setExecutor((CommandExecutor)new Binladem());
        this.getCommand("desfake").setExecutor((CommandExecutor)new Fake());
        this.getCommand("clear").setExecutor((CommandExecutor)new Clear(this));
        this.getCommand("fly").setExecutor((CommandExecutor)new Fly(this));
        this.getCommand("tell").setExecutor((CommandExecutor)new Tell(this));
        this.getCommand("skit").setExecutor((CommandExecutor)new Skit());
        this.getCommand("vida").setExecutor((CommandExecutor)new Vidas());
        this.getCommand("head").setExecutor((CommandExecutor)new Head(this));
        this.getCommand("kick").setExecutor((CommandExecutor)new Kick());
        this.getCommand("sopa").setExecutor((CommandExecutor)new NPCSopa());
        this.getCommand("recraft").setExecutor((CommandExecutor)new NPCRecraft());
        this.getCommand("resetkit").setExecutor((CommandExecutor)new ResetKit());
        this.getCommand("hotpotato").setExecutor((CommandExecutor)new HotPotato());
        this.getCommand("kill").setExecutor((CommandExecutor)new Kill());
        this.getCommand("upi").setExecutor((CommandExecutor)new Up(this));
        this.getCommand("forcefield").setExecutor((CommandExecutor)new Forcefield());
        this.getCommand("ghoul").setExecutor((CommandExecutor)new Ghoul());
        this.getCommand("hulk").setExecutor((CommandExecutor)new Hulk());
        this.getCommand("launcher").setExecutor((CommandExecutor)new Launcher());
        this.getCommand("grappler").setExecutor((CommandExecutor)new Grappler());
        this.getCommand("milkman").setExecutor((CommandExecutor)new Milkman());
        this.getCommand("efeito1").setExecutor((CommandExecutor)new Flame());
        this.getCommand("efeito2").setExecutor((CommandExecutor)new EnderSignal());
        this.getCommand("efeito3").setExecutor((CommandExecutor)new Smoke());
        this.getCommand("efeito4").setExecutor((CommandExecutor)new RedstoneBlock());
        this.getCommand("efeito5").setExecutor((CommandExecutor)new DiamondBlock());
        this.getCommand("efeito6").setExecutor((CommandExecutor)new Water());
        this.getCommand("efeito7").setExecutor((CommandExecutor)new Potion());
        this.getCommand("efeito8").setExecutor((CommandExecutor)new Rainbow());
        this.getCommand("efeitos").setExecutor((CommandExecutor)new Selector(this));
        this.getCommand("removerefeito").setExecutor((CommandExecutor)new RemoverEfeito());
        this.getCommand("fisherman").setExecutor((CommandExecutor)new Fisherman());
        this.getCommand("wither").setExecutor((CommandExecutor)new Wither());
        this.getCommand("ironman").setExecutor((CommandExecutor)new IronMan());
        this.getCommand("report").setExecutor((CommandExecutor)new Report(this));
        this.getCommand("surprise").setExecutor((CommandExecutor)new Surprise());
        this.getCommand("help").setExecutor((CommandExecutor)new Info());
        this.getCommand("backpacker").setExecutor((CommandExecutor)new Backpacker());
        this.getCommand("infernor").setExecutor((CommandExecutor)new Infernor());
        this.getCommand("ebola").setExecutor((CommandExecutor)new Ebola());
        this.getCommand("flash").setExecutor((CommandExecutor)new Flash());
        this.getCommand("creditos").setExecutor((CommandExecutor)new Creditos(this));
        this.getCommand("leopardo").setExecutor((CommandExecutor)new Leopardo());
        this.getCommand("gm").setExecutor((CommandExecutor)new Gm());
        this.getCommand("youtuber").setExecutor((CommandExecutor)new Youtuber(this));
        this.getCommand("grenadier").setExecutor((CommandExecutor)new Grenadier());
        this.getCommand("req").setExecutor((CommandExecutor)new YtAPI(this));
        this.getCommand("ninja").setExecutor((CommandExecutor)new Ninja());
        this.getCommand("resouper").setExecutor((CommandExecutor)new Resouper());
        this.getCommand("grandpa").setExecutor((CommandExecutor)new Grandpa(this));
        this.getCommand("thor").setExecutor((CommandExecutor)new Thor(this));
        this.getCommand("kangaroo").setExecutor((CommandExecutor)new Kangaroo(this));
        this.getCommand("stomper").setExecutor((CommandExecutor)new Stomper(this));
        this.getCommand("rain").setExecutor((CommandExecutor)new Rain(this));
        this.getCommand("bc").setExecutor((CommandExecutor)new BroadCast(this));
        this.getCommand("barbarian").setExecutor((CommandExecutor)new Barbarian());
        this.getCommand("critical").setExecutor((CommandExecutor)new Critical());
        this.getCommand("poseidon").setExecutor((CommandExecutor)new Poseidon(this));
        this.getCommand("fujao").setExecutor((CommandExecutor)new Fujao(this));
        this.getCommand("tag").setExecutor((CommandExecutor)new Tag());
        this.getCommand("frosty").setExecutor((CommandExecutor)new Frosty(this));
        this.getCommand("indio").setExecutor((CommandExecutor)new Indio(this));
        this.getCommand("urgal").setExecutor((CommandExecutor)new Urgal(this));
        this.getCommand("titan").setExecutor((CommandExecutor)new Titan());
        this.getCommand("suicide").setExecutor((CommandExecutor)new Suicide());
        this.getCommand("build").setExecutor((CommandExecutor)new Build());
        this.getCommand("tpall").setExecutor((CommandExecutor)new Tpall(this));
        this.getCommand("nofall").setExecutor((CommandExecutor)new NoFall());
        this.getCommand("monk").setExecutor((CommandExecutor)new Monk());
        this.getCommand("gladiator").setExecutor((CommandExecutor)new Gladiator(this));
        this.getCommand("thresh").setExecutor((CommandExecutor)new Thresh());
        this.getCommand("tempo").setExecutor((CommandExecutor)new Tempo());
    }
    
    public static WorldGuardPlugin getWorldGuard() {
        final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }
        return (WorldGuardPlugin)plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sMeta = sopa.getItemMeta();
        sMeta.setDisplayName("§6Sopa");
        sopa.setItemMeta(sMeta);
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o pode usa admin!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("setrdm")) {
            if (!p.hasPermission("set.warps")) {
                sender.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            this.getConfig().set("RdmWorld", (Object)p.getLocation().getWorld().getName());
            this.getConfig().set("RdmX", (Object)p.getLocation().getX());
            this.getConfig().set("RdmY", (Object)p.getLocation().getY());
            this.getConfig().set("RdmZ", (Object)p.getLocation().getZ());
            this.saveConfig();
            p.sendMessage("§2ReiDaMesa setado!");
            return true;
        }
        else if (cmd.getName().equalsIgnoreCase("setmdr")) {
            if (!p.hasPermission("set.warps")) {
                sender.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            this.getConfig().set("MdrWorld", (Object)p.getLocation().getWorld().getName());
            this.getConfig().set("MdrX", (Object)p.getLocation().getX());
            this.getConfig().set("MdrY", (Object)p.getLocation().getY());
            this.getConfig().set("MdrZ", (Object)p.getLocation().getZ());
            this.saveConfig();
            p.sendMessage("§2MaeDaRua setado!");
            return true;
        }
        else if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (!p.hasPermission("set.warps")) {
                sender.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            this.getConfig().set("SpawnWorld", (Object)p.getLocation().getWorld().getName());
            this.getConfig().set("SpawnX", (Object)p.getLocation().getX());
            this.getConfig().set("SpawnY", (Object)p.getLocation().getY());
            this.getConfig().set("SpawnZ", (Object)p.getLocation().getZ());
            this.saveConfig();
            final World world = p.getWorld();
            final Location loc = p.getLocation();
            world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
            p.sendMessage("§2Spawn setado!");
            return true;
        }
        else if (cmd.getName().equalsIgnoreCase("setmain")) {
            if (!p.hasPermission("set.warps")) {
                sender.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            this.getConfig().set("MainWorld", (Object)p.getLocation().getWorld().getName());
            this.getConfig().set("MainX", (Object)p.getLocation().getX());
            this.getConfig().set("MainY", (Object)p.getLocation().getY());
            this.getConfig().set("MainZ", (Object)p.getLocation().getZ());
            this.saveConfig();
            final World world = p.getWorld();
            final Location loc = p.getLocation();
            world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
            p.sendMessage("§2Main setado!");
            return true;
        }
        else if (cmd.getName().equalsIgnoreCase("setfps")) {
            if (!p.hasPermission("set.warps")) {
                sender.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            this.getConfig().set("FpsWorld", (Object)p.getLocation().getWorld().getName());
            this.getConfig().set("FpsX", (Object)p.getLocation().getX());
            this.getConfig().set("FpsY", (Object)p.getLocation().getY());
            this.getConfig().set("FpsZ", (Object)p.getLocation().getZ());
            this.saveConfig();
            p.sendMessage("§2Fps setado!");
            return true;
        }
        else {
            if (!cmd.getName().equalsIgnoreCase("setchallenge")) {
                if (cmd.getName().equalsIgnoreCase("main")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
                    p.setHealth(1);
                    final ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
                    final ItemMeta redstonemeta = redstone.getItemMeta();
                    redstonemeta.setDisplayName("§aTeleportando...");
                    redstone.setItemMeta(redstonemeta);
                    p.getInventory().setHelmet(redstone);
                    p.getInventory().clear();
                    p.sendMessage("§aVoc\u00ea sera teleportado em 5 segundos");
                    Main.warping.add(p);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Main.warping.contains(p)) {
                                for (final PotionEffect effect : p.getActivePotionEffects()) {
                                    p.removePotionEffect(effect.getType());
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 0));
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000000, 1));
                                }
                                final World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("MainWorld"));
                                final double x = Main.this.getConfig().getDouble("MainX");
                                final double y = Main.this.getConfig().getDouble("MainY");
                                final double z = Main.this.getConfig().getDouble("MainZ");
                                final PlayerInventory inv = p.getInventory();
                                p.teleport(new Location(w, x, y, z));
                                p.setHealth(20);
                                p.getInventory().clear();
                                p.getInventory().setArmorContents((ItemStack[])null);
                                Arrays.remove(p);
                                Arrays.Used.add(p.getName());
                                Arrays.Used.contains(p.getName());
                                final ItemStack espada = new ItemStack(Material.IRON_SWORD);
                                espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                                final ItemMeta kespada = espada.getItemMeta();
                                kespada.setDisplayName(ChatColor.YELLOW + "Espada");
                                espada.setItemMeta(kespada);
                                inv.setItem(0, espada);
                                final ItemStack helmet = new ItemStack(Material.IRON_HELMET);
                                final ItemMeta khelmet = helmet.getItemMeta();
                                khelmet.setDisplayName(ChatColor.YELLOW + "Capacete");
                                helmet.setItemMeta(khelmet);
                                final ItemStack helmet2 = new ItemStack(Material.IRON_CHESTPLATE);
                                final ItemMeta khelmet2 = helmet2.getItemMeta();
                                khelmet2.setDisplayName(ChatColor.YELLOW + "Peitoral");
                                helmet2.setItemMeta(khelmet2);
                                final ItemStack helmet3 = new ItemStack(Material.IRON_LEGGINGS);
                                final ItemMeta khelmet3 = helmet3.getItemMeta();
                                khelmet3.setDisplayName(ChatColor.YELLOW + "Cal\u00e7a");
                                helmet3.setItemMeta(khelmet3);
                                final ItemStack helmet4 = new ItemStack(Material.IRON_BOOTS);
                                final ItemMeta khelmet4 = helmet4.getItemMeta();
                                khelmet4.setDisplayName(ChatColor.YELLOW + "Bota");
                                helmet4.setItemMeta(khelmet4);
                                p.getInventory().setHelmet(helmet);
                                p.getInventory().setChestplate(helmet2);
                                p.getInventory().setLeggings(helmet3);
                                p.getInventory().setBoots(helmet4);
                                p.getInventory().setItem(0, espada);
                                Arrays.sopa(p);
                                Arrays.Used.contains(p.getName());
                                p.sendMessage("§aVoc\u00ea foi teletransportado para >> §6Main!");
                                Main.warping.remove(p);
                            }
                        }
                    }, 100L);
                }
                if (cmd.getName().equalsIgnoreCase("rdm")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
                    p.setHealth(1);
                    final ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
                    final ItemMeta redstonemeta = redstone.getItemMeta();
                    redstonemeta.setDisplayName("§aTeleportando...");
                    redstone.setItemMeta(redstonemeta);
                    p.getInventory().setHelmet(redstone);
                    p.getInventory().clear();
                    p.sendMessage("§aVoc\u00ea sera teleportado em 5 segundos");
                    Main.warping.add(p);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Main.warping.contains(p)) {
                                for (final PotionEffect effect : p.getActivePotionEffects()) {
                                    p.removePotionEffect(effect.getType());
                                }
                                Arrays.remove(p);
                                Arrays.Used.add(p.getName());
                                Arrays.Used.contains(p.getName());
                                final World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("RdmWorld"));
                                final double x = Main.this.getConfig().getDouble("RdmX");
                                final double y = Main.this.getConfig().getDouble("RdmY");
                                final double z = Main.this.getConfig().getDouble("RdmZ");
                                final PlayerInventory inv = p.getInventory();
                                p.teleport(new Location(w, x, y, z));
                                p.setHealth(20);
                                p.getInventory().clear();
                                p.getInventory().setArmorContents((ItemStack[])null);
                                Arrays.Used.add(p.getName());
                                final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
                                espada.setDurability((short)0);
                                final ItemMeta kespada = espada.getItemMeta();
                                kespada.setDisplayName(ChatColor.YELLOW + "Espada");
                                espada.setItemMeta(kespada);
                                inv.setItem(0, espada);
                                Arrays.sopa(p);
                                p.sendMessage("§aVoc\u00ea foi teletransportado para >> §6Rdm!");
                                Main.warping.remove(p);
                            }
                        }
                    }, 100L);
                }
                if (cmd.getName().equalsIgnoreCase("mdr")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
                    p.setHealth(1);
                    final ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
                    final ItemMeta redstonemeta = redstone.getItemMeta();
                    redstonemeta.setDisplayName("§aTeleportando...");
                    redstone.setItemMeta(redstonemeta);
                    p.getInventory().setHelmet(redstone);
                    p.getInventory().clear();
                    p.sendMessage("§aVoc\u00ea sera teleportado em 5 segundos");
                    Main.warping.add(p);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Main.warping.contains(p)) {
                                for (final PotionEffect effect : p.getActivePotionEffects()) {
                                    p.removePotionEffect(effect.getType());
                                }
                                Arrays.remove(p);
                                Arrays.Used.contains(p.getName());
                                Arrays.Used.add(p.getName());
                                final World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("MdrWorld"));
                                final double x = Main.this.getConfig().getDouble("MdrX");
                                final double y = Main.this.getConfig().getDouble("MdrY");
                                final double z = Main.this.getConfig().getDouble("MdrZ");
                                final PlayerInventory inv = p.getInventory();
                                p.teleport(new Location(w, x, y, z));
                                p.setHealth(20);
                                p.getInventory().clear();
                                p.getInventory().setArmorContents((ItemStack[])null);
                                final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
                                espada.setDurability((short)0);
                                final ItemMeta kespada = espada.getItemMeta();
                                kespada.setDisplayName(ChatColor.YELLOW + "Espada");
                                espada.setItemMeta(kespada);
                                inv.setItem(0, espada);
                                Arrays.sopa(p);
                                p.sendMessage("§aVoc\u00ea foi teletransportado para >> §6Mdr!");
                                Main.warping.remove(p);
                            }
                        }
                    }, 100L);
                }
                if (cmd.getName().equalsIgnoreCase("challenge")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
                    p.setHealth(1);
                    final ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
                    final ItemMeta redstonemeta = redstone.getItemMeta();
                    redstonemeta.setDisplayName("§aTeleportando...");
                    redstone.setItemMeta(redstonemeta);
                    p.getInventory().setHelmet(redstone);
                    p.getInventory().clear();
                    p.sendMessage("§aVoc\u00ea sera teleportado em 5 segundos");
                    Main.warping.add(p);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Main.warping.contains(p)) {
                                for (final PotionEffect effect : p.getActivePotionEffects()) {
                                    p.removePotionEffect(effect.getType());
                                }
                                Arrays.remove(p);
                                Arrays.Used.add(p.getName());
                                Arrays.Used.contains(p.getName());
                                final World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("ChallengeWorld"));
                                final double x = Main.this.getConfig().getDouble("ChallengeX");
                                final double y = Main.this.getConfig().getDouble("ChallengeY");
                                final double z = Main.this.getConfig().getDouble("ChallengeZ");
                                final PlayerInventory inv = p.getInventory();
                                p.teleport(new Location(w, x, y, z));
                                p.setHealth(20);
                                p.getInventory().clear();
                                p.getInventory().setArmorContents((ItemStack[])null);
                                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                                espada.setDurability((short)0);
                                final ItemMeta kespada = espada.getItemMeta();
                                kespada.setDisplayName("§5Espada");
                                espada.setItemMeta(kespada);
                                inv.setItem(0, espada);
                                Arrays.Used.contains(p.getName());
                                Arrays.sopa(p);
                                p.sendMessage("§aVoc\u00ea foi teletransportado para >> §6Lava Challenge!");
                                Main.warping.remove(p);
                            }
                        }
                    }, 100L);
                }
                if (cmd.getName().equalsIgnoreCase("fps")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
                    p.setHealth(1);
                    final ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
                    final ItemMeta redstonemeta = redstone.getItemMeta();
                    redstonemeta.setDisplayName("§aTeleportando...");
                    redstone.setItemMeta(redstonemeta);
                    p.getInventory().setHelmet(redstone);
                    p.getInventory().clear();
                    p.sendMessage("§aVoc\u00ea sera teleportado em 5 segundos");
                    Main.warping.add(p);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Main.warping.contains(p)) {
                                for (final PotionEffect effect : p.getActivePotionEffects()) {
                                    p.removePotionEffect(effect.getType());
                                }
                                Arrays.remove(p);
                                Arrays.Used.add(p.getName());
                                Arrays.Used.contains(p.getName());
                                final World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("FpsWorld"));
                                final double x = Main.this.getConfig().getDouble("FpsX");
                                final double y = Main.this.getConfig().getDouble("FpsY");
                                final double z = Main.this.getConfig().getDouble("FpsZ");
                                final PlayerInventory inv = p.getInventory();
                                p.teleport(new Location(w, x, y, z));
                                p.setHealth(20);
                                p.getInventory().clear();
                                p.getInventory().setArmorContents((ItemStack[])null);
                                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                                espada.setDurability((short)0);
                                espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                                final ItemMeta kespada = espada.getItemMeta();
                                kespada.setDisplayName("§5Espada");
                                espada.setItemMeta(kespada);
                                inv.setItem(0, espada);
                                Arrays.sopa(p);
                                Arrays.Used.add(p.getName());
                                p.sendMessage("§aVoc\u00ea foi teletransportado para >> §6Fps!");
                                Main.warping.remove(p);
                            }
                        }
                    }, 100L);
                }
                if (cmd.getName().equalsIgnoreCase("spawn")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
                    p.setHealth(1);
                    final ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
                    final ItemMeta redstonemeta = redstone.getItemMeta();
                    redstonemeta.setDisplayName("§aTeleportando...");
                    redstone.setItemMeta(redstonemeta);
                    p.getInventory().setHelmet(redstone);
                    p.getInventory().clear();
                    p.sendMessage("§aVoc\u00ea sera teleportado em 5 segundos");
                    Main.warping.add(p);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Main.warping.contains(p)) {
                                p.teleport(p.getWorld().getSpawnLocation());
                                p.setHealth(20);
                                p.getInventory();
                                p.getInventory().clear();
                                for (final PotionEffect effect : p.getActivePotionEffects()) {
                                    p.removePotionEffect(effect.getType());
                                }
                                p.getInventory().setArmorContents((ItemStack[])null);
                                for (final PotionEffect effect : p.getActivePotionEffects()) {
                                    p.removePotionEffect(effect.getType());
                                }
                                p.sendMessage("§7§oVoc\u00ea foi teletransportado para >> §6Spawn!");
                                Main.warping.remove(p);
                                final World world = p.getWorld();
                                final Location loc = new Location(world, -674.0, 92.0, -1143.0);
                                Main.this.tp(p, loc);
                                Arrays.remove(p);
                                p.teleport(p.getWorld().getSpawnLocation());
                                p.sendMessage("§7Bem Vindo Ao " + Strings.NomeServer);
                                final ItemStack kit = new ItemStack(Material.CHEST);
                                final ItemMeta kkit = kit.getItemMeta();
                                kkit.setDisplayName("§f» §6Kits §f«");
                                kit.setItemMeta(kkit);
                                final ItemStack warp = new ItemStack(Material.NAME_TAG);
                                final ItemMeta kwarp = warp.getItemMeta();
                                kwarp.setDisplayName("§f» §6Warps §f«");
                                warp.setItemMeta(kwarp);
                                final ItemStack shop = new ItemStack(Material.PAPER);
                                final ItemMeta kshop = shop.getItemMeta();
                                kshop.setDisplayName("§f» §6Menu §f«");
                                shop.setItemMeta(kshop);
                                final ItemStack buycraft = new ItemStack(Material.EMERALD);
                                final ItemMeta kbuycraft = buycraft.getItemMeta();
                                kbuycraft.setDisplayName("§f» §6Loja §f«");
                                buycraft.setItemMeta(kbuycraft);
                                final ItemStack grade = new ItemStack(Material.VINE);
                                final ItemMeta kgrade = grade.getItemMeta();
                                kgrade.setDisplayName(Strings.NomeServer);
                                grade.setItemMeta(kgrade);
                                p.getInventory().clear();
                                p.getInventory().setArmorContents((ItemStack[])null);
                                p.getInventory().setItem(0, grade);
                                p.getInventory().setItem(1, kit);
                                p.getInventory().setItem(2, grade);
                                p.getInventory().setItem(3, warp);
                                p.getInventory().setItem(4, grade);
                                p.getInventory().setItem(5, shop);
                                p.getInventory().setItem(6, grade);
                                p.getInventory().setItem(7, buycraft);
                                p.getInventory().setItem(8, grade);
                            }
                        }
                    }, 100L);
                }
                return false;
            }
            if (!p.hasPermission("set.warps")) {
                sender.sendMessage(String.valueOf(Strings.NomeServer) + " §e>> §cSem Permiss\u00e3o!");
                return true;
            }
            this.getConfig().set("ChallengeWorld", (Object)p.getLocation().getWorld().getName());
            this.getConfig().set("ChallengeX", (Object)p.getLocation().getX());
            this.getConfig().set("ChallengeY", (Object)p.getLocation().getY());
            this.getConfig().set("ChallengeZ", (Object)p.getLocation().getZ());
            this.saveConfig();
            p.sendMessage("§2Challenge setado!");
            return true;
        }
    }
    
    protected void tp(final Player p, final Location loc) {
    }
}
