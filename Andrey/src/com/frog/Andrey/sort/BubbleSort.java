package com.frog.Andrey.sort;

import com.frog.Andrey.classes.SortInfo;

import java.util.Arrays;

import static com.frog.Andrey.utils.Utils.checksum;
import static com.frog.Andrey.utils.Utils.swap;

public class BubbleSort {

    public static void main(String[] args) {
        final int[] ref = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] arr;

        // iterate, show swaps and result checksum
        arr = ref;
        int swaps = iterate(arr);
        System.out.println(Arrays.toString(arr) + "\n" + swaps + " " + checksum(arr));

        // sort, show passes and swaps
        arr = ref.clone();
        SortInfo info = sort(arr);
        System.out.println(Arrays.toString(arr) + "\n" + info.getPasses() + " " + info.getSwaps());
    }


    public static SortInfo sort(int[] array) {
        if (array == null || array.length <= 0) {
            return new SortInfo(0, 0);
        }

        int passes = 1; // count last pass
        int total = 0; // total swaps
        int swaps;
        while ((swaps = iterate(array)) != 0) {
            total += swaps;
            passes++;
        }

        return new SortInfo(passes, total);
    }


    public static int iterate(int[] array) {
        int size;
        if (array == null || (size = array.length) <= 0) {
            return 0;
        }

        int count = 0;
        int cur; // current
        int prev; // previous
        for (cur = 1; cur < size; cur++) {
            prev = cur - 1;
            if (array[prev] > array[cur]) count += swap(array, prev, cur);
        }

        return count;
    }

}
