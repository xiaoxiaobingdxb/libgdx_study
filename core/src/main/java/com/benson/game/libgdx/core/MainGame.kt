package com.benson.game.libgdx.core

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MainGame: ApplicationListener {

    private lateinit var batch: Batch
    private lateinit var texture: Texture

    override fun create() {
        batch = SpriteBatch()
        texture = Texture("test.png")
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun render() {
        Gdx.gl.glClearColor(1F, 0F, 0F, 1F)

        // 清屏
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(texture, 0F, 0F)
        batch.end()
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun dispose() {
        batch.dispose();
        texture.dispose();
    }
}