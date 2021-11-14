package com.bigtallahasee.me.civilization.listeners;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

public class PlayerJoinEvent implements Listener {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    public void onPlayerjoin (org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!plugin.getEconomy().hasAccount(player)){
            plugin.getEconomy().createPlayerAccount(player);
        }
    }
}
