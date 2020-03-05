package com.frog.Andrey.utils;

public abstract class SortUtils {

    /**
     * Sorts given array via bubble sort.
     *
     * @param array Array to be sorted.
     * @return Number of swaps used by bubble sort.
     */
    public static int bubbleSort(int[] array) {
        int size;
        if (array == null || (size = array.length) <= 0) return 0;
        int total = 0;
        int count;
        do {
            count = total;
            for (int index = 1; index < size; index++) {
                int prev = index - 1;
                if (array[prev] > array[index]) total += swap(array, prev, index);
            }
        } while (total != count);
        return total;
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
