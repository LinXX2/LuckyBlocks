package linxx.luckyblocks.misc;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import linxx.luckyblocks.main.LuckyBlocks;
import net.md_5.bungee.api.ChatColor;

public class Methods {

	LuckyBlocks plugin;


	public Methods(LuckyBlocks main) {
		plugin = main;
	}

	public void addRecipes() {
		int[] il = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		ItemStack LuckyBlock = new ItemBuilder(Material.SPONGE).setName(ChatColor.RED + "[LUCKY-BLOCK]").build();
		ShapedRecipe recipe = new ShapedRecipe(LuckyBlock);
		recipe.shape("ABC", "DEF", "GHI");
		
		for(int i : il) {
			if (!(plugin.craftingcfg.get("LuckyBlocks.Recipe." + i + ".ID").equals("nothing"))) {
				ItemStack is = new ItemBuilder(plugin.craftingcfg.getInt("LuckyBlocks.Recipe." + i + ".ID"),
						(byte) plugin.craftingcfg.getInt("LuckyBlocks.Recipe." + i + ".subID")).build();
				
				recipe.setIngredient(numberToChar(i - 1), is.getData());
			}
		}
		plugin.getServer().addRecipe(recipe);
	}
	public char numberToChar(int number) {
	    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	    return (alphabet[number]);
	}

}
