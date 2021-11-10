package com.bigtallahasee.me.civilization.plugin.player.character.commands;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.Bukkit;
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

    private String eatMsg = plugin.getConfig().get("Eat-Msg").toString();
    private String drinkMsg = plugin.getConfig().get("Drink-Msg").toString();
    private String waveMsg = plugin.getConfig().get("Wave-Msg").toString();
    private String danceMsg = plugin.getConfig().get("Dance-Msg").toString();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()){
            if(command.getName().equals("interact")){
                if(args[0].equalsIgnoreCase("eat")){
                    player.sendMessage(eatMsg);
                }
                if(args[0].equalsIgnoreCase("drink")){
                    player.sendMessage(drinkMsg);
                }
                if(args[0].equalsIgnoreCase("wave")){
                    player.sendMessage(waveMsg);
                    Bukkit.broadcast(player.getName() + "is waving!", "civilization.rp");
                }
                if(args[0].equalsIgnoreCase("dance")){
                    player.sendMessage(danceMsg);
                    Bukkit.broadcast(player.getName() + "started busting a move!", "civilization.rp");
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
