package click.seichi.gigantic.animation.animations.effect

import click.seichi.gigantic.animation.Animation
import org.bukkit.Material
import org.bukkit.Particle

/**
 * @author tar0ss
 */
object ApostolAnimations {

    val EXPLOSION = Animation(0) { location, _ ->
        location.world.spawnParticle(Particle.EXPLOSION_NORMAL, location, 1)
    }

    val BLIZZARD = Animation(0) { location, _ ->
        location.world.spawnParticle(Particle.BLOCK_CRACK, location, 1, Material.PACKED_ICE.createBlockData())
    }

    val MAGIC = Animation(0) { location, _ ->
        location.world.spawnParticle(Particle.NOTE, location, 1)
    }

    val FLAME = Animation(0) { location, _ ->
        location.world.spawnParticle(Particle.FLAME, location, 4)
    }

    val WITCH_SCENT = Animation(0) { location, _ ->
        location.world.spawnParticle(Particle.SPELL_WITCH, location, 3)
    }

    val SLIME = Animation(0) { location, _ ->
        location.world.spawnParticle(Particle.SLIME, location, 1)
    }

    val BUBBLE = Animation(0) { location, _ ->
        location.world.spawnParticle(Particle.BUBBLE_POP, location, 1)
    }


}