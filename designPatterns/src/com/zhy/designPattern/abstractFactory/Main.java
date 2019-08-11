package com.zhy.designPattern.abstractFactory;

import com.zhy.designPattern.abstractFactory.abstactPojo.Food;
import com.zhy.designPattern.abstractFactory.abstractFactory.CommonPlayerFactory;
import com.zhy.designPattern.abstractFactory.abstractFactory.VipPlayerFor5MFactory;

public class Main {

    public static void main(String[] args) {
        //在普通用户是你吃的面包 拿着的普通的武器Ak47 开着小破车
        //这个就规定一族(一套设定)的产品
//        Car car = new Car();
//        car.go();
//        Ak47 ak47  = new Ak47();
//        ak47.fire();
//        Bread bread = new Bread();
//        bread.printName();

        //充了 5毛钱的用户
//        Steamer steamer = new Steamer();
//        steamer.go();
//        Torpedo t = new Torpedo();
//        t.fire();
//        Meat meat = new Meat();
//        meat.printName();

        //普通会员 装备工厂类
        CommonPlayerFactory commonPlayerFactory = CommonPlayerFactory.getINSTANCE();
        Food bread = commonPlayerFactory.createFood();
        bread.printName();
        //5毛会员 装备工厂类
        VipPlayerFor5MFactory vipPlayerFor5MFactory = VipPlayerFor5MFactory.getINSTANCE();
        Food meat = vipPlayerFor5MFactory.createFood();
        meat.printName();

    }
}
