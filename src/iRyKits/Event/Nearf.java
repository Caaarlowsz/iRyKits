package iRyKits.Event;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.enchantments.*;

public class Nearf implements Listener
{
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (p.getInventory().getChestplate() != null) {
                p.getInventory().getChestplate().setDurability((short)0);
            }
            if (p.getInventory().getBoots() != null) {
                p.getInventory().getBoots().setDurability((short)0);
            }
            if (p.getInventory().getLeggings() != null) {
                p.getInventory().getLeggings().setDurability((short)0);
            }
            if (p.getInventory().getHelmet() != null) {
                p.getInventory().getHelmet().setDurability((short)0);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamageByEntity1(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player d = (Player)e.getDamager();
            if (d.getItemInHand().getType() == Material.DIAMOND_SWORD || d.getItemInHand().getType() == Material.WOOD_SWORD || d.getItemInHand().getType() == Material.STONE_SWORD || d.getItemInHand().getType() == Material.FISHING_ROD || d.getItemInHand().getType() == Material.STONE_AXE || d.getItemInHand().getType() == Material.BOW || d.getItemInHand().getType() == Material.IRON_SWORD || d.getItemInHand().getType() == Material.DIAMOND_AXE) {
                d.getItemInHand().setDurability((short)0);
            }
        }
    }
    
    @EventHandler
    public void NerfsDanos(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            final Player player = (Player)event.getDamager();
            if (event.getDamage() > 1.0) {
                event.setDamage(event.getDamage() - 1.0);
            }
            if (event.getDamager() instanceof Player) {
                if (player.getFallDistance() > 0.0f && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                    final int NewDamage = (int)(event.getDamage() * 1.5) - (int)event.getDamage();
                    if (event.getDamage() > 1.0) {
                        event.setDamage(event.getDamage() - NewDamage);
                    }
                }
                if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                    event.setDamage(1.5);
                }
                if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                    event.setDamage(2.5);
                }
                if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                    event.setDamage(4.0);
                }
                if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                    event.setDamage(5.0);
                }
                if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
                    event.setDamage(event.getDamage() + 1.0);
                }
                if (player.getFallDistance() > 0.0f && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                    if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                    }
                    if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) && !player.isOnGround()) {
                        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                    }
                }
            }
        }
    }
}
