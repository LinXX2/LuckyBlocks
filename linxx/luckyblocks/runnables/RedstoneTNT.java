package linxx.luckyblocks.runnables;

import org.bukkit.Location;
import org.bukkit.Material;

import linxx.luckyblocks.main.LuckyBlocks;

public class RedstoneTNT implements Runnable {

	
	public LuckyBlocks plugin;
	int i = 0;
	private int id = -1;
	Location loc;
	
	
	public RedstoneTNT(LuckyBlocks main, Location loc) {
		this.plugin = main;
		this.loc = loc;
		id = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, this, 10L, 10L);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		if(i == 0) {
			loc.getWorld().spawnFallingBlock(loc, Material.REDSTONE_BLOCK, (byte) 0);
		}else {
			loc.getWorld().spawnFallingBlock(loc, Material.TNT, (byte) 0);
		}
		
		if(i == 10) {

			plugin.getServer().getScheduler().cancelTask(id);

		}
		i++;
		
		
	}

}
