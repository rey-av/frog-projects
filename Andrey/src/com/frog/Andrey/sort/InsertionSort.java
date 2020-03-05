package com.frog.Andrey.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertionSort {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(
                "Logos", "Buenos", "Aires", "Wind", "Infrastructure", "Cynical", "Heart", "Thought"));
        System.out.println(sort(list));
        list = new LinkedList<>(Arrays.asList("34", "2", "9", "50", "11110", "0011"));
        System.out.println(sort(list));
    }


    public static LinkedList<String> sort(LinkedList<String> list) {
        if (list == null || list.isEmpty()) return list;
        for (int i = 1; i < list.size(); i++)
            for (int j = 0; j < i; j++) if (list.get(j).compareTo(list.get(i)) > 0) list.add(j, list.remove(i));
        return list;
    }

}
