package com.bigtallahasee.me.civilization.listeners;

import com.bigtallahasee.me.civilization.Civilization;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class InteractEvents implements Listener {
    Civilization plugin = Civilization.getPlugin(Civilization.class);

    private String cowMilkMsg = plugin.getConfig().getString("Custom-Cow-Milk-Msg");
    private String shearSheepMsg = plugin.getConfig().getString("Custom-Shear-Sheep-Msg");

    @EventHandler
    public void onMilkCowEvent(PlayerBucketFillEvent event){
        Player player = event.getPlayer();

        player.sendMessage(cowMilkMsg);

    }

    @EventHandler
    public void onShearEvent(PlayerShearEntityEvent event){
        Player player = event.getPlayer();

        player.sendMessage(shearSheepMsg);

    }
}
