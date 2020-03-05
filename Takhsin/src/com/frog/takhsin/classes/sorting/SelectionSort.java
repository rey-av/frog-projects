package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

public class SelectionSort extends AbstractSort {

    public SelectionSort(String name) {
        super(name);
    }


    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        boolean swap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            int swapPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swapPos = j;
                    swap = true;
                }
            }

            if (swap) {
                swap(arr, i, swapPos);
            }
        }

        return arr;
    }

}
