package com.zhy.designPattern.strategy;

public class Cat implements Comparable<Cat> {

    private int weight;

    public Cat(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat cat) {
        if (this.weight < (cat.weight)) {
            return -1;
        }else if (this.weight>(cat.weight)) {
            return 1;
        }else {
            return 0;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                '}';
    }
}
