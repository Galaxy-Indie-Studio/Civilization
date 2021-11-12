package com.bigtallahasee.me.civilization.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomMsgsFile {
    private static File customMsgsFile;
    private static FileConfiguration customMsgs;

    public static void customMsgsFileSetup() {
        customMsgsFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Civilization").getDataFolder(),"custommsgs.yml" );

        if(!customMsgsFile.exists()) {
            try {
                customMsgsFile.createNewFile();
            }catch(IOException e) {

            }
        }
        customMsgs = YamlConfiguration.loadConfiguration(customMsgsFile);

    }

    public static FileConfiguration getCustomMsgs() {
        return customMsgs;
    }

    public static void customMsgsSave() {
        try {
            customMsgs.save(customMsgsFile);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void customMsgsReload() {
        customMsgs = YamlConfiguration.loadConfiguration(customMsgsFile);
    }
}
