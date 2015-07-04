package me.michaelkrauty.InventoryManager.commands.inventory;

import me.michaelkrauty.InventoryManager.Main;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created on 6/21/2015.
 *
 * @author michaelkrauty
 */
public class InventoryListCommand {

    public InventoryListCommand(Main main, Player player) {
        if (main.inventories.data.getString(player.getUniqueId().toString()) == null)
            player.sendMessage("§7You don't have any saved inventories.");
        else {
            Set<String> inventories = main.inventories.data.getConfigurationSection(player.getUniqueId().toString()).getKeys(true);
            player.sendMessage("§7Saved inventories:");
            ArrayList<String> invs = new ArrayList<String>();
            for (String inv : inventories)
                if (!inv.contains("."))
                    invs.add(inv);
            player.sendMessage("§a" + invs.toString());
        }
    }
}
