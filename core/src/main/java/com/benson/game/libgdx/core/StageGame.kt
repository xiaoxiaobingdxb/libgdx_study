package com.benson.game.libgdx.core

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.StretchViewport

class StageGame: ApplicationListener {

    companion object {
        // 视口世界的宽高统使用 480 * 800, 并统一使用伸展视口（StretchViewport）
         private const val WORLD_WIDTH = 480F
        private const val WORLD_HEIGHT = 800F
    }

    private lateinit var texture: Texture

    private lateinit var myActor: MyActor
    private lateinit var stage: Stage

    override fun create() {
        // 设置 log 输出级别
        Gdx.app.logLevel = Application.LOG_DEBUG

        texture = Texture("test.png")
        myActor = MyActor(TextureRegion(texture))

        // 使用伸展视口（StretchViewport）创建舞台
        stage = Stage(StretchViewport(WORLD_WIDTH, WORLD_HEIGHT))
//        stage.addActor(myActor)
//        ActionDemo.testMoveToAction(myActor)
//        ActionDemo.testMoveByAction(myActor)
//        ActionDemo.testRotationToAction(myActor)
//        ActionDemo.testRotationByAction(myActor)
//        ActionDemo.testScaleToAction(myActor)
//        ActionDemo.testScaleByAction(myActor)
//        ActionDemo.testSizeToAction(myActor)
//        ActionDemo.testSizeByAction(myActor)
//        ActionDemo.testAlphaAction(myActor)
//        ActionDemo.testParallelAction(myActor)
//        ActionDemo.testSequenceAction(myActor)
        stage.addActor(RunAnimationActor())
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun render() {
        Gdx.gl.glClearColor(1F, 0F, 0F, 1F)
        // 清屏
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        stage.act()
        stage.draw()
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun dispose() {
        texture.dispose()
        stage.dispose()
    }
}