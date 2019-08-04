package com.zhy.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        int initTank = Integer.parseInt((String) PropertiesMgr.getConfig("initTank"));
        //初始化敌方坦克
        for (int i = 0; i < initTank; i++) {
            tankFrame.tanks.add(new Tank(50 + i * 80, 100, Dir.DOWN, tankFrame, Group.BAD));
        }

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
