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
package net.jadedmc.jadedlobby.utils;

import net.jadedmc.jadedlobby.JadedLobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * A collection of utilities to help with managing locations.
 */
public class LocationUtils {

    /**
     * Get the spawn Location from the Config
     * @param plugin Instance of the plugin.
     * @return Spawn Location
     */
    public static Location getSpawn(JadedLobbyPlugin plugin) {
        String world = plugin.settingsManager().getConfig().getString("Spawn.World");
        double x = plugin.settingsManager().getConfig().getDouble("Spawn.X");
        double y = plugin.settingsManager().getConfig().getDouble("Spawn.Y");
        double z = plugin.settingsManager().getConfig().getDouble("Spawn.Z");
        float pitch = (float) plugin.settingsManager().getConfig().getDouble("Spawn.Pitch");
        float yaw = (float) plugin.settingsManager().getConfig().getDouble("Spawn.Yaw");

        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

    /**
     * Get if the spawn location has been set.
     * @param plugin Instance of the plugin.
     * @return Whether a spawn location has been set.
     */
    public static boolean isSpawnSet(JadedLobbyPlugin plugin) {
        return plugin.settingsManager().getConfig().getBoolean("Spawn.Set");
    }

    /**
     * Sets the location of spawn to a given location.
     * @param plugin Instance of the plugin.
     * @param location New location of spawn.
     */
    public static void setSpawn(JadedLobbyPlugin plugin, Location location) {
        plugin.settingsManager().getConfig().set("Spawn.World", location.getWorld().getName());
        plugin.settingsManager().getConfig().set("Spawn.X", location.getX());
        plugin.settingsManager().getConfig().set("Spawn.Y", location.getY());
        plugin.settingsManager().getConfig().set("Spawn.Z", location.getZ());
        plugin.settingsManager().getConfig().set("Spawn.Yaw", location.getYaw());
        plugin.settingsManager().getConfig().set("Spawn.Pitch", location.getPitch());
        plugin.settingsManager().getConfig().set("Spawn.Set", true);

        plugin.settingsManager().reloadConfig();
    }
}
