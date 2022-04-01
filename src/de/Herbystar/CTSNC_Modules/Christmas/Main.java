package de.Herbystar.CTSNC_Modules.Christmas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static Christmas cm;
		
	public void onEnable() {
		sendMerryChristmas();
		instance = this;
		cm = new Christmas(instance);
	}
	
	public void onDisable() {
		
	}
	
	private void sendMerryChristmas() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§c[§eCTSNC-Christmas§c] §6§l# §c§lM§f§le§c§lr§f§lr§c§ly "
				+ "§f§lC§c§lh§f§lr§c§li§f§ls§c§lt§f§lm§c§la§f§ls §6§l#");
		Bukkit.getConsoleSender().sendMessage("");
	}

}
