package com.zhy.designPattern.single;

/**
 * 静态内部类
 * 通过jvm保证线程安全
 */
public class Single5 {

    private Single5(){}

    private static class Single5Holder{
        //jvm只会加载一个class;所以保证了线程安全的问题
        private static final Single5 INSTANCE  = new Single5();
    }


    public static Single5 getInstance(){
        return Single5Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()-> System.out.println(Single5.getInstance().hashCode())).start();
        }
    }
}
