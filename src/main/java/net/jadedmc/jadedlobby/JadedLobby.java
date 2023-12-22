/*
 * This file is part of JadedLobby, licensed under the MIT License.
 *
 *  Copyright (c) JadedMC
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package net.jadedmc.jadedlobby;

import net.jadedmc.jadedlobby.events.LobbyJoinEvent;
import net.jadedmc.jadedlobby.lobby.LobbyScoreboard;
import net.jadedmc.jadedlobby.utils.LocationUtils;
import net.jadedmc.jadedutils.items.ItemBuilder;
import net.jadedmc.jadedutils.items.SkullBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class JadedLobby {
    private static JadedLobbyPlugin plugin;

    public static void setPlugin(final JadedLobbyPlugin pl) {
        plugin = pl;
    }

    public static void sendToLobby(final Player player) {
        // Reset Player
        player.setMaxHealth(20);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.getActivePotionEffects().forEach(potionEffect -> player.removePotionEffect(potionEffect.getType()));

        player.setExp(0);
        player.setLevel(0);
        player.setGameMode(GameMode.ADVENTURE);
        player.setCollidable(true);

        // Teleport Player
        if(LocationUtils.isSpawnSet(plugin)) {
            player.teleport(LocationUtils.getSpawn(plugin));
        }

        // Lobby flight
        if(player.hasPermission("jadedlobby.fly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
        }
        else {
            player.setAllowFlight(false);
            player.setFlying(false);
        }

        // Scoreboard
        if(plugin.settingsManager().getConfig().getBoolean("Scoreboard.Enabled")) {
            new LobbyScoreboard(plugin, player).addPlayer(player);
        }

        // Give items.
        ItemStack gamesItem = new ItemBuilder(Material.COMPASS)
                .setDisplayName("<green><bold>Games")
                .build();

        ItemStack profileItem = new SkullBuilder(player)
                .asItemBuilder()
                .setDisplayName("<green><bold>Profile")
                .build();

        ItemStack cosmeticsItem = new ItemBuilder(Material.CHEST)
                .setDisplayName("<green><bold>Cosmetics")
                .build();

        ItemStack settings = new ItemBuilder(Material.COMPARATOR)
                .setDisplayName("<green><bold>Settings")
                        .build();

        player.getInventory().clear();
        player.getInventory().setItem(0, gamesItem);
        player.getInventory().setItem(1, profileItem);
        player.getInventory().setItem(2, cosmeticsItem);
        player.getInventory().setItem(8, settings);

        // LobbyJoinEvent
        plugin.getServer().getPluginManager().callEvent(new LobbyJoinEvent(player));
    }
}