package com.frog.Andrey.sort;

import java.util.LinkedList;

import static java.util.Arrays.asList;

public class InsertionSort {

    public static void main(String[] args) {
        LinkedList<String> list;

        list = new LinkedList<>(asList("Logos", "Buenos", "Aires", "Wind", "Infrastructure", "Cynical", "Heart"));
        sort(list);
        System.out.println(list);

        list = new LinkedList<>(asList("34", "2", "9", "50", "11110", "0011"));
        sort(list);
        System.out.println(list);
    }


    public static void sort(LinkedList<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        int it; // index to iterate over
        int in; // index to insert at
        for (it = 1; it < list.size(); it++) {
            for (in = 0; in < it; in++) {
                if (list.get(in).compareTo(list.get(it)) > 0) {
                    list.add(in, list.remove(it));
                }
            }
        }
    }

}
