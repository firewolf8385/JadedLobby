package net.jadedmc.jadedlobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

public class LobbyJoinEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;

    public LobbyJoinEvent(final Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public @NonNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
