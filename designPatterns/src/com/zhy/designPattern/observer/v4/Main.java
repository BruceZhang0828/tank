package com.zhy.designPattern.observer.v4;


class Child{
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        //观察者 执行观察方式
        dad.feed();
        mum.feed();
        dog.feed();
    }

}

class Dad{
    public void feed() {
        System.out.println("dad feeding...");
    }
}

class Mum{
    public void feed(){
        System.out.println("mum feeding...");
    }
}

class Dog{
    public void feed(){
        System.out.println("dog look at the baby...");
    }
}
public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
