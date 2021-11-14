package com.bigtallahasee.me.civilization;

import com.bigtallahasee.me.civilization.listeners.PlayerJoinEvent;
import com.bigtallahasee.me.civilization.plugin.player.character.commands.CharacterCommands;
import com.bigtallahasee.me.civilization.plugin.player.character.commands.InteractionChatRPCommands;
import com.bigtallahasee.me.civilization.plugin.landclaiming.clans.commands.ClanRegularCommands;
import com.bigtallahasee.me.civilization.plugin.landclaiming.kingdoms.commands.KingdomRegularCommands;
import com.bigtallahasee.me.civilization.utils.Logger;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Civilization extends JavaPlugin {

    private static Economy econ = null;
    private static Permission perms = null;

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(),this);

        //Regular player commands
        getCommand("interact").setExecutor(new InteractionChatRPCommands());
        getCommand("interact").setTabCompleter(new InteractionChatRPCommands());
        getCommand("char").setExecutor(new CharacterCommands());
        getCommand("kingdom").setExecutor(new KingdomRegularCommands());
        getCommand("clan").setExecutor(new ClanRegularCommands());

        //Admin commands



        if (!setupEconomy() ) {
            Logger.log(Logger.LogLevel.INFO, String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();

        getConfig().options().copyDefaults();
        saveDefaultConfig();
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
