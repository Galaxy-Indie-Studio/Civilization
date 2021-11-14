package com.bigtallahasee.me.civilization.plugin.careers.commands;

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

public class SpecialBountyHunterCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    private final String bountyHunterPerm = plugin.getConfig().getString("Server-Bounty-Hunter-Perm");
    private boolean isBountyHunterEnabled = plugin.getConfig().getBoolean("Bounties-Enabled");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission(bountyHunterPerm) || player.hasPermission("civilization.*") || player.isOp()) {
            if (args.length <= 1) {
                if (command.getName().equals("bounty-hunter")) {
                    if(isBountyHunterEnabled) {
                        isBountyHunterEnabled = true;
                        if (args[0].equalsIgnoreCase("id")) {
                            Player target = Bukkit.getPlayerExact(args[1]);
                            if (target instanceof Player) {
                                ChatMethods.devNoteMethod(player);

                                player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "#    Player ID                                 #");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "#-----------------------------------#");
                            } else {
                                player.sendMessage("You must id a real Player!");
                            }
                        }
                    }else{
                        ChatMethods.devNoteMethod(player);
                        player.sendMessage(" ");
                        player.sendMessage("Special Bounty Actions are disabled on the server!");
                        player.sendMessage("If this is a mistake, Please reach out to your ");
                        player.sendMessage("server Admin!");
                        isBountyHunterEnabled = false;
                    }

                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have the proper perms to");
                player.sendMessage(ChatColor.RED + "execute this command!");
                player.sendMessage(ChatColor.GREEN + "Require Perm (" + bountyHunterPerm + ChatColor.GREEN + ")");
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("id");
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
