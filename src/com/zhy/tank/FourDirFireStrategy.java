package com.zhy.tank;

public class FourDirFireStrategy implements FireStrategy{

    private static final FourDirFireStrategy INSTANCE = new FourDirFireStrategy();

    private FourDirFireStrategy(){}


    public static FourDirFireStrategy getInstance(){
        return INSTANCE;
    }
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX()+tank.WIDTH/2-Bullet.WIDTH/2;
        int bY = tank.getY()+tank.HEIGHT/2-Bullet.HEIGHT/2;

        Dir[] values = Dir.values();

        for (Dir dir:values){
            new Bullet(bX, bY,dir,tank.getGm(),tank.getGroup());
        }
    }
}
