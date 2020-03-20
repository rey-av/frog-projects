package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

public class QuickSort extends AbstractSort {

    private SortDirection direction;


    public QuickSort() {
        super("QuickSort");
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);
        this.direction = direction;
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }


    private void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }


    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (direction.equals(SortDirection.ASC)) {
                if (arr[j] <= pivot) {
                    ++i;
                    swap(arr, i, j);
                }
            } else {
                if (arr[j] >= pivot) {
                    ++i;
                    swap(arr, i, j);
                }
            }
        }
        swap(arr, i + 1, right);

        return i + 1;
    }

}
