package com.zhy.tank.decorator;

import com.zhy.tank.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator {

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        go.paint(g);

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.drawLine(go.x, go.y, go.x+go.getWidth(),go.y+go.getHeight());
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
