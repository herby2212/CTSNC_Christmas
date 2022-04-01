package de.Herbystar.CTSNC_Modules.Christmas;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.Herbystar.CTSNC.Main;
import de.Herbystar.CTSNC.Files.Files;
import de.Herbystar.TTA.Utils.TTA_BukkitVersion;

public class Snow extends BukkitRunnable {
		
	public Player player;
	
	public Snow(Player player) {
		this.player = player;
	}
	
	@Override
	public void run() {
		if(!player.isOnline()) {
			stop();
		}
		Location l = player.getLocation().add(0, 2.6, 0);
		if(Main.instance.getServerVersion().equalsIgnoreCase("v1_9_R1.") | Main.instance.getServerVersion().equalsIgnoreCase("v1_9_R2.") | 
				TTA_BukkitVersion.getVersionAsInt(2) >= 110) {
			l.getWorld().spawnParticle(Particle.SNOW_SHOVEL, l, 100);	
		} else {
			if(Main.instance.getServerVersion().equalsIgnoreCase("v1_8_R1.")) {
				Particles_v1_8_1.sendParticle(net.minecraft.server.v1_8_R1.EnumParticle.SNOW_SHOVEL, l, 1.2f, 0.005f, 1.2f, 0.05f, 70);
			}
			if(Main.instance.getServerVersion().equalsIgnoreCase("v1_8_R2.")) {
				Particles_v1_8_2.sendParticle(net.minecraft.server.v1_8_R2.EnumParticle.SNOW_SHOVEL, l, 1.2f, 0.005f, 1.2f, 0.05f, 70);
			}
			if(Main.instance.getServerVersion().equalsIgnoreCase("v1_8_R3.")) {
				Particles_v1_8_3.sendParticle(net.minecraft.server.v1_8_R3.EnumParticle.SNOW_SHOVEL, l, 1.2f, 0.005f, 1.2f, 0.05f, 70);
			}
		}
		if(Files.cm.getBoolean("WaterToSnow") == true) {
			Location pLoc = player.getLocation();
			Block block = pLoc.getBlock();
			Block blockBelow = new Location(player.getWorld(), pLoc.getX(), pLoc.getY() - 1.0, pLoc.getZ()).getBlock();
			if(!block.getType().isSolid()) {
				if(blockBelow.isLiquid()) {
					blockBelow.setType(Material.ICE);
				} else {
					block.setType(Material.SNOW);
				}
			}
		}
	}
	
	public void stop() {
		cancel();
		Christmas.remove(player);
	}

}
