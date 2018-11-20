package click.seichi.gigantic.message.messages

import click.seichi.gigantic.message.ChatMessage
import click.seichi.gigantic.message.ChatMessageProtocol
import click.seichi.gigantic.message.LocalizedText
import click.seichi.gigantic.monster.SoulMonster
import org.bukkit.ChatColor
import java.util.*

/**
 * @author tar0ss
 */
object BattleMessages {

    val WIN = { monster: SoulMonster ->
        ChatMessage(ChatMessageProtocol.ACTION_BAR,
                LocalizedText(
                        Locale.JAPANESE.let {
                            it to "${ChatColor.YELLOW}" +
                                    monster.getName(it) +
                                    "を倒した!"
                        }
                ))
    }

    val SPAWN = { monster: SoulMonster ->
        ChatMessage(ChatMessageProtocol.ACTION_BAR,
                LocalizedText(
                        Locale.JAPANESE.let {
                            it to "${ChatColor.LIGHT_PURPLE}${ChatColor.BOLD}" +
                                    monster.getName(it) +
                                    " が出現!!"
                        }
                ))
    }

    val DAMEGE = { monster: SoulMonster, damage: Long ->
        ChatMessage(ChatMessageProtocol.ACTION_BAR,
                LocalizedText(
                        Locale.JAPANESE.let {
                            it to "${ChatColor.LIGHT_PURPLE}${ChatColor.BOLD}" +
                                    monster.getName(it) +
                                    " から $damage のダメージを受けた"
                        }
                ))
    }

}