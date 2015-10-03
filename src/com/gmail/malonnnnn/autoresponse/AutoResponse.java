package com.gmail.malonnnnn.autoresponse;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Owner on 10/2/2015.
 */
public class AutoResponse extends JavaPlugin implements Listener {

    static HashMap<String, String> messageMap = new HashMap<>();
    static HashMap<String, Boolean> messageActive = new HashMap<>();

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        StringTokenizer st = new StringTokenizer(msg);
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            if(Bukkit.getPlayer(name) != null)
                if(messageActive.get(name)) {
                    new BukkitRunnable(){
                        @Override
                        public void run() {
                            String message = messageMap.get(name);
                            Bukkit.broadcastMessage(name + " says " + ChatColor.BLUE + message);
                        }
                    }.runTaskLater(this, 20);


                }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setmessage")) {
            if (sender instanceof Player) {
                String name = sender.getName();
                String message = "";
                for (int i = 0; i < args.length; i++)
                    message += args[i] + " ";
                messageMap.put(name, message);
                sender.sendMessage("message set as " + ChatColor.BLUE + message);
                return true;
            }

        }

        if (cmd.getName().equalsIgnoreCase("getmessage")) {
            if (args.length != 1) {
                sender.sendMessage("/getmessage <player>");
                return false;
            }
            String name = args[0];
            String message = messageMap.get(name);
            Bukkit.broadcastMessage(name + " says " + ChatColor.BLUE + message);
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("autorespond")) {
            if (sender instanceof Player)
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("on")) {
                        String name = sender.getName();
                        messageActive.put(name, true);
                    } else if (args[0].equalsIgnoreCase("off")) {
                        String name = sender.getName();
                        messageActive.put(name, false);
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + "ERROR: " + ChatColor.RED + "/autorespond <on|off>");
                        sender.sendMessage("args length " + args.length + args[0]);
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "ERROR: " + ChatColor.RED + "/autorespond <on|off>");
                    sender.sendMessage("args length" + args.length + args[0]);
                    return false;
                }
        }
        return false;
    }
}
