package com.zhy.tank.decorator;

import com.zhy.tank.GameObject;

import java.awt.*;

/**
 * 使用装饰器模式给项目子弹方框
 */
public abstract class GODecorator extends GameObject {

    protected GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
