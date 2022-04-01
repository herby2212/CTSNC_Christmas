package de.Herbystar.CTSNC_Modules.Christmas;
 
import net.minecraft.server.v1_8_R2.EnumParticle;
import net.minecraft.server.v1_8_R2.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
 
 
public class Particles_v1_8_2 {
 
    public static void sendParticle(EnumParticle type, Location loc, float xOffset, float yOffset, float zOffset,
            float speed, int count) {
        float x = (float) loc.getX();
        float y = (float) loc.getY();
        float z = (float) loc.getZ();
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, x, y, z, xOffset, yOffset,
                zOffset, speed, count, null);
        for (Player p : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }
 
    public static void sendParticle(EnumParticle type, double x, double y, double z, float xOffset, float yOffset,
            float zOffset, float speed, int count) {
        float xf = (float) x;
        float yf = (float) y;
        float zf = (float) y;
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, xf, yf, zf, xOffset, yOffset,
                zOffset, speed, count, null);
        for (Player p : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }
 
    public static void sendParticleTo(EnumParticle type, Player p, Location loc, float xOffset, float yOffset,
            float zOffset, float speed, int count) {
        float x = (float) loc.getX();
        float y = (float) loc.getY();
        float z = (float) loc.getZ();
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, x, y, z, xOffset, yOffset,
                zOffset, speed, count, null);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }
 
    public static void sendParticleTo(EnumParticle type, Player p, double x, double y, double z, float xOffset,
            float yOffset, float zOffset, float speed, int count) {
        float xf = (float) x;
        float yf = (float) y;
        float zf = (float) y;
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, xf, yf, zf, xOffset, yOffset,
                zOffset, speed, count, null);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
 
    }
 
}