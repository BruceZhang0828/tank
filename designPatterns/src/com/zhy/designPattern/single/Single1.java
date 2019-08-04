package com.zhy.designPattern.single;

/**
 * 饿汉式
 * 1.不管用到与否,都要现在放到内存一份
 */
public class Single1 {

    private static final Single1 INSTANCE = new Single1();
    //1.单例模式必须要设置构造方法为私有
    private Single1(){}

    //2.提供一个获取实例的方法

    public static Single1 getInstance(){
        return INSTANCE;
    }
}
