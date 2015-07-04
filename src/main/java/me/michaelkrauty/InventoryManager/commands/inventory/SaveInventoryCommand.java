package me.michaelkrauty.InventoryManager.commands.inventory;

import me.michaelkrauty.InventoryManager.ItemSerialization;
import me.michaelkrauty.InventoryManager.Main;
import org.bukkit.entity.Player;

/**
 * Created on 6/21/2015.
 *
 * @author michaelkrauty
 */
public class SaveInventoryCommand {

    public SaveInventoryCommand(Main main, Player player, String name) {
        main.inventories.data.set(player.getUniqueId().toString() + "." + name.replace(" ", "_") + ".items", ItemSerialization.saveInventory(player.getInventory()));
        player.sendMessage("§7Inventory saved as §a" + name + "§7.");
    }
}
