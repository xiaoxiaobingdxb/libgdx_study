package com.benson.game.libgdx.quick

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

open class QuickGameApplication : ApplicationAdapter() {

    companion object {
        // 视口世界的宽高统使用 480 * 800, 并统一使用伸展视口（StretchViewport）
        const val WORLD_WIDTH = 480F
        const val WORLD_HEIGHT = 800F
    }

    override fun render() {
        super.render()
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F)
        // 清屏
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

}