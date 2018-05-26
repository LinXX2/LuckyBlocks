package linxx.luckyblocks.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import linxx.luckyblocks.main.LuckyBlocks;
import net.md_5.bungee.api.ChatColor;

public class GiveLuckyBlock implements CommandExecutor {

	LuckyBlocks plugin;

	public GiveLuckyBlock(LuckyBlocks main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("giveluckyblock")) {
			if(sender.hasPermission("luckyblock.admin")) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					ItemStack LuckyBlock = new ItemStack(Material.SPONGE, 1);
					ItemMeta luckymeta = LuckyBlock.getItemMeta();
					luckymeta.setDisplayName(ChatColor.RED + "[LUCKY-BLOCK]");
					LuckyBlock.setItemMeta(luckymeta);
					p.getInventory().addItem(LuckyBlock);
					String msg = plugin.messagecfg.getString("getluckyblock");
					msg = ChatColor.translateAlternateColorCodes('&', msg);
					p.sendMessage(msg);
				} else {
					plugin.getLogger().warning("This is a Player command!");
				}
			}
		}
		return true;
	}
}
