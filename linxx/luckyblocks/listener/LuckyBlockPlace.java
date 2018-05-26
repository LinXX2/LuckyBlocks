package linxx.luckyblocks.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import linxx.luckyblocks.events.PlaceLuckyBlockEvent;
import linxx.luckyblocks.main.LuckyBlocks;
import net.md_5.bungee.api.ChatColor;

public class LuckyBlockPlace implements Listener {

	LuckyBlocks plugin;

	public LuckyBlockPlace(LuckyBlocks main) {
		this.plugin = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if (e.getBlock().getType() == Material.SPONGE) {
			if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()
					.equals(ChatColor.RED + "[LUCKY-BLOCK]")
					|| e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()
					.equals(ChatColor.RED + "[LUCKY-BLOCK]")) {
				PlaceLuckyBlockEvent event = new PlaceLuckyBlockEvent(e.getBlock(), e.getPlayer());
				Bukkit.getServer().getPluginManager().callEvent(event);
				if (!event.isCancelled()) {
					plugin.locs.add(e.getBlock().getLocation());
					String msg = plugin.messagecfg.getString("placeluckyblock");
					msg = ChatColor.translateAlternateColorCodes('&', msg);
					e.getPlayer().sendMessage(msg);
				}
				if (event.isCancelled()) {
					e.setCancelled(true);
				}

			}
		}
	}
}
