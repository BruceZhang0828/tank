package com.zhy.tank.abstractfactory;

import com.zhy.tank.Group;

import java.awt.*;

/**
 * 坦克基类
 */
public abstract class BaseTank {
    public Group  group = Group.BAD;
    public Rectangle rectangle = new Rectangle();

    /**
     * 抽象画图方法
     * @param g
     */
    public abstract void paint(Graphics g);

    public Group getGroup() {
        return group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
