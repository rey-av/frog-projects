package com.frog.Andrey.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static List<Integer> run(List<Integer> input) {
        if (input.isEmpty()) throw new IllegalArgumentException();
        return sort(new ArrayList<>(input));
    }


    private static List<Integer> sort(List<Integer> list) {
        int size = list.size();
        if (size == 1) return list;
        int middle = (size + 1) / 2;
        return merge(sort(list.subList(0, middle)), sort(list.subList(middle, size)));
    }


    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>(left.size() + right.size());
    }

}
