package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

public class ShakerSort extends AbstractSort {

    public ShakerSort() {
        super("Shaker sort");
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        boolean swapped = true;
        while (swapped) {
            swapped = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (direction.equals(SortDirection.ASC)) {
                    if (arr[i + 1] < arr[i]) {
                        swap(arr, i, i + 1);
                        swapped = true;
                    }
                } else {
                    if (arr[i + 1] > arr[i]) {
                        swap(arr, i, i + 1);
                        swapped = true;
                    }
                }
            }
            for (int i = arr.length - 1; i > 1; i--) {
                if (direction.equals(SortDirection.ASC)) {
                    if (arr[i - 1] > arr[i]) {
                        swap(arr, i, i - 1);
                        swapped = true;
                    }
                } else {
                    if (arr[i - 1] < arr[i]) {
                        swap(arr, i, i - 1);
                        swapped = true;
                    }
                }
            }

            if (!swapped) {
                break;
            }

        }
        return arr;
    }

}
