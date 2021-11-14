package com.bigtallahasee.me.civilization.plugin.landclaiming.kingdoms.commands;

import com.bigtallahasee.me.civilization.Civilization;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KingdomRegularCommands implements TabExecutor {
    Civilization plugin = Civilization.getPlugin(Civilization.class);
    Economy eco;

    private boolean isDisbandRefundEnabled = plugin.getConfig().getBoolean("");
    private int maxKingdoms = plugin.getConfig().getInt("Max-Kingdoms-Amount");

    List<String> kingdomNames = new ArrayList<>();
    private String[] kingdomStatus = {"Peaceful","Neutral","Hostile"};
    private String alliedKingdom;
    private String enemyKingdom;
    private String newKingdomName;

    //kingdom variables
    private String kingdomName = "None";
    private String currentKingdomStatus = "None";
    private List<String> kingdomAlliances = new ArrayList<>();
    private List<String> kingdomEnemies = new ArrayList<>();
    private List<String> atWarWith = new ArrayList<>();
    private int kingdomBankBalance = 0;

    //kingdom economy variables
    private int amountDeposited;
    private int amountWithdrawn;
    private double startKingdomAmount = plugin.getConfig().getDouble("New-Kingdom-Fee");




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String name = player.getName();
        if (player.hasPermission("civilization.default") || player.hasPermission("civilization.*") || player.isOp()){
            if(args.length <= 0){
                if(command.getName().equals("kingdom")){
                    if(args[0].equalsIgnoreCase("create")){
                            createKingdom(player);
                            plugin.getEconomy().withdrawPlayer(player, startKingdomAmount);
                    }
                    if(args[0].equalsIgnoreCase("disband") && isDisbandRefundEnabled){
                        player.sendMessage("You haved disbanded " + kingdomName);
                    }
                    if(args[0].equalsIgnoreCase("bank")){
                        if(args[1].equalsIgnoreCase("withdraw")){
                            player.sendMessage("You have withdrawn money from the Kingdom's Bank!");
                            plugin.getEconomy().withdrawPlayer(player, amountWithdrawn);
                        }
                        if(args[1].equalsIgnoreCase("deposit")){
                            player.sendMessage("You have deposited money into the Kingdom's Bank!");
                            plugin.getEconomy().depositPlayer(player, amountDeposited);

                        }
                        if(args[1].equalsIgnoreCase("show")){
                            player.sendMessage("Kingdom Bank: " + kingdomBankBalance);
                        }
                    }
                    if(args[0].equalsIgnoreCase("list")){
                        for(int i = 0; i <= maxKingdoms; i++){
                            if(kingdomNames != null){
                                player.sendMessage(kingdomNames.get(i));
                            }
                            if(kingdomNames == null){
                                player.sendMessage("There aren't any kingdoms founded yet!");
                            }
                        }
                    }
                    if(args[0].equalsIgnoreCase("set")){
                        if(player.hasPermission("civilization.*") || player.isOp()){
                            if(args[1].equalsIgnoreCase("name")){
                                player.sendMessage("You have changed the name to your kingdom to " + newKingdomName);
                            }
                        }
                        if(args[1].equalsIgnoreCase("status")){
                            if(args[2].equalsIgnoreCase("peaceful")){
                                currentKingdomStatus = kingdomStatus[0];
                            }
                            if(args[2].equalsIgnoreCase("neutral")){
                                currentKingdomStatus = kingdomStatus[1];
                            }
                            if(args[2].equalsIgnoreCase("hostile")){
                                currentKingdomStatus= kingdomStatus[2];
                            }
                        }
                        if(args[1].equalsIgnoreCase("alliance")){
                            if(args[2].equalsIgnoreCase("add")){
                                player.sendMessage("You have allied " + alliedKingdom);
                            }
                            if(args[2].equalsIgnoreCase("remove")){
                                player.sendMessage("You have removed " + alliedKingdom + "from you allies list!");
                            }
                        }
                        if(args[1].equalsIgnoreCase("enemy")){
                            if(args[2].equalsIgnoreCase("add")){
                                player.sendMessage("You have added " + enemyKingdom + "to your enemies list!");
                            }
                            if(args[2].equalsIgnoreCase("remove")){
                                player.sendMessage("You have removed " + enemyKingdom + "from your enemies list!");
                            }
                        }
                    }
                    if(args[0].equalsIgnoreCase("show")){
                        player.sendMessage("Kingdom Name: ");
                        player.sendMessage("Kingdom Status: " + currentKingdomStatus);
                        player.sendMessage("Kingdom Alliances: ");
                        player.sendMessage("Kingdom Enemies: ");
                        player.sendMessage("At War With: ");
                        player.sendMessage("Kingdom Bank: " + kingdomBankBalance);
                    }
                    if(args[0].equalsIgnoreCase("help")){

                    }
                }
            }
        }


        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("create", "disband", "bank", "list", "show","help");
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

    public void createKingdom(Player player){

        for(int i = 0; i <= maxKingdoms; i++){
            if(kingdomName != kingdomNames.get(i)){
                kingdomNames.add("");
            }
            if(kingdomName == kingdomNames.get(i)){
                player.sendMessage(kingdomName + " already exists! try again");
            }
            if(kingdomName == null){
                return;
            }
        }
    }
}
