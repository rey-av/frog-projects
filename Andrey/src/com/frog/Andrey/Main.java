package com.frog.Andrey;

import com.frog.Andrey.classes.SortInfo;

import java.util.Arrays;

import static com.frog.Andrey.utils.ArithmeticUtils.checksum;
import static com.frog.Andrey.utils.SortUtils.bubbleIterate;
import static com.frog.Andrey.utils.SortUtils.bubbleSort;

public class Main {

    public static void main(String[] args) {
        // checksum // Code Abbey checksum ✔
        int[] array = {3, 1, 4, 1, 5, 9};
        System.out.println(checksum(array));

        // bubble iterate // Code Abbey bubble iterate ✔
        array = new int[]{1, 4, 3, 2, 6, 5};
        int swaps = bubbleIterate(array);
        System.out.println(Arrays.toString(array) + "\n" + swaps + " " + checksum(array));

        // bubble sort // Code Abbey bubble sort ✔
        array = new int[]{3, 1, 4, 1, 5, 9, 2, 6};
        SortInfo info = bubbleSort(array);
        System.out.println(Arrays.toString(array) + "\n" + info.getPasses() + " " + info.getSwaps());
    }

}
