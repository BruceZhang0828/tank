package com.zhy.tank;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX()+tank.WIDTH/2-Bullet.WIDTH/2;
        int bY = tank.getY()+tank.HEIGHT/2-Bullet.HEIGHT/2;
       new Bullet(bX, bY,tank.getDir(),tank.getGroup());
    }
}
