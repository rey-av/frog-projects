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
        int len;
        if (arr == null || (len = arr.length) <= 0) return;
        int iMax;
        while (len > 1) {
            iMax = 0;
            for (int i = 1; i < len; i++) {
                if (arr[i] > arr[iMax]) iMax = i;
            }
            if (iMax != len - 1) swap(arr, iMax, len - 1);
            len--;
        }
    }

}
