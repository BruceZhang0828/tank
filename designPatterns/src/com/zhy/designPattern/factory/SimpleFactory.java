package com.zhy.designPattern.factory;

/**
 * 简单工厂:
 * 工厂类基本都是单例
 * 任意定制交通工具
 */
public class SimpleFactory {


    private SimpleFactory(){};

    private static final SimpleFactory SIMPLE_FACTORY = new SimpleFactory();


    public static SimpleFactory getInstance() {
        return SIMPLE_FACTORY;
    }


    public Moveable createCar(){
        return new Car();
    }

    public Moveable createPlane(){

        return new Plane();
    }
}
