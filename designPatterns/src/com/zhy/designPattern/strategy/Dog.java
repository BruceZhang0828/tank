package com.zhy.designPattern.strategy;

public class Dog {

    private int height;


    public Dog(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "height=" + height +
                '}';
    }
}
