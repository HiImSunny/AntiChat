package vn.sunext.chatmanager.functions;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ParticleSystem {

    public void onParticles1(Player p) {
        p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 50000F, 1F);
        p.spawnParticle(Particle.MOB_APPEARANCE, p.getLocation(), 50, 0.5, 0.5, 0.5, 0.5);
        p.spawnParticle(Particle.VILLAGER_ANGRY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
        p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
        p.spawnParticle(Particle.NOTE, p.getLocation(), 60, 2.0, 2.0, 2.0, 2.0);
    }

    public void onParticles2(Player p) {
        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 50000F, 1F);
        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 50000F, 1F);
        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 50000F, 1F);
        p.playSound(p.getLocation(), Sound.ENTITY_DONKEY_DEATH, 50000F, 1F);
        p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 50000F, 1F);
        p.spawnParticle(Particle.MOB_APPEARANCE, p.getLocation(), 50, 0.5, 0.5, 0.5, 0.5);
        p.spawnParticle(Particle.VILLAGER_ANGRY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
        p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
        p.spawnParticle(Particle.NOTE, p.getLocation(), 60, 2.0, 2.0, 2.0, 2.0);
    }

}
