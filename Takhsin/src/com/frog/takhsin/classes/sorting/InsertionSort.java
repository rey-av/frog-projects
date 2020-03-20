package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

public class InsertionSort extends AbstractSort {

    public InsertionSort() {
        super("Insertion sort");
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        if (arr.length == 1) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (direction.equals(SortDirection.ASC)) {
                    if (arr[i] < arr[j]) {
                        swap(arr, i, j);
                        break;
                    }
                } else {
                    if (arr[i] > arr[j]) {
                        swap(arr, i, j);
                        break;
                    }
                }
            }
        }
        return arr;
    }

}
