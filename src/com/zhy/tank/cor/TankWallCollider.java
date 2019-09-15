package com.zhy.tank.cor;

import com.zhy.tank.GameObject;
import com.zhy.tank.Tank;
import com.zhy.tank.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t1 = (Tank) o1;
            Wall w = (Wall) o2;
            if (t1.rectangle.intersects(w.rectangle)) {
                t1.back();
                return false;
            }
        }else if(o1 instanceof Wall && o2 instanceof Tank){
            return collide(o2, o1);
        }

        return true;
    }
}
