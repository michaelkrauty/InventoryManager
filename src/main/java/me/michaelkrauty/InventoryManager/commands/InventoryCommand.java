package me.michaelkrauty.InventoryManager.commands;

import me.michaelkrauty.InventoryManager.Main;
import me.michaelkrauty.InventoryManager.commands.inventory.DeleteInventoryCommand;
import me.michaelkrauty.InventoryManager.commands.inventory.InventoryListCommand;
import me.michaelkrauty.InventoryManager.commands.inventory.LoadInventoryCommand;
import me.michaelkrauty.InventoryManager.commands.inventory.SaveInventoryCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created on 6/21/2015.
 *
 * @author michaelkrauty
 */
public class InventoryCommand implements CommandExecutor {

    private final Main main;

    public InventoryCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        if (args.length > 0) {
            String name;
            if (args.length > 1) {
                name = "";
                for (int i = 1; i < args.length; i++)
                    name = name + args[i] + " ";
                name = name.trim();
            } else
                name = "default";
            if (args[0].equalsIgnoreCase("save")) {
                new SaveInventoryCommand(main, player, name);
            } else if (args[0].equalsIgnoreCase("load")) {
                new LoadInventoryCommand(main, player, name);
            } else if (args[0].equalsIgnoreCase("list")) {
                new InventoryListCommand(main, player);
            } else if (args[0].equalsIgnoreCase("delete")) {
                new DeleteInventoryCommand(main, player, name);
            }
            return true;
        }
        player.sendMessage("§7Usage: §a/inv <save/load/delete/list> [name]");
        return true;
    }
}
