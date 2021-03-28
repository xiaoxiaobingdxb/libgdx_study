package com.benson.game.libgdx.core

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.ui.List
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.benson.game.libgdx.font.GdxFont
import com.benson.game.libgdx.quick.QuickGameApplication
import kotlin.math.min

class WidgetGame: QuickGameApplication() {

    private lateinit var img: Image
    private lateinit var label: Label
    private lateinit var btn: Button
    private lateinit var checkBox: CheckBox
    private lateinit var text: TextField
    private lateinit var list: List<String>

    private lateinit var stage: Stage

    override fun create() {
        super.create()
        img = Image(Texture("test.png"))
        label = Label("label", Label.LabelStyle().apply {
            font = GdxFont.REGULAR_26
            fontColor = Color.BLACK
        })
        btn = Button(Button.ButtonStyle())
        checkBox = CheckBox("", CheckBox.CheckBoxStyle().apply {
            font = GdxFont.REGULAR_26
        })
        text = TextField("test", TextField.TextFieldStyle().apply {
            font = GdxFont.REGULAR_26
            fontColor = Color.BLACK
        })
        list = List(List.ListStyle().apply {
            font = GdxFont.REGULAR_26
            selection = TiledDrawable(TextureRegion(Texture(Pixmap(10, 10, Pixmap.Format.RGB888).apply {
                setColor(1F, 1F, 1F, 1F)
                fill()
                setColor(Color.RED)
                drawCircle(width / 2, height / 2, min(width, height) / 2) // 画一个半径为宽高较小的一半的圆
            })))
        })
        list.setItems(*Array(10) {index -> "$index"})

        stage = Stage(StretchViewport(WORLD_WIDTH, WORLD_HEIGHT))
        stage.addActor(VerticalGroup().apply {
            width = WORLD_WIDTH
            height = WORLD_HEIGHT
            addActor(img)
            addActor(label)
            addActor(btn)
            addActor(checkBox)
            addActor(text)
            addActor(list)
        })
    }

    override fun render() {
        super.render()
        stage.act()
        stage.draw()
    }

    override fun dispose() {
        super.dispose()
        stage.dispose()
    }

}