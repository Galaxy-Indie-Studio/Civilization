package com.bigtallahasee.me.civilization.listeners;

import com.bigtallahasee.me.civilization.Civilization;
import com.bigtallahasee.me.civilization.utils.Logger;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.IOException;
import java.util.List;

public class PlayerJoinEvent implements Listener {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    public void onPlayerjoin (org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!plugin.getEconomy().hasAccount(player)){
            plugin.getEconomy().createPlayerAccount(player);
        }
    }

    public void newPlayerDataFile(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.toString();
        if (!player.hasPlayedBefore() ) {
            plugin.getPlayerData().createSection(name);
            plugin.getPlayerData().createSection("Name: ");
            plugin.getPlayerData().createSection("Age: ");
            plugin.getPlayerData().createSection("Gender: ");
            plugin.getPlayerData().createSection("Height: ");
            plugin.getPlayerData().createSection("Race: ");
            plugin.getPlayerData().createSection("Allegiance: ");
            plugin.getPlayerData().createSection("Personality: ");

            try {
                plugin.getPlayerData().save("playerdata.yml");
            } catch (IOException exception) {
                Logger.log(Logger.LogLevel.ERROR, "IOException has occured!");
                Logger.log(Logger.LogLevel.ERROR, "Check Java : 33");
                Logger.log(Logger.LogLevel.ERROR, "in com.bigtallahasee.me.civilization.listeners.PlayerJoinEvent");
            }
        }
    }
}
