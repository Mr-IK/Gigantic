package click.seichi.gigantic.menu.menus

import click.seichi.gigantic.button.buttons.MenuButtons
import click.seichi.gigantic.extension.wrappedLocale
import click.seichi.gigantic.menu.Menu
import click.seichi.gigantic.message.messages.MenuMessages
import org.bukkit.entity.Player

/**
 * @author tar0ss
 */
object ProfileSkillMenu : Menu() {

    override val size: Int
        get() = 9

    override fun getTitle(player: Player): String {
        return MenuMessages.PROFILE_SKILL.asSafety(player.wrappedLocale)
    }

    init {
        registerButton(0, MenuButtons.PROFILE_SKILL_SWITCH)
        registerButton(1, MenuButtons.PROFILE_SKILL_HEAL)
        registerButton(2, MenuButtons.PROFILE_SKILL_FLASH)
        registerButton(3, MenuButtons.PROFILE_SKILL_MINEBURST)
        registerButton(4, MenuButtons.PROFILE_SKILL_TERRA_DRAIN)
    }

}