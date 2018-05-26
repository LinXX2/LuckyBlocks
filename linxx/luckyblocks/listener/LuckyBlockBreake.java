package linxx.luckyblocks.listener;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import linxx.luckyblocks.api.LuckyEvent;
import linxx.luckyblocks.events.OpenLuckyBlockEvent;
import linxx.luckyblocks.main.LuckyBlocks;
import net.md_5.bungee.api.ChatColor;

public class LuckyBlockBreake implements Listener {

	LuckyBlocks plugin;

	public LuckyBlockBreake(LuckyBlocks main) {
		plugin = main;
	}

	@EventHandler
	public void onBlockBreake(BlockBreakEvent e) {
		if (e.getBlock().getType() == Material.SPONGE) {
			if (plugin.locs.contains(e.getBlock().getLocation())) {
				try {plugin.messagecfg.load(plugin.messageFile);} catch (IOException | InvalidConfigurationException e1) {e1.printStackTrace();}
				try {plugin.playerscfg.load(plugin.playersFile);} catch (IOException | InvalidConfigurationException e1) {e1.printStackTrace();}
				LuckyEvent m;
				if(new Random().nextInt() <= 50) {
					int random = new Random().nextInt(plugin.luckyevents.size());
					m = plugin.luckyevents.get(random);
				} else {
					int random = new Random().nextInt(plugin.unluckyevents.size());
					m = plugin.unluckyevents.get(random);
				}
				
				OpenLuckyBlockEvent event = new OpenLuckyBlockEvent(e.getBlock(), m.getName(), e.getPlayer());
				Bukkit.getServer().getPluginManager().callEvent(event);
				if (!event.isCancelled()) {
					try {
						m.getAction().invoke(m.getClassinstance(), e);
					} catch (IllegalAccessException ex) {
						ex.printStackTrace();
					} catch (IllegalArgumentException ex) {
						ex.printStackTrace();
					} catch (InvocationTargetException ex) {
						ex.printStackTrace();
					}
					plugin.locs.remove(e.getBlock().getLocation());
					int openedluckyblocks = plugin.playerscfg.getInt(e.getPlayer().getUniqueId().toString());
					String openedluckyblockss = plugin.playerscfg.getString(e.getPlayer().getUniqueId().toString());
					if(plugin.playerscfg.get(e.getPlayer().getUniqueId().toString()) != null) {
						plugin.playerscfg.set(e.getPlayer().getUniqueId().toString(), openedluckyblocks + 1);
						if(plugin.settingscfg.getBoolean("achivements.broadcastachivements")){
							if(plugin.achivementsteps.contains(openedluckyblocks)) {
								String achivementmessage = plugin.messagecfg.getString("achivements.broadcastmessage");
								achivementmessage = achivementmessage.replaceAll("@player", e.getPlayer().getName());
								achivementmessage = achivementmessage.replaceAll("@blocks", openedluckyblockss);
								achivementmessage = ChatColor.translateAlternateColorCodes('&', achivementmessage);
								Bukkit.broadcastMessage(achivementmessage);
							}
						}	
					}
					else {
						plugin.playerscfg.set(e.getPlayer().getUniqueId().toString(), 1);
					}
					try {
						plugin.playerscfg.save(plugin.playersFile);
						plugin.playerscfg.load(plugin.playersFile);
					} catch (IOException | InvalidConfigurationException e1) {e1.printStackTrace();}
					
					
				}
				if(event.isCancelled()) {
					e.setCancelled(true);
				}

			}
		}
	}
}
