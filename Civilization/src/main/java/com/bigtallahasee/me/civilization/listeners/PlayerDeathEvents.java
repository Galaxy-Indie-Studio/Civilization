package com.bigtallahasee.me.civilization.listeners;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathEvents implements Listener {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    private String playerDeathMsg = plugin.getConfig().getString("Custom-Player-Death-Msg");

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        event.setDeathMessage(playerDeathMsg);
    }
}
