package com.bigtallahasee.me.civilization.files;

import java.io.File;
import java.io.IOException;

import com.bigtallahasee.me.civilization.listeners.PlayerJoinEvent;
import com.bigtallahasee.me.civilization.utils.Logger;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerDataFile {
	
	private static File playerDataFile;
	private static FileConfiguration playerData;

	public static void playerDataSetup() {
		playerDataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Civilization").getDataFolder(),"playerdata.yml" );
		
		if(!playerDataFile.exists()) {
			try { 
				playerDataFile.createNewFile();
			}catch(IOException e) {
				
			}
		}
		playerData = YamlConfiguration.loadConfiguration(playerDataFile);
		
	}
	
	public static FileConfiguration getPlayerData() {
		return playerData;
	}
	
	public static void playerDataSave() {
		try {
			playerData.save(playerDataFile);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void playerDataReload() {
		playerData = YamlConfiguration.loadConfiguration(playerDataFile);
	}
	
	public static void playerDataAddDefaults(org.bukkit.event.player.PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(!playerData.contains(player.getName()) && player.hasPlayedBefore()){
			playerData.createSection(player.getName());
			playerData.set("Name", "None");
			playerData.set("Age", 0);
			playerData.set("Gender", "None");
			playerData.set("Height", 71);
			playerData.set("Allegiance", "None");
			playerData.set("Description", "None");

			playerDataSave();

		}else if(!playerData.contains(player.getName()) && !player.hasPlayedBefore()){
			playerDataSetup();
			playerData.createSection(player.getName());
			playerData.set("Name", "None");
			playerData.set("Age", 0);
			playerData.set("Gender", "None");
			playerData.set("Height", 71);
			playerData.set("Allegiance", "None");
			playerData.set("Description", "None");

			playerDataSave();
		}else{
			Logger.log(Logger.LogLevel.WARNING, "Players data already exists in playerdata.yml!");
		}
		
	}

}
