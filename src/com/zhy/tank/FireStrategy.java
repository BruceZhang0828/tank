package com.zhy.tank;

import com.zhy.tank.abstractfactory.BaseTank;

/**
 * 坦克开火的策略
 */
public interface FireStrategy {

    void fire(BaseTank tank);
}
