package com.zhy.designPattern.single;

public class Main {

    public static void main(String[] args) {

        //饿汉式
       /* Single1 instance1 = Single1.getInstance();
        Single1 instance2 = Single1.getInstance();
        System.out.println(instance1 == instance2);*/

        //懒汉式
        Single2 instance3 = Single2.getInstance();
        Single2 instance4 = Single2.getInstance();
        System.out.println(instance3 == instance4);
    }
}
