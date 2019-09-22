package com.zhy.designPattern.observer.v3;

//加入观察者 Dad
public class Main {

    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}

class Child{
    private boolean cry = false;
    private Dad dad = new Dad();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        //观察者 执行观察方式
        dad.feed();
    }

}


class Dad{
    public void feed(){
        System.out.println("喂奶...");
    }
}
