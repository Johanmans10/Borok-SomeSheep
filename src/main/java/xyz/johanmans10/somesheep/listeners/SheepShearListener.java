package xyz.johanmans10.somesheep.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import xyz.johanmans10.somesheep.SomeSheep;

import java.util.HashMap;
import java.util.Map;

public class SheepShearListener implements Listener {

    private final Map<Sheep, Integer> sheepTaskMap;

    public SheepShearListener() {
        sheepTaskMap = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(this, SomeSheep.getInstance());
    }

    @EventHandler
    public void onPlayerShearEntity(PlayerShearEntityEvent event) {
        if (!(event.getEntity() instanceof Sheep sheep)) {
            return;
        }

        if (sheepTaskMap.containsKey(sheep)) {
            Bukkit.getScheduler().cancelTask(sheepTaskMap.remove(sheep));
            sheep.setCustomName(null);
        } else {
            int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SomeSheep.getInstance(), () -> {
                sheep.setCustomName(sheep.isSheared() ? null : "Dinnerbone");
                sheep.setSheared(!sheep.isSheared());
            }, 20, 10);

            sheep.setCustomNameVisible(false);

            sheepTaskMap.put(sheep, task);
        }
    }
}
