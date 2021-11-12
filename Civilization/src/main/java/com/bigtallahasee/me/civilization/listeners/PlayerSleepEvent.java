package com.bigtallahasee.me.civilization.listeners;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerSleepEvent implements Listener {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    private String sleepMsg = plugin.getConfig().getString("Custom-Bed-Enter-Msg");
    private String wakeupMsg = plugin.getConfig().getString("Custom-Bed-Leave-Msg");

    @EventHandler
    public void onPlayerSleepEvent(PlayerBedEnterEvent e){
        Player player = e.getPlayer();

        player.sendMessage(sleepMsg);
    }

    @EventHandler
    private void onPlayerWakeUpEvent(PlayerBedLeaveEvent e){
        Player player = e.getPlayer();

        player.sendMessage(wakeupMsg);
    }
}
