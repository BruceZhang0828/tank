package com.zhy.designPattern.abstractFactory.abstractFactory;

import com.zhy.designPattern.abstractFactory.AbstractFactory;
import com.zhy.designPattern.abstractFactory.Meat;
import com.zhy.designPattern.abstractFactory.Steamer;
import com.zhy.designPattern.abstractFactory.Torpedo;
import com.zhy.designPattern.abstractFactory.abstactPojo.Food;
import com.zhy.designPattern.abstractFactory.abstactPojo.Vehicle;
import com.zhy.designPattern.abstractFactory.abstactPojo.Weapon;

public class VipPlayerFor5MFactory extends AbstractFactory {

    private static final VipPlayerFor5MFactory INSTANCE = new VipPlayerFor5MFactory();

    private VipPlayerFor5MFactory(){}


    public static VipPlayerFor5MFactory getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Food createFood() {
        return new Meat();
    }

    @Override
    public Vehicle createVehicle() {
        return new Steamer();
    }

    @Override
    public Weapon createWeapon() {
        return new Torpedo();
    }
}
