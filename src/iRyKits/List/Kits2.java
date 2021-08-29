package iRyKits.List;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import iRyKits.Main;

public class Kits2 implements Listener, CommandExecutor {
	public Kits2(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String CommandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kits2")) {
			final Inventory kits2 = Bukkit.createInventory((InventoryHolder) p, 54, "§6§lSeus Kits [§2§l2§6§l]");
			p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
			final ItemStack vidro = new ItemStack(Material.THIN_GLASS);
			final ItemMeta kvidro = vidro.getItemMeta();
			kvidro.setDisplayName("§f-");
			vidro.setItemMeta(kvidro);
			final ItemStack hp = new ItemStack(Material.POTATO_ITEM);
			final ItemMeta khp = hp.getItemMeta();
			khp.setDisplayName("§aHotPotato");
			final ArrayList<String> hpl = new ArrayList<>();
			hpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			hpl.add("§7Habilidade: Coloque uma tnt na cabe\u00e7a dos inimigos!");
			hpl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			khp.setLore(hpl);
			hp.setItemMeta(khp);
			final ItemStack e = new ItemStack(Material.SKULL_ITEM);
			final ItemMeta ke = e.getItemMeta();
			ke.setDisplayName("§aEbola");
			final ArrayList<String> el = new ArrayList<>();
			el.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			el.add("§7Habilidade: Transmita sua doen\u00e7a!");
			el.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ke.setLore(el);
			e.setItemMeta(ke);
			final ItemStack f = new ItemStack(Material.LAVA_BUCKET);
			final ItemMeta kf = f.getItemMeta();
			kf.setDisplayName("§aFireman");
			final ArrayList<String> fl = new ArrayList<>();
			fl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			fl.add("§7Habilidade: N\u00e3o tome dano para o fogo!");
			fl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kf.setLore(fl);
			f.setItemMeta(kf);
			final ItemStack mk = new ItemStack(Material.MILK_BUCKET);
			final ItemMeta kmk = mk.getItemMeta();
			kmk.setDisplayName("§aMilkman");
			final ArrayList<String> mkl = new ArrayList<>();
			mkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			mkl.add("§7Habilidade: Ganhe resistencia e regenera\u00e7ao!");
			mkl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kmk.setLore(mkl);
			mk.setItemMeta(kmk);
			final ItemStack flash = new ItemStack(Material.REDSTONE_TORCH_ON);
			final ItemMeta kflash = flash.getItemMeta();
			kflash.setDisplayName("§aFlash");
			final ArrayList<String> flashl = new ArrayList<>();
			flashl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			flashl.add("§7Habilidade: Corra rapido como flash!");
			flashl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kflash.setLore(flashl);
			flash.setItemMeta(kflash);
			final ItemStack mf = new ItemStack(Material.BLAZE_POWDER);
			final ItemMeta kmf = mf.getItemMeta();
			kmf.setDisplayName("§aMorf");
			final ArrayList<String> mfl = new ArrayList<>();
			mfl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			mfl.add("§7Habilidade: Morfa e fique invisivel!");
			mfl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kmf.setLore(mfl);
			mf.setItemMeta(kmf);
			final ItemStack su = new ItemStack(Material.NAME_TAG);
			final ItemMeta ksu = su.getItemMeta();
			ksu.setDisplayName("§aSurprise");
			final ArrayList<String> sul = new ArrayList<>();
			sul.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			sul.add("§7Habilidade: Pegue kit aleatorio!");
			sul.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ksu.setLore(sul);
			su.setItemMeta(ksu);
			final ItemStack r = new ItemStack(Material.SADDLE);
			final ItemMeta kr = r.getItemMeta();
			kr.setDisplayName("§aRider");
			final ArrayList<String> rl = new ArrayList<>();
			rl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			rl.add("§7Habilidade: Coloque um cavalo perto de voc\u00ea!");
			rl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kr.setLore(rl);
			r.setItemMeta(kr);
			final ItemStack spi = new ItemStack(Material.STRING);
			final ItemMeta kspi = spi.getItemMeta();
			kspi.setDisplayName("§aSpiderMan");
			final ArrayList<String> spil = new ArrayList<>();
			spil.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			spil.add("§7Habilidade: Taque teias em seu inimigo!");
			spil.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kspi.setLore(spil);
			spi.setItemMeta(kspi);
			final ItemStack ph = new ItemStack(Material.FEATHER);
			final ItemMeta kph = ph.getItemMeta();
			kph.setDisplayName("§aPhantom");
			final ArrayList<String> phl = new ArrayList<>();
			phl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			phl.add("§7Habilidade: Voe como um p\u00e1ssaro!");
			phl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kph.setLore(phl);
			ph.setItemMeta(kph);
			final ItemStack c4 = new ItemStack(Material.WOOD_BUTTON);
			final ItemMeta kc4 = c4.getItemMeta();
			kc4.setDisplayName("§aC4");
			final ArrayList<String> c4l = new ArrayList<>();
			c4l.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			c4l.add("§7Habilidade: Jogue c4 nos inimigo!");
			c4l.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kc4.setLore(c4l);
			c4.setItemMeta(kc4);
			final ItemStack ender = new ItemStack(Material.PORTAL);
			final ItemMeta kender = ender.getItemMeta();
			kender.setDisplayName("§aEndermage");
			final ArrayList<String> enderl = new ArrayList<>();
			enderl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			enderl.add("§7Habilidade: Puxe os inimigos!");
			enderl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kender.setLore(enderl);
			ender.setItemMeta(kender);
			final ItemStack sonic = new ItemStack(Material.LAPIS_BLOCK);
			final ItemMeta ksonic = sonic.getItemMeta();
			ksonic.setDisplayName("§aSonic");
			final ArrayList<String> sonicl = new ArrayList<>();
			sonicl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			sonicl.add("§7Habilidade: Coloque poison nos inimigos!");
			sonicl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ksonic.setLore(sonicl);
			sonic.setItemMeta(ksonic);
			final ItemStack desh = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta kdesh = desh.getItemMeta();
			kdesh.setDisplayName("§aDeshFire");
			final ArrayList<String> deshl = new ArrayList<>();
			deshl.add("-*-*-*-*-*-*-*-*-*-*");
			deshl.add("§7Habilidade: Solte fogo!");
			deshl.add("-*-*-*-*-*-*-*-*-*-*");
			kdesh.setLore(deshl);
			desh.setItemMeta(kdesh);
			final ItemStack infer = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta kinfer = infer.getItemMeta();
			kinfer.setDisplayName("§aInfernor");
			final ArrayList<String> inferl = new ArrayList<>();
			inferl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			inferl.add("§7Habilidade: Crie uma arena de fogo!");
			inferl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kinfer.setLore(inferl);
			infer.setItemMeta(kinfer);
			final ItemStack glad = new ItemStack(Material.IRON_FENCE);
			final ItemMeta kglad = glad.getItemMeta();
			kglad.setDisplayName("§aGladiator");
			final ArrayList<String> gladl = new ArrayList<>();
			gladl.add("-*-*-*-*-*-*-*-*-*-*-*-*");
			gladl.add("§7Habilidade: Crie uma arena!");
			gladl.add("-*-*-*-*-*-*-*-*-*-*-*-*");
			kglad.setLore(gladl);
			glad.setItemMeta(kglad);
			final ItemStack th = new ItemStack(Material.LEASH);
			final ItemMeta kth = th.getItemMeta();
			kth.setDisplayName("§aThresh");
			final ArrayList<String> thl = new ArrayList<>();
			thl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			thl.add("§7Habilidade: Puxe os inimigos e de veneno!");
			thl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kth.setLore(thl);
			th.setItemMeta(kth);
			final ItemStack tw = new ItemStack(Material.DIRT);
			final ItemMeta ktw = tw.getItemMeta();
			ktw.setDisplayName("§aTower");
			final ArrayList<String> twl = new ArrayList<>();
			twl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			twl.add("§7Habilidade: Tenha stomper e endermage!");
			twl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ktw.setLore(twl);
			tw.setItemMeta(ktw);
			final ItemStack binlada = new ItemStack(Material.TNT);
			final ItemMeta kbinlada = binlada.getItemMeta();
			kbinlada.setDisplayName("§aBinladem");
			final ArrayList<String> binladal = new ArrayList<>();
			binladal.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			binladal.add("§7Habilidade: Seja um terrorista!");
			binladal.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			kbinlada.setLore(binladal);
			binlada.setItemMeta(kbinlada);
			final ItemStack rain = new ItemStack(Material.ARROW);
			final ItemMeta krain = rain.getItemMeta();
			krain.setDisplayName("§aRain");
			final ArrayList<String> rainl = new ArrayList<>();
			rainl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			rainl.add("§7Habilidade: Atire flechas nos inimigos!");
			rainl.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			krain.setLore(rainl);
			rain.setItemMeta(krain);
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
			final ItemStack kits3 = new ItemStack(Material.SIGN);
			final ItemMeta k = kits3.getItemMeta();
			k.setDisplayName("§c\u25c4 Voltar");
			kits3.setItemMeta(k);
			final ItemStack Carpet = new ItemStack(Material.SIGN);
			final ItemMeta kCarpet = Carpet.getItemMeta();
			kCarpet.setDisplayName("§a\u25ba Sem Pagina Superior");
			Carpet.setItemMeta(kCarpet);
			kits2.setItem(0, kits3);
			kits2.setItem(1, ultra);
			kits2.setItem(2, escada);
			kits2.setItem(3, ultra);
			kits2.setItem(4, pl);
			kits2.setItem(5, ultra);
			kits2.setItem(6, escada);
			kits2.setItem(7, ultra);
			kits2.setItem(8, Carpet);
			if (p.hasPermission("kit.hotpotato")) {
				kits2.addItem(new ItemStack[] { hp });
			}
			if (p.hasPermission("kit.ebola")) {
				kits2.addItem(new ItemStack[] { e });
			}
			if (p.hasPermission("kit.fireman")) {
				kits2.addItem(new ItemStack[] { f });
			}
			if (p.hasPermission("kit.milkman")) {
				kits2.addItem(new ItemStack[] { mk });
			}
			if (p.hasPermission("kit.flash")) {
				kits2.addItem(new ItemStack[] { flash });
			}
			if (p.hasPermission("kit.morf")) {
				kits2.addItem(new ItemStack[] { mf });
			}
			if (p.hasPermission("kit.surprise")) {
				kits2.addItem(new ItemStack[] { su });
			}
			if (p.hasPermission("kit.rider")) {
				kits2.addItem(new ItemStack[] { r });
			}
			if (p.hasPermission("kit.spiderman")) {
				kits2.addItem(new ItemStack[] { spi });
			}
			if (p.hasPermission("kit.phantom")) {
				kits2.addItem(new ItemStack[] { ph });
			}
			if (p.hasPermission("kit.c4")) {
				kits2.addItem(new ItemStack[] { c4 });
			}
			if (p.hasPermission("kit.endermage")) {
				kits2.addItem(new ItemStack[] { ender });
			}
			if (p.hasPermission("kit.sonic")) {
				kits2.addItem(new ItemStack[] { sonic });
			}
			if (p.hasPermission("kit.deshfire")) {
				kits2.addItem(new ItemStack[] { desh });
			}
			if (p.hasPermission("kit.infernor")) {
				kits2.addItem(new ItemStack[] { infer });
			}
			if (p.hasPermission("kit.gladiator")) {
				kits2.addItem(new ItemStack[] { glad });
			}
			if (p.hasPermission("kit.thresh")) {
				kits2.addItem(new ItemStack[] { th });
			}
			if (p.hasPermission("kit.tower")) {
				kits2.addItem(new ItemStack[] { tw });
			}
			if (p.hasPermission("kit.binladem")) {
				kits2.addItem(new ItemStack[] { binlada });
			}
			if (p.hasPermission("kit.rain")) {
				kits2.addItem(new ItemStack[] { rain });
			}
			for (int x = 0; x < kits2.getSize(); ++x) {
				while (kits2.getItem(x) == null) {
					kits2.setItem(x, vidro);
				}
			}
			p.openInventory(kits2);
		}
		return false;
	}

	@EventHandler
	public void onClickKits(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§6§lSeus Kits [§2§l2§6§l]")) {
			if (e.getCurrentItem() == null) {
				return;
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGhoul")) {
				p.closeInventory();
				p.chat("/ghoul");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHotPotato")) {
				p.closeInventory();
				p.chat("/hotpotato");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEbola")) {
				p.closeInventory();
				p.chat("/ebola");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFireman")) {
				p.closeInventory();
				p.chat("/fireman");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMilkman")) {
				p.closeInventory();
				p.chat("/milkman");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFlash")) {
				p.closeInventory();
				p.chat("/flash");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMorf")) {
				p.closeInventory();
				p.chat("/morf");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSurprise")) {
				p.closeInventory();
				p.chat("/surprise");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMacaco")) {
				p.closeInventory();
				p.chat("/macaco");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRider")) {
				p.closeInventory();
				p.chat("/rider");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpiderMan")) {
				p.closeInventory();
				p.chat("/spiderman");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPhantom")) {
				p.closeInventory();
				p.chat("/phantom");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aC4")) {
				p.closeInventory();
				p.chat("/c4");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEndermage")) {
				p.closeInventory();
				p.chat("/endermage");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSonic")) {
				p.closeInventory();
				p.chat("/sonic");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDeshFire")) {
				p.closeInventory();
				p.chat("/deshfire");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aInfernor")) {
				p.closeInventory();
				p.chat("/infernor");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGladiator")) {
				p.closeInventory();
				p.chat("/gladiator");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aThresh")) {
				p.closeInventory();
				p.chat("/thresh");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTower")) {
				p.closeInventory();
				p.chat("/tower");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aBinladem")) {
				p.closeInventory();
				p.chat("/binladem");
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRain")) {
				p.closeInventory();
				p.chat("/rain");
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c\u25c4 Voltar")) {
				p.closeInventory();
				p.chat("/kits");
			}
		}
	}
}
