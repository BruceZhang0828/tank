package com.zhy.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank myTank = new Tank(200, 200, Dir.DOWN,this,Group.GOOD);

    List<Bullet> bullets = new ArrayList<>();

    List<Tank> tanks = new ArrayList<>();

    List<Explode> explodes = new ArrayList<>();


    public GameModel() {
        int initTank = Integer.parseInt((String) PropertiesMgr.getConfig("initTank"));
        //初始化敌方坦克
        for (int i = 0; i < initTank; i++) {
            this.tanks.add(new Tank(50 + i * 80, 100, Dir.DOWN, this, Group.BAD));
        }
    }

    /**
     * 绘制方法
     *
     * @param g
     */
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + this.bullets.size(), 10, 60);
        g.drawString("敌人坦克数量:"+this.tanks.size(),10 , 80);
        g.drawString("爆炸数量:"+this.explodes.size(),10 , 100);
        g.setColor(c);
        myTank.paint(g);

        //使用迭代器容易出现异常ConcurrentModificationException
        /*for (Bullet b :
                bullets) {
            b.paint(g);
        }*/
        for (int i = 0; i < this.bullets.size(); i++) {
            this.bullets.get(i).paint(g);
        }

        for (int i = 0; i < this.tanks.size(); i++) {
            Tank tank = this.tanks.get(i);
            tank.paint(g);
        }

        for (int i = 0; i < this.bullets.size(); i++) {
            //this.bullets.get(i).collideWith(this.myTank);
            for (int j = 0; j < this.tanks.size(); j++) {
                this.bullets.get(i).collideWith(this.tanks.get(j));
            }
        }
    }


    public Tank getMyTank() {
        return myTank;
    }
}
