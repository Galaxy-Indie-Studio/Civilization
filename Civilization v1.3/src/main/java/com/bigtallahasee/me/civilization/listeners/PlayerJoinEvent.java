package com.bigtallahasee.me.civilization.listeners;

import com.bigtallahasee.me.civilization.Civilization;
import com.bigtallahasee.me.civilization.files.PlayerDataFile;
import com.bigtallahasee.me.civilization.utils.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;
import java.util.List;

public class PlayerJoinEvent implements Listener {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    @EventHandler
    public void onPlayerjoin (org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!plugin.getEconomy().hasAccount(player)){
            plugin.getEconomy().createPlayerAccount(player);
        }
    }

    @EventHandler
    public void newPlayerDataFile(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();

    }
}
