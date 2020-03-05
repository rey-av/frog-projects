package com.frog.Andrey;

import java.util.Arrays;

import static com.frog.Andrey.utils.ArithmeticUtils.checksum;
import static com.frog.Andrey.utils.SortUtils.bubbleSort;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        // checksum
//        out.println(checksum(new int[]{3, 1, 4, 1, 5, 9}));

        // bubble sort
        int[] array = {1, 4, 3, 2, 6, 5};
        out.println(Arrays.toString(array));
        int swapped = bubbleSort(array);
        out.println(Arrays.toString(array));
        out.println(swapped + " " + checksum(array));
    }

}
