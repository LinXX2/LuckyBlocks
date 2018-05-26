package linxx.luckyblocks.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import linxx.luckyblocks.main.LuckyBlocks;
import linxx.luckyblocks.misc.ItemBuilder;
import net.md_5.bungee.api.ChatColor;

public class InventoryClick implements Listener {

	LuckyBlocks plugin;

	public InventoryClick(LuckyBlocks main) {
		plugin = main;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
			if (e.getClickedInventory().getName().equals(ChatColor.MAGIC + "ABC" + ChatColor.RESET + ChatColor.RED
					+ "LuckyBlocks" + ChatColor.RESET + ChatColor.MAGIC + "ABC")) {
				if (e.getCurrentItem().equals(new ItemBuilder(Material.STAINED_GLASS_PANE).setName("t").build())) {
					e.setCancelled(true);
				}
			}
		}

	}
}
