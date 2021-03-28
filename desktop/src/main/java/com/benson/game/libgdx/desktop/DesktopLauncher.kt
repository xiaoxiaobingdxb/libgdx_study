package com.benson.game.libgdx.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.benson.game.libgdx.core.MainGame
import com.benson.game.libgdx.core.StageGame
import com.benson.game.libgdx.core.WidgetGame

fun main() {
    val config = LwjglApplicationConfiguration().apply {
        title = "Study_Libgdx"
        resizable = false
    }
//    LwjglApplication(MainGame(), config)
//    LwjglApplication(StageGame(), config)
    LwjglApplication(WidgetGame(), config)
}

class DesktopLauncher {


}