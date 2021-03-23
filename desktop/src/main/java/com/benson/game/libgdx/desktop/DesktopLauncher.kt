package com.benson.game.libgdx.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.benson.game.libgdx.core.MainGame

fun main() {
    val config = LwjglApplicationConfiguration().apply {
        title = "Study_Libgdx"
        resizable = false
    }
    LwjglApplication(MainGame(), config)
}

class DesktopLauncher {


}