package com.zhy.designPattern.observer.v7;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多时候,我们处理事件的时候,需要事件源
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
        wakeupEvent wakeupEvent = new wakeupEvent(System.currentTimeMillis(), "bed",this);
        for (Observer observer : observers) {
            observer.actionOnWakeUp(wakeupEvent);
        }
    }


}

class wakeupEvent<T>{
    long timestamp;
    String loc;
    T source;
    public wakeupEvent(long timestamp,String loc,T source){
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    public T getSource(){
        return source;
    }
}

interface Observer{
    void actionOnWakeUp(wakeupEvent wakeupEvent);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad ... feed ");
    }

    @Override
    public void actionOnWakeUp(wakeupEvent wakeupEvent) {
        Child source = (Child)wakeupEvent.getSource();
        System.out.println(source);
        feed();
    }
}

class Mum implements Observer {

    public void hung(){
        System.out.println("mum hung...");
    }

    @Override
    public void actionOnWakeUp(wakeupEvent wakeupEvent) {
        hung();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("wang ...");
    }

    @Override
    public void actionOnWakeUp(wakeupEvent wakeupEvent) {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeup();
    }
}
