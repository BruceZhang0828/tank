package com.zhy.tank.cor;

import com.zhy.tank.Bullet;
import com.zhy.tank.GameObject;
import com.zhy.tank.Tank;
import com.zhy.tank.Wall;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            if (b.rectangle.intersects(w.rectangle)) {
                b.die();
                return false;
            } else {
                return true;
            }

        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        } else {
            return true;
        }

    }
}
