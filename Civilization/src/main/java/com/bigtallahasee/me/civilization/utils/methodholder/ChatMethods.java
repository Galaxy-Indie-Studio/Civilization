package com.bigtallahasee.me.civilization.utils.methodholder;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatMethods {
    Civilization plugin;

    private String serverBountyHunterPermission = plugin.getConfig().getString("Server-Bounty-Hunter-Perm");

    public ChatMethods(Civilization civilization){
        this.plugin = civilization;
    }

    public void devNoteMethod(Player player){
        player.sendMessage("#----------------------------#");
        player.sendMessage("# Dev Note                      #");
        player.sendMessage("#----------------------------#");
        player.sendMessage("This feature is still in development and");
        player.sendMessage("may not do anything or function properly!");
        player.sendMessage("Thank you for you patitence and we will have it available asap!");
    }

    public void bountyHunterRegristrationHeader(){
        Bukkit.broadcast("#--------------------------------#", "civilization");
        Bukkit.broadcast("# Civilization Bounty Hunter Registration      #", "civilization.*");
        Bukkit.broadcast("#--------------------------------#", "civilization");

    }

    public void broadcastBountyHunterRegristration(Player player){
        Bukkit.broadcast(player.getName() + " would like to register their Bounty Hunting Company!", "civilization.*");
        Bukkit.broadcast("Give the player the server Bounty Hunter Permission! (Bounty Hunter Perm: " + serverBountyHunterPermission + ")", "civilization.*");
    }

}
