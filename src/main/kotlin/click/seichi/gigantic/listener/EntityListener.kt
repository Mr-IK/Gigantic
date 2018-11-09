package click.seichi.gigantic.listener

import org.bukkit.entity.EntityType
import org.bukkit.entity.Mob
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntitySpawnEvent

/**
 * @author tar0ss
 */
class EntityListener : Listener {

    // モブのスポーンをキャンセル
    @EventHandler
    fun onSpawnEntity(event: EntitySpawnEvent) {
        if (event.entity !is Mob) return
        event.isCancelled = true
    }

    @EventHandler
    fun onDamege(event: EntityDamageByEntityEvent) {
        if (event.damager.type != EntityType.FIREWORK) return
        event.isCancelled = true
    }
}