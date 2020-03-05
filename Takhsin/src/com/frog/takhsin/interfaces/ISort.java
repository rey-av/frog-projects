package com.frog.takhsin.interfaces;

import com.frog.takhsin.enums.SortDirection;

public interface ISort {

    int[] sort(int[] arr, SortDirection direction);

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
