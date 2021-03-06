package com.bigtallahasee.me.civilization;

import com.bigtallahasee.me.civilization.commands.PluginCommands;
import com.bigtallahasee.me.civilization.files.ClanDataFile;
import com.bigtallahasee.me.civilization.files.KingdomDataFile;
import com.bigtallahasee.me.civilization.files.PlayerDataFile;
import com.bigtallahasee.me.civilization.listeners.ChatListeners;
import com.bigtallahasee.me.civilization.listeners.PlayerDeathEvents;
import com.bigtallahasee.me.civilization.listeners.PlayerJoinEvent;
import com.bigtallahasee.me.civilization.plugin.careers.commands.RegularCareerCommands;
import com.bigtallahasee.me.civilization.plugin.careers.commands.SpecialBountyHunterCommands;
import com.bigtallahasee.me.civilization.plugin.landclaiming.kingdoms.commands.KingdomRegualarCommands;
import com.bigtallahasee.me.civilization.plugin.player.character.commands.CharacterCommands;
import com.bigtallahasee.me.civilization.plugin.player.character.commands.InteractionChatRPCommands;
import com.bigtallahasee.me.civilization.plugin.landclaiming.clans.commands.ClanRegularCommands;
import com.bigtallahasee.me.civilization.utils.Logger;
import com.bigtallahasee.me.civilization.utils.Settings;
import com.bigtallahasee.me.civilization.utils.UpdateChecker;
import com.bigtallahasee.me.civilization.utils.methodholder.ChatMethods;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Civilization extends JavaPlugin {

    private static Economy econ = null;
    private static Permission perms = null;
    private String pluginName = "Civilization";
    private String pluginVersion = "1.4";
    private String discordInvite = " ";
    private String githubLink = " ";
    private String[] contributors = {""};

    ChatMethods chatMethods;


    @Override
    public void onEnable() {
        Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
        Logger.log(Logger.LogLevel.INFO, "Thank you for downloading " + pluginName + " " + pluginVersion);
        Logger.log(Logger.LogLevel.INFO, "If you need any assistance then feel free to reach out on Discord or Github!");
        Logger.log(Logger.LogLevel.INFO, "Discord: " + discordInvite);
        Logger.log(Logger.LogLevel.INFO, "Github: " + githubLink);
        Logger.log(Logger.LogLevel.INFO, "Give a big shout to the fellow Developers who have helped make " + pluginName + " " + pluginVersion + " a reality!");
        Logger.log(Logger.LogLevel.INFO, "Thank you all for all of your help and I hope we can continue in the future");
        Logger.log(Logger.LogLevel.INFO, "Contributors: " + contributors);


        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(),this);
        getServer().getPluginManager().registerEvents(new ChatListeners(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEvents(), this);

        //Regular player commands
        getCommand("interact").setExecutor(new InteractionChatRPCommands());
        getCommand("interact").setTabCompleter(new InteractionChatRPCommands());

        getCommand("char").setExecutor(new CharacterCommands());

        getCommand("kingdom").setExecutor(new KingdomRegualarCommands());
        getCommand("kingdom").setTabCompleter(new KingdomRegualarCommands());

        getCommand("clan").setExecutor(new ClanRegularCommands());
        getCommand("clan").setTabCompleter(new ClanRegularCommands());

        getCommand("careers").setExecutor(new RegularCareerCommands());
        getCommand("careers").setTabCompleter(new RegularCareerCommands());

        //Special Career Commands
        getCommand("bounty-hunter").setExecutor(new SpecialBountyHunterCommands());
        getCommand("bounty-hunter").setExecutor(new SpecialBountyHunterCommands());

        //Admin commands

        getCommand("civilization").setExecutor(new PluginCommands());
        getCommand("civilization").setTabCompleter(new PluginCommands());



        if (!setupEconomy() ) {
            Logger.log(Logger.LogLevel.INFO, String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        PlayerDataFile.playerDataSetup();
        PlayerDataFile.getPlayerData().options().copyDefaults(true);
        PlayerDataFile.playerDataSave();

        KingdomDataFile.kingdomDataSetup();
        KingdomDataFile.getkingdomData().options().copyDefaults(true);
        KingdomDataFile.kingdomDataSave();

        ClanDataFile.clanDataSetup();
        ClanDataFile.getClanData().options().copyDefaults(true);
        ClanDataFile.clanDataSave();


        //Update Checker
        new UpdateChecker(this, 97540).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Logger.log(Logger.LogLevel.SUCCESS, ("Civilization is up to date!"));
            } else {
                Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
                Logger.log(Logger.LogLevel.WARNING, ("Civilization is outdated!"));
                Logger.log(Logger.LogLevel.WARNING, ("Newest version: " + version));
                Logger.log(Logger.LogLevel.WARNING, ("Your version: " + Settings.VERSION));
                Logger.log(Logger.LogLevel.WARNING, ("Please Update Here: " + Settings.PLUGIN_URL + UpdateChecker.resourceId));
                Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
            }
        });

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    @Override
    public void onDisable() {

    }
    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }


}
