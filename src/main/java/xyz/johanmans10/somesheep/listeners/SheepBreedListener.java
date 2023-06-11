package xyz.johanmans10.somesheep.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.johanmans10.somesheep.SomeSheep;

public class SheepBreedListener implements Listener {

    public SheepBreedListener() {
        Bukkit.getPluginManager().registerEvents(this, SomeSheep.getInstance());
    }

    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {
        if (!(event.getEntity().getType().equals(EntityType.SHEEP))) return;
        if (event.getBreeder() != null) {
            event.getBreeder().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 120, 10));
        }
        if (!(event.getFather() instanceof Sheep father)) return;
        if (!(event.getMother() instanceof Sheep mother)) return;

        this.getTopPassenger(father).addPassenger(father.getWorld().spawnEntity(father.getLocation(), EntityType.SHEEP, true));
        this.getTopPassenger(mother).addPassenger(mother.getWorld().spawnEntity(mother.getLocation(), EntityType.SHEEP, true));
    }

    private Entity getTopPassenger(Entity entity) {
        if (entity.getPassengers().isEmpty()) {
             return entity;
        }
        return getTopPassenger(entity.getPassengers().get(0));
    }
}
