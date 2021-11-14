package com.bigtallahasee.me.civilization.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class KingdomDataFile {
    private static File kingdomDataFile;
    private static FileConfiguration kingdomData;

    public static void kingdomDataSetup() {
        kingdomDataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Civilization").getDataFolder(),"kingdomData.yml" );

        if(!kingdomDataFile.exists()) {
            try {
                kingdomDataFile.createNewFile();
            }catch(IOException e) {

            }
        }
        kingdomData = YamlConfiguration.loadConfiguration(kingdomDataFile);

    }

    public static FileConfiguration getkingdomData() {
        return kingdomData;
    }

    public static void kingdomDataSave() {
        try {
            kingdomData.save(kingdomDataFile);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void kingdomDataReload() {
        kingdomData = YamlConfiguration.loadConfiguration(kingdomDataFile);
    }

    public static void kingdomDataAddDefaults(org.bukkit.event.player.PlayerJoinEvent event) {

    }
}
