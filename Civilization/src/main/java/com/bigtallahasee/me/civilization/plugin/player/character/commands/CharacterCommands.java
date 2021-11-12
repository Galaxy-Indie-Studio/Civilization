package com.bigtallahasee.me.civilization.plugin.player.character.commands;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CharacterCommands implements CommandExecutor {
      Civilization plugin = Civilization.getPlugin(Civilization.class);

    List<String> serverAlligances = plugin.getConfig().getStringList("Server-Alligances");
    List<String> serverRaces = plugin.getConfig().getStringList("Server-Races");

    private String treasonBounty = plugin.getConfig().get("Treason-Bounty").toString();
    private String customBountyMsg = plugin.getConfig().getString("Bounty-Msg");
    private String customTreasonMsg = plugin.getConfig().getString("Treason-Msg");

    private boolean isCharacterEnabled = plugin.getConfig().getBoolean("Character-Card-Enabled");

    //Custom Msg Variables
    String setNameMsg = plugin.getConfig().getString("Set-Name-Msg");
    String setAgeMsg = plugin.getConfig().getString("Set-Age-Msg");
    String setGenderMsg = plugin.getConfig().getString("Set-Gender-Msg");
    String setHeightMsg = plugin.getConfig().getString("Set-Height-Msg");
    String setRaceMsg = plugin.getConfig().getString("Set-Race-Msg");
    String setAllegianceMsg = plugin.getConfig().getString("Set-Allegiance-Msg");
    String setDescriptionMsg = plugin.getConfig().getString("Set-Description-Msg");
    String setMaleMsg = plugin.getConfig().getString("Set-Male-Msg");
    String setFemaleMsg = plugin.getConfig().getString("Set-Female-Msg");

    //Hover Chat Messages
    String playerName = "None"; //plugin.getConfig().getString("Name");
    String playerAge = "0"; //plugin.getConfig().getString("Age");
    String playerGender = "None";  //plugin.getConfig().getString("Gender");
    String playerHeight = "None";  //plugin.getConfig().getString("Height");
    String playerRace = "Human"; //plugin.getConfig().getString("Race");
    String playerAllegiance = "None"; // plugin.getConfig().getString("Allegiance");
    String playerDescription = "Default Description"; // plugin.getConfig().getString("Description");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("char set ")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Name: " + playerName);
                return true;
            }
        }

        Player player = (Player) sender;
        if (!player.hasPermission("civilization.")) {

        }

        if (args.length == 1) {
            player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
            player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
            player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
            player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
            player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
            player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
            player.sendMessage(" ");

            player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
            player.sendMessage(ChatColor.LIGHT_PURPLE +"# Player Card                       #");
            player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
            player.sendMessage(" ");

            TextComponent playersName = new TextComponent(ChatColor.LIGHT_PURPLE + "Name: " + ChatColor.GREEN + playerName);
            playersName.setBold(true);
            playersName.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set name"));
            playersName.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to change your Name!").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(playersName);

            TextComponent age = new TextComponent(ChatColor.LIGHT_PURPLE + "Age: " + ChatColor.GREEN + playerAge);
            age.setBold(true);
            age.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set age"));
            age.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to change your Age!").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(age);

            TextComponent gender = new TextComponent(ChatColor.LIGHT_PURPLE + "Gender: " + ChatColor.GREEN + playerGender);
            gender.setBold(true);
            gender.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set gender"));
            gender.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to change your Gender!").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(gender);

            TextComponent height = new TextComponent(ChatColor.LIGHT_PURPLE + "Height: " + ChatColor.GREEN + playerHeight);
            height.setBold(true);
            height.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set height"));
            height.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to change your Height!").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(height);

            TextComponent race = new TextComponent(ChatColor.LIGHT_PURPLE + "Race: " + ChatColor.GREEN + playerRace);
            race.setBold(true);
            race.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set race"));
            race.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to change your Race!").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(race);

            TextComponent allegiance = new TextComponent(ChatColor.LIGHT_PURPLE + "Allegiance: " + ChatColor.GREEN + playerAllegiance);
            allegiance.setBold(true);
            allegiance.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set allegiance"));
            allegiance.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to change your Allegiance!").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(allegiance);

            TextComponent description = new TextComponent(ChatColor.LIGHT_PURPLE + "Description: " + ChatColor.GREEN + playerDescription);
            description.setBold(true);
            description.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set description"));
            description.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to change your Description!").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(description);
            return true;
        }
        if (args[0].equalsIgnoreCase("set")) {
            if(args[1].equalsIgnoreCase("name")){
                player.sendMessage(" ");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                player.sendMessage(" ");

                player.sendMessage(setNameMsg);
            }
            if(args[1].equalsIgnoreCase("age")){
                player.sendMessage(" ");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                player.sendMessage(" ");

                player.sendMessage(setAgeMsg);
            }
            if(args[1].equalsIgnoreCase("gender")){
                player.sendMessage(" ");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                player.sendMessage(" ");

                TextComponent male = new TextComponent(ChatColor.WHITE + "Male");
                male.setBold(true);
                male.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set gender male"));
                male.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to be a Male!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(male);

                TextComponent female = new TextComponent(ChatColor.BLUE + "Female");
                female.setBold(true);
                female.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set gender female"));
                female.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to be a Female!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(female);


                try{
                    if(args[2].equalsIgnoreCase("male")) {
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                        player.sendMessage(" ");

                        player.sendMessage(ChatColor.BLUE + setMaleMsg);
                        PlayerDataFile.getPlayerData().set("Gender", "Male");

                    }
                    if(args[2].equalsIgnoreCase("female")){
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                        player.sendMessage(" ");

                        player.sendMessage(ChatColor.LIGHT_PURPLE + setFemaleMsg);
                        PlayerDataFile.getPlayerData().set("Gender", "Female");

                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
            if(args[1].equalsIgnoreCase("height")){
                player.sendMessage(" ");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                player.sendMessage(setHeightMsg);


            }
            if(args[1].equalsIgnoreCase("race")){
                player.sendMessage(" ");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                player.sendMessage(" ");

                TextComponent human = new TextComponent(ChatColor.WHITE + "Human");
                human.setBold(true);
                human.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set race human"));
                human.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to be a Human!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(human);

                TextComponent race2 = new TextComponent(ChatColor.BLUE + "Race2");
                race2.setBold(true);
                race2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set race race2"));
                race2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to be a Race2!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(race2);

                TextComponent race3 = new TextComponent(ChatColor.GREEN + "Race3");
                race3.setBold(true);
                race3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set race race3"));
                race3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to be a Race3!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(race3);

                TextComponent race4 = new TextComponent(ChatColor.RED + "Race4");
                race4.setBold(true);
                race4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set race race4"));
                race4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to be a Race4!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(race4);

                try {
                    if (args[2].equalsIgnoreCase("human")) {
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                        player.sendMessage(" ");



                        player.sendMessage(setRaceMsg);
                    }
                    if (args[2].equalsIgnoreCase("race2")){
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                        player.sendMessage(" ");



                        player.sendMessage(setRaceMsg);
                    }
                    if(args[2].equalsIgnoreCase("race3")){
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                        player.sendMessage(" ");



                        player.sendMessage(setRaceMsg);
                    }
                    if(args[2].equalsIgnoreCase("race4")){
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                        player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                        player.sendMessage(" ");


                        player.sendMessage(setRaceMsg);
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
            if(args[1].equalsIgnoreCase("allegiance")){
                player.sendMessage(" ");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                player.sendMessage(" ");

                TextComponent air = new TextComponent(ChatColor.WHITE + "Air");
                air.setBold(true);
                air.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set age air"));
                air.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to join the Air Nomads!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(air);

                TextComponent water = new TextComponent(ChatColor.BLUE + "Water");
                water.setBold(true);
                water.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set age water"));
                water.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to join the Water Tribesmen!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(water);

                TextComponent earth = new TextComponent(ChatColor.GREEN + "Earth");
                earth.setBold(true);
                earth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set age earth"));
                earth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to Earth Kingdomsmen!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(earth);

                TextComponent fire = new TextComponent(ChatColor.RED + "Fire");
                fire.setBold(true);
                fire.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/char set age fire"));
                fire.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to join the Fire Nation!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(fire);


                try {
                    if (args[2].equalsIgnoreCase("air")) {
                        player.sendMessage("");
                        player.sendMessage(ChatColor.WHITE + "Air");
                    }
                    if (args[2].equalsIgnoreCase("water")) {
                        player.sendMessage("");
                        player.sendMessage(ChatColor.BLUE + "Water");
                    }
                    if (args[2].equalsIgnoreCase("earth")) {
                        player.sendMessage("");
                        player.sendMessage(ChatColor.GREEN + "Earth");
                    }
                    if (args[2].equalsIgnoreCase("fire")) {
                        player.sendMessage("");
                        player.sendMessage(ChatColor.RED + "Fire");
                    }
                }catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
            if(args[1].equalsIgnoreCase("description")){
                player.sendMessage(" ");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"# Dev Note                            #");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"#----------------------------#");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"This feature is still in development and");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"may not do anything or function properly!");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you for you patitence and we will have it available asap!");
                player.sendMessage(" ");

                player.sendMessage(setDescriptionMsg);
            }

        }
    return false;
    }
}
