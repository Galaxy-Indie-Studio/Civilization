package com.bigtallahasee.me.civilization.commands;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginCommands implements CommandExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);


    private String author = "BigTallahasee";
    private String title = "Civilization ";
    private String version = "1.0 ";

    private String month = "11";
    private String day = "9";
    private String year = "2021";
    private String dateCreated = month + "/" + day + "/" + year;
    
    private String pluginDescription = "This plugin was originally created for Bending Nations, A roleplaying server, based off of Avatar the Last Air Bender and Legends of Korra";
    private String github = "";
    private String discord = "";
    private String spigotPage = "";
    private String devWebsite = "";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission("civilization.*") || player.isOp()){
            if(args[0].equalsIgnoreCase("reload")){
                if(args[1].equalsIgnoreCase("config")){
                    plugin.saveDefaultConfig();
                    plugin.reloadConfig();
                }
                if(args[1].equalsIgnoreCase("player-data")){

                }
                if(args[1].equalsIgnoreCase("kingdom-data")){

                }
                if(args[1].equalsIgnoreCase("clan-data")){

                }
                if(args[1].equalsIgnoreCase("all")){

                }
            }
            if(args[0].equalsIgnoreCase("plugin")){
                if(args[1].equalsIgnoreCase("info")){

                }
                if(args[1].equalsIgnoreCase("support")){

                }
            }
        }




        return false;
    }
}
