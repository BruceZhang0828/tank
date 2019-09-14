package com.zhy.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        int initTank = Integer.parseInt((String) PropertiesMgr.getConfig("initTank"));
        //初始化敌方坦克
        for (int i = 0; i < initTank; i++) {
            tankFrame.tanks.add(tankFrame.gf.createTank(50, i*80, Dir.DOWN, Group.BAD, tankFrame));
        }

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
