package xyz.johanmans10.somesheep.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import xyz.johanmans10.somesheep.SomeSheep;

public class SheepRegrowListener implements Listener {

    public SheepRegrowListener() {
        Bukkit.getPluginManager().registerEvents(this, SomeSheep.getInstance());
    }

    @EventHandler
    public void onSheepRegrowWool(SheepRegrowWoolEvent event) {
        Sheep entity = event.getEntity();
        entity.setCustomName("jeb_");
        entity.setCustomNameVisible(false);
    }
}
