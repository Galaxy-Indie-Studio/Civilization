package com.bigtallahasee.me.civilization.plugin.careers.commands;

import com.bigtallahasee.me.civilization.Civilization;
import com.bigtallahasee.me.civilization.utils.methodholder.ChatMethods;
import org.bukkit.Bukkit;
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

public class RegularCareerCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);
    private boolean isCareersEnabled = plugin.getConfig().getBoolean("Careers-Enabled");
    private boolean isTradeRoutesAvailable = true;

    private String serverBountyHunterPermission = plugin.getConfig().getString("Server-Bounty-Hunter-Perm");

    ChatMethods chatMethods;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()) {
                if(command.getName().equals("careers")){
                    if(isCareersEnabled) {
                        if (args[0].equalsIgnoreCase("bounty-hunter")) {
                            if (args[1].equalsIgnoreCase("register")) {
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "Your application to be a bounty hunter has been submitted!");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "Someone will be with you shortly!");

                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#--------------------------------#", "civilization");
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "# Civilization Bounty Hunter Registration       #", "civilization.*");
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#--------------------------------#", "civilization");
                                Bukkit.broadcast(ChatColor.DARK_GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " would like to register their Bounty Hunting Company!", "civilization.*");
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "Give the player the server Bounty Hunter Permission! (Bounty Hunter Perm: " + serverBountyHunterPermission + ")", "civilization.*");
                            }
                            if (args[1].equalsIgnoreCase("report")) {
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#--------------------------------#", serverBountyHunterPermission);
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "# Bounty Hunter Reporting System       #", serverBountyHunterPermission);
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#--------------------------------#", serverBountyHunterPermission);
                                Bukkit.broadcast(ChatColor.DARK_GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has a clue about a outgoint Bounty!", serverBountyHunterPermission);
                            }
                        }
                        if (args[0].equalsIgnoreCase("company")) {
                            if (args[1].equalsIgnoreCase("new")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage(ChatColor.DARK_GREEN + "You have created a new company!");
                            }
                            if (args[1].equalsIgnoreCase("disband")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have disbanded your company!");
                            }
                            if (args[1].equalsIgnoreCase("hire")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have hired that player to your company!");
                            }
                            if (args[1].equalsIgnoreCase("show")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("Company Name: ");
                                player.sendMessage("Company Bank: ");
                                player.sendMessage("Company Trade Partners: ");
                                player.sendMessage("Company Description: ");
                            }
                        }
                        if (args[0].equalsIgnoreCase("smuggler")) {
                            ChatMethods.devNoteMethod(player);

                            player.sendMessage(" ");
                            player.sendMessage("You have become a smuggler!");
                        }
                        if (args[0].equalsIgnoreCase("caravaneer")) {
                            if (args[1].equalsIgnoreCase("join")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have become a caravneer");
                            }
                            if (args[1].equalsIgnoreCase("trade-routes")) {
                                if (isTradeRoutesAvailable) {
                                    ChatMethods.devNoteMethod(player);

                                    player.sendMessage(" ");
                                    player.sendMessage("Available Trade Routes: ");
                                } else {
                                    player.sendMessage("There aren't any Trade Routes that need a caravaneer");
                                }
                            }
                        }
                        if (args[0].equalsIgnoreCase("help")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#    Careers Help                                  #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                            player.sendMessage("/careers bounty-assigner (Sends a ping to staff letting them know youd like to be a Bounty Assigner)");
                            player.sendMessage("/careers company new [name] (Creates a new company with the name created!)");
                            player.sendMessage("/careers company disband (Disbands your current Kingdom!)");
                            player.sendMessage("/careers ");
                        }
                    }else {
                        ChatMethods.devNoteMethod(player);
                        player.sendMessage(" ");
                        player.sendMessage("Careers are disabled on the server!");
                        player.sendMessage("If this is a mistake, Please reach out to your ");
                        player.sendMessage("server Admin!");
                    }
                }
            }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> list = Arrays.asList("bounty-assigner", "company", "smuggler", "caravaneer", "help");
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
