package com.zhy.designPattern.single;

/**
 * 加锁双重判断
 */
public class Single4 {

    private static volatile Single4 INSTANCE = null; //需要添加volatile进行同步

    private Single4(){}

    public  static Single4 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Single4.class) {
                if (INSTANCE ==null) {
                    //进行多线程测试
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Single4();
                }
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single4.getInstance().hashCode())).start();
        }
    }
}
