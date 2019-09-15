package com.zhy.tank.cor;

import com.zhy.tank.Bullet;
import com.zhy.tank.GameObject;
import com.zhy.tank.Tank;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if (b.group == t.group) return true;

            if (b.rectangle.intersects(t.rectangle)) {
                b.die();
                t.die();
                return false;
            } else {
                return true;
            }

        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        } else {
            return true;
        }

    }
}
