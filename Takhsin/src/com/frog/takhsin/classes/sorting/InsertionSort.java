package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

import java.util.Arrays;

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

        int[] sortedArr = Arrays.copyOf(arr, 1); // init subarray

        for (int i = 0; i < arr.length - 1; i++) {
            // list logic manually synthesised
            // create new array with size +1 filled with 0
            sortedArr = Arrays.copyOf(sortedArr, i + 2);
            // replace 0 with next number from original array
            System.arraycopy(arr, i + 1, sortedArr, sortedArr.length - 1, 1);

            for (int j = sortedArr.length - 1; j > 0; j--) {
                if (direction.equals(SortDirection.ASC)) {
                    if (sortedArr[j] < sortedArr[j - 1]) {
                        swap(sortedArr, j, j - 1);
                        continue;
                    }
                } else {
                    if (sortedArr[j] > sortedArr[j - 1]) {
                        swap(sortedArr, j, j - 1);
                        continue;
                    }
                }
                break;
            }
        }
        return sortedArr;
    }

}
