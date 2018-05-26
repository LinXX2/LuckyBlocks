package linxx.luckyblocks.api;

import linxx.luckyblocks.main.LuckyBlocks;

public interface Module {
	
    public String getName();

    public String getVersion();

    public String getAuthor();
    
    public void load(LuckyBlocks lb, API api);

}

