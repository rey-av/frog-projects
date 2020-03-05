package com.frog.Andrey.utils;

import com.frog.Andrey.classes.SortInfo;

public abstract class SortUtils {

    public static void selectionSort(int[] arr) {
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


    public static SortInfo bubbleSort(int[] array) {
        if (array == null || array.length <= 0) return new SortInfo(0, 0);
        int passes = 1; // last pass
        int total = 0;
        int swaps;
        while ((swaps = bubbleIterate(array)) != 0) {
            total += swaps;
            passes++;
        }
        return new SortInfo(passes, total);
    }


    public static int bubbleIterate(int[] array) {
        int size;
        if (array == null || (size = array.length) <= 0) return 0;
        int count = 0;
        for (int index = 1; index < size; index++) {
            int prev = index - 1;
            if (array[prev] > array[index]) count += swap(array, prev, index);
        }
        return count;
    }


    private static int swap(int[] array, int index1, int index2) {
        if (array == null || array.length < 2 || index1 < 0 || index2 < 0 || index1 == index2) return 0;
        int tempo = array[index1];
        array[index1] = array[index2];
        array[index2] = tempo;
        return 1;
    }

}
