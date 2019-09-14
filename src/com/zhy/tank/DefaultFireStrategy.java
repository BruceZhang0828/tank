package com.zhy.tank;

import com.zhy.tank.abstractfactory.BaseTank;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank tank) {
        Tank t = (Tank)tank;
        int bX = tank.getX()+t.WIDTH/2-Bullet.WIDTH/2;
        int bY = tank.getY()+t.HEIGHT/2-Bullet.HEIGHT/2;
        t.getTf().gf.createBullet(bX, bY,t.getDir(),tank.getGroup(),t.getTf());
    }
}
