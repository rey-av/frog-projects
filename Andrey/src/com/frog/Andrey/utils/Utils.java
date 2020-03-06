package com.frog.Andrey.utils;

public abstract class Utils {

    public static int swap(int[] array, int i1, int i2) {
        if (array == null || array.length < 2 || i1 < 0 || i2 < 0 || i1 == i2) {
            return 0;
        }

        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;

        return 1;
    }


    public static int checksum(int[] array) {
        return checksum(113, 10000007, array);
    }


    public static int checksum(final int SEED, final int LIMIT, int[] array) {
        int size;
        if (array == null || (size = array.length) <= 0) {
            return 0;
        }

        int checksum = 0;
        for (int index = 0; index < size; index++) {
            // new checksum is modulo by LIMIT of previous checksum with current element both multiplied by SEED
            checksum = (checksum + array[index]) * SEED % LIMIT;
        }

        return checksum;
    }

}
