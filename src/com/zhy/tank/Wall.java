package com.zhy.tank;

import java.awt.*;

public class Wall extends GameObject{

    int h,w;
    public Rectangle rectangle;


    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rectangle = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x, y, w, h);
        g.setColor(color);

    }
}
