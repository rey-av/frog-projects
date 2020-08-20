package com.frog.Andrey.sort;

import com.frog.Andrey.utils.ArrayFactory;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedCountingSort {

    public static void main(String[] args) {
        List<Integer> unsorted = ArrayFactory.generate();
        List<Integer> sorted = sort(unsorted);

        System.out.println(unsorted);
        System.out.println(sorted);
    }


    public static List<Integer> sort(List<Integer> input) {
        // assert

        ArrayList<Integer> clone = new ArrayList<>(input);

        int min = find(clone, false);
        int max = find(clone, true);
        int diff = max - min + 1;
        int delay = Math.min(min, 0);

        int[] vocabulary = new int[diff];
        for (int value : clone) ++vocabulary[value - delay];

        List<Integer> result = new ArrayList<>(clone.size());

        for (int i = 0; i < diff; i++)
            for (int j = 0; j < vocabulary[i]; j++) result.add(i + delay);

        return result;
    }


    private static int find(List<Integer> list, boolean max) {
        // assert
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++)
            result = max ? Math.max(result, list.get(i)) : Math.min(result, list.get(i));
        return result;
    }

}
