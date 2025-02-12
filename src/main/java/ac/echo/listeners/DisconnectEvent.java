package ac.echo.listeners;

import ac.echo.Echo;
import ac.echo.profile.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

public class DisconnectEvent implements Listener {
    private void onDisconnect(final Player player) {
        Profile profile = Echo.INSTANCE.getProfileManager().getProfile(player.getUniqueId());

        if (profile.isFrozen()) {
            player.setFlying(false);
            player.setWalkSpeed(0.2F);
            player.setFoodLevel(20);
            player.setSprinting(true);
            player.removePotionEffect(PotionEffectType.JUMP);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onKick(final PlayerKickEvent e) {
        e.setLeaveMessage(null);

        this.onDisconnect(e.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(final PlayerQuitEvent e) {
        e.setQuitMessage(null);

        this.onDisconnect(e.getPlayer());
    }

}
