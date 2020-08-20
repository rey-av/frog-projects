package com.frog.Andrey.sort;

import java.util.Arrays;

import static com.frog.Andrey.utils.Utils.swap;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] input) {
        // assert

        int[] clone = input.clone();

        int remain = clone.length; // count of elements left to sort

        int max; // index of max
        while (remain > 1) {
            max = 0;
            for (int i = 1; i < remain; i++) if (clone[i] > clone[max]) max = i;
            if (max != remain - 1) swap(clone, max, remain - 1);
            remain--;
        }
    }

}
