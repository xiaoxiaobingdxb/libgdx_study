package com.benson.game.libgdx.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor

/**
 * @author dengxiaobing
 * @date 2021/3/25 10:09 上午
 * @description 用动画实现小人跑步效果
 */
class RunAnimationActor : Actor() {

    companion object {
        private const val ROW_SIZE = 5 // 5行
        private const val COLUMN_SIZE = 6 // 6列
    }

    private var runAnimation: Animation<TextureRegion>
    private lateinit var currentFrame: TextureRegion

    // 状态时间, 渲染时间步 delta 的累加值
    private var stateTime = 0f

    init {
        val texture = Texture("run.png")
        val frames = TextureRegion.split(texture,
                texture.width / COLUMN_SIZE,
                texture.height / ROW_SIZE)
                .flatMap { it.toList() }
        runAnimation = Animation(0.05F, *frames.toTypedArray()).apply {
            playMode = Animation.PlayMode.LOOP
        }
        setSize(texture.width.toFloat() / COLUMN_SIZE, texture.height.toFloat() / ROW_SIZE)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
        if (!isVisible || batch == null) {
            return
        }
        // 累加时间步（stateTime 也可表示游戏的运行时间）
        stateTime += Gdx.graphics.deltaTime

        // 根据当前 播放模式 获取当前关键帧, 就是在 stateTime 这个时刻应该播放哪一帧
        currentFrame = runAnimation.getKeyFrame(stateTime)


        // 绘制当前关键帧
        batch.draw(currentFrame, 50F, 100F)
    }

}