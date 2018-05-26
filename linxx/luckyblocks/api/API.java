package linxx.luckyblocks.api;

import linxx.luckyblocks.main.LuckyBlocks;

public class API {

	private LuckyBlocks plugin;
	private static API instance;
	public API(LuckyBlocks main) {
		plugin = main;
		this.instance = this;
	}

	public void addLuckyEvent(LuckyEvent luckyevent) {
		if(luckyevent.getEventtype() == EventType.LUCKY) {
			plugin.luckyevents.add(luckyevent);
		}
		if(luckyevent.getEventtype() == EventType.UNLUCKY) {
			plugin.unluckyevents.add(luckyevent);
		}
	}
	
	public static API GET_INSTANCE() {
		return instance;
	}
}
