package com.benson.game.libgdx.font

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.BitmapFont

object GdxFont {

    val REGULAR_26 by lazy {
        BitmapFont(Gdx.app.files.internal("Amble-Regular-26.fnt"))
    }

}