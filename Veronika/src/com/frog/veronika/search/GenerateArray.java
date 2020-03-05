package com.frog.veronika.search;

import java.util.Arrays;
import java.util.Random;

public class GenerateArray {

    private int[] nums;
    private Random rnd = new Random(System.currentTimeMillis());

    public int[] createArray() {
        nums = new int[]{39, 56, 82, 112, 136, 5, 162, 253, 7, 21, 73, 226, 182, 67, 147, 45, 287, 282, 191,
                151, 285, 132, 257, 245, 190, 254, 272, 89, 267};
        return nums;
    }


    public int[] createRandomArray(int size, int min, int max) {
        nums = new int[size];
        for (int i = 0; i < size; i++) {

            nums[i] = min + rnd.nextInt(max - min + 1);
        }
        return nums;
    }

    public void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr)); // TODO: переделать на более красивый вывод
    }

}
