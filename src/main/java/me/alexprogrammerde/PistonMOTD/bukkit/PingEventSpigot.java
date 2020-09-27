package me.alexprogrammerde.PistonMOTD.bukkit;

import me.alexprogrammerde.PistonMOTD.api.PlaceholderUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.List;

public class PingEventSpigot implements Listener {
    PistonMOTDBukkit plugin;

    public PingEventSpigot(PistonMOTDBukkit plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        if (plugin.getConfig().getBoolean("motd.activated")) {
            List<String> list = plugin.getConfig().getStringList("motd.text");
            event.setMotd(PlaceholderUtil.parseText(list.get((int) Math.round(Math.random() * (list.size() - 1)))));
        }

        if (plugin.getConfig().getBoolean("overridemax.activated")) {
            event.setMaxPlayers(plugin.getConfig().getInt("overridemax.value"));
        }
    }
}