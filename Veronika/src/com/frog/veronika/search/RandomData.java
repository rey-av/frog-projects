package com.frog.veronika.search;

import java.util.Random;

public class RandomData {

    private int[] nums;
    private Random rnd = new Random(System.currentTimeMillis());


    public int[] createArray() {
        nums = new int[]{39, 56, 82, 112, 136, 5, 162, 48, 7};
        return nums;
    }

    // TODO:Обновить метод добавив bool параметр, включающий метод сортировки
    public int[] createRandomArray(int size, int min, int max) {
        nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = min + rnd.nextInt(max - min + 1);
        }

        return nums;
    }

    // TODO: Удалить после обновления "createRandomArray"
    public int[] createOrderedArray() {
        nums = new int[]{19, 48, 50, 56, 68, 69, 70, 94, 103};
        return nums;
    }


    public int[] getArray() {
        return nums;
    }

    public void setArray(int[] arr) {
        nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
    }

}
