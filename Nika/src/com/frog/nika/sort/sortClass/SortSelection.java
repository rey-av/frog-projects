package com.frog.nika.sort.sortClass;

import com.frog.nika.abstractClass.AbstractSort;

public class SortSelection extends AbstractSort {

    @Override
    public void Sort(int[] arr) {

        if (arr == null) {
            System.out.println("Array cannot be null. Sort was interrupted.");
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            int minVal = arr[i]; //  вытаскиваем значение элемента
            int minIndex = i;    //  индекс

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }

}
