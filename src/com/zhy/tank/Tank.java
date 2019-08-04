package com.zhy.tank;

import java.awt.*;
import java.util.Random;

public class Tank {

    //移动单元长度
    private static final int SPEED =5;

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();

    //坦克坐标
    private int x,y;
    //坦克的朝向
    private Dir dir = Dir.DOWN;
    //绘制坦克的窗口
    private TankFrame tf;
    //坦克移动的状态
    private boolean moving = true;

    boolean removeFlag = false;

    Random random = new Random();

    Rectangle rectangle = new Rectangle();

    //创建一个爆照效果
    Explode e = null;

    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf =tf;
        this.group = group;
        this.rectangle.x = x;
        this.rectangle.y = y;
        this.rectangle.width = WIDTH;
        this.rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        //绘制一个正方形
        /*Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);*/

        if (this.removeFlag) {
            tf.tanks.remove(this);
            return;
        }
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL, this.x, this.y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU, this.x, this.y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR, this.x, this.y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD, this.x, this.y,null);
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
        this.rectangle.x = x;
        this.rectangle.y = y;
        if (this.group == Group.BAD && random.nextInt(10) > 8) this.fire();

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }
        boundCheck();
    }

    /**
     * 坦克边界检查
     */
    private void boundCheck() {
        if (this.x < 2) {
            this.x = 2;
        }

        if (this.y < 28) {
            this.y = 28;
        }

        if (this.x > this.tf.getWidth() - this.WIDTH - 2) {
            this.x = this.tf.getWidth() - this.WIDTH - 2;
        }

        if (this.y > this.tf.getHeight() - this.HEIGHT - 2) {
            this.y = this.tf.getHeight() - this.HEIGHT - 2;
        }
    }

    /**
     * 敌方坦克随机调整方向
     */
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    /**
     * 坦克发射子弹方法
     */
    public void fire() {
        int bX = this.x+this.WIDTH/2-Bullet.WIDTH/2;
        int bY = this.y+this.HEIGHT/2-Bullet.HEIGHT/2;
        tf.bullets.add (new Bullet(bX, bY,this.dir,this.tf,this.group)) ;
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

    /**
     * 坦克销毁方法
     */
    public void die() {
        this.removeFlag = true;
        int bX = this.x+WIDTH/2-ResourceMgr.explodes[0].getWidth()/2;
        int bY = this.y+HEIGHT/2-ResourceMgr.explodes[0].getHeight()/2;
        this.tf.explodes.add(new Explode(bX,bY, this.tf));
        this.tf.setExplode(true);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
