package click.seichi.gigantic.menu.menus

import click.seichi.gigantic.belt.Belt
import click.seichi.gigantic.extension.wrappedLocale
import click.seichi.gigantic.item.items.menu.BeltSwitchButtons
import click.seichi.gigantic.menu.Menu
import click.seichi.gigantic.message.messages.menu.BeltSwitchMessages
import org.bukkit.ChatColor
import org.bukkit.entity.Player

/**
 * @author tar0ss
 */
object BeltSwitchSettingMenu : Menu() {

    override val size: Int
        get() = 9

    override fun getTitle(player: Player): String {
        return "${ChatColor.BLACK}" +
                BeltSwitchMessages.TITLE.asSafety(player.wrappedLocale)
    }

    init {
        Belt.values().forEachIndexed { index, belt ->
            registerButton(index, BeltSwitchButtons.BELT_SWITCHER_SETTING(belt))
        }
    }

}