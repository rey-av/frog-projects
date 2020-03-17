package com.frog.nika.sort.sortClass;

import com.frog.nika.abstractClass.AbstractSort;

public class SortBubbles extends AbstractSort {

    @Override
    public void Sort(int[] arr) {
        if (arr == null) {
            System.out.println("Array cannot be null. Sort was interrupted.");
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
