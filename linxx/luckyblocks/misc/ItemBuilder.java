package linxx.luckyblocks.misc;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

	ItemStack is;
	ItemMeta meta;

	@SuppressWarnings("deprecation")
	public ItemBuilder(int type) {
		is = new ItemStack(type);
		meta = is.getItemMeta();
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder(int type, byte data) {
		is = new ItemStack(type);
		is.getData().setData(data);
		meta = is.getItemMeta();
	}

	public ItemBuilder(Material material) {
		is = new ItemStack(material);
		meta = is.getItemMeta();
	}

	public ItemBuilder(Material material, int amount) {
		is = new ItemStack(material, amount);
		meta = is.getItemMeta();
	}

	public ItemBuilder(Material material, int amount, byte subid) {
		is = new ItemStack(material, amount, subid);
		meta = is.getItemMeta();
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder(Material material, int amount, byte subid, short damage) {
		is = new ItemStack(material, amount, damage, subid);
		meta = is.getItemMeta();
	}

	public ItemBuilder setName(String s) {
		meta.setDisplayName(s);
		return this;
	}

	public ItemBuilder addEnchantment(Enchantment ench, int value) {
		meta.addEnchant(ench, value, true);
		return this;
	}

	public ItemBuilder addOwner(String name) {
		SkullMeta smeta = (SkullMeta) meta;
		smeta.setOwner(name);
		is.setItemMeta(smeta);
		return this;
	}

	public ItemBuilder addBookEnchant(Enchantment ench, int value) {
		EnchantmentStorageMeta esm = (EnchantmentStorageMeta) meta;
		esm.addStoredEnchant(ench, value, true);
		is.setItemMeta(esm);
		return this;
	}

	public ItemBuilder addColor(Color c) {
		LeatherArmorMeta lam = (LeatherArmorMeta) meta;
		lam.setColor(c);
		is.setItemMeta(lam);
		return this;
	}

	public ItemBuilder setLore(List<String> lore) {
		meta.setLore(lore);
		return this;
	}

	public ItemBuilder hideEnchants() {
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return this;
	}

	public ItemBuilder hideAttributes() {
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		return this;
	}

	public ItemStack build() {
		is.setItemMeta(meta);
		return is;
	}

}
