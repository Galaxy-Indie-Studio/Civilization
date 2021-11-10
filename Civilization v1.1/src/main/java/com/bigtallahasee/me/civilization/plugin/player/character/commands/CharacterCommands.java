package com.bigtallahasee.me.civilization.plugin.player.character.commands;

import com.bigtallahasee.me.civilization.Civilization;
import com.bigtallahasee.me.civilization.utils.methodholder.ChatMethods;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharacterCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    private String treasonBounty = plugin.getConfig().get("Treason-Bounty").toString();
    private String defaultBountyMsg = " dollar bounty will be placed on your head!";
    private String defaultTreasonMsg = "This is treason, Are you sure you want to continue!" ;

    private boolean isCharacterEnabled = plugin.getConfig().getBoolean("Character-Card-Enabled");

    ChatMethods chatMethods;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()) {
            if (isCharacterEnabled) {
                isCharacterEnabled = true;
                if (command.getName().equals("char")) {
                    if (args[0].equalsIgnoreCase("name")) {
                        if (args[1].equalsIgnoreCase("set")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");

                            player.sendMessage(" ");
                            player.sendMessage("You have changed your name!");
                        }
                    }
                    if (args[0].equalsIgnoreCase("age")) {
                        if (args[1].equalsIgnoreCase("set")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");

                            player.sendMessage(" ");
                            player.sendMessage("You have changed your age!");
                        }
                    }
                    if (args[0].equalsIgnoreCase("gender")) {
                        if (args[1].equalsIgnoreCase("set")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");

                            player.sendMessage(" ");
                            player.sendMessage("You have changed your gender!");
                        }
                    }
                    if (args[0].equalsIgnoreCase("height")) {
                        if (args[1].equalsIgnoreCase("set")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");

                            player.sendMessage(" ");
                            player.sendMessage("You have changed your height!");
                        }
                    }
                    if (args[0].equalsIgnoreCase("race")) {
                        if (args[1].equalsIgnoreCase("set")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");

                            player.sendMessage(" ");
                            player.sendMessage("You have changed your race!");
                        }
                    }
                    if (player.hasPermission("civilization.*") || player.hasPermission("civilization.allegiance") || player.isOp()) {
                        if (args[0].equalsIgnoreCase("allegiance")) {
                            if (args[1].equalsIgnoreCase("set")) {
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");

                                player.sendMessage(" ");
                                player.sendMessage("You have changed your allegiance!");
                            }
                        }
                    } else if (player.hasPermission("civilization.default")) {
                        if (args[0].equalsIgnoreCase("allegiance")) {
                            if (args[1].equalsIgnoreCase("set")) {
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");

                                player.sendMessage(" ");
                                player.sendMessage(defaultTreasonMsg);
                                player.sendMessage("If you proceed, a " + treasonBounty + " " + defaultBountyMsg);
                            }
                        }

                    }
                    if (args[0].equalsIgnoreCase("personality")) {
                        if (args[1].equalsIgnoreCase("set")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");


                            player.sendMessage(" ");
                            player.sendMessage("You have changed your personality!");
                        }
                    }
                }
            }else if (!isCharacterEnabled){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "# Dev Note                             #");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for you patitence and we will have it available asap!");


                player.sendMessage(" ");
                player.sendMessage("Character cards are not enabled");
                player.sendMessage("on this server!");
                player.sendMessage(" ");
                player.sendMessage("If this is a mistake please,");
                player.sendMessage("Contact your server staff.");
                isCharacterEnabled = false;
            }
        }else{
            player.sendMessage("You don't have proper permission to");
            player.sendMessage("execute this command!");
            player.sendMessage("Required Perm (civilization.default)");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("name", "age", "gender", "height", "race", "allegiance", "personality");
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
