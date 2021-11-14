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

    private String eatMsg = plugin.getConfig().getString("Eat-Msg");
    private String drinkMsg = plugin.getConfig().getString("Drink-Msg");

    private String waveMsg = plugin.getConfig().getString("Wave-Msg");
    private String waveBroadcastMsg = plugin.getConfig().getString("Wave-Broadcast-Msg");
    private String danceMsg = plugin.getConfig().getString("Dance-Msg");
    private String danceBroadcastMsg = plugin.getConfig().getString("Dance-Broadcast-Msg");

    private boolean isInteractionEnabled = plugin.getConfig().getBoolean("Interactions-Enabled");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()){
            if(command.getName().equals("interact")){
                if(isInteractionEnabled) {
                    isInteractionEnabled = true;
                    if (args[0].equalsIgnoreCase("eat")) {
                        player.sendMessage(eatMsg);
                    }
                    if (args[0].equalsIgnoreCase("drink")) {
                        player.sendMessage(drinkMsg);
                    }
                    if (args[0].equalsIgnoreCase("wave")) {
                        player.sendMessage(waveMsg);
                        Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + waveBroadcastMsg, "civilization.rp");
                    }
                    if (args[0].equalsIgnoreCase("dance")) {
                        player.sendMessage(ChatColor.AQUA + danceMsg);
                        Bukkit.broadcast(ChatColor.LIGHT_PURPLE + player.getName() + " " + ChatColor.AQUA + danceMsg, "civilization.rp");
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
        }








        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("eat", "drink", "wave", "dance");
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
