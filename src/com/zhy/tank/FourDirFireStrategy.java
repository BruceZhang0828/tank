package com.zhy.tank;

import com.zhy.tank.abstractfactory.BaseTank;

public class FourDirFireStrategy implements FireStrategy{

    private static final FourDirFireStrategy INSTANCE = new FourDirFireStrategy();

    private FourDirFireStrategy(){}


    public static FourDirFireStrategy getInstance(){
        return INSTANCE;
    }
    @Override
    public void fire(BaseTank tank) {
        Tank t = (Tank)tank;
        int bX = tank.getX()+t.WIDTH/2-Bullet.WIDTH/2;
        int bY = tank.getY()+t.HEIGHT/2-Bullet.HEIGHT/2;

        Dir[] values = Dir.values();

        for (Dir dir:values){
           t.getTf().gf.createBullet(bX, bY,dir,tank.getGroup(),t.getTf());
        }
    }
}
