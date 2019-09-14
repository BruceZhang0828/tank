package com.zhy.tank.abstractfactory;

import java.awt.*;

/**
 * 抽象的子弹的基类
 */
public abstract class BaseBullet{
    /**
     * 绘制图像的方法
     * @param g
     */
    public abstract void paint(Graphics g);
    /**
     * 子弹与坦克的碰撞测试
     */
    public abstract void collideWith(BaseTank tank);
}
