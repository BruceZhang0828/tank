package com.zhy.designPattern.factory;

/**
 * 定制交通过程
 */
public class CarFactory {

    private static final CarFactory NSTANCE = new CarFactory();

    private CarFactory (){}

    public static CarFactory getNSTANCE() {
        return NSTANCE;
    }

    public Car createCar(){
        return new Car();
    }
}
