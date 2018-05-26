package linxx.luckyblocks.misc;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import linxx.luckyblocks.api.API;
import linxx.luckyblocks.api.EventType;
import linxx.luckyblocks.api.LuckyEvent;
import linxx.luckyblocks.main.LuckyBlocks;
import linxx.luckyblocks.runnables.RedstoneTNT;
import net.md_5.bungee.api.ChatColor;

public class LuckyEvents {
	

	LuckyBlocks plugin;
	Random r = new Random();

	public LuckyEvents(LuckyBlocks main) {
		plugin = main;
	}

	@SuppressWarnings("rawtypes")
	public void addEvents() {
		try {
			Class[] commandArg = new Class[1];
			commandArg[0] = BlockBreakEvent.class;
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("Diamond", plugin.luckyEvents.getClass().getMethod("Diamonds", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("LuckySword", plugin.luckyEvents.getClass().getMethod("LuckySword", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("LuckyPotion", plugin.luckyEvents.getClass().getMethod("LuckyPotion", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("IronTools", plugin.luckyEvents.getClass().getMethod("IronTools", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("UnluckyPotion", plugin.luckyEvents.getClass().getMethod("UnluckyPotion", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("Bedrock", plugin.luckyEvents.getClass().getMethod("Bedrock", commandArg), plugin.luckyEvents, EventType.UNLUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("LuckyHelmet", plugin.luckyEvents.getClass().getMethod("LuckyHelmet", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("LuckyChest", plugin.luckyEvents.getClass().getMethod("LuckyChest", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("LuckyLeggings", plugin.luckyEvents.getClass().getMethod("LuckyLeggings", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("LuckyBoots", plugin.luckyEvents.getClass().getMethod("LuckyBoots", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("ObsidianJail", plugin.luckyEvents.getClass().getMethod("ObsidianBlock", commandArg), plugin.luckyEvents, EventType.UNLUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("SaddleDrop", plugin.luckyEvents.getClass().getMethod("SaddleDrop", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("EnderChestDrop", plugin.luckyEvents.getClass().getMethod("EnderChestDrop", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("ObsidianDrop", plugin.luckyEvents.getClass().getMethod("ObsidianDrop", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("RedstoneTNT", plugin.luckyEvents.getClass().getMethod("RedstoneTnt", commandArg), plugin.luckyEvents, EventType.UNLUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("GiantZombie", plugin.luckyEvents.getClass().getMethod("GiantZombie", commandArg), plugin.luckyEvents, EventType.UNLUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("dropRandomOre", plugin.luckyEvents.getClass().getMethod("dropRandomOre", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("SummonXPBottles", plugin.luckyEvents.getClass().getMethod("SummonXPBottles", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("BucketDrop", plugin.luckyEvents.getClass().getMethod("BucketDrop", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("DropGoldApples", plugin.luckyEvents.getClass().getMethod("DropGoldApples", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("ChickenDrop", plugin.luckyEvents.getClass().getMethod("ChickenDrop", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("CakeDrop", plugin.luckyEvents.getClass().getMethod("CakeDrop", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("BeefDrop", plugin.luckyEvents.getClass().getMethod("BeefDrop", commandArg), plugin.luckyEvents, EventType.LUCKY));
			API.GET_INSTANCE().addLuckyEvent(new LuckyEvent("StoneTools", plugin.luckyEvents.getClass().getMethod("StoneTools", commandArg), plugin.luckyEvents, EventType.LUCKY));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

	public void Diamonds(BlockBreakEvent e) {
		ItemStack is = new ItemStack(Material.DIAMOND, 9);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.BLACK + "DIAMONDS");
		is.setItemMeta(im);
		e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
	}

	public void LuckySword(BlockBreakEvent e) {

		ItemStack is = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta im = is.getItemMeta();
		im.addEnchant(Enchantment.DAMAGE_ALL, r.nextInt(2) + 3, true);
		im.addEnchant(Enchantment.DURABILITY, r.nextInt(2) + 1, true);
		im.addEnchant(Enchantment.FIRE_ASPECT, r.nextInt(2), false);
		im.setDisplayName(ChatColor.RED + "LuckySword");
		is.setItemMeta(im);
		e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
	}

	@SuppressWarnings("deprecation")
	public void LuckyPotion(BlockBreakEvent e) {
		ItemStack is = new ItemStack(Material.SPLASH_POTION, 1);
		PotionMeta pm = (PotionMeta) is.getItemMeta();
		pm.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 4 * 60 * 20, r.nextInt(1)), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 4 * 60 * 20, r.nextInt(4)), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 4 * 60 * 20, r.nextInt(4)), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 4 * 60 * 20, 1), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 4 * 60 * 20, r.nextInt(5)), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5 * 60 * 20, 1), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 5 * 60 * 20, 1), true);
		pm.setMainEffect(PotionEffectType.REGENERATION);
		pm.setDisplayName(ChatColor.GREEN + "Lucky-Potion");
		is.setItemMeta(pm);
		e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
	}

	public void IronTools(BlockBreakEvent e) {
		e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_PICKAXE, 1));
		e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_SPADE, 1));
		e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_SWORD, 1));
	}

	@SuppressWarnings("deprecation")
	public void UnluckyPotion(BlockBreakEvent e) {
		ItemStack is = new ItemStack(Material.SPLASH_POTION, 1);
		PotionMeta pm = (PotionMeta) is.getItemMeta();
		pm.setMainEffect(PotionEffectType.HARM);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 0, r.nextInt(3)), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 4 * 60 * 20, r.nextInt(2)), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 4 * 60 * 20, 1), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 4 * 60 * 20, 1), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.HUNGER, 4 * 60 * 20, r.nextInt(3)), true);
		pm.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 4 * 60 * 20, r.nextInt(2)), true);
		is.setItemMeta(pm);
		e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
	}

	@SuppressWarnings("deprecation")
	public void Bedrock(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.add(0, 10, 0);
		e.getBlock().getWorld().spawnFallingBlock(loc, Material.BEDROCK, (byte) 0);
		String msg = plugin.messagecfg.getString("events.bedrock");
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		e.getPlayer().sendMessage(msg);

	}

	public void LuckyHelmet(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		ItemBuilder ib = new ItemBuilder(Material.GOLD_HELMET);
		ib.addEnchantment(Enchantment.DURABILITY, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FALL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FIRE, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_PROJECTILE, r.nextInt(5));
		loc.getWorld().dropItemNaturally(loc, ib.build());
	}

	public void LuckyChest(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		ItemBuilder ib = new ItemBuilder(Material.GOLD_CHESTPLATE);
		ib.addEnchantment(Enchantment.DURABILITY, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FALL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FIRE, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_PROJECTILE, r.nextInt(5));
		loc.getWorld().dropItemNaturally(loc, ib.build());
	}

	public void LuckyLeggings(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		ItemBuilder ib = new ItemBuilder(Material.GOLD_LEGGINGS);
		ib.addEnchantment(Enchantment.DURABILITY, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FALL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FIRE, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_PROJECTILE, r.nextInt(5));
		loc.getWorld().dropItemNaturally(loc, ib.build());
	}

	public void LuckyBoots(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		ItemBuilder ib = new ItemBuilder(Material.GOLD_BOOTS);
		ib.addEnchantment(Enchantment.DURABILITY, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FALL, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_FIRE, r.nextInt(5));
		ib.addEnchantment(Enchantment.PROTECTION_PROJECTILE, r.nextInt(5));
		ib.addEnchantment(Enchantment.FROST_WALKER, r.nextInt(1));
		loc.getWorld().dropItemNaturally(loc, ib.build());
	}
	
	public void ObsidianBlock(BlockBreakEvent e) {
		Player p = e.getPlayer();
		World w = e.getPlayer().getWorld();
		new Location(w, p.getLocation().getX(), p.getLocation().getY() + 2, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() + 2, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() + 2, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY() + 2, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY() + 2, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() + 2, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() + 2, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() + 2, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() + 2, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		
		new Location(w, p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() - 1, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() - 1, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() - 1, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() - 1, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() - 1, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() - 1, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY(), p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY(), p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY(), p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY(), p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY(), p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY(), p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() + 1, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() + 1, p.getLocation().getZ()).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() + 1, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() + 1, p.getLocation().getY() + 1, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() + 1, p.getLocation().getZ() - 1).getBlock().setType(Material.OBSIDIAN);
		new Location(w, p.getLocation().getX() - 1, p.getLocation().getY() + 1, p.getLocation().getZ() + 1).getBlock().setType(Material.OBSIDIAN);
		
		new Location(w, p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ()).getBlock().setType(Material.WATER);
		new Location(w, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ()).getBlock().setType(Material.WATER);
	}
	
	public void SaddleDrop(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.SADDLE, 2).build());
	}
	
	public void EnderChestDrop(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.ENDER_CHEST, 2).build());
	}
	public void ObsidianDrop(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.OBSIDIAN, new Random().nextInt(20)).build());
	}
	@SuppressWarnings("deprecation")
	public void RedstoneTnt(BlockBreakEvent e) {

		Location loc = e.getBlock().getLocation();
		loc.add(0, 10, 0);
		RedstoneTNT rtnt = new RedstoneTNT(plugin, loc);
	}
	
	public void GiantZombie(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().spawnEntity(loc, EntityType.GIANT);
	}
	public void dropRandomOre(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.DIAMOND, new Random().nextInt(20)).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.EMERALD, new Random().nextInt(20)).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.IRON_INGOT, new Random().nextInt(20)).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.GOLD_INGOT, new Random().nextInt(20)).build());
	}
	public void SummonXPBottles(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.add(0, 5, 0);
		for(int i = 0; i<10; i++) {
			loc.getWorld().spawnEntity(loc, EntityType.THROWN_EXP_BOTTLE);
		}
	}
	
	
	
	
	
	
	
	
	public void BucketDrop(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.BUCKET, new Random().nextInt(3)).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.LAVA_BUCKET, new Random().nextInt(3)).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.WATER_BUCKET, new Random().nextInt(3)).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.MILK_BUCKET, new Random().nextInt(3)).build());
	}
	
	public void CakeDrop(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.BUCKET, new Random().nextInt(5)).build());

	}
	public void DropGoldApples(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.GOLDEN_APPLE, new Random().nextInt(3)).build());
		loc.getWorld().dropItem(loc, new ItemStack(Material.GOLDEN_APPLE, new Random().nextInt(3), (short) 1));
		
		
	}
	public void ChickenDrop(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.RAW_CHICKEN, new Random().nextInt(30)).build());
		loc.getWorld().dropItem(loc, new ItemStack(Material.COOKED_CHICKEN, new Random().nextInt(30), (short) 1));
	}
	public void BeefDrop(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.RAW_BEEF, new Random().nextInt(30)).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.COOKED_BEEF, new Random().nextInt(30)).build());
	}
	public void StoneTools(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.STONE_AXE, 1).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.STONE_HOE, 1).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.STONE_PICKAXE, 1).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.STONE_SPADE, 1).build());
		loc.getWorld().dropItem(loc, new ItemBuilder(Material.STONE_SWORD, 1).build());
	}
}
