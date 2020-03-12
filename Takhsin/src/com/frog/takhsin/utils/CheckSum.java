package com.frog.takhsin.utils;

public abstract class CheckSum {

    private static final long SEED = 89;
    private static final long LIMIT = 10000007;


    public static long checkSum(int[] arr) {
        Assert.isTrue(arr != null && arr.length > 0, "Array cannot be null or empty");

        long checksum = 0;

        for (int i : arr) {
            checksum = ((checksum + i) * SEED) % LIMIT;
        }

        return checksum;
    }


    public static boolean compareCheckSum(int[] arr1, int[] arr2) {
        return checkSum(arr1) == checkSum(arr2);
    }

}
