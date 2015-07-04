package me.michaelkrauty.InventoryManager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created on 6/21/2015.
 *
 * @author michaelkrauty
 */
public class InventoriesFile {

    public final YamlConfiguration data = new YamlConfiguration();
    private final File iFile;
    private final Main main;

    public InventoriesFile(Main main) {
        this.main = main;
        iFile = new File(main.getDataFolder(), "inventories.yml");
        if (!iFile.exists())
            try {
                iFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        load();
    }

    public void save() {
        try {
            data.save(iFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            data.load(iFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
