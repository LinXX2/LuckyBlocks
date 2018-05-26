package linxx.luckyblocks.misc;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvBuilder {

	Inventory inv;

	public InvBuilder(int rows, String iname) {
		inv = Bukkit.createInventory(null, rows * 9, iname);
	}

	public InvBuilder fillInv(ItemStack is) {
		for (int i = 0; i < inv.getSize(); i++) {
			if ((inv.getItem(i) == null)) {
				inv.setItem(i, is);
			}
		}
		return this;
	}

	public InvBuilder setItem(ItemStack is, int position) {
		inv.setItem(position, is);
		return this;
	}

	public Inventory build() {
		return inv;
	}
}
