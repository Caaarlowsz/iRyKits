package iRyKits;

public class Strings
{
    public static String NomeServer;
    public static String Men1;
    public static String Men2;
    public static String Men3;
    public static String Men4;
    public static String Aviso;
    public static String Resetkit;
    public static String Motd;
    public static String KillMsg;
    public static String SuicideMsg;
    public static String NomeNaoCrashar1;
    public static String NomeNaoCrashar2;
    public static String NomeNaoCrashar3;
    public static String MsgCrashdo;
    public static String MsgSemPermCrash;
    public static String MsgNaoCrashado;
    public static String MsgAntiSpam;
    public static String MsgClear;
    public static String MsgTpall;
    public static String MsgFechandoServer;
    public static String StatusName;
    public static String MsgFormulario;
    public static String NoCommand;
    
    static {
        Strings.NomeServer = Main.getInstance().getConfig().getString("NomeServer").replace("&", "§");
        Strings.Men1 = Main.getInstance().getConfig().getString("MensagemAutomatica1").replace("&", "§");
        Strings.Men2 = Main.getInstance().getConfig().getString("MensagemAutomatica2").replace("&", "§");
        Strings.Men3 = Main.getInstance().getConfig().getString("MensagemAutomatica3").replace("&", "§");
        Strings.Men4 = Main.getInstance().getConfig().getString("MensagemAutomatica4").replace("&", "§");
        Strings.Aviso = Main.getInstance().getConfig().getString("NomeAviso").replace("&", "§");
        Strings.Resetkit = Main.getInstance().getConfig().getString("Resetkit").replace("&", "§");
        Strings.Motd = Main.getInstance().getConfig().getString("Motd").replace("&", "§");
        Strings.KillMsg = Main.getInstance().getConfig().getString("KillMsg").replace("&", "§");
        Strings.SuicideMsg = Main.getInstance().getConfig().getString("SuicideMsg").replace("&", "§");
        Strings.NomeNaoCrashar1 = Main.getInstance().getConfig().getString("NomeNaoCrashar1").replace("&", "§");
        Strings.NomeNaoCrashar2 = Main.getInstance().getConfig().getString("NomeNaoCrashar2").replace("&", "§");
        Strings.NomeNaoCrashar3 = Main.getInstance().getConfig().getString("NomeNaoCrashar3").replace("&", "§");
        Strings.MsgCrashdo = Main.getInstance().getConfig().getString("MsgCrashado").replace("&", "§");
        Strings.MsgSemPermCrash = Main.getInstance().getConfig().getString("MsgSemPermCrash").replace("&", "§");
        Strings.MsgNaoCrashado = Main.getInstance().getConfig().getString("MsgNaoCrashado").replace("&", "§");
        Strings.MsgAntiSpam = Main.getInstance().getConfig().getString("MsgAntiSpam").replace("&", "§");
        Strings.MsgClear = Main.getInstance().getConfig().getString("MsgClear").replace("&", "§");
        Strings.MsgTpall = Main.getInstance().getConfig().getString("MsgTpall").replace("&", "§");
        Strings.MsgFechandoServer = Main.getInstance().getConfig().getString("MsgFechandoServer").replace("&", "§");
        Strings.StatusName = Main.getInstance().getConfig().getString("StatusName").replace("&", "§");
        Strings.MsgFormulario = Main.getInstance().getConfig().getString("MsgFormulario").replace("&", "§");
        Strings.NoCommand = Main.getInstance().getConfig().getString("NoCommand").replace("&", "§");
    }
}
