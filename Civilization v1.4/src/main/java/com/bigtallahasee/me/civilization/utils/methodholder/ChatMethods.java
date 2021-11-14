package com.bigtallahasee.me.civilization.utils.methodholder;

import com.bigtallahasee.me.civilization.Civilization;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatMethods {
    static Civilization plugin;



    public ChatMethods(Civilization civilization){
        plugin = civilization;
    }

    public static void devNoteMethod(Player player){
        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
        player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                      #");
        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
        player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
        player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
        player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
    }

    public static void bountyHunterRegristrationHeader(){
        Bukkit.broadcast("#--------------------------------#", "civilization");
        Bukkit.broadcast("# Civilization Bounty Hunter Registration      #", "civilization.*");
        Bukkit.broadcast("#--------------------------------#", "civilization");

    }

    public static void broadcastBountyHunterRegristration(Player player){
        String serverBountyHunterPermission = plugin.getConfig().getString("Server-Bounty-Hunter-Perm");
        Bukkit.broadcast(player.getName() + " would like to register their Bounty Hunting Company!", "civilization.*");
        Bukkit.broadcast("Give the player the server Bounty Hunter Permission! (Bounty Hunter Perm: " + serverBountyHunterPermission + ")", "civilization.*");
    }

}
