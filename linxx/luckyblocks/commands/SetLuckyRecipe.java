package linxx.luckyblocks.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import linxx.luckyblocks.main.LuckyBlocks;
import linxx.luckyblocks.misc.InvBuilder;
import linxx.luckyblocks.misc.ItemBuilder;
import net.md_5.bungee.api.ChatColor;

public class SetLuckyRecipe implements CommandExecutor {

	LuckyBlocks plugin;

	public SetLuckyRecipe(LuckyBlocks main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("luckyblock.admin")) {
			if (sender instanceof Player) {
				Inventory inv = new InvBuilder(5,
						ChatColor.MAGIC + "ABC" + ChatColor.RESET + ChatColor.RED + "LuckyBlocks" + ChatColor.RESET
								+ ChatColor.MAGIC + "ABC")
										.fillInv(new ItemBuilder(Material.STAINED_GLASS_PANE).setName("t").build())
										.setItem(null, 12).setItem(null, 13).setItem(null, 14).setItem(null, 21)
										.setItem(null, 22).setItem(null, 23).setItem(null, 30).setItem(null, 31)
										.setItem(null, 32).build();
				Player p = (Player) sender;
				p.openInventory(inv);
	
			} else {
				plugin.getLogger().warning("This is a Player command!");
			}
		}
		return true;
	}

}
