package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;
import com.frog.takhsin.interfaces.ISort;
import com.frog.takhsin.utils.Assert;

public class BubbleSort implements ISort {


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        Assert.notNull(arr, "Array cannot be null");
        Assert.notNull(direction, "Direction cannot be null");
        Assert.isTrue(arr.length > 0, "Array cannot be empty");

        if (arr.length == 1) {
            return arr;
        }

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (direction.equals(SortDirection.ASC)) {
                    if (arr[i + 1] < arr[i]) {
                        swap(arr, i, i + 1); // no pass by reference, thanks Java :(
                        swapped = true;
                    }
                } else {
                    if (arr[i + 1] > arr[i]) {
                        swap(arr, i, i + 1);
                        swapped = true;
                    }
                }
            }
        }

        return arr;
    }


    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


//    public static void main(String[] args) {
//        int[] ints = {1, 4, 3, 2, 6, 5, -1};
//        BubbleSort bubbleSort = new BubbleSort();
//        int[] sorted = bubbleSort.sort(ints, SortDirection.ASC);
//        Arrays.stream(sorted).forEach(System.out::print);
//
//        System.out.println();
//        int[] sorted2 = bubbleSort.sort(ints, SortDirection.DSC);
//        Arrays.stream(sorted2).forEach(System.out::print);
//    }

}
