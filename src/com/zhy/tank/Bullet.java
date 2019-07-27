package com.zhy.tank;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    //移动单元长度
    private static final int SPEED =10;

    private int x,y;
    private Dir dir = Dir.DOWN;

    private static final int WIDTH = 10,HEIGHT=10;

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, WIDTH, HEIGHT);
        g.setColor(color);
        move();
    }

    private void move(){
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
