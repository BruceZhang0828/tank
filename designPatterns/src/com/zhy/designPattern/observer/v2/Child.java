package com.zhy.designPattern.observer.v2;

/**
 * 面向对象 创建相关类
 */
public class Child {
    public boolean cry;

    public boolean isCry(){
        return this.cry;
    }

    //小孩子醒来了
    public void wakeUp(){
        System.out.println("小孩子醒来了...");
        cry = true;
    }

    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("observer...");
        }
    }

}
