package com.zhy.designPattern.single;

/**
 * 懒汉式
 * 多线程访问时不安全
 */
public class Single2 {

    private static Single2 INSTANCE = null;


    private Single2(){}

    public static Single2 getInstance() {
        if (INSTANCE == null) {
            //进行多线程测试


            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Single2();
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single2.getInstance().hashCode())).start();
        }
    }

}
