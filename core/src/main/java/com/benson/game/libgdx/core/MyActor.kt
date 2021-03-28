package com.benson.game.libgdx.core

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor

class MyActor(private val region: TextureRegion) : Actor() {

    init {
        setSize(region.regionWidth.toFloat(), region.regionHeight.toFloat())
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
        if (!isVisible || batch == null) {
            return
        }
        val tempBatchColor = batch.color
        val color = color
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha)
        batch.draw(
                region,
                x, y,
                originX, originY,
                width, height,
                scaleX, scaleY,
                rotation
        )
        batch.color = tempBatchColor
    }

}