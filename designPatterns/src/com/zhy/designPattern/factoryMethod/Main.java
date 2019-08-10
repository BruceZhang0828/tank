package com.zhy.designPattern.factoryMethod;

public class Main {

    public static void main(String[] args) {
        //Car car = new Car();
        //car.go();

//        Moveable plane =  new Plane();
//        plane.go();

//        Moveable bo =  new Boomu();
//        bo.go();

//        Moveable car = FactoryMethod.getInstance().createCar();
//        car.go();


//        Moveable plane = FactoryMethod.getInstance().createPlane();
//        plane.go();

//        Moveable car = CarFactory.getNSTANCE().create();
//        car.go();

        Moveable plane  = PlaneFactroty.getINSTANCE().create();
        plane.go();

    }
}
