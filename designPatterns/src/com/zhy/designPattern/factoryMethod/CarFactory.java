package com.zhy.designPattern.factoryMethod;

/**
 * 简单工厂:
 *  * 工厂类基本都是单例
 *  * 任意定制交通工具
 */
public class CarFactory implements FactoryMethod{

    private static final CarFactory NSTANCE = new CarFactory();

    private CarFactory (){}

    public static CarFactory getNSTANCE() {
        return NSTANCE;
    }

    @Override
    public Moveable create() {
        return new Car();
    }
}
