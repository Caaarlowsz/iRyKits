package iRyKits.List;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Main;

public class Kits implements Listener, CommandExecutor {
	public Kits(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String CommandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kits")) {
			final Inventory kits = Bukkit.createInventory((InventoryHolder) p, 54, "§6§lSeus Kits [§2§l1§6§l]");
			p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
			final ItemStack vidro = new ItemStack(Material.THIN_GLASS);
			final ItemMeta kvidro = vidro.getItemMeta();
			kvidro.setDisplayName("§f-");
			vidro.setItemMeta(kvidro);
			final ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD, 1);
			final ItemMeta kpvp = pvp.getItemMeta();
			kpvp.setDisplayName("§aPvP");
			final ArrayList<String> pvpl = new ArrayList<>();
			pvpl.add("-*-*-*-*-*-*-*-*-*");
			pvpl.add("§7Habilidade: Nenhuma");
			pvpl.add("-*-*-*-*-*-*-*-*-*");
			kpvp.setLore(pvpl);
			pvp.setItemMeta(kpvp);
			final ItemStack snail = new ItemStack(Material.WEB);
			final ItemMeta ksnail = snail.getItemMeta();
			ksnail.setDisplayName("§aSnail");
			final ArrayList<String> snaillo = new ArrayList<>();
			snaillo.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			snaillo.add("§7Habilidade: Deixe os inimigos lento!");
			snaillo.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ksnail.setLore(snaillo);
			snail.setItemMeta(ksnail);
			final ItemStack viper = new ItemStack(Material.SPIDER_EYE);
			final ItemMeta kviper = viper.getItemMeta();
			kviper.setDisplayName("§aViper");
			final ArrayList<String> viperl = new ArrayList<>();
			viperl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			viperl.add("§7Habilidade: Deixe os inimigos com veneno!");
			viperl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kviper.setLore(viperl);
			viper.setItemMeta(kviper);
			final ItemStack cookie = new ItemStack(Material.COOKIE);
			final ItemMeta kcookie = cookie.getItemMeta();
			kcookie.setDisplayName("§aCookieMonster");
			final ArrayList<String> cookiel = new ArrayList<>();
			cookiel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			cookiel.add("§7Habilidade: Ganhe velocidade e regenera\u00e7\u00e3o!");
			cookiel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kcookie.setLore(cookiel);
			cookie.setItemMeta(kcookie);
			final ItemStack camel = new ItemStack(Material.SAND);
			final ItemMeta kcamel = camel.getItemMeta();
			kcamel.setDisplayName("§aCamel");
			final ArrayList<String> camello = new ArrayList<>();
			camello.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			camello.add("§7Habilidade: Na areia tenha velocidade e regenera\u00e7\u00e3o!");
			camello.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kcamel.setLore(camello);
			camel.setItemMeta(kcamel);
			final ItemStack fo = new ItemStack(Material.SNOW_BLOCK);
			final ItemMeta kfo = fo.getItemMeta();
			kfo.setDisplayName("§aFrosty");
			final ArrayList<String> frostyl = new ArrayList<>();
			frostyl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			frostyl.add("§7Habilidade: Na neve tenha velocidade e regenera\u00e7\u00e3o!");
			frostyl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kfo.setLore(frostyl);
			fo.setItemMeta(kfo);
			final ItemStack kangaroo = new ItemStack(Material.FIREWORK);
			final ItemMeta kkangaroo = kangaroo.getItemMeta();
			kkangaroo.setDisplayName("§aKangaroo");
			final ArrayList<String> kgl = new ArrayList<>();
			kgl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kgl.add("§7Habilidade: De boost com firework!");
			kgl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kkangaroo.setLore(kgl);
			kangaroo.setItemMeta(kkangaroo);
			final ItemStack posei = new ItemStack(Material.WATER_BUCKET);
			final ItemMeta kposei = posei.getItemMeta();
			kposei.setDisplayName("§aPoseidon");
			final ArrayList<String> psl = new ArrayList<>();
			psl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			psl.add("§7Habilidade: Tenha velocidade e for\u00e7a na agua!");
			psl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kposei.setLore(psl);
			posei.setItemMeta(kposei);
			final ItemStack stomper = new ItemStack(Material.IRON_BOOTS);
			final ItemMeta kstomper = stomper.getItemMeta();
			kstomper.setDisplayName("§aStomper");
			final ArrayList<String> stl = new ArrayList<>();
			stl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			stl.add("§7Habilidade: Pule em algu\u00e9m e fa\u00e7a estrago!");
			stl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kstomper.setLore(stl);
			stomper.setItemMeta(kstomper);
			final ItemStack anchor = new ItemStack(Material.ANVIL);
			final ItemMeta kanchor = anchor.getItemMeta();
			kanchor.setDisplayName("§aAnchor");
			final ArrayList<String> acl = new ArrayList<>();
			acl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			acl.add("§7Habilidade: N\u00e3o leve knockback!");
			acl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kanchor.setLore(acl);
			anchor.setItemMeta(kanchor);
			final ItemStack blackout = new ItemStack(Material.POTION, 1, (short) 8230);
			final ItemMeta kblackout = blackout.getItemMeta();
			kblackout.setDisplayName("§aBlackOut");
			final ArrayList<String> bol = new ArrayList<>();
			bol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			bol.add("§7Habilidade: Deixe os inimigos cego!");
			bol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kblackout.setLore(bol);
			blackout.setItemMeta(kblackout);
			final ItemStack urgal = new ItemStack(Material.POTION, 1, (short) 41);
			final ItemMeta kurgal = urgal.getItemMeta();
			kurgal.setDisplayName("§aUrgal");
			final ArrayList<String> ugl = new ArrayList<>();
			ugl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ugl.add("§7Habilidade: Seja mais forte contra os inimigos!");
			ugl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kurgal.setLore(ugl);
			urgal.setItemMeta(kurgal);
			final ItemStack grand = new ItemStack(Material.STICK);
			grand.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
			final ItemMeta kgrand = grand.getItemMeta();
			kgrand.setDisplayName("§aGrandpa");
			final ArrayList<String> gpl = new ArrayList<>();
			gpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			gpl.add("§7Habilidade: Taque os inimigos para longe de voc\u00ea!");
			gpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kgrand.setLore(gpl);
			grand.setItemMeta(kgrand);
			final ItemStack trocador = new ItemStack(Material.IRON_CHESTPLATE);
			final ItemMeta ktrocador = trocador.getItemMeta();
			ktrocador.setDisplayName("§aTrocador");
			final ArrayList<String> tcl = new ArrayList<>();
			tcl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			tcl.add("§7Habilidade: Fique full ferro!");
			tcl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ktrocador.setLore(tcl);
			trocador.setItemMeta(ktrocador);
			final ItemStack thor = new ItemStack(Material.WOOD_AXE);
			final ItemMeta kthor = thor.getItemMeta();
			kthor.setDisplayName("§aThor");
			final ArrayList<String> trl = new ArrayList<>();
			trl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			trl.add("§7Habilidade: Provoque raios com seu machado!");
			trl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kthor.setLore(trl);
			thor.setItemMeta(kthor);
			final ItemStack sniper = new ItemStack(Material.IRON_BARDING);
			final ItemMeta ksniper = sniper.getItemMeta();
			ksniper.setDisplayName("§aSniper");
			final ArrayList<String> spl = new ArrayList<>();
			spl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			spl.add("§7Habilidade: Atire como um atirador de elite!");
			spl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ksniper.setLore(spl);
			sniper.setItemMeta(ksniper);
			final ItemStack switcher = new ItemStack(Material.SNOW_BALL);
			final ItemMeta kswitcher = switcher.getItemMeta();
			kswitcher.setDisplayName("§aSwitcher");
			final ArrayList<String> swl = new ArrayList<>();
			swl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			swl.add("§7Habilidade: Troque de lugar!");
			swl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kswitcher.setLore(swl);
			switcher.setItemMeta(kswitcher);
			final ItemStack grappler = new ItemStack(Material.LEASH);
			final ItemMeta kgrappler = grappler.getItemMeta();
			kgrappler.setDisplayName("§aGrappler");
			final ArrayList<String> grl = new ArrayList<>();
			grl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			grl.add("§7Habilidade: Jogue sua corda e seja rapido!");
			grl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kgrappler.setLore(grl);
			grappler.setItemMeta(kgrappler);
			final ItemStack titan = new ItemStack(Material.BEDROCK);
			final ItemMeta ktitan = titan.getItemMeta();
			ktitan.setDisplayName("§aTitan");
			final ArrayList<String> ttl = new ArrayList<>();
			ttl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ttl.add("§7Habilidade: Fique com velocidade IV e regenera\u00e7\u00e3o IV!");
			ttl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ktitan.setLore(ttl);
			titan.setItemMeta(ktitan);
			final ItemStack monk = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta kmonk = monk.getItemMeta();
			kmonk.setDisplayName("§aMonk");
			final ArrayList<String> mkl = new ArrayList<>();
			mkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			mkl.add("§7Habilidade: Monke os itens do os inimigos!");
			mkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kmonk.setLore(mkl);
			monk.setItemMeta(kmonk);
			final ItemStack fuga = new ItemStack(Material.SLIME_BALL);
			final ItemMeta kfuga = fuga.getItemMeta();
			kfuga.setDisplayName("§aFuj\u00e3o");
			final ArrayList<String> fjl = new ArrayList<>();
			fjl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			fjl.add("§7Habilidade: Fuja dos inimigos!");
			fjl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kfuga.setLore(fjl);
			fuga.setItemMeta(kfuga);
			final ItemStack indio = new ItemStack(Material.PUMPKIN_SEEDS);
			final ItemMeta kindio = indio.getItemMeta();
			kindio.setDisplayName("§aIndio");
			final ArrayList<String> indiol = new ArrayList<>();
			indiol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			indiol.add("§7Habilidade: Atire nos inimigos!");
			indiol.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kindio.setLore(indiol);
			indio.setItemMeta(kindio);
			final ItemStack cp = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta kcp = cp.getItemMeta();
			kcp.setDisplayName("§aCheckPoint");
			final ArrayList<String> cpl = new ArrayList<>();
			cpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			cpl.add("§7Habilidade: Teleport com item!");
			cpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kcp.setLore(cpl);
			cp.setItemMeta(kcp);
			final ItemStack rp = new ItemStack(Material.MUSHROOM_SOUP);
			final ItemMeta krp = rp.getItemMeta();
			krp.setDisplayName("§aResouper");
			final ArrayList<String> rpl = new ArrayList<>();
			rpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			rpl.add("§7Habilidade: Ao matar um player seu inv enche de sopa!");
			rpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			krp.setLore(rpl);
			rp.setItemMeta(krp);
			final ItemStack bn = new ItemStack(Material.WOOD_SWORD);
			final ItemMeta kbn = bn.getItemMeta();
			kbn.setDisplayName("§aBarbarian");
			final ArrayList<String> bnl = new ArrayList<>();
			bnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			bnl.add("§7Habilidade: Ao matar um player sua espada aumenta level!");
			bnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kbn.setLore(bnl);
			bn.setItemMeta(kbn);
			final ItemStack fm = new ItemStack(Material.FISHING_ROD);
			final ItemMeta kfm = fm.getItemMeta();
			kfm.setDisplayName("§aFisherman");
			final ArrayList<String> fml = new ArrayList<>();
			fml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			fml.add("§7Habilidade: Puxe um inimigo para perto de voc\u00ea!");
			fml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kfm.setLore(fml);
			fm.setItemMeta(kfm);
			final ItemStack im = new ItemStack(Material.IRON_INGOT);
			final ItemMeta kim = im.getItemMeta();
			kim.setDisplayName("§aIronMan");
			final ArrayList<String> iml = new ArrayList<>();
			iml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			iml.add("§7Habilidade: Ao matar um player voc\u00ea ganha um iron!");
			iml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kim.setLore(iml);
			im.setItemMeta(kim);
			final ItemStack ct = new ItemStack(Material.GOLDEN_APPLE);
			final ItemMeta kct = ct.getItemMeta();
			kct.setDisplayName("§aCritical");
			final ArrayList<String> ctl = new ArrayList<>();
			ctl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ctl.add("§7Habilidade: De criticals nos inimigos!");
			ctl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kct.setLore(ctl);
			ct.setItemMeta(kct);
			final ItemStack sc = new ItemStack(Material.ENCHANTED_BOOK);
			final ItemMeta ksc = sc.getItemMeta();
			ksc.setDisplayName("§aSpecialist");
			final ArrayList<String> scl = new ArrayList<>();
			scl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			scl.add("§7Habilidade: Ao matar um player voc\u00ea ganha um level de xp!");
			scl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ksc.setLore(scl);
			sc.setItemMeta(ksc);
			final ItemStack hk = new ItemStack(Material.SADDLE);
			final ItemMeta khk = hk.getItemMeta();
			khk.setDisplayName("§aHulk");
			final ArrayList<String> hkl = new ArrayList<>();
			hkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			hkl.add("§7Habilidade: Coloque um player na sua cabe\u00e7a!");
			hkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			khk.setLore(hkl);
			hk.setItemMeta(khk);
			final ItemStack nm = new ItemStack(Material.NETHERRACK);
			final ItemMeta knm = nm.getItemMeta();
			knm.setDisplayName("§aNetherMan");
			final ArrayList<String> nml = new ArrayList<>();
			nml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			nml.add("§7Habilidade: No nether tenha velocidade e regenera\u00e7\u00e3o!");
			nml.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			knm.setLore(nml);
			nm.setItemMeta(knm);
			final ItemStack bp = new ItemStack(Material.LEATHER);
			final ItemMeta kbp = bp.getItemMeta();
			kbp.setDisplayName("§aBackpacker");
			final ArrayList<String> bpl = new ArrayList<>();
			bpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			bpl.add("§7Habilidade: Voc\u00ea abri um menu de sopas!");
			bpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kbp.setLore(bpl);
			bp.setItemMeta(kbp);
			final ItemStack nj = new ItemStack(Material.COAL_BLOCK);
			final ItemMeta knj = nj.getItemMeta();
			knj.setDisplayName("§aNinja");
			final ArrayList<String> njl = new ArrayList<>();
			njl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			njl.add("§7Habilidade: Voc\u00ea teletransporta para o player que voc\u00ea hitou!");
			njl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			knj.setLore(njl);
			nj.setItemMeta(knj);
			final ItemStack l = new ItemStack(Material.MONSTER_EGG);
			final ItemMeta kl = l.getItemMeta();
			kl.setDisplayName("§aLobisomen");
			final ArrayList<String> ll = new ArrayList<>();
			ll.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ll.add("§7Habilidade: Spawne lobos perto de voc\u00ea!");
			ll.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kl.setLore(ll);
			l.setItemMeta(kl);
			final ItemStack ln = new ItemStack(Material.SPONGE);
			final ItemMeta kln = ln.getItemMeta();
			kln.setDisplayName("§aLauncher");
			final ArrayList<String> lnl = new ArrayList<>();
			lnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			lnl.add("§7Habilidade: Jogue os inimigos para cima!");
			lnl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kln.setLore(lnl);
			ln.setItemMeta(kln);
			final ItemStack lp = new ItemStack(Material.MOB_SPAWNER);
			final ItemMeta klp = lp.getItemMeta();
			klp.setDisplayName("§aLeopardo");
			final ArrayList<String> lpl = new ArrayList<>();
			lpl.add("-*-*-*-*-*-*-*-*-*-*-*");
			lpl.add("§7Habilidade: Ganhe speed!");
			lpl.add("-*-*-*-*-*-*-*-*-*-*-*");
			klp.setLore(lpl);
			lp.setItemMeta(klp);
			final ItemStack wt = new ItemStack(Material.NETHER_STAR);
			final ItemMeta kwt = wt.getItemMeta();
			kwt.setDisplayName("§aWither");
			final ArrayList<String> wtl = new ArrayList<>();
			wtl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			wtl.add("§7Habilidade: Deixe os inimigos com wither!");
			wtl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kwt.setLore(wtl);
			wt.setItemMeta(kwt);
			final ItemStack ff = new ItemStack(Material.IRON_FENCE);
			final ItemMeta kff = ff.getItemMeta();
			kff.setDisplayName("§aForcefield");
			final ArrayList<String> ffl = new ArrayList<>();
			ffl.add("-*-*-*-*-*-*-*-*-*-*-*");
			ffl.add("§7Habilidade: Ative seu ff!");
			ffl.add("-*-*-*-*-*-*-*-*-*-*-*");
			kff.setLore(ffl);
			ff.setItemMeta(kff);
			final ItemStack cactus = new ItemStack(Material.CACTUS);
			final ItemMeta kcactus = cactus.getItemMeta();
			kcactus.setDisplayName("§aCactus");
			final ArrayList<String> cactusl = new ArrayList<>();
			cactusl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*");
			cactusl.add("§7Habilidade: Retribua seu dano com seu thorns!");
			cactusl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*");
			kcactus.setLore(cactusl);
			cactus.setItemMeta(kcactus);
			final ItemStack grenadier = new ItemStack(Material.FLINT_AND_STEEL);
			final ItemMeta kgrenadier = grenadier.getItemMeta();
			kgrenadier.setDisplayName("§aGrenadier");
			final ArrayList<String> grenadierl = new ArrayList<>();
			grenadierl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			grenadierl.add("§7Habilidade: Jogue granadas!");
			grenadierl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kgrenadier.setLore(grenadierl);
			grenadier.setItemMeta(kgrenadier);
			final ItemStack ryu = new ItemStack(Material.BEACON);
			final ItemMeta kryu = ryu.getItemMeta();
			kryu.setDisplayName("§aRyu");
			final ArrayList<String> ryul = new ArrayList<>();
			ryul.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ryul.add("§7Habilidade: De um hadouken!");
			ryul.add("-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kryu.setLore(ryul);
			ryu.setItemMeta(kryu);
			final ItemStack goku = new ItemStack(Material.GOLD_BLOCK);
			final ItemMeta kgoku = goku.getItemMeta();
			kgoku.setDisplayName("§aGoku");
			final ArrayList<String> gokul = new ArrayList<>();
			gokul.add("-*-*-*-*-*-*-*-*-*-*-*");
			gokul.add("§7Habilidade: Kamehameha!");
			gokul.add("-*-*-*-*-*-*-*-*-*-*-*");
			kgoku.setLore(gokul);
			goku.setItemMeta(kgoku);
			final ItemStack vk = new ItemStack(Material.WOOD_AXE);
			vk.addEnchantment(Enchantment.DURABILITY, 3);
			final ItemMeta kvk = vk.getItemMeta();
			kvk.setDisplayName("§aViking");
			final ArrayList<String> vkl = new ArrayList<>();
			vkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			vkl.add("§7Habilidade: De um dano mais forte!");
			vkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kvk.setLore(vkl);
			vk.setItemMeta(kvk);
			final ItemStack g = new ItemStack(Material.REDSTONE);
			final ItemMeta kg = g.getItemMeta();
			kg.setDisplayName("§aGhoul");
			final ArrayList<String> gl = new ArrayList<>();
			gl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			gl.add("§7Habilidade: Se torne um verdadeiro ghoul!");
			gl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kg.setLore(gl);
			g.setItemMeta(kg);
			final ItemStack re = new ItemStack(Material.WOOD_HOE);
			final ItemMeta kre = re.getItemMeta();
			kre.setDisplayName("§aReaper");
			final ArrayList<String> rel = new ArrayList<>();
			rel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			rel.add("§7Habilidade: Deixe os inimigos com wither IV!");
			rel.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kre.setLore(rel);
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
			final ArrayList<String> ultralore = new ArrayList<>();
			u.setLore(ultralore);
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
		final Player p = (Player) e.getWhoClicked();
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
