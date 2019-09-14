package com.zhy.tank.abstractfactory;

import com.zhy.tank.Dir;
import com.zhy.tank.Group;
import com.zhy.tank.TankFrame;

public class RectFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        // TODO Auto-generated method stub
        return new RectTank(x, y, dir,tf , group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        // TODO Auto-generated method stub
        return new RectExplode(x, y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir,tf, group);
    }
}
