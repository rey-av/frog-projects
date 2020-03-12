package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;


public class MergingSort extends AbstractSort {


    public MergingSort() {
        super("Merging sort");
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        if (arr.length == 1) {
            return arr;
        }

        int[] sorted = new int[arr.length];
        mergeSort(arr, sorted, 0, arr.length - 1, direction);


        return arr;
    }


    private void mergeSort(int[] arr, int[] temp, int left, int right, SortDirection direction) {
        if (left == right) {
            return;
        }

        int middleIndex = (left + right) / 2;

        mergeSort(arr, temp, left, middleIndex, direction);
        mergeSort(arr, temp, middleIndex + 1, right, direction);
        merge(arr, temp, left, right, direction);

        // Copy new values to original array
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }


    private void merge(int[] arr, int[] temp, int left, int right, SortDirection direction) {
        int leftIndex = left;
        int middleIndex = (left + right) / 2;
        int rightIndex = middleIndex + 1;
        int tempIndex = left;

        // Sort elements until either of sub-arrays pointer reaches end
        while (leftIndex <= middleIndex && rightIndex <= right) {
            if (SortDirection.ASC.equals(direction)) {
                if (arr[leftIndex] <= arr[rightIndex]) {
                    temp[tempIndex] = arr[leftIndex++];
                } else {
                    temp[tempIndex] = arr[rightIndex++];
                }
            } else {
                if (arr[leftIndex] >= arr[rightIndex]) {
                    temp[tempIndex] = arr[leftIndex++];
                } else {
                    temp[tempIndex] = arr[rightIndex++];
                }
            }
            tempIndex++;
        }

        // Copy rest of elements as is
        while (leftIndex <= middleIndex) {
            temp[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = arr[rightIndex++];
        }
    }

}
