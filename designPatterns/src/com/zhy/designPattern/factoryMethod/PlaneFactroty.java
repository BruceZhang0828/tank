package com.zhy.designPattern.factoryMethod;

public class PlaneFactroty implements FactoryMethod {

    private PlaneFactroty(){

    }

    private static final PlaneFactroty INSTANCE = new PlaneFactroty();


    public static PlaneFactroty getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Moveable create() {
        return new Plane();
    }
}
