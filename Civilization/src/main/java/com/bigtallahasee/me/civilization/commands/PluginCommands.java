package com.bigtallahasee.me.civilization.commands;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginCommands implements CommandExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    ChatMethods chatMethods;

    private String author = "BigTallahasee";
    private String title = "Civilization ";
    private String version = "1.1 ";

    private String month = "11";
    private String day = "9";
    private String year = "2021";
    private String dateCreated = month + "/" + day + "/" + year;

    private String pluginDescription = "This plugin was originally created for Bending Nations, A roleplaying server, based off of Avatar the Last Air Bender and Legends of Korra";
    private String github = "https://github.com/Galaxy-Indie-Studio/Civilization";
    private String discord = "https://discord.gg/39KeWsyUuu";
    private String spigotPage = "";
    private String devWebsite = "https://galaxystudio1.godaddysites.com/";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission("civilization.*") || player.isOp()){
            if(command.getName().equals("civilization")) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (args[1].equalsIgnoreCase("config")) {
                        player.sendMessage("Config reloaded!");
                        plugin.saveDefaultConfig();
                        plugin.reloadConfig();
                    }
                    if (args[1].equalsIgnoreCase("player-data")) {
                        player.sendMessage(ChatColor.GREEN + "Player Data File has been reloaded successfully!");
                        PlayerDataFile.playerDataReload();

                    }
                    if (args[1].equalsIgnoreCase("kingdom-data")) {
                        player.sendMessage(ChatColor.GREEN + "Kingdom Data File has been reloaded successfully!");
                        KingdomDataFile.kingdomDataReload();

                    }
                    if (args[1].equalsIgnoreCase("clan-data")) {
                        player.sendMessage(ChatColor.GREEN + "Clan Data File has been reloaded successfully!");
                        ClanDataFile.clanDataReload();

                    }
                    if (args[1].equalsIgnoreCase("custom-msgs")) {
                        player.sendMessage(ChatColor.GREEN + "Custom Msgs File has been reloaded successfully!");
                        CustomMsgsFile.customMsgsReload();
                    }
                    if (args[1].equalsIgnoreCase("all")) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                        player.sendMessage(ChatColor.RED + "Reloading all data files!!! Please Wait!");
                        plugin.reloadConfig();
                        PlayerDataFile.playerDataReload();
                        KingdomDataFile.kingdomDataReload();
                        ClanDataFile.clanDataReload();
                        CustomMsgsFile.customMsgsReload();
                        player.sendMessage(ChatColor.GREEN + "All Data Files have been reloaded successfully!");
                    }
                }
                if (args[0].equalsIgnoreCase("plugin")) {
                    if (args[1].equalsIgnoreCase("info")) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#    Plugin Info                                #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                        player.sendMessage("Author: " + author);
                        player.sendMessage("Title: " + title);
                        player.sendMessage("Version: " + version);
                        player.sendMessage("Date Created: " + dateCreated);
                        player.sendMessage("Github: " + github);
                        player.sendMessage("Discord: " + discord);
                        player.sendMessage("Dev Website: " + devWebsite);
                        player.sendMessage("Spigot Page: " + spigotPage);
                        player.sendMessage("Description: " + pluginDescription);

                    }
                    if (args[1].equalsIgnoreCase("support")) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#    Support Links                                  #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                        player.sendMessage("If you need support, Reach out on Github or Discord");
                        player.sendMessage("Github: " + github);
                        player.sendMessage("Discord: " + discord);
                    }
                }
            }
        }else{
            player.sendMessage(ChatColor.RED + "You don't have the proper permission to");
            player.sendMessage(ChatColor.RED + "execute this command!");
            player.sendMessage(ChatColor.GREEN + "Required Perm: (civilizations.*)");
        }
        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("reload", "plugin");
        String input = args[0].toLowerCase();

        List<String> completions = null;
        for (String s : list) {
            if (s.startsWith(input)) {
                if (completions == null) {
                    completions = new ArrayList<>();
                }
                completions.add(s);
            }
        }
        if (completions != null) {
            Collections.sort(completions);
            return completions;
        }
        return completions;
    }
}
