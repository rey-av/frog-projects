package com.frog.Andrey.utils;

public abstract class ArithmeticUtils {

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
