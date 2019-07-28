package com.zhy.tank;

import java.awt.*;

public class Explode {
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();

    private int setp = 0;

    private int x,y;

    private TankFrame tf;

    public Explode(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[setp++],this.x,this.y,null);
        if (this.setp>=ResourceMgr.explodes.length){
            setp = 0;
            this.tf.setExplode(false);
            this.tf.setE(null);
        }
    }





    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
