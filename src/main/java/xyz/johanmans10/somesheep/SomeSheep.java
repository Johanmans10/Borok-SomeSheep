package xyz.johanmans10.somesheep;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.johanmans10.somesheep.listeners.SheepBreedListener;
import xyz.johanmans10.somesheep.listeners.SheepRegrowListener;
import xyz.johanmans10.somesheep.listeners.SheepShearListener;

public class SomeSheep extends JavaPlugin {

    private static SomeSheep instance;

    @Override
    public void onEnable() {
        instance = this;

        new SheepBreedListener();
        new SheepRegrowListener();
        new SheepShearListener();
    }

    public static SomeSheep getInstance() {
        return instance;
    }
}
