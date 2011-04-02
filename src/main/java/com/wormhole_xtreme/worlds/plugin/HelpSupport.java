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
package com.wormhole_xtreme.worlds.plugin;

import java.util.logging.Level;

import me.taylorkelly.help.Help;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.wormhole_xtreme.worlds.WormholeXTremeWorlds;

/**
 * The Class PluginUtilities.
 *
 * @author alron
 */
public class HelpSupport 
{
    
    private static final WormholeXTremeWorlds thisPlugin = WormholeXTremeWorlds.getThisPlugin();
    private static final PluginManager pluginManager = WormholeXTremeWorlds.getThisPlugin().getServer().getPluginManager();
    
    public static void enableHelp()
    {
        if (WormholeXTremeWorlds.getHelp() == null)
        {
            final Plugin helpTest = pluginManager.getPlugin("Help");
            if (helpTest != null)
            {
                final String version = helpTest.getDescription().getVersion();
                if (!version.startsWith("0.2"))
                {
                    thisPlugin.prettyLog(Level.WARNING, false, "Not a support version of Help: " + version + " Recommended is: 0.2.x");
                }
                try
                {
                    WormholeXTremeWorlds.setHelp((Help)helpTest);
                    thisPlugin.prettyLog(Level.INFO, false, "Attached to Help version: " + version);
                }
                catch (ClassCastException e)
                {
                    thisPlugin.prettyLog(Level.WARNING, false, "Failed to get cast to Help: " + e.getMessage());
                }
            }
            else
            {
                thisPlugin.prettyLog(Level.INFO, false, "Help plugin is not yet available; there will be no Help integration until it is loaded.");
            }
        }
    }
    
    public static void disableHelp()
    {
        if (WormholeXTremeWorlds.getHelp() != null)
        {
            WormholeXTremeWorlds.setHelp(null);
            thisPlugin.prettyLog(Level.INFO, false, "Detached from Help plugin.");
        }
    }
    
    public static void registerHelpCommands()
    {
        // TODO: Add help commands to register here.
    }
}