package com.zhy.designPattern.abstractFactory;

import com.zhy.designPattern.abstractFactory.abstactPojo.Food;
import com.zhy.designPattern.abstractFactory.abstactPojo.Vehicle;
import com.zhy.designPattern.abstractFactory.abstactPojo.Weapon;

public abstract class AbstractFactory {
    //创建食物
    public abstract Food createFood();

    //创建交通工具
    public abstract Vehicle createVehicle();

    //创建武器
    public abstract Weapon createWeapon();
}
