package iRyKits.Event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import iRyKits.Main;

public class NoDrop implements Listener {
	public Main plugin;

	public NoDrop(Main main) {
		main = this.plugin;
	}

	@EventHandler
	public void onDrop(final PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.WORKBENCH) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.STICK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.COOKIE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.ENCHANTED_BOOK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.SADDLE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.LEATHER) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.MONSTER_EGG) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.VINE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.CHEST) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.NAME_TAG) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.PAPER) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.EMERALD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BEDROCK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.LEASH) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.IRON_BARDING) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.SLIME_BALL) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.FLOWER_POT_ITEM) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.NETHER_FENCE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.PUMPKIN_SEEDS) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.TNT) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.CACTUS) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.FLINT_AND_STEEL) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BEACON) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.GOLD_BLOCK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.STONE_AXE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.IRON_AXE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_AXE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.POTATO_ITEM) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.MILK_BUCKET) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_TORCH_ON) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BLAZE_POWDER) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.WOOD_BUTTON) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.PORTAL) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.COAL_BLOCK) {
			e.setCancelled(true);
		}
	}
}
