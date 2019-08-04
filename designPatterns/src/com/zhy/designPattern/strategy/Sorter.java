package com.zhy.designPattern.strategy;

import java.util.Arrays;

/**
 * 排序工具
 */
public class Sorter {

    public static void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }

            swap(arr, i, minPos);
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable num = arr[i];
        arr [i] = arr[j];
        arr [j] = num;
    }
}
