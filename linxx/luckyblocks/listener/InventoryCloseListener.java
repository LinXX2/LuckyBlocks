package linxx.luckyblocks.listener;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import linxx.luckyblocks.main.LuckyBlocks;
import net.md_5.bungee.api.ChatColor;

public class InventoryCloseListener implements Listener {

	LuckyBlocks plugin;

	public InventoryCloseListener(LuckyBlocks main) {
		plugin = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) throws IOException {
		if (e.getInventory().getName().equals(ChatColor.MAGIC + "ABC" + ChatColor.RESET + ChatColor.RED + "LuckyBlocks"
				+ ChatColor.RESET + ChatColor.MAGIC + "ABC")) {
			try {plugin.craftingcfg.load(plugin.craftingRecipeFile);} catch (IOException | InvalidConfigurationException e1) {e1.printStackTrace();}
			int[] il = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int[] slots = { 12, 13, 14, 21, 22, 23, 30, 31, 32 };
			for (int i : il) {
				System.out.println(Integer.toString(slots[i - 1]));
				if (!(e.getInventory().getItem(slots[i - 1]) == (null))) {
					plugin.craftingcfg.set("LuckyBlocks.Recipe." + i + ".ID",
							e.getInventory().getItem(slots[i - 1]).getTypeId());
					plugin.craftingcfg.set("LuckyBlocks.Recipe." + i + ".subID",
							e.getInventory().getItem(slots[i - 1]).getData().getData());
					plugin.craftingcfg.save(plugin.craftingRecipeFile);
				} else {
					plugin.craftingcfg.set("LuckyBlocks.Recipe." + i + ".ID", "nothing");
					plugin.craftingcfg.save(plugin.craftingRecipeFile);
				}
			}
			String msg = plugin.messagecfg.getString("setrecipemessage");
			msg = ChatColor.translateAlternateColorCodes('&', msg);
			e.getPlayer().sendMessage(msg);
		}
	}

}