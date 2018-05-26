package linxx.luckyblocks.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import linxx.luckyblocks.main.LuckyBlocks;
import net.md_5.bungee.api.ChatColor;

public class GetOpenedLuckyBlocks implements CommandExecutor {
	
	LuckyBlocks plugin;
	
	public GetOpenedLuckyBlocks(LuckyBlocks main) {
		this.plugin = main;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
		    OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
		    if (op.hasPlayedBefore()) {
		        UUID uuid = op.getUniqueId();
		        if(plugin.playerscfg.contains(uuid.toString())) {
		        	String msg = plugin.messagecfg.getString("getopenedluckyblocks.success");
		        	msg = msg.replaceAll("@player", args[0]);
		        	msg = msg.replaceAll("@blocks", plugin.playerscfg.getString(uuid.toString()));
		        	msg = ChatColor.translateAlternateColorCodes('&', msg);
		        	sender.sendMessage(msg);
		        } else {
		        	String msg = plugin.messagecfg.getString("getopenedluckyblocks.error");
		        	msg = msg.replaceAll("@player", args[0]);
		        	msg = ChatColor.translateAlternateColorCodes('&', msg);
		        	sender.sendMessage(msg);
		        }
			}
		} else {
			sender.sendMessage(ChatColor.RED + "/getopenedluckyblocks <Player>");
		}
		return true;
	}
	
	
	


}
