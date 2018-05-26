package linxx.luckyblocks.events;


import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import linxx.luckyblocks.api.LuckyEvent;

public final class OpenLuckyBlockEvent extends Event implements Cancellable {
	
	private Block block;
	private Player breaker;
	private LuckyEvent luckyevent;
	private boolean cancelled = false;
	private static final HandlerList handlers = new HandlerList();
	
	public OpenLuckyBlockEvent(Block block, String eventname, Player breaker) {
		
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
	
	public Player getBreaker() {
		return breaker;
	}
	
	public LuckyEvent getLuckyevent() {
		return luckyevent;
	}
	
	
}
