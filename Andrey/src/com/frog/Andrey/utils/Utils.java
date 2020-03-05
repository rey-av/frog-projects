package com.frog.Andrey.utils;

public abstract class Utils {

    public static int swap(int[] array, int index1, int index2) {
        if (array == null || array.length < 2 || index1 < 0 || index2 < 0 || index1 == index2) return 0;
        int tempo = array[index1];
        array[index1] = array[index2];
        array[index2] = tempo;
        return 1;
    }


    public static int checksum(int[] array) {
        return checksum(113, 10000007, array);
    }


    public static int checksum(final int SEED, final int LIMIT, int[] array) {
        int size;
        if (array == null || (size = array.length) <= 0) return 0;
        int result = 0;
        for (int index = 0; index < size; index++) result = (result + array[index]) * SEED % LIMIT;
        return result;
    }

}
