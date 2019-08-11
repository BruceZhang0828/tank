package com.zhy.designPattern.abstractFactory.abstractFactory;

import com.zhy.designPattern.abstractFactory.AbstractFactory;
import com.zhy.designPattern.abstractFactory.Ak47;
import com.zhy.designPattern.abstractFactory.Bread;
import com.zhy.designPattern.abstractFactory.Car;
import com.zhy.designPattern.abstractFactory.abstactPojo.Food;
import com.zhy.designPattern.abstractFactory.abstactPojo.Vehicle;
import com.zhy.designPattern.abstractFactory.abstactPojo.Weapon;

public class CommonPlayerFactory extends AbstractFactory {

    private static final CommonPlayerFactory INSTANCE = new CommonPlayerFactory();

    private CommonPlayerFactory(){}


    public static CommonPlayerFactory getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new Ak47();
    }
}
