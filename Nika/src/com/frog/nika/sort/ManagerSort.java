package com.frog.nika.sort;

import com.frog.nika.abstractClass.AbstractSort;

import static com.frog.nika.sort.EnumSort.sortType;

public class ManagerSort {

    private SorterFactory factory;

    public ManagerSort() {
        factory = new SorterFactory();
    }

    public void Sort(sortType type, int[] arr) {
        AbstractSort abstractSort = factory.SelectSort(type);
        if (type == null) {
            System.out.println("Invalid sort type. Sort was interrupted. Current sort type: " + type);
            return;
        }
        abstractSort.Sort(arr);
    }
}
