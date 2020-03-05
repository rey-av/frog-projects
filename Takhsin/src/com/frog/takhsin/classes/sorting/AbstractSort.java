package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;
import com.frog.takhsin.utils.Assert;

public abstract class AbstractSort {

    protected String name;


    public AbstractSort(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public int[] sort(int[] arr, SortDirection direction) {
        Assert.notNull(arr, "Array cannot be null");
        Assert.notNull(direction, "Direction cannot be null");
        Assert.isTrue(arr.length > 0, "Array cannot be empty");
        return null;
    }


    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
