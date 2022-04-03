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

import de.Herbystar.CTSNC_Modules.Christmas.Utilities.XMaterial;

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

	
	@SuppressWarnings("deprecation")
	public static void setSantaHead(Player player) {
		ItemStack s = XMaterial.PLAYER_HEAD.parseItem();
	    SkullMeta m = (SkullMeta)Bukkit.getItemFactory().getItemMeta(XMaterial.PLAYER_HEAD.parseMaterial());
	    try {
		    m.setOwningPlayer(Bukkit.getOfflinePlayer("Santa"));
	    } catch(NoSuchMethodError ex) {
	    	m.setOwner("Santa");
	    }
	    m.setDisplayName("§4§lSanta");
	    s.setItemMeta(m);
	    player.getInventory().setHelmet(s);
	}
	
	@SuppressWarnings("deprecation")
	public static void setChristmasBanner(Player player) {
		Material mat = XMaterial.BLACK_BANNER.parseMaterial();
		if(!XMaterial.isNewVersion()) {
			mat = Material.valueOf("BANNER");
		}
		ItemStack b = new ItemStack(mat);
		BannerMeta m = (BannerMeta) b.getItemMeta();
		m.setDisplayName("§6§lChristmas Tree");
		m.setBaseColor(DyeColor.BLACK);
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
