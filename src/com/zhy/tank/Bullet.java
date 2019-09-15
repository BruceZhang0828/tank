package com.zhy.tank;

import sun.java2d.loops.FillRect;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet extends GameObject{
    //移动单元长度
    private static final int SPEED =10;

    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();

    public Dir dir = Dir.DOWN;

    public Rectangle rectangle = new Rectangle();

     public Group group = Group.BAD;

   // private static final int WIDTH = 10,HEIGHT=10;

    GameModel gm;


    private boolean removeFlag = false;

    @Override
    public void paint(Graphics g) {

        if (removeFlag) {
            this.gm.gameObjects.remove(this);
        } else {
//            Color color = g.getColor();
//            g.setColor(Color.RED);
//            g.fillOval(this.x, this.y, WIDTH, HEIGHT);
//            g.setColor(color);

            switch (dir) {
                case LEFT:
                    g.drawImage(ResourceMgr.bulletL, this.x, this.y,null);
                    break;
                case UP:
                    g.drawImage(ResourceMgr.bulletU, this.x, this.y,null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgr.bulletR, this.x, this.y,null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgr.bulletD, this.x, this.y,null);
                    break;
            }
            move();
        }
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


        this.rectangle.x = x;
        this.rectangle.y = y;

        if (x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) {
            removeFlag = true;
        }
    }

    public Bullet(int x, int y, Dir dir,GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
    }

    public Bullet(int x, int y, Dir dir,GameModel gm,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        this.rectangle.x = x;
        this.rectangle.y = y;
        this.rectangle.width = WIDTH;
        this.rectangle.height = HEIGHT;
        gm.add(this);
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

    /**
     * 子弹与坦克的碰撞测试
     * @param tank
     */
    public void collideWith(Tank tank) {

        if (this.group == tank.getGroup()) return ;

        //两个图片相交
        if (this.rectangle.intersects(tank.rectangle)){
            this.die(); //子弹销毁
            tank.die(); //坦克销毁
        }
    }

    public void die() {
        this.removeFlag  = true;
    }
}
