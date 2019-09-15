package com.zhy.tank.cor;

import com.zhy.tank.Bullet;
import com.zhy.tank.GameObject;
import com.zhy.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.rectangle.intersects(t2.rectangle)) {
                t1.recoverDir();
                t2.recoverDir();
            }
        }

        return true;
    }
}
