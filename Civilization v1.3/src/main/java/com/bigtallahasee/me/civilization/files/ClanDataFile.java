package com.bigtallahasee.me.civilization.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ClanDataFile {
    private static File clanDataFile;
    private static FileConfiguration clanData;

    public static void clanDataSetup() {
        clanDataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Civilization").getDataFolder(),"clanData.yml" );

        if(!clanDataFile.exists()) {
            try {
                clanDataFile.createNewFile();
            }catch(IOException e) {

            }
        }
        clanData = YamlConfiguration.loadConfiguration(clanDataFile);

    }

    public static FileConfiguration getClanData() {
        return clanData;
    }

    public static void clanDataSave() {
        try {
            clanData.save(clanDataFile);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void clanDataReload() {
        clanData = YamlConfiguration.loadConfiguration(clanDataFile);
    }

    public static void clanDataAddDefaults(org.bukkit.event.player.PlayerJoinEvent event) {

    }
}
