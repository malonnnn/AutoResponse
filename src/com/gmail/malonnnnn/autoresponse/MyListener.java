/*package com.gmail.malonnnnn.autoresponse;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Owner on 10/2/2015.

class MyListener implements Listener {

    private final AutoResponse plugin;

    public MyListener(AutoResponse plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Create the task and schedule to run it once, after 20 ticks
        BukkitTask task = new ExampleTask(this.plugin).runTaskLater(this.plugin, 20);
    }

}
*/