package com.bigtallahasee.me.civilization.plugin.landclaiming.clans.commands;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class ClanRegularCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);


    private boolean notInClan;

    //Clan info
    private String clanName = plugin.getConfig().get("Clan-Name").toString();



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        int maxClanMembers =plugin.getConfig().getInt("Max-Clan-Members");
        Player target = getServer().getPlayer(args[1]);



        if(player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()){
            if(command.getName().equals("clan")){
                if(args[0].equalsIgnoreCase("start")){

                }
                if(args[0].equalsIgnoreCase("invite")){
                    if(!notInClan){
                        player.sendMessage("You must been in a clan!");
                        notInClan = false;
                    }
                    if(args[1].equalsIgnoreCase(target.toString())){
                        target.sendMessage("You have been invited to join " + clanName);
                    }
                }
                if(args[0].equalsIgnoreCase("disband")){
                    player.sendMessage("You have disbanded the " + clanName);
                }
                if(args[0].equalsIgnoreCase("list")){

                }
                if(args[0].equalsIgnoreCase("help")){
                    player.sendMessage("#-----------------------------------#");
                    player.sendMessage("#    Clan Help                                  #");
                    player.sendMessage("#-----------------------------------#");
                    player.sendMessage("/clan start [name]: This will start a clan with the entered name!");
                    player.sendMessage("/clan invite [MCUSERNAME]: This will invite the targeted MC-USER to your clan!");
                    player.sendMessage("/clan disband:  This will disband the clan that you are in!");
                    player.sendMessage("/clan list: This displays a list of all the clans on the server!");
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("found", "disband", "invite", "list", "help");
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

    public void civilizationStart(Player target){



        return;
    }
}
