/*
 *   Wormhole X-Treme Worlds Plugin for Bukkit
 *   Copyright (C) 2011  Dean Bailey
 *
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.wormhole_xtreme.worlds.events;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;

import com.wormhole_xtreme.worlds.WormholeXTremeWorlds;


// TODO: Auto-generated Javadoc
/**
 * The Class EventUtilities.
 *
 * @author alron
 */
public class EventUtilities {

    /** The Constant thisPlugin. */
    private static final WormholeXTremeWorlds thisPlugin = WormholeXTremeWorlds.getThisPlugin();
    
    /** The Constant pluginManager. */
    private static final PluginManager pluginManager = thisPlugin.getServer().getPluginManager();
    
    /** The Constant plugin. */
    private static final PluginEnable pluginEnable = new PluginEnable();
    
    private static final PluginDisable pluginDisable = new PluginDisable();
    
    /** The Constant world. */
    private static final WorldLoad worldLoad = new WorldLoad();
    
    private static final WorldSave worldSave = new WorldSave();
    
    /**
     * Register events.
     */
    public static void registerEvents()
    {
        pluginManager.registerEvent(Event.Type.PLUGIN_ENABLE, pluginEnable, Priority.Monitor, thisPlugin);
        pluginManager.registerEvent(Event.Type.PLUGIN_DISABLE, pluginDisable, Priority.Monitor, thisPlugin);
        pluginManager.registerEvent(Event.Type.WORLD_LOAD, worldLoad, Priority.Monitor, thisPlugin);
        pluginManager.registerEvent(Event.Type.WORLD_SAVE, worldSave, Priority.Monitor, thisPlugin);
    }
}