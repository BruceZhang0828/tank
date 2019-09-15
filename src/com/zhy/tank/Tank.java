package com.zhy.tank;

import java.awt.*;
import java.io.File;
import java.util.Random;

public class Tank extends GameObject{


    int oldx,oldy;

    //移动单元长度
    private static final int SPEED =5;

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();

    //坦克的朝向
    private Dir dir = Dir.DOWN;
    //坦克移动的状态
    private boolean moving = true;

    boolean removeFlag = false;

    Random random = new Random();

    public Rectangle rectangle = new Rectangle();

    //创建一个爆照效果
    Explode e = null;

    public Group group = Group.BAD;

    private FireStrategy fs;

    public Tank(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.rectangle.x = x;
        this.rectangle.y = y;
        this.rectangle.width = WIDTH;
        this.rectangle.height = HEIGHT;


        if (Group.BAD == group) {
            try {
                Class<?> clazz = Class.forName((String) PropertiesMgr.getConfig("badFS"));
                fs = (FireStrategy) clazz.newInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            fs = FourDirFireStrategy.getInstance();
        }
    }

    @Override
    public void paint(Graphics g) {
        //绘制一个正方形
        /*Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);*/

        if (this.removeFlag) {
            GameModel.getInstance().gameObjects.remove(this);
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
        oldx = x;
        oldy = y;
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

        if (this.x > TankFrame.GAME_WIDTH - this.WIDTH - 2) {
            this.x = TankFrame.GAME_WIDTH  - this.WIDTH - 2;
        }

        if (this.y > TankFrame.GAME_HEIGHT - this.HEIGHT - 2) {
            this.y = TankFrame.GAME_HEIGHT - this.HEIGHT - 2;
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

        fs.fire(this);
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
        GameModel.getInstance().add(new Explode(bX,bY));
        //this.gm.setExplode(true);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * 方向翻转 这个方法好像有点废
     */
    public void recoverDir() {
        Dir[] values = Dir.values();
        for (int i = 0; i < values.length; i++) {
            if (values [i]==this.dir) {
                if (i==0) {
                    this.dir = values[2];
                }else if(i==1){
                    this.dir = values[3];
                }else if (i==2){
                    this.dir = values [0];
                }else {
                    this.dir = values [1];
                }
            }
        }
    }


    public void back(){
        x = oldx;
        y = oldy;
    }
}
