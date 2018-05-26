package linxx.luckyblocks.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class PlaceLuckyBlockEvent extends Event implements Cancellable {

	private Block block;
	private Player placer;
	private boolean cancelled = false;
	private static final HandlerList handlers = new HandlerList();
	
	public PlaceLuckyBlockEvent(Block block, Player placer) {
		
	}
	
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		cancelled = arg0;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public Block getBlock() {
		return block;
	}
	
	public Player getPlacer() {
		return placer;
	}	
}
