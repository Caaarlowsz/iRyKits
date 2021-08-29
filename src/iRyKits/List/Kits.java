package iRyKits.List;

import iRyKits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class Kits implements Listener, CommandExecutor
{
    public Kits(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String CommandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("kits")) {
            final Inventory kits = Bukkit.createInventory((InventoryHolder)p, 54, "§6§lSeus Kits [§2§l1§6§l]");
            p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
            final ItemStack vidro = new ItemStack(Material.THIN_GLASS);
            final ItemMeta kvidro = vidro.getItemMeta();
            kvidro.setDisplayName("§f-");
            vidro.setItemMeta(kvidro);
            final ArrayList pvplore = new ArrayList();
            final ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD, 1);
            final ItemMeta kpvp = pvp.getItemMeta();
            kpvp.setDisplayName("§aPvP");
            final ArrayList pvpl = new ArrayList();
            pvpl.add("-*-*-*-*-*-*-*-*-*");
            pvpl.add("§7Habilidade: Nenhuma");
            pvpl.add("-*-*-*-*-*-*-*-*-*");
            kpvp.setLore((List)pvpl);
            pvp.setItemMeta(kpvp);
            final ArrayList snaillore = new ArrayList();
            final ItemStack snail = new ItemStack(Material.WEB);
            final ItemMeta ksnail = snail.getItemMeta();
            ksnail.setDisplayName("§aSnail");
            final ArrayList snaillo = new ArrayList();
            snaillo.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            snaillo.add("§7Habilidade: Deixe os inimigos lento!");
            snaillo.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ksnail.setLore((List)snaillo);
            snail.setItemMeta(ksnail);
            final ArrayList viperlore = new ArrayList();
            final ItemStack viper = new ItemStack(Material.SPIDER_EYE);
            final ItemMeta kviper = viper.getItemMeta();
            kviper.setDisplayName("§aViper");
            final ArrayList viperl = new ArrayList();
            viperl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            viperl.add("§7Habilidade: Deixe os inimigos com veneno!");
            viperl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kviper.setLore((List)viperl);
            viper.setItemMeta(kviper);
            final ArrayList cookiemonsterlore = new ArrayList();
            final ItemStack cookie = new ItemStack(Material.COOKIE);
            final ItemMeta kcookie = cookie.getItemMeta();
            kcookie.setDisplayName("§aCookieMonster");
            final ArrayList cookiel = new ArrayList();
            cookiel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            cookiel.add("§7Habilidade: Ganhe velocidade e regenera\u00e7\u00e3o!");
            cookiel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kcookie.setLore((List)cookiel);
            cookie.setItemMeta(kcookie);
            final ArrayList Camellore = new ArrayList();
            final ItemStack camel = new ItemStack(Material.SAND);
            final ItemMeta kcamel = camel.getItemMeta();
            kcamel.setDisplayName("§aCamel");
            final ArrayList camello = new ArrayList();
            camello.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            camello.add("§7Habilidade: Na areia tenha velocidade e regenera\u00e7\u00e3o!");
            camello.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kcamel.setLore((List)camello);
            camel.setItemMeta(kcamel);
            final ArrayList fo\u00e7lore = new ArrayList();
            final ItemStack fo = new ItemStack(Material.SNOW_BLOCK);
            final ItemMeta kfo = fo.getItemMeta();
            kfo.setDisplayName("§aFrosty");
            final ArrayList frostyl = new ArrayList();
            frostyl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            frostyl.add("§7Habilidade: Na neve tenha velocidade e regenera\u00e7\u00e3o!");
            frostyl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kfo.setLore((List)frostyl);
            fo.setItemMeta(kfo);
            final ArrayList kangaroolore = new ArrayList();
            final ItemStack kangaroo = new ItemStack(Material.FIREWORK);
            final ItemMeta kkangaroo = kangaroo.getItemMeta();
            kkangaroo.setDisplayName("§aKangaroo");
            final ArrayList kgl = new ArrayList();
            kgl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kgl.add("§7Habilidade: De boost com firework!");
            kgl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kkangaroo.setLore((List)kgl);
            kangaroo.setItemMeta(kkangaroo);
            final ArrayList poseilore = new ArrayList();
            final ItemStack posei = new ItemStack(Material.WATER_BUCKET);
            final ItemMeta kposei = posei.getItemMeta();
            kposei.setDisplayName("§aPoseidon");
            final ArrayList psl = new ArrayList();
            psl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            psl.add("§7Habilidade: Tenha velocidade e for\u00e7a na agua!");
            psl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kposei.setLore((List)psl);
            posei.setItemMeta(kposei);
            final ArrayList stompe = new ArrayList();
            final ItemStack stomper = new ItemStack(Material.IRON_BOOTS);
            final ItemMeta kstomper = stomper.getItemMeta();
            kstomper.setDisplayName("§aStomper");
            final ArrayList stl = new ArrayList();
            stl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            stl.add("§7Habilidade: Pule em algu\u00e9m e fa\u00e7a estrago!");
            stl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kstomper.setLore((List)stl);
            stomper.setItemMeta(kstomper);
            final ArrayList Anchorlore = new ArrayList();
            final ItemStack anchor = new ItemStack(Material.ANVIL);
            final ItemMeta kanchor = anchor.getItemMeta();
            kanchor.setDisplayName("§aAnchor");
            final ArrayList acl = new ArrayList();
            acl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            acl.add("§7Habilidade: N\u00e3o leve knockback!");
            acl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kanchor.setLore((List)acl);
            anchor.setItemMeta(kanchor);
            final ArrayList blackoutlore = new ArrayList();
            final ItemStack blackout = new ItemStack(Material.POTION, 1, (short)8230);
            final ItemMeta kblackout = blackout.getItemMeta();
            kblackout.setDisplayName("§aBlackOut");
            final ArrayList bol = new ArrayList();
            bol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            bol.add("§7Habilidade: Deixe os inimigos cego!");
            bol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kblackout.setLore((List)bol);
            blackout.setItemMeta(kblackout);
            final ArrayList urgallore = new ArrayList();
            final ItemStack urgal = new ItemStack(Material.POTION, 1, (short)41);
            final ItemMeta kurgal = urgal.getItemMeta();
            kurgal.setDisplayName("§aUrgal");
            final ArrayList ugl = new ArrayList();
            ugl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ugl.add("§7Habilidade: Seja mais forte contra os inimigos!");
            ugl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kurgal.setLore((List)ugl);
            urgal.setItemMeta(kurgal);
            final ArrayList grandlore = new ArrayList();
            final ItemStack grand = new ItemStack(Material.STICK);
            grand.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
            final ItemMeta kgrand = grand.getItemMeta();
            kgrand.setDisplayName("§aGrandpa");
            final ArrayList gpl = new ArrayList();
            gpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            gpl.add("§7Habilidade: Taque os inimigos para longe de voc\u00ea!");
            gpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kgrand.setLore((List)gpl);
            grand.setItemMeta(kgrand);
            final ArrayList trocadorlore = new ArrayList();
            final ItemStack trocador = new ItemStack(Material.IRON_CHESTPLATE);
            final ItemMeta ktrocador = trocador.getItemMeta();
            ktrocador.setDisplayName("§aTrocador");
            final ArrayList tcl = new ArrayList();
            tcl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            tcl.add("§7Habilidade: Fique full ferro!");
            tcl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ktrocador.setLore((List)tcl);
            trocador.setItemMeta(ktrocador);
            final ArrayList thorlore = new ArrayList();
            final ItemStack thor = new ItemStack(Material.WOOD_AXE);
            final ItemMeta kthor = thor.getItemMeta();
            kthor.setDisplayName("§aThor");
            final ArrayList trl = new ArrayList();
            trl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            trl.add("§7Habilidade: Provoque raios com seu machado!");
            trl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kthor.setLore((List)trl);
            thor.setItemMeta(kthor);
            final ArrayList sniperlore = new ArrayList();
            final ItemStack sniper = new ItemStack(Material.IRON_BARDING);
            final ItemMeta ksniper = sniper.getItemMeta();
            ksniper.setDisplayName("§aSniper");
            final ArrayList spl = new ArrayList();
            spl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            spl.add("§7Habilidade: Atire como um atirador de elite!");
            spl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ksniper.setLore((List)spl);
            sniper.setItemMeta(ksniper);
            final ArrayList switcherlore = new ArrayList();
            final ItemStack switcher = new ItemStack(Material.SNOW_BALL);
            final ItemMeta kswitcher = switcher.getItemMeta();
            kswitcher.setDisplayName("§aSwitcher");
            final ArrayList swl = new ArrayList();
            swl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            swl.add("§7Habilidade: Troque de lugar!");
            swl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kswitcher.setLore((List)swl);
            switcher.setItemMeta(kswitcher);
            final ArrayList grapplerlore = new ArrayList();
            final ItemStack grappler = new ItemStack(Material.LEASH);
            final ItemMeta kgrappler = grappler.getItemMeta();
            kgrappler.setDisplayName("§aGrappler");
            final ArrayList grl = new ArrayList();
            grl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            grl.add("§7Habilidade: Jogue sua corda e seja rapido!");
            grl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kgrappler.setLore((List)grl);
            grappler.setItemMeta(kgrappler);
            final ArrayList titanlore = new ArrayList();
            final ItemStack titan = new ItemStack(Material.BEDROCK);
            final ItemMeta ktitan = titan.getItemMeta();
            ktitan.setDisplayName("§aTitan");
            final ArrayList ttl = new ArrayList();
            ttl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ttl.add("§7Habilidade: Fique com velocidade IV e regenera\u00e7\u00e3o IV!");
            ttl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ktitan.setLore((List)ttl);
            titan.setItemMeta(ktitan);
            final ArrayList monklore = new ArrayList();
            final ItemStack monk = new ItemStack(Material.BLAZE_ROD);
            final ItemMeta kmonk = monk.getItemMeta();
            kmonk.setDisplayName("§aMonk");
            final ArrayList mkl = new ArrayList();
            mkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            mkl.add("§7Habilidade: Monke os itens do os inimigos!");
            mkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kmonk.setLore((List)mkl);
            monk.setItemMeta(kmonk);
            final ArrayList fugalore = new ArrayList();
            final ItemStack fuga = new ItemStack(Material.SLIME_BALL);
            final ItemMeta kfuga = fuga.getItemMeta();
            kfuga.setDisplayName("§aFuj\u00e3o");
            final ArrayList fjl = new ArrayList();
            fjl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            fjl.add("§7Habilidade: Fuja dos inimigos!");
            fjl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kfuga.setLore((List)fjl);
            fuga.setItemMeta(kfuga);
            final ArrayList indiolore = new ArrayList();
            final ItemStack indio = new ItemStack(Material.PUMPKIN_SEEDS);
            final ItemMeta kindio = indio.getItemMeta();
            kindio.setDisplayName("§aIndio");
            final ArrayList indiol = new ArrayList();
            indiol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            indiol.add("§7Habilidade: Atire nos inimigos!");
            indiol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kindio.setLore((List)indiol);
            indio.setItemMeta(kindio);
            final ArrayList cplore = new ArrayList();
            final ItemStack cp = new ItemStack(Material.NETHER_FENCE);
            final ItemMeta kcp = cp.getItemMeta();
            kcp.setDisplayName("§aCheckPoint");
            final ArrayList cpl = new ArrayList();
            cpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            cpl.add("§7Habilidade: Teleport com item!");
            cpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kcp.setLore((List)cpl);
            cp.setItemMeta(kcp);
            final ArrayList rplore = new ArrayList();
            final ItemStack rp = new ItemStack(Material.MUSHROOM_SOUP);
            final ItemMeta krp = rp.getItemMeta();
            krp.setDisplayName("§aResouper");
            final ArrayList rpl = new ArrayList();
            rpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            rpl.add("§7Habilidade: Ao matar um player seu inv enche de sopa!");
            rpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            krp.setLore((List)rpl);
            rp.setItemMeta(krp);
            final ArrayList bnlore = new ArrayList();
            final ItemStack bn = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta kbn = bn.getItemMeta();
            kbn.setDisplayName("§aBarbarian");
            final ArrayList bnl = new ArrayList();
            bnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            bnl.add("§7Habilidade: Ao matar um player sua espada aumenta level!");
            bnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kbn.setLore((List)bnl);
            bn.setItemMeta(kbn);
            final ArrayList fmlore = new ArrayList();
            final ItemStack fm = new ItemStack(Material.FISHING_ROD);
            final ItemMeta kfm = fm.getItemMeta();
            kfm.setDisplayName("§aFisherman");
            final ArrayList fml = new ArrayList();
            fml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            fml.add("§7Habilidade: Puxe um inimigo para perto de voc\u00ea!");
            fml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kfm.setLore((List)fml);
            fm.setItemMeta(kfm);
            final ArrayList imlore = new ArrayList();
            final ItemStack im = new ItemStack(Material.IRON_INGOT);
            final ItemMeta kim = im.getItemMeta();
            kim.setDisplayName("§aIronMan");
            final ArrayList iml = new ArrayList();
            iml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            iml.add("§7Habilidade: Ao matar um player voc\u00ea ganha um iron!");
            iml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kim.setLore((List)iml);
            im.setItemMeta(kim);
            final ArrayList ctlore = new ArrayList();
            final ItemStack ct = new ItemStack(Material.GOLDEN_APPLE);
            final ItemMeta kct = ct.getItemMeta();
            kct.setDisplayName("§aCritical");
            final ArrayList ctl = new ArrayList();
            ctl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ctl.add("§7Habilidade: De criticals nos inimigos!");
            ctl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kct.setLore((List)ctl);
            ct.setItemMeta(kct);
            final ArrayList sclore = new ArrayList();
            final ItemStack sc = new ItemStack(Material.ENCHANTED_BOOK);
            final ItemMeta ksc = sc.getItemMeta();
            ksc.setDisplayName("§aSpecialist");
            final ArrayList scl = new ArrayList();
            scl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            scl.add("§7Habilidade: Ao matar um player voc\u00ea ganha um level de xp!");
            scl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ksc.setLore((List)scl);
            sc.setItemMeta(ksc);
            final ArrayList hklore = new ArrayList();
            final ItemStack hk = new ItemStack(Material.SADDLE);
            final ItemMeta khk = hk.getItemMeta();
            khk.setDisplayName("§aHulk");
            final ArrayList hkl = new ArrayList();
            hkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            hkl.add("§7Habilidade: Coloque um player na sua cabe\u00e7a!");
            hkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            khk.setLore((List)hkl);
            hk.setItemMeta(khk);
            final ArrayList nmlore = new ArrayList();
            final ItemStack nm = new ItemStack(Material.NETHERRACK);
            final ItemMeta knm = nm.getItemMeta();
            knm.setDisplayName("§aNetherMan");
            final ArrayList nml = new ArrayList();
            nml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            nml.add("§7Habilidade: No nether tenha velocidade e regenera\u00e7\u00e3o!");
            nml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            knm.setLore((List)nml);
            nm.setItemMeta(knm);
            final ArrayList bplore = new ArrayList();
            final ItemStack bp = new ItemStack(Material.LEATHER);
            final ItemMeta kbp = bp.getItemMeta();
            kbp.setDisplayName("§aBackpacker");
            final ArrayList bpl = new ArrayList();
            bpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            bpl.add("§7Habilidade: Voc\u00ea abri um menu de sopas!");
            bpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kbp.setLore((List)bpl);
            bp.setItemMeta(kbp);
            final ArrayList njlore = new ArrayList();
            final ItemStack nj = new ItemStack(Material.COAL_BLOCK);
            final ItemMeta knj = nj.getItemMeta();
            knj.setDisplayName("§aNinja");
            final ArrayList njl = new ArrayList();
            njl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            njl.add("§7Habilidade: Voc\u00ea teletransporta para o player que voc\u00ea hitou!");
            njl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            knj.setLore((List)njl);
            nj.setItemMeta(knj);
            final ArrayList llore = new ArrayList();
            final ItemStack l = new ItemStack(Material.MONSTER_EGG);
            final ItemMeta kl = l.getItemMeta();
            kl.setDisplayName("§aLobisomen");
            final ArrayList ll = new ArrayList();
            ll.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ll.add("§7Habilidade: Spawne lobos perto de voc\u00ea!");
            ll.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kl.setLore((List)ll);
            l.setItemMeta(kl);
            final ArrayList lnlore = new ArrayList();
            final ItemStack ln = new ItemStack(Material.SPONGE);
            final ItemMeta kln = ln.getItemMeta();
            kln.setDisplayName("§aLauncher");
            final ArrayList lnl = new ArrayList();
            lnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            lnl.add("§7Habilidade: Jogue os inimigos para cima!");
            lnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kln.setLore((List)lnl);
            ln.setItemMeta(kln);
            final ArrayList lplore = new ArrayList();
            final ItemStack lp = new ItemStack(Material.MOB_SPAWNER);
            final ItemMeta klp = lp.getItemMeta();
            klp.setDisplayName("§aLeopardo");
            final ArrayList lpl = new ArrayList();
            lpl.add("-*-*-*-*-*-*-*-*-*-*-*");
            lpl.add("§7Habilidade: Ganhe speed!");
            lpl.add("-*-*-*-*-*-*-*-*-*-*-*");
            klp.setLore((List)lpl);
            lp.setItemMeta(klp);
            final ArrayList wtlore = new ArrayList();
            final ItemStack wt = new ItemStack(Material.NETHER_STAR);
            final ItemMeta kwt = wt.getItemMeta();
            kwt.setDisplayName("§aWither");
            final ArrayList wtl = new ArrayList();
            wtl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            wtl.add("§7Habilidade: Deixe os inimigos com wither!");
            wtl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kwt.setLore((List)wtl);
            wt.setItemMeta(kwt);
            final ArrayList fflore = new ArrayList();
            final ItemStack ff = new ItemStack(Material.IRON_FENCE);
            final ItemMeta kff = ff.getItemMeta();
            kff.setDisplayName("§aForcefield");
            final ArrayList ffl = new ArrayList();
            ffl.add("-*-*-*-*-*-*-*-*-*-*-*");
            ffl.add("§7Habilidade: Ative seu ff!");
            ffl.add("-*-*-*-*-*-*-*-*-*-*-*");
            kff.setLore((List)ffl);
            ff.setItemMeta(kff);
            final ArrayList cactuslore = new ArrayList();
            final ItemStack cactus = new ItemStack(Material.CACTUS);
            final ItemMeta kcactus = cactus.getItemMeta();
            kcactus.setDisplayName("§aCactus");
            final ArrayList cactusl = new ArrayList();
            cactusl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*");
            cactusl.add("§7Habilidade: Retribua seu dano com seu thorns!");
            cactusl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*");
            kcactus.setLore((List)cactusl);
            cactus.setItemMeta(kcactus);
            final ArrayList grenadierlore = new ArrayList();
            final ItemStack grenadier = new ItemStack(Material.FLINT_AND_STEEL);
            final ItemMeta kgrenadier = grenadier.getItemMeta();
            kgrenadier.setDisplayName("§aGrenadier");
            final ArrayList grenadierl = new ArrayList();
            grenadierl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            grenadierl.add("§7Habilidade: Jogue granadas!");
            grenadierl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kgrenadier.setLore((List)grenadierl);
            grenadier.setItemMeta(kgrenadier);
            final ArrayList ryulore = new ArrayList();
            final ItemStack ryu = new ItemStack(Material.BEACON);
            final ItemMeta kryu = ryu.getItemMeta();
            kryu.setDisplayName("§aRyu");
            final ArrayList ryul = new ArrayList();
            ryul.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            ryul.add("§7Habilidade: De um hadouken!");
            ryul.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kryu.setLore((List)ryul);
            ryu.setItemMeta(kryu);
            final ArrayList gokulore = new ArrayList();
            final ItemStack goku = new ItemStack(Material.GOLD_BLOCK);
            final ItemMeta kgoku = goku.getItemMeta();
            kgoku.setDisplayName("§aGoku");
            final ArrayList gokul = new ArrayList();
            gokul.add("-*-*-*-*-*-*-*-*-*-*-*");
            gokul.add("§7Habilidade: Kamehameha!");
            gokul.add("-*-*-*-*-*-*-*-*-*-*-*");
            kgoku.setLore((List)gokul);
            goku.setItemMeta(kgoku);
            final ArrayList vklore = new ArrayList();
            final ItemStack vk = new ItemStack(Material.WOOD_AXE);
            vk.addEnchantment(Enchantment.DURABILITY, 3);
            final ItemMeta kvk = vk.getItemMeta();
            kvk.setDisplayName("§aViking");
            final ArrayList vkl = new ArrayList();
            vkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            vkl.add("§7Habilidade: De um dano mais forte!");
            vkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kvk.setLore((List)vkl);
            vk.setItemMeta(kvk);
            final ArrayList glore = new ArrayList();
            final ItemStack g = new ItemStack(Material.REDSTONE);
            final ItemMeta kg = g.getItemMeta();
            kg.setDisplayName("§aGhoul");
            final ArrayList gl = new ArrayList();
            gl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            gl.add("§7Habilidade: Se torne um verdadeiro ghoul!");
            gl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kg.setLore((List)gl);
            g.setItemMeta(kg);
            final ArrayList relore = new ArrayList();
            final ItemStack re = new ItemStack(Material.WOOD_HOE);
            final ItemMeta kre = re.getItemMeta();
            kre.setDisplayName("§aReaper");
            final ArrayList rel = new ArrayList();
            rel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            rel.add("§7Habilidade: Deixe os inimigos com wither IV!");
            rel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            kre.setLore((List)rel);
            re.setItemMeta(kre);
            final ItemStack pl = new ItemStack(Material.ENDER_PORTAL);
            final ItemMeta kpl = pl.getItemMeta();
            kpl.setDisplayName("§3§lPlugin Feito Por: §c§liRyaaNziN");
            pl.setItemMeta(kpl);
            final ItemStack escada = new ItemStack(Material.VINE);
            final ItemMeta kescada = escada.getItemMeta();
            kescada.setDisplayName("§f-");
            escada.setItemMeta(kescada);
            final ItemStack ultra = new ItemStack(Material.THIN_GLASS);
            final ItemMeta u = ultra.getItemMeta();
            u.setDisplayName("§f-");
            final ArrayList ultralore = new ArrayList();
            u.setLore((List)ultralore);
            ultra.setItemMeta(u);
            final ItemStack kits2 = new ItemStack(Material.SIGN);
            final ItemMeta k2 = kits2.getItemMeta();
            k2.setDisplayName("§a\u25ba Passar");
            kits2.setItemMeta(k2);
            final ItemStack Carpet1 = new ItemStack(Material.SIGN);
            final ItemMeta kCarpet1 = Carpet1.getItemMeta();
            kCarpet1.setDisplayName("§c\u25c4 Sem Pagina Anterior");
            Carpet1.setItemMeta(kCarpet1);
            kits.setItem(0, Carpet1);
            kits.setItem(1, ultra);
            kits.setItem(2, escada);
            kits.setItem(3, ultra);
            kits.setItem(4, pl);
            kits.setItem(5, ultra);
            kits.setItem(6, escada);
            kits.setItem(7, ultra);
            kits.setItem(8, kits2);
            if (p.hasPermission("kit.pvp")) {
                kits.addItem(new ItemStack[] { pvp });
            }
            if (p.hasPermission("kit.kangaroo")) {
                kits.addItem(new ItemStack[] { kangaroo });
            }
            if (p.hasPermission("kit.poseidon")) {
                kits.addItem(new ItemStack[] { posei });
            }
            if (p.hasPermission("kit.frosty")) {
                kits.addItem(new ItemStack[] { fo });
            }
            if (p.hasPermission("kit.camel")) {
                kits.addItem(new ItemStack[] { camel });
            }
            if (p.hasPermission("kit.grandpa")) {
                kits.addItem(new ItemStack[] { grand });
            }
            if (p.hasPermission("kit.stomper")) {
                kits.addItem(new ItemStack[] { stomper });
            }
            if (p.hasPermission("kit.anchor")) {
                kits.addItem(new ItemStack[] { anchor });
            }
            if (p.hasPermission("kit.cookiemonster")) {
                kits.addItem(new ItemStack[] { cookie });
            }
            if (p.hasPermission("kit.blackout")) {
                kits.addItem(new ItemStack[] { blackout });
            }
            if (p.hasPermission("kit.snail")) {
                kits.addItem(new ItemStack[] { snail });
            }
            if (p.hasPermission("kit.viper")) {
                kits.addItem(new ItemStack[] { viper });
            }
            if (p.hasPermission("kit.urgal")) {
                kits.addItem(new ItemStack[] { urgal });
            }
            if (p.hasPermission("kit.trocador")) {
                kits.addItem(new ItemStack[] { trocador });
            }
            if (p.hasPermission("kit.thor")) {
                kits.addItem(new ItemStack[] { thor });
            }
            if (p.hasPermission("kit.sniper")) {
                kits.addItem(new ItemStack[] { sniper });
            }
            if (p.hasPermission("kit.switcher")) {
                kits.addItem(new ItemStack[] { switcher });
            }
            if (p.hasPermission("kit.grappler")) {
                kits.addItem(new ItemStack[] { grappler });
            }
            if (p.hasPermission("kit.titan")) {
                kits.addItem(new ItemStack[] { titan });
            }
            if (p.hasPermission("kit.monk")) {
                kits.addItem(new ItemStack[] { monk });
            }
            if (p.hasPermission("kit.fujao")) {
                kits.addItem(new ItemStack[] { fuga });
            }
            if (p.hasPermission("kit.indio")) {
                kits.addItem(new ItemStack[] { indio });
            }
            if (p.hasPermission("kit.checkpoint")) {
                kits.addItem(new ItemStack[] { cp });
            }
            if (p.hasPermission("kit.resouper")) {
                kits.addItem(new ItemStack[] { rp });
            }
            if (p.hasPermission("kit.barbarian")) {
                kits.addItem(new ItemStack[] { bn });
            }
            if (p.hasPermission("kit.fisherman")) {
                kits.addItem(new ItemStack[] { fm });
            }
            if (p.hasPermission("kit.ironman")) {
                kits.addItem(new ItemStack[] { im });
            }
            if (p.hasPermission("kit.critical")) {
                kits.addItem(new ItemStack[] { ct });
            }
            if (p.hasPermission("kit.specialist")) {
                kits.addItem(new ItemStack[] { sc });
            }
            if (p.hasPermission("kit.hulk")) {
                kits.addItem(new ItemStack[] { hk });
            }
            if (p.hasPermission("kit.netherman")) {
                kits.addItem(new ItemStack[] { nm });
            }
            if (p.hasPermission("kit.backpacker")) {
                kits.addItem(new ItemStack[] { bp });
            }
            if (p.hasPermission("kit.ninja")) {
                kits.addItem(new ItemStack[] { nj });
            }
            if (p.hasPermission("kit.lobisomen")) {
                kits.addItem(new ItemStack[] { l });
            }
            if (p.hasPermission("kit.launcher")) {
                kits.addItem(new ItemStack[] { ln });
            }
            if (p.hasPermission("kit.leopardo")) {
                kits.addItem(new ItemStack[] { lp });
            }
            if (p.hasPermission("kit.wither")) {
                kits.addItem(new ItemStack[] { wt });
            }
            if (p.hasPermission("kit.forcefield")) {
                kits.addItem(new ItemStack[] { ff });
            }
            if (p.hasPermission("kit.cactus")) {
                kits.addItem(new ItemStack[] { cactus });
            }
            if (p.hasPermission("kit.grenadier")) {
                kits.addItem(new ItemStack[] { grenadier });
            }
            if (p.hasPermission("kit.ryu")) {
                kits.addItem(new ItemStack[] { ryu });
            }
            if (p.hasPermission("kit.goku")) {
                kits.addItem(new ItemStack[] { goku });
            }
            if (p.hasPermission("kit.viking")) {
                kits.addItem(new ItemStack[] { vk });
            }
            if (p.hasPermission("kit.ghoul")) {
                kits.addItem(new ItemStack[] { g });
            }
            if (p.hasPermission("kit.reaper")) {
                kits.addItem(new ItemStack[] { re });
            }
            for (int x = 0; x < kits.getSize(); ++x) {
                while (kits.getItem(x) == null) {
                    kits.setItem(x, vidro);
                }
            }
            p.openInventory(kits);
        }
        return false;
    }
    
    @EventHandler
    public void onClickKits(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§6§lSeus Kits [§2§l1§6§l]")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPvP")) {
                p.closeInventory();
                p.chat("/pvp");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aUrgal")) {
                p.closeInventory();
                p.chat("/urgal");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKangaroo")) {
                p.closeInventory();
                p.chat("/kangaroo");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrandpa")) {
                p.closeInventory();
                p.chat("/grandpa");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aViper")) {
                p.closeInventory();
                p.chat("/viper");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSnail")) {
                p.closeInventory();
                p.chat("/snail");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aBlackOut")) {
                p.closeInventory();
                p.chat("/blackout");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCookieMonster")) {
                p.closeInventory();
                p.chat("/cookiemonster");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCamel")) {
                p.closeInventory();
                p.chat("/camel");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFrosty")) {
                p.closeInventory();
                p.chat("/frosty");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPoseidon")) {
                p.closeInventory();
                p.chat("/poseidon");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aStomper")) {
                p.closeInventory();
                p.chat("/stomper");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAnchor")) {
                p.closeInventory();
                p.chat("/anchor");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTrocador")) {
                p.closeInventory();
                p.chat("/trocador");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aThor")) {
                p.closeInventory();
                p.chat("/thor");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSniper")) {
                p.closeInventory();
                p.chat("/sniper");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSwitcher")) {
                p.closeInventory();
                p.chat("/switcher");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrappler")) {
                p.closeInventory();
                p.chat("/grappler");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTitan")) {
                p.closeInventory();
                p.chat("/titan");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMonk")) {
                p.closeInventory();
                p.chat("/monk");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFuj\u00e3o")) {
                p.closeInventory();
                p.chat("/fujao");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aIndio")) {
                p.closeInventory();
                p.chat("/indio");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCheckPoint")) {
                p.closeInventory();
                p.chat("/checkpoint");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aResouper")) {
                p.closeInventory();
                p.chat("/resouper");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aBarbarian")) {
                p.closeInventory();
                p.chat("/barbarian");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFisherman")) {
                p.closeInventory();
                p.chat("/fisherman");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aIronMan")) {
                p.closeInventory();
                p.chat("/ironman");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCritical")) {
                p.closeInventory();
                p.chat("/critical");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpecialist")) {
                p.closeInventory();
                p.chat("/specialist");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHulk")) {
                p.closeInventory();
                p.chat("/hulk");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNetherMan")) {
                p.closeInventory();
                p.chat("/netherman");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aBackpacker")) {
                p.closeInventory();
                p.chat("/backpacker");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNinja")) {
                p.closeInventory();
                p.chat("/ninja");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLobisomen")) {
                p.closeInventory();
                p.chat("/lobisomen");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLauncher")) {
                p.closeInventory();
                p.chat("/launcher");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLeopardo")) {
                p.closeInventory();
                p.chat("/leopardo");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aWither")) {
                p.closeInventory();
                p.chat("/wither");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aForcefield")) {
                p.closeInventory();
                p.chat("/forcefield");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDeshFire")) {
                p.closeInventory();
                p.chat("/deshfire");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCactus")) {
                p.closeInventory();
                p.chat("/cactus");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrenadier")) {
                p.closeInventory();
                p.chat("/grenadier");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRyu")) {
                p.closeInventory();
                p.chat("/ryu");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGoku")) {
                p.closeInventory();
                p.chat("/goku");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aViking")) {
                p.closeInventory();
                p.chat("/viking");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGhoul")) {
                p.closeInventory();
                p.chat("/ghoul");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aReaper")) {
                p.closeInventory();
                p.chat("/reaper");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a\u25ba Passar")) {
                p.closeInventory();
                p.chat("/kits2");
            }
        }
    }
}
