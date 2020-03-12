package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

public class ShellSort extends AbstractSort {

    public ShellSort() {
        super("Shell sort");
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        if (arr.length == 1) {
            return arr;
        }

        int gap = arr.length / 2;

        while (gap > 0) {
            for (int i = 0; i < arr.length - gap; i += gap) {
                for (int j = 0; j < i + gap && j < arr.length - gap; j++) {
                    if (direction.equals(SortDirection.ASC)) {
                        if (arr[j] > arr[j + gap]) {
                            swap(arr, j, j + gap);
                        }
                    } else {
                        if (arr[j] < arr[j + gap]) {
                            swap(arr, j, j + gap);
                        }
                    }
                }
            }

            gap = gap == 2 ? 1 : (int) (gap / 2.2); //The best performance is offered by a sequence by Marcin Ciura
        }

        return arr;
    }

}
