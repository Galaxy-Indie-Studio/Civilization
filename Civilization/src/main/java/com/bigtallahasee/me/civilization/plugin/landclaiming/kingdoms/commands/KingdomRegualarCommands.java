package com.bigtallahasee.me.civilization.plugin.landclaiming.kingdoms.commands;

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

public class KingdomRegualarCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);
    private boolean isKingdomEnabled = plugin.getConfig().getBoolean("Kingdoms-Enabled");
    public boolean isInKingdom = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()){
                if(command.getName().equals("kingdom")) {
                    if (isKingdomEnabled) {
                        isKingdomEnabled = true;
                        if (args[0].equalsIgnoreCase("found")) {
                            if (!isInKingdom) {
                                ChatMethods.devNoteMethod(player);
                                player.sendMessage(" ");
                                player.sendMessage("You have created a new Kingdom!");
                                isInKingdom = true;
                            } else {
                                ChatMethods.devNoteMethod(player);
                                player.sendMessage(" ");
                                player.sendMessage("You are already in a Kingdom!");
                                isInKingdom = true;
                            }
                        }
                        if (args[0].equalsIgnoreCase("disband")) {
                            if (isInKingdom) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have disbanded this Kingdom!");
                                isInKingdom = false;
                            } else {
                                ChatMethods.devNoteMethod(player);
                                player.sendMessage(" ");
                                player.sendMessage("You are not in a Kingdom!");
                                isInKingdom = false;
                            }
                        }
                        if (args[0].equalsIgnoreCase("invite")) {
                            Player target = Bukkit.getPlayerExact(args[1]);
                            if (target != null) {
                                if (args[1].equalsIgnoreCase(String.valueOf(target))) {
                                    ChatMethods.devNoteMethod(player);

                                    player.sendMessage(" ");
                                    player.sendMessage("You have invited that player to your kingdom!");
                                }
                            }
                        }
                        if (args[0].equalsIgnoreCase("kick")) {
                            Player target = Bukkit.getPlayerExact(args[1]);
                            if (target != null) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have kicked that player from your Kingdom!");
                            }
                        }
                        if (args[0].equalsIgnoreCase("bank")) {
                            if (args[1].equalsIgnoreCase("withdraw")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have withdrawn money from the Kingdom Bank!");
                            }
                            if (args[1].equalsIgnoreCase("deposit")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("You have deposited money to the Kingdom Bank!");
                            }
                            if (args[1].equalsIgnoreCase("show")) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(" ");
                                player.sendMessage("Kingdom Name: ");
                                player.sendMessage("Kingdom Bank Balance: ");
                            }
                        }
                        if (args[0].equalsIgnoreCase("show")) {
                            ChatMethods.devNoteMethod(player);

                            player.sendMessage(" ");
                            player.sendMessage("Kingdom Name: ");
                            player.sendMessage("Kingdom Bank Balance: ");
                            player.sendMessage("Kingdom Allies: ");
                            player.sendMessage("Kingdom Enemies: ");
                            player.sendMessage("Kingdom Description: ");
                        }
                        if (args[0].equalsIgnoreCase("list")) {
                            ChatMethods.devNoteMethod(player);
                        }
                        if (args[0].equalsIgnoreCase("help")) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#    Kingdom Help                                  #");
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                            player.sendMessage("/kingdom found [kingdom-name] (Founds a Kingdom with the name you give!)");
                            player.sendMessage("/kingdom disband [kingdom-name] (Disbands a Kingdom with the name you give!)");
                            player.sendMessage("/kingdom bank withdraw [amount] (Withdraws money from the Kingdom Bank and deposits it into the players bank!)");
                            player.sendMessage("/kingdom bank deposit [amount] (Withdraws money from the player and Deposits it into the Kingdom Bank!)");
                            player.sendMessage("/kingdom bank show (Shows your Kingdom's Bank Balance!)");
                            player.sendMessage("/kingdom show (Shows your Kingdom's info!)");
                            player.sendMessage("/kingdom list (Shows all of the Kingdom's that exist on the server!)");
                            player.sendMessage("/kingdom help (Shows all the commands for this portion of the plugin!)");
                        }
                    }else{
                        ChatMethods.devNoteMethod(player);
                        player.sendMessage(" ");
                        player.sendMessage("Kingdoms are disabled on the server!");
                        player.sendMessage("If this is a mistake, Please reach out to your ");
                        player.sendMessage("server Admin!");
                        isKingdomEnabled = false;
                    }
                }
            }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("found", "disband", "bank" ,"invite", "kick", "list", "show", "help");
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
