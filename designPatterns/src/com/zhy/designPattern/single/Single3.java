package com.zhy.designPattern.single;


/**
 * 加锁的懒汉式
 */
public class Single3 {
    private static Single3 INSTANCE = null;

    private Single3(){}

    public synchronized static Single3 getInstance() {
        if (INSTANCE == null) {
            //进行多线程测试

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Single3();
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single3.getInstance().hashCode())).start();
        }
    }
}
