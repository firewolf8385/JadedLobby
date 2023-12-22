package net.jadedmc.jadedlobby.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        // Exit if the item is null.
        if(event.getItem() == null)
            return;

        // Exit if item meta is null.
        if(event.getItem().getItemMeta() == null)
            return;

        String item = ChatColor.stripColor(event.getItem().getItemMeta().getDisplayName());

        if(item == null) {
            return;
        }

        switch (item) {
            case "Cosmetics" -> {
                player.performCommand("uc menu");
            }
        }
    }
}