package me.michaelkrauty.InventoryManager.commands.inventory;

import me.michaelkrauty.InventoryManager.Main;
import org.bukkit.entity.Player;

/**
 * Created on 6/21/2015.
 *
 * @author michaelkrauty
 */
public class DeleteInventoryCommand {

    public DeleteInventoryCommand(Main main, Player player, String name) {
        if (main.inventories.data.getString(player.getUniqueId().toString() + "." + name.replace(" ", "_")) == null) {
            player.sendMessage("§7Tried to delete inventory §a" + name + "§7, but it looks like it doesn't exist.");
        }
        main.inventories.data.set(player.getUniqueId().toString() + "." + name.replace(" ", "_"), null);
        player.sendMessage("§7Deleted inventory §a" + name + "§7.");
    }
}
