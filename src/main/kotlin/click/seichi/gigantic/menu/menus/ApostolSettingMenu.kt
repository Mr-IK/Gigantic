package click.seichi.gigantic.menu.menus

import click.seichi.gigantic.breaker.spells.Apostol
import click.seichi.gigantic.cache.key.Keys
import click.seichi.gigantic.config.Config
import click.seichi.gigantic.extension.*
import click.seichi.gigantic.item.Button
import click.seichi.gigantic.item.items.menu.BackButton
import click.seichi.gigantic.menu.Menu
import click.seichi.gigantic.message.messages.MenuMessages
import click.seichi.gigantic.message.messages.menu.ApostolMenuMessages
import click.seichi.gigantic.sound.sounds.PlayerSounds
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

/**
 * @author tar0ss
 */
object ApostolSettingMenu : Menu() {

    override val size: Int
        get() = 3 * 9

    override fun getTitle(player: Player): String {
        return ApostolMenuMessages.TITLE.asSafety(player.wrappedLocale)
    }

    init {
        // 戻るボタン
        registerButton(0, BackButton(this, SpellMenu))

        registerButton(11, object : Button {
            override fun findItemStack(player: Player): ItemStack? {
                return ItemStack(Material.DIAMOND_PICKAXE).apply {
                    setDisplayName(ApostolMenuMessages.CURRENT_AREA.asSafety(player.wrappedLocale))

                    val breakArea = player.getOrPut(Keys.SPELL_APOSTOL_BREAK_AREA)
                    val limitOfBreakNum = Apostol.calcLimitOfBreakNumOfApostol(player.maxMana)

                    setLore(*ApostolMenuMessages.CURRENT_AREA_LORE(breakArea)
                            .map { it.asSafety(player.wrappedLocale) }
                            .toTypedArray())

                    addLore(MenuMessages.LINE)

                    addLore(ApostolMenuMessages.LIMIT_SIZE.asSafety(player.wrappedLocale))

                    addLore(*ApostolMenuMessages.LIMIT_OF_BREAK_NUM_LORE(limitOfBreakNum)
                            .map { it.asSafety(player.wrappedLocale) }
                            .toTypedArray())

                    itemMeta = itemMeta.apply {
                        addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    }
                }
            }

            override fun onClick(player: Player, event: InventoryClickEvent) {
                reopen(player)
            }

        })

        // 横幅変更（上げる）
        registerButton(12, object : Button {
            override fun findItemStack(player: Player): ItemStack? {
                return ItemStack(Material.YELLOW_STAINED_GLASS_PANE).apply {
                    val breakArea = player.getOrPut(Keys.SPELL_APOSTOL_BREAK_AREA)
                    val nextBreakArea = breakArea.add(2, 0, 0)
                    val limitOfBreakNum = Apostol.calcLimitOfBreakNumOfApostol(player.maxMana)

                    if (nextBreakArea.calcBreakNum() > limitOfBreakNum) {
                        setDisplayName(ApostolMenuMessages.LIMIT_OF_BREAK_NUM.asSafety(player.wrappedLocale))
                    } else {
                        setDisplayName(ApostolMenuMessages.BIGGER_WIDTH(breakArea).asSafety(player.wrappedLocale))
                    }
                }
            }


            override fun onClick(player: Player, event: InventoryClickEvent) {
                player.transform(Keys.SPELL_APOSTOL_BREAK_AREA) { breakArea ->
                    val nextBreakArea = breakArea.add(2, 0, 0)
                    val limitOfBreakNum = Apostol.calcLimitOfBreakNumOfApostol(player.maxMana)
                    if (nextBreakArea.width in 1..Config.SPELL_APOSTOL_LIMIT_SIZE &&
                            nextBreakArea.calcBreakNum() <= limitOfBreakNum) {
                        PlayerSounds.TOGGLE.playOnly(player)
                        nextBreakArea
                    } else {
                        PlayerSounds.FAIL.playOnly(player)
                        breakArea
                    }
                }
                reopen(player)
            }

        })
        // 横幅変更（下げる）
        registerButton(10,
                object : Button {
                    override fun findItemStack(player: Player): ItemStack? {
                        return ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE).apply {
                            val breakArea = player.getOrPut(Keys.SPELL_APOSTOL_BREAK_AREA)
                            setDisplayName(ApostolMenuMessages.SMALLER_WIDTH(breakArea).asSafety(player.wrappedLocale))
                        }
                    }

                    override fun onClick(player: Player, event: InventoryClickEvent) {
                        player.transform(Keys.SPELL_APOSTOL_BREAK_AREA) { breakArea ->
                            val nextBreakArea = breakArea.add(-2, 0, 0)
                            if (nextBreakArea.width > 0) {
                                PlayerSounds.TOGGLE.playOnly(player)
                                nextBreakArea
                            } else {
                                PlayerSounds.FAIL.playOnly(player)
                                breakArea
                            }
                        }
                        reopen(player)
                    }

                })

