package com.zhy.designPattern.strategy;

public class CatWeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat c1, Cat c2) {
        if (c1.getWeight() < c2.getWeight()) {
            return -1;
        }else if (c1.getWeight()>(c2.getWeight())) {
            return 1;
        }else {
            return 0;
        }
    }
}
