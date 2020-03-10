package com.frog.Andrey.sort;

import com.frog.Andrey.classes.SortInfo;

import java.util.Arrays;

import static com.frog.Andrey.utils.Utils.checksum;
import static com.frog.Andrey.utils.Utils.swap;
import static java.lang.System.out;

public class BubbleSort {

    private static final int[] ARRAY = new int[]{3, 1, 4, 1, 5, 9, 2, 6};


    public static void main(String[] args) {
        // sort, show passes and swaps
        int[] arr = ARRAY;
        SortInfo info = sort(arr);
        out.println(Arrays.toString(arr) + "\n" + info.getPasses() + " " + info.getSwaps() + " " + checksum(arr));
    }


    public static SortInfo sort(int[] array) {
        if (array == null || array.length <= 0) return new SortInfo(0, 0);

        int passes = 1; // count last pass
        int total = 0; // total swaps
        int swaps;
        while ((swaps = iterate(array)) != 0) {
            total += swaps;
            passes++;
        }

        return new SortInfo(passes, total);
    }


    private static int iterate(int[] array) {
        int count = 0;
        int cur; // current
        int prev; // previous
        for (cur = 1; cur < array.length; cur++) {
            prev = cur - 1;
            if (array[prev] > array[cur]) count += swap(array, prev, cur);
        }
        return count;
    }

}
