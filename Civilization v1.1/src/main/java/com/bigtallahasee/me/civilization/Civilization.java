package com.bigtallahasee.me.civilization;

import com.bigtallahasee.me.civilization.commands.PluginCommands;
import com.bigtallahasee.me.civilization.listeners.PlayerJoinEvent;
import com.bigtallahasee.me.civilization.plugin.careers.commands.RegularCareerCommands;
import com.bigtallahasee.me.civilization.plugin.careers.commands.SpecialBountyHunterCommands;
import com.bigtallahasee.me.civilization.plugin.landclaiming.kingdoms.commands.KingdomRegualarCommands;
import com.bigtallahasee.me.civilization.plugin.player.character.commands.CharacterCommands;
import com.bigtallahasee.me.civilization.plugin.player.character.commands.InteractionChatRPCommands;
import com.bigtallahasee.me.civilization.plugin.landclaiming.clans.commands.ClanRegularCommands;
import com.bigtallahasee.me.civilization.utils.Logger;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Civilization extends JavaPlugin {

    private static Economy econ = null;
    private static Permission perms = null;

    File playerData;
    FileConfiguration playerDataFile;

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(),this);

        //Regular player commands
        getCommand("interact").setExecutor(new InteractionChatRPCommands());
        getCommand("interact").setTabCompleter(new InteractionChatRPCommands());

        getCommand("char").setExecutor(new CharacterCommands());
        getCommand("char").setTabCompleter(new CharacterCommands());

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

        createPlayerData();
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

    public FileConfiguration getPlayerData() {
        return this.playerDataFile;
    }

    private void createPlayerData() {
        playerData = new File(getDataFolder(), "playerdata.yml");
        if (!playerData.exists()) {
            playerData.getParentFile().mkdirs();
            saveResource("playerdata.yml", false);
        }

        playerDataFile= new YamlConfiguration();
        try {
            playerDataFile.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
