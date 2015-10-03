/*package com.gmail.malonnnnn.autoresponse;

import com.gmail.malonnnnn.autoresponse.ExampleTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new ExampleListener(this);
    }
}

class ExampleListener implements Listener {

    private final ExamplePlugin plugin;

    public ExampleListener(ExamplePlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Create the task and schedule to run it once, after 20 ticks
        BukkitTask task = new ExampleTask(this.plugin).runTaskLater(this.plugin, 20);
    }

}
*/