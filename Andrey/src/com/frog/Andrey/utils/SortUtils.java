package com.frog.Andrey.utils;

import com.frog.Andrey.classes.SortInfo;

public abstract class SortUtils {

    /**
     * Sorts given array via bubble sort.
     *
     * @param array Array to be sorted.
     * @return Number of swaps used by bubble sort.
     */
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


    /**
     * Performs a single bubble sort iteration.
     *
     * @param array Array to be iterated.
     * @return Number of swaps used by iteration.
     */
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


    /**
     * Swaps elements with the specified indices within an array.
     *
     * @param array  Array elements of which are to be swapped.
     * @param index1 Index of a first swapped element.
     * @param index2 Index of a second swapped element.
     * @return 0 if a swap is impossible due to illegal arguments, otherwise 1.
     */
    private static int swap(int[] array, int index1, int index2) {
        if (array == null || array.length < 2 || index1 < 0 || index2 < 0 || index1 == index2) return 0;
        int tempo = array[index1];
        array[index1] = array[index2];
        array[index2] = tempo;
        return 1;
    }

}