        // 高さ変更（上げる）
        registerButton(2,
                object : Button {
                    override fun findItemStack(player: Player): ItemStack? {
                        return ItemStack(Material.ORANGE_STAINED_GLASS_PANE).apply {
                            val breakArea = player.getOrPut(Keys.SPELL_APOSTOL_BREAK_AREA)
                            val nextBreakArea = breakArea.add(0, 1, 0)
                            val limitOfBreakNum = Apostol.calcLimitOfBreakNumOfApostol(player.maxMana)

                            if (nextBreakArea.calcBreakNum() > limitOfBreakNum) {
                                setDisplayName(ApostolMenuMessages.LIMIT_OF_BREAK_NUM.asSafety(player.wrappedLocale))
                            } else {
                                setDisplayName(ApostolMenuMessages.BIGGER_HEIGHT(breakArea).asSafety(player.wrappedLocale))
                            }
                        }
                    }

                    override fun onClick(player: Player, event: InventoryClickEvent) {
                        player.transform(Keys.SPELL_APOSTOL_BREAK_AREA) { breakArea ->
                            val nextBreakArea = breakArea.add(0, 1, 0)
                            val limitOfBreakNum = Apostol.calcLimitOfBreakNumOfApostol(player.maxMana)
                            if (nextBreakArea.height in 1..Config.SPELL_APOSTOL_LIMIT_SIZE && nextBreakArea.calcBreakNum() <= limitOfBreakNum) {
                                PlayerSounds.TOGGLE.playOnly(player)
                                nextBreakArea
                            } else {
                                PlayerSounds.FAIL.playOnly(player)
                                breakArea
                            }
                        }
                        reopen(player)
                    }

                })
        // 高さ変更（下げる）
        registerButton(20,
                object : Button {
                    override fun findItemStack(player: Player): ItemStack? {
                        return ItemStack(Material.PINK_STAINED_GLASS_PANE).apply {
                            val breakArea = player.getOrPut(Keys.SPELL_APOSTOL_BREAK_AREA)
                            setDisplayName(ApostolMenuMessages.SMALLER_HEIGHT(breakArea).asSafety(player.wrappedLocale))
                        }
                    }

                    override fun onClick(player: Player, event: InventoryClickEvent) {
                        player.transform(Keys.SPELL_APOSTOL_BREAK_AREA) { breakArea ->
                            val nextBreakArea = breakArea.add(0, -1, 0)
                            if (nextBreakArea.height > 0) {
                                PlayerSounds.TOGGLE.playOnly(player)
                                nextBreakArea
                            } else {
                                PlayerSounds.FAIL.playOnly(player)
                                breakArea
                            }
                        }
                        reopen(player)
                    }

                })

        // 奥行変更（上げる）
        registerButton(3,
                object : Button {
                    override fun findItemStack(player: Player): ItemStack? {
                        return ItemStack(Material.MAGENTA_STAINED_GLASS_PANE).apply {
                            val breakArea = player.getOrPut(Keys.SPELL_APOSTOL_BREAK_AREA)
                            val nextBreakArea = breakArea.add(0, 0, 1)
                            val limitOfBreakNum = Apostol.calcLimitOfBreakNumOfApostol(player.maxMana)

                            if (nextBreakArea.calcBreakNum() > limitOfBreakNum) {
                                setDisplayName(ApostolMenuMessages.LIMIT_OF_BREAK_NUM.asSafety(player.wrappedLocale))
                            } else {
                                setDisplayName(ApostolMenuMessages.BIGGER_DEPTH(breakArea).asSafety(player.wrappedLocale))
                            }
                        }
                    }

                    override fun onClick(player: Player, event: InventoryClickEvent) {
                        player.transform(Keys.SPELL_APOSTOL_BREAK_AREA) { breakArea ->
                            val nextBreakArea = breakArea.add(0, 0, 1)
                            val limitOfBreakNum = Apostol.calcLimitOfBreakNumOfApostol(player.maxMana)
                            if (nextBreakArea.depth in 1..Config.SPELL_APOSTOL_LIMIT_SIZE && nextBreakArea.calcBreakNum() <= limitOfBreakNum) {
                                PlayerSounds.TOGGLE.playOnly(player)
                                nextBreakArea
                            } else {
                                PlayerSounds.FAIL.playOnly(player)
                                breakArea
                            }
                        }
                        reopen(player)
                    }

                })
        // 奥行変更（下げる）
        registerButton(19,
                object : Button {
                    override fun findItemStack(player: Player): ItemStack? {
                        return ItemStack(Material.LIME_STAINED_GLASS_PANE).apply {
                            val breakArea = player.getOrPut(Keys.SPELL_APOSTOL_BREAK_AREA)
                            setDisplayName(ApostolMenuMessages.SMALLER_DEPTH(breakArea).asSafety(player.wrappedLocale))
                        }
                    }

                    override fun onClick(player: Player, event: InventoryClickEvent) {
                        player.transform(Keys.SPELL_APOSTOL_BREAK_AREA) { breakArea ->
                            val nextBreakArea = breakArea.add(0, 0, -1)
                            if (nextBreakArea.depth > 0) {
                                PlayerSounds.TOGGLE.playOnly(player)
                                nextBreakArea
                            } else {
                                PlayerSounds.FAIL.playOnly(player)
                                breakArea
                            }
                        }
                        reopen(player)
                    }

                })
    }

}