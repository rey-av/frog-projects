package com.frog.Andrey.utils;

public abstract class ArithmeticUtils {

    /**
     * Calculates checksum of given array.
     *
     * @param array Array which checksum is to be checked.
     * @return Checksum of a given array.
     */
    public static int checksum(int[] array) {
        return checksum(113, 10000007, array);
    }


    /**
     * Calculates checksum of given array.
     *
     * @param seed  Seed to be used in calculations.
     * @param limit Limit to be used in calculations.
     * @param array Array which checksum is to be checked.
     * @return Checksum of a given array.
     */
    public static int checksum(final int seed, final int limit, int[] array) {
        int size;
        if (array == null || (size = array.length) <= 0) return 0;
        int result = 0;
        for (int index = 0; index < size; index++) result = (result + array[index]) * seed % limit;
        return result;
    }

}
