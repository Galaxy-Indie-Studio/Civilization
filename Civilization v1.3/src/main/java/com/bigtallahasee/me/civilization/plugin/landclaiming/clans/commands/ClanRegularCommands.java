package com.bigtallahasee.me.civilization.plugin.landclaiming.clans.commands;

import com.bigtallahasee.me.civilization.Civilization;
import com.bigtallahasee.me.civilization.utils.methodholder.ChatMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClanRegularCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);


    private boolean isInClan = false;

    //Clan info

    private boolean isClansEnabled = plugin.getConfig().getBoolean("Clans-Enabled");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        //int maxClanMembers =plugin.getConfig().getInt("Max-Clan-Members");


        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()) {
            if (command.getName().equals("clan")) {
                if (isClansEnabled) {
                    isClansEnabled = true;
                    if (args[0].equalsIgnoreCase("found")) {
                        if (!isInClan) {
                            ChatMethods.devNoteMethod(player);
                            player.sendMessage(" ");
                            player.sendMessage("You have founded a clan!");
                            isInClan = true;
                        } else {
                            ChatMethods.devNoteMethod(player);
                            player.sendMessage(" ");
                            player.sendMessage("You are already in a clan!");
                            isInClan = true;
                        }

                    }
                    if (args[0].equalsIgnoreCase("invite")) {
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if (target != null) {
                            if (args[1].equalsIgnoreCase(String.valueOf(target))) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have invited them to the clan!");
                            }
                        } else {
                            player.sendMessage("You must enter a real player!");
                        }
                    }
                    if (args[0].equalsIgnoreCase("kick")) {
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if (target != null) {
                            ChatMethods.devNoteMethod(player);

                            player.sendMessage(" ");
                            player.sendMessage("You have kicked that player from your Clan!");
                        } else {
                            player.sendMessage("You must enter a real player!");
                        }
                    }
                    if (args[0].equalsIgnoreCase("disband")) {
                        if (isInClan) {
                            ChatMethods.devNoteMethod(player);
                            isInClan = false;
                            player.sendMessage(" ");
                            player.sendMessage("You have disbanded your clan");
                        } else {
                            ChatMethods.devNoteMethod(player);
                            player.sendMessage(" ");
                            player.sendMessage("You are not in a clan!");
                            isInClan = false;
                        }
                    }
                    if (args[0].equalsIgnoreCase("list")) {
                        ChatMethods.devNoteMethod(player);
                    }
                    if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#    Clan Help                                  #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                        player.sendMessage("/clan start [name]: This will start a clan with the entered name!");
                        player.sendMessage("/clan invite [MCUSERNAME]: This will invite the targeted MC-USER to your clan!");
                        player.sendMessage("/clan disband:  This will disband the clan that you are in!");
                        player.sendMessage("/clan list: This displays a list of all the clans on the server!");
                    }
                }
            } else {
                ChatMethods.devNoteMethod(player);
                player.sendMessage(" ");
                player.sendMessage("Clans are disabled on the server!");
                player.sendMessage("If this is a mistake, Please reach out to your ");
                player.sendMessage("server Admin!");
                isClansEnabled = false;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("found", "disband", "invite", "kick", "list", "help");
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
