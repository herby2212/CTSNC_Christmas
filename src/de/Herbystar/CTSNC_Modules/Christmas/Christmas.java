package de.Herbystar.CTSNC_Modules.Christmas;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Christmas {
	
	private static Map<Player, Snow> snows;
	public Main plugin;
	
	public Christmas(Main plugin) {
		this.plugin = plugin;
		snows = new HashMap<>();
	}
	
	public static void add(Player p) {
		snows.put(p, new Snow(p));
		snows.get(p).runTaskTimer(Main.instance, 0, 3);
	}
	
	public static void remove(Player p) {
		snows.get(p).cancel();
		snows.remove(p);
	}

	
	public static void setSantaHead(Player player) {
		ItemStack s = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	    SkullMeta m = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
	    m.setOwner("Santa");
	    m.setDisplayName("§4§lSanta");
	    s.setItemMeta(m);	
	    player.getInventory().setHelmet(s);
	}
	
	@SuppressWarnings("deprecation")
	public static void setChristmasBanner(Player player) {
		ItemStack b = new ItemStack(Material.BANNER);
		BannerMeta m = (BannerMeta) b.getItemMeta();
		m.setBaseColor(DyeColor.BLACK);
		m.setDisplayName("§6§lChristmas Tree");
		m.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_CENTER));
		m.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLE_TOP));
		m.addPattern(new Pattern(DyeColor.GREEN, PatternType.HALF_HORIZONTAL));
		m.addPattern(new Pattern(DyeColor.GREEN, PatternType.DIAGONAL_LEFT));
		m.addPattern(new Pattern(DyeColor.GREEN, PatternType.DIAGONAL_RIGHT_MIRROR));
		m.addPattern(new Pattern(DyeColor.YELLOW, PatternType.TRIANGLES_TOP));
		m.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
		m.addPattern(new Pattern(DyeColor.RED, PatternType.FLOWER));
		m.addPattern(new Pattern(DyeColor.GREEN, PatternType.CREEPER));
		m.addPattern(new Pattern(DyeColor.GREEN, PatternType.SKULL));
		b.setItemMeta(m);
		player.getInventory().setHelmet(b);
	}

}
