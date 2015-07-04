package me.michaelkrauty.InventoryManager;

import me.michaelkrauty.InventoryManager.commands.InventoryCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created on 6/18/2015.
 *
 * @author michaelkrauty
 */
public class Main extends JavaPlugin implements Listener {

    public InventoriesFile inventories;

    public void onEnable() {
        getServer().getPluginCommand("inventory").setExecutor(new InventoryCommand(this));
        getServer().getPluginManager().registerEvents(this, this);
        if (!getDataFolder().exists())
            getDataFolder().mkdir();
        inventories = new InventoriesFile(this);
    }

    public void onDisable() {
        inventories.save();
    }
}
