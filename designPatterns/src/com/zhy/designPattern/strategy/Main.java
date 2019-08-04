package com.zhy.designPattern.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        /*Cat[] cats = {new Cat(10),new Cat(5),new Cat(3)};
        Sorter.sort(cats);
        Arrays.stream(cats).forEach(System.out::println);*/

        //使用策略模式进行判断大小
        Cat[] cats = {new Cat(10),new Cat(5),new Cat(3)};
        new SortByStrategy<Cat>().sort(cats,new CatWeightComparator());
        Arrays.stream(cats).forEach(System.out::println);




    }
}
