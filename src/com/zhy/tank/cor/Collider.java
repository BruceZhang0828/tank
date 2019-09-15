package com.zhy.tank.cor;

import com.zhy.tank.GameObject;

public interface Collider {
    boolean collide(GameObject o1,GameObject o2);
}
