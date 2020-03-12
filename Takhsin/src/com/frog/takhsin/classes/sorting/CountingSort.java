package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

public class CountingSort extends AbstractSort {

    public CountingSort() {
        super("Counting sort");
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        if (arr.length == 1) {
            return arr;
        }

        int[] sortedArr = new int[arr.length];

        int min = arr[0];
        int max = min;

        for (int i : arr) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }

        int[] counts = new int[max - min + 1];

        for (int value : arr) {
            counts[value - min]++;
        }

        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        if (SortDirection.ASC.equals(direction)) {
            for (int i = arr.length - 1; i >= 0; i--) {
                sortedArr[counts[arr[i] - min]--] = arr[i];
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                sortedArr[counts[arr[i] - min]--] = arr[i];
            }
        }

        return sortedArr;
    }

}
