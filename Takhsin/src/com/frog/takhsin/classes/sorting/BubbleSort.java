package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

public class BubbleSort extends AbstractSort {

    public BubbleSort(String name) {
        super(name);
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        if (arr.length == 1) {
            return arr;
        }

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (direction.equals(SortDirection.ASC)) {
                    if (arr[i + 1] < arr[i]) {
                        swap(arr, i, i + 1); // no pass by reference, thanks Java :(
                        swapped = true;
                    }
                } else {
                    if (arr[i + 1] > arr[i]) {
                        swap(arr, i, i + 1);
                        swapped = true;
                    }
                }
            }
        }

        return arr;
    }


}
