package com.bigtallahasee.me.civilization.plugin.player.character.commands;

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

public class InteractionChatRPCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    //Passive Interactions
    private final String eatMsg = plugin.getConfig().getString("Eat-Msg");
    private final String drinkMsg = plugin.getConfig().getString("Drink-Msg");
    private final String waveMsg = plugin.getConfig().getString("Wave-Msg");
    private final String waveBroadcastMsg = plugin.getConfig().getString("Wave-Broadcast-Msg");
    private final String danceMsg = plugin.getConfig().getString("Dance-Msg");
    private final String danceBroadcastMsg = plugin.getConfig().getString("Dance-Broadcast-Msg");
    private final String shrugBroadcastMsg = plugin.getConfig().getString("Shrug-Broadcast-Msg");
    private final String laughBroadcastMsg = plugin.getConfig().getString("Laugh-Broadcast-Msg");

    //Neutral Interactions
    private final String yellBroadcastMsg = plugin.getConfig().getString("Yell-Broadcast-Msg");
    private final String yellAtBroadcastMsg = plugin.getConfig().getString("Yell-At-Broadcast-Msg");

    //Hostile Interactions
    private final String punchBroadcastMsg = plugin.getConfig().getString("Punch-Broadcast-Msg");
    private final String kickBroadcastMsg = plugin.getConfig().getString("Kick-Broadcast-Msg");
    private final String slapBroadcastMsg = plugin.getConfig().getString("Slap-Broadcast-Msg");

    private boolean isInteractionEnabled = plugin.getConfig().getBoolean("Interactions-Enabled");



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Player target = Bukkit.getPlayerExact(args[2]);
        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()){
            if(command.getName().equals("interact")){
                if(isInteractionEnabled) {
                    if (args[0].equalsIgnoreCase("passive")) {
                        isInteractionEnabled = true;
                        if (args[1].equalsIgnoreCase("eat")) {
                            player.sendMessage(eatMsg);
                        }
                        if (args[1].equalsIgnoreCase("drink")) {
                            player.sendMessage(drinkMsg);
                        }
                        if (args[1].equalsIgnoreCase("wave")) {
                            player.sendMessage(waveMsg);
                            Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + waveBroadcastMsg, "civilization.rp");
                        }
                        if (args[1].equalsIgnoreCase("dance")) {
                            player.sendMessage(ChatColor.AQUA + danceMsg);
                            Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + danceBroadcastMsg, "civilization.rp");
                        }
                        if (args[1].equalsIgnoreCase("shrug")) {
                            Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + shrugBroadcastMsg, "civilization.rp");
                        }
                        if (args[1].equalsIgnoreCase("laugh")) {
                            Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + laughBroadcastMsg, "civilization.rp");
                        }
                    }
                    if(args[0].equalsIgnoreCase("neutral")){
                        if(args[1].equalsIgnoreCase("yell")){
                            Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + yellBroadcastMsg, "civilization.rp");
                        }
                        if(args[1].equalsIgnoreCase("yell")){
                            if(args[2].equalsIgnoreCase(target.getName())){
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + yellAtBroadcastMsg + " " + target.getName(), "civilization.rp");
                            }
                        }
                    }
                    if (args[0].equalsIgnoreCase("hostile")) {
                        if (args[1].equalsIgnoreCase("punch")) {
                            if(args[2].equalsIgnoreCase(target.getName())) {
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + punchBroadcastMsg + " " + target.getName(), "civilization.rp");
                            }
                        }
                        if (args[1].equalsIgnoreCase("kick")) {
                            if (args[2].equalsIgnoreCase(target.getName())) {
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + kickBroadcastMsg + " " + target.getName(), "civilization.rp");
                            }
                        }
                        if (args[1].equalsIgnoreCase("slap")) {
                            if (args[2].equalsIgnoreCase(target.getName())) {
                                Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + slapBroadcastMsg + " " + target.getName(), "civilization.rp");
                            }
                        }
                    }
                }
                }else{
                    ChatMethods.devNoteMethod(player);
                    player.sendMessage(" ");
                    player.sendMessage("Interactions are disabled on the server!");
                    player.sendMessage("If this is a mistake, Please reach out to your ");
                    player.sendMessage("server Admin!");
                    isInteractionEnabled = false;
                }
            }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> result;
        List<String> list = Arrays.asList("eat", "drink", "wave", "dance", "shrug", "laugh", "yell", "punch", "kick", "slap");
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
            result = completions;
        } else {
            result = completions;
        }
        return result;
    }
}
