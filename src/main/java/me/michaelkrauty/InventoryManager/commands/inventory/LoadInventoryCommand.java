package me.michaelkrauty.InventoryManager.commands.inventory;

import me.michaelkrauty.InventoryManager.ItemSerialization;
import me.michaelkrauty.InventoryManager.Main;
import org.bukkit.entity.Player;

/**
 * Created on 6/21/2015.
 *
 * @author michaelkrauty
 */
public class LoadInventoryCommand {

    public LoadInventoryCommand(Main main, Player player, String name) {
        if (main.inventories.data.getString(player.getUniqueId().toString() + "." + name.trim().replace(" ", "_")) == null)
            player.sendMessage("§7Tried to load inventory §a" + name + "§7, but failed because it doesn't exist!");
        else {
            try {
                player.getInventory().setContents(ItemSerialization.loadInventory(main.inventories.data.getString(player.getUniqueId().toString() + "." + name.replace(" ", "_") + ".items")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            player.sendMessage("§7Loaded inventory §a" + name + "§7.");
        }
    }
}
