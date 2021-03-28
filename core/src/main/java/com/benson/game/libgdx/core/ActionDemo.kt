package com.benson.game.libgdx.core

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.actions.Actions

/**
 * @author dengxiaobing
 * @date 2021/3/25 9:18 上午
 * @description 动作执行原理（查看 Actor 和相应 Action 的源码）:
 *
 * 实际上动作添加到演员身上的后, 动作被存放到一个数组中, 然后在更新演员逻辑的 actor.act()方法中遍历存放动作的数组,
 * 对每一个动作根据时间步 delta 改变演员相应的状态属性值。然后在绘制演员的 actor.draw() 方法中绘制演员时使用新的
 * 状态属性值绘制, 和上一帧相比, 就显的演员被“动”起来了。
 */
object ActionDemo {

    /**
     * actor初始化位置设置显示到stage中心
     */
    private fun moveToStageCenter(actor: Actor) {
        actor.setPosition(
                actor.stage.width / 2 - actor.width / 2,
                actor.stage.height / 2 - actor.height / 2
        )
    }

    /**
     * actor初始化位置设置到stage的坐标原点
     */
    private fun moveToZero(actor: Actor) {
        actor.setPosition(0F, 0F)
    }

    /**
     * 设置actor旋转中心为actor的中心
     */
    private fun originCenter(actor: Actor) {
        actor.setOrigin(actor.width / 2, actor.height / 2)
    }

    /**
     * 1. 移动动作(绝对)
     */
    fun testMoveToAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToZero(actor)
        }

        // 获取一个 MoveTo 动作, 3 秒内移动到 (150, 300) 的位置
        val action = Actions.moveTo(150F, 300F, 3.0F)

        // 将动作附加在actor身上, 执行动作
        actor.addAction(action)
    }

    /**
     * 2. 移动动作（相对）
     */
    fun testMoveByAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToStageCenter(actor)
        }

        // 获取一个 MoveBy 动作
        // 2 秒内, 在actor在原位置基础上, 水平方向移动 100, 竖直方向移动 -200
        val action = Actions.moveBy(100F, -200F, 2.0F)

        // 将动作附近在actor身上, 执行动作
        actor.addAction(action)
    }

    /**
     * 3.旋转动作（绝对）
     */
    fun testRotationToAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToStageCenter(actor)
            originCenter(actor)
        }


        // 初始角度为-90度
        actor.rotation = -90F

        // 2s内从-90度旋转到-270度
        val action = Actions.rotateTo(-270F, 2F)
        actor.addAction(action)

    }

    /**
     * 4.旋转动作（相对）
     */
    fun testRotationByAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToStageCenter(actor)
            originCenter(actor)
        }

        // 初始角度为-90度
        actor.rotation = -90F

        // 2s内旋转45度
        val action = Actions.rotateBy(-45F, 2F)
        actor.addAction(action)
    }

    /**
     * 5. 缩放动作（绝对）
     */
    fun testScaleToAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToStageCenter(actor)
            originCenter(actor)
        }

        // 初始缩放为(x: 0.5, y: 2.0)
        actor.setScale(0.5F, 2.0F)

        // 2s内从(x: 0.5, y: 2.0)变为(x: 1.0, y: 1.0)
        val action = Actions.scaleTo(1.0F, 1.0F, 2.0F)
        actor.addAction(action)
    }

    /**
     * 6. 缩放动作（相对）
     */
    fun testScaleByAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToStageCenter(actor)
            originCenter(actor)
        }

        // 初始缩放为(x: 0.5, y: 2.0)
        actor.setScale(0.5F, 2.0F)

        // 2s内从(x: 0.5, y: 2.0)变为(x: 1.0, y: 1.0)
        val action = Actions.scaleBy(0.5F, -1.0F, 2.0F)
        actor.addAction(action)
    }

    /**
     * 7. 尺寸改变动作（绝对）
     */
    fun testSizeToAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToZero(actor)
        }

        // 2s内尺寸改变为(width: 300, height: 150)
        val action = Actions.sizeTo(300F, 150F, 2F)
        actor.addAction(action)
    }

    /**
     * 8. 尺寸改变动作（相对）
     */
    fun testSizeByAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToZero(actor)
        }

        // 2s内尺寸增加(width: 100, height: 50)
        val action = Actions.sizeBy(100F, 50F, 2F)
        actor.addAction(action)
    }

    /**
     * 9. 透明度变化动作
     */
    fun testAlphaAction(actor: Actor, init: Boolean = false) {
        if (!init) {
            moveToStageCenter(actor)
        }

        // 初始透明度为1，也就是完全不透明
        actor.color.a = 1.0F

        /**
         * 2s内透明度变为0.5
         */
        val action = Actions.alpha(0.5F, 2F)
        actor.addAction(action)
    }

    /**
     * 10. 并行动作：移动、缩放、旋转
     */
    fun testParallelAction(actor: Actor) {
        moveToStageCenter(actor)
        testMoveByAction(actor, true)
        testScaleByAction(actor, true)
        testRotationByAction(actor, true)
        val actions = Array(actor.actions.size) { index -> actor.actions[index] }
        actor.clearActions()
        val parallelAction = Actions.parallel(actions[0], actions[1], actions[2])
        actor.addAction(parallelAction)
    }

    /**
     * 11. 串行动作：移动、缩放、旋转
     */
    fun testSequenceAction(actor: Actor) {
        moveToStageCenter(actor)
        testMoveByAction(actor, true)
        testScaleByAction(actor, true)
        testRotationByAction(actor, true)
        val actions = Array(actor.actions.size) { index -> actor.actions[index] }
        actor.clearActions()
        val parallelAction = Actions.sequence(actions[0], actions[1], actions[2])
        actor.addAction(parallelAction)
    }
}