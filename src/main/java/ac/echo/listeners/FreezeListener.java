package ac.echo.listeners;

import ac.echo.Echo;
import ac.echo.profile.Profile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Profile profile = Echo.INSTANCE.getProfileManager().getProfile(event.getPlayer().getUniqueId());
        if (profile.isFrozen()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Profile profile = Echo.INSTANCE.getProfileManager().getProfile(event.getPlayer().getUniqueId());
        if (profile.isFrozen()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            Profile profile = Echo.INSTANCE.getProfileManager().getProfile(p.getUniqueId());
            if (profile.isFrozen()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player p = (Player) event.getDamager();
            Profile profile = Echo.INSTANCE.getProfileManager().getProfile(p.getUniqueId());
            if (profile.isFrozen()) {
                event.setCancelled(true);
            }
        }


    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            Profile profile = Echo.INSTANCE.getProfileManager().getProfile(p.getUniqueId());
            if (profile.isFrozen()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Profile profile = Echo.INSTANCE.getProfileManager().getProfile(event.getPlayer().getUniqueId());
        if (profile.isFrozen()) {
            event.setCancelled(true);
            event.getPlayer().teleport(event.getFrom());
        }
    }

}
