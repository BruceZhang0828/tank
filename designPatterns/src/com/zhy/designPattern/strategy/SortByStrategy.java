package com.zhy.designPattern.strategy;

public class SortByStrategy<T> {

    public  void sort(T[] arr,Comparator<T> comparator) {

        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos]) == -1 ? j : minPos;
            }

            swap(arr, i, minPos);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T num = arr[i];
        arr [i] = arr[j];
        arr [j] = num;
    }
}
