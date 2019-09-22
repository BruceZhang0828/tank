package com.zhy.designPattern.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类观察者与被观察者
 */
class Child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }
    public boolean isCry() {
        return cry;
    }


    public void wakeup(){
        cry = true;
        for (Observer observer : observers) {
            observer.actionOnWakeUp();
        }
    }


}

interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad ... feed ");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer {

    public void hung(){
        System.out.println("mum hung...");
    }

    @Override
    public void actionOnWakeUp() {
        hung();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("wang ...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeup();
    }
}
