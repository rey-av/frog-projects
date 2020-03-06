package com.frog.Andrey.sort;

import java.util.Arrays;

import static com.frog.Andrey.utils.Utils.swap;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        int remain; // count of elements left to sort
        if (arr == null || (remain = arr.length) <= 0) return;

        int max; // index of max
        while (remain > 1) {
            max = 0;
            for (int i = 1; i < remain; i++) if (arr[i] > arr[max]) max = i;
            if (max != remain - 1) swap(arr, max, remain - 1);
            remain--;
        }
    }

}
