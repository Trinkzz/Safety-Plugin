package main.safety;

import main.safety.handler.BanHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Safety extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling Safety");
        // Enable logic, if any
        new BanHandler(this); // Ensure that BanHandler is registered
    }

    @Override
    public void onDisable() {
        // Disable logic, if any
    Bukkit.getLogger().info("Disabling Safety");
    }
}
