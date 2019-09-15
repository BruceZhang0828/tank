package com.zhy.tank;

import com.zhy.tank.cor.BulletTankCollider;
import com.zhy.tank.cor.Collider;
import com.zhy.tank.cor.ColliderChain;
import com.zhy.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank myTank = new Tank(200, 200, Dir.DOWN,this,Group.GOOD);

    List<GameObject> gameObjects = new ArrayList<>();

    //Collider btc = new BulletTankCollider();
    //Collider ttc = new TankTankCollider();

    public Collider colliderChain = new ColliderChain();
    public GameModel() {
        int initTank = Integer.parseInt((String) PropertiesMgr.getConfig("initTank"));
        //初始化敌方坦克
        for (int i = 0; i < initTank; i++) {
            add(new Tank(50 + i * 80, 100, Dir.DOWN, this, Group.BAD));
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
        /*g.drawString("子弹的数量:" + this.bullets.size(), 10, 60);
        g.drawString("敌人坦克数量:"+this.tanks.size(),10 , 80);
        g.drawString("爆炸数量:"+this.explodes.size(),10 , 100);*/
        g.setColor(c);
        myTank.paint(g);

        //使用迭代器容易出现异常ConcurrentModificationException
        /*for (Bullet b :
                bullets) {
            b.paint(g);
        }*/
        for (int i = 0; i < this.gameObjects.size(); i++) {
            this.gameObjects.get(i).paint(g);
        }


        //碰撞检测
        for (int i = 0; i < this.gameObjects.size(); i++) {
            for (int j = i+1; j <this.gameObjects.size() ; j++) {
                GameObject o1 = gameObjects.get(i);
                GameObject o2 = gameObjects.get(j);
                //for
                colliderChain.collide(o1, o2);
            }
        }

    }

    /**
     * 添加方法
     * @param gameObject
     */
    public void add(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }


    public Tank getMyTank() {
        return myTank;
    }
}
