package com.zhy.tank.cor;

import com.zhy.tank.GameObject;
import com.zhy.tank.PropertiesMgr;
import com.zhy.tank.ResourceMgr;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{

    public List<Collider> colliders = new LinkedList<>();


    public ColliderChain() {
        String colliders = PropertiesMgr.getConfigStr("colliders");
        String[] collidersArray = colliders.split(",");
        for (int i = 0; i < collidersArray.length; i++) {
            String s = collidersArray[i];
            try {
                Class<?> clazz = Class.forName(s);
                Collider instance = (Collider)clazz.newInstance();
                this.colliders.add(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Collider c){
        colliders.add(c);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            boolean b = colliders.get(i).collide(o1, o2);
            if (!b) {
                break;
            }
        }

        return true;
    }
}
