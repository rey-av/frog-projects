package com.frog.nika.sort.sortClass;

import com.frog.nika.abstractClass.AbstractSort;

public class SortInsertion extends AbstractSort {

    @Override
    public void Sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int index = i;
            int temp = arr[i];

            while (index > 0 && arr[index - 1] >= temp) {
                arr[index] = arr[index - 1]; // меняем элемент на следующий
                index--;
            }
            arr[index] = temp;
        }

    }

}
