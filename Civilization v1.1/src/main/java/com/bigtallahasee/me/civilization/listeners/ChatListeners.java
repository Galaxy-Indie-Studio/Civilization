package com.bigtallahasee.me.civilization.listeners;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ChatListeners implements Listener {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    private boolean isClansEnabled = plugin.getConfig().getBoolean("Clans-Enabled");
    private boolean isKingdomsEnabled = plugin.getConfig().getBoolean("Kingdoms-Enabled");
    private boolean isCharEnabled = plugin.getConfig().getBoolean("Character-Card-Enabled");
    private boolean isInteractEnabled = plugin.getConfig().getBoolean("Bounties-Enabled");

    public void OnClanCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();

        if(event.getMessage().equals("/clan") && !isClansEnabled){
            event.setCancelled(true);
        }
    }

    public void OnKingdomCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();

        if(event.getMessage().equals("/kingdom") && !isKingdomsEnabled){
            event.setCancelled(true);
        }
    }

    public void OnCharCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();

        if(event.getMessage().equals("/char") && !isCharEnabled){
            event.setCancelled(true);
        }
    }

    public void OnInteractCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();

        if(event.getMessage().equals("/interact") && !isInteractEnabled){
            event.setCancelled(true);
        }
    }
}
