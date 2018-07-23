package click.seichi.gigantic.player.defalutInventory.inventories

import click.seichi.gigantic.player.defalutInventory.DefaultInventory
import org.bukkit.Location
import java.util.*

/**
 * @author tar0ss
 */
object MainInventory : DefaultInventory() {

    val lastLocationMap = mutableMapOf<UUID, Location>()

    override val slotItemMap: Map<Int, SlotItem> = mapOf(
//            9 to object : SlotItem {
//                override fun getItemStack(player: Player): ItemStack? {
//                    return player.getHead().apply {
//                        setDisplayName(
//                                MenuMessages.PROFILE.asSafety(player.wrappedLocale)
//                        )
//                    }
//                }
//
//                override fun onClick(player: Player, event: InventoryClickEvent) {
//                }
//            },
//            19 to object : SlotItem {
//                override fun getItemStack(player: Player): ItemStack? {
//                    val gPlayer = player.gPlayer ?: return null
//                    if (!LockedFunction.RAID_BATTLE.isUnlocked(gPlayer)) return null
//                    return RaidManager.getBattleList().first().boss.head.toItemStack().apply {
//                        setDisplayName(
//                                MenuMessages.RAID_BOSS.asSafety(player.wrappedLocale)
//                        )
//                    }
//                }
//
//                override fun onClick(player: Player, event: InventoryClickEvent) {
//                    val gPlayer = player.gPlayer ?: return
//                    if (!LockedFunction.RAID_BATTLE.isUnlocked(gPlayer)) return
//                    if (event.inventory.holder === RaidBattleMenu) return
//                    RaidBattleMenu.open(player)
//                }
//            }
//            ,
//            25 to object : SlotItem {
//                override fun getItemStack(player: Player): ItemStack? {
//                    return ItemStack(Material.RED_ROSE, 1, 8).apply {
//                        when (player.gameMode) {
//                            GameMode.SURVIVAL -> setDisplayName(
//                                    MenuMessages.REST.asSafety(player.wrappedLocale)
//                            )
//                            GameMode.SPECTATOR -> setDisplayName(
//                                    MenuMessages.BACK_FROM_REST.asSafety(player.wrappedLocale)
//                            )
//                        }
//                    }
//                }
//
//                override fun onClick(player: Player, event: InventoryClickEvent) {
//                    val gPlayer = player.gPlayer ?: return
//                    when (player.gameMode) {
//                        GameMode.SURVIVAL -> {
//                            player.gameMode = GameMode.SPECTATOR
//                            lastLocationMap[player.uniqueId] = player.location
//                            gPlayer.defaultInventory.update(player)
//                        }
//                        GameMode.SPECTATOR -> {
//                            player.gameMode = GameMode.SURVIVAL
//                            lastLocationMap.remove(player.uniqueId)?.run {
//                                player.teleport(this)
//                            }
//                            gPlayer.defaultInventory.update(player)
//                        }
//                    }
//                }
//
//            }
    )

}