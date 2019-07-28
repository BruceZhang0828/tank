package com.zhy.tank;

import java.awt.*;

public class Tank {

    //移动单元长度
    private static final int SPEED =10;

    public static final int WIDTH = ResourceMgr.tankD.getWidth();
    public static final int HEIGHT = ResourceMgr.tankD.getHeight();

    //坦克坐标
    private int x,y;
    //坦克的朝向
    private Dir dir = Dir.DOWN;
    //绘制坦克的窗口
    private TankFrame tf;
    //坦克移动的状态
    private boolean moving = false;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf =tf;
    }

    public void paint(Graphics g) {
        //绘制一个正方形
        /*Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);*/
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, this.x, this.y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, this.x, this.y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, this.x, this.y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, this.x, this.y,null);
                break;
        }
        move();

    }


    private void move() {
        if (!this.moving) return;
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


    /**
     * 坦克发射子弹方法
     */
    public void fire() {
        int bX = this.x+this.WIDTH/2-Bullet.WIDTH/2;
        int bY = this.y+this.HEIGHT/2-Bullet.HEIGHT/2;
        tf.bullets.add (new Bullet(bX, bY,this.dir,this.tf)) ;
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


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


}
