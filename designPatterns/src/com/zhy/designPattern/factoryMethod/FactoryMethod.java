package com.zhy.designPattern.factoryMethod;

/**
 * 简单工厂:
 * 工厂类基本都是单例
 * 任意定制交通工具
 */
public interface FactoryMethod {

    Moveable create();
}
