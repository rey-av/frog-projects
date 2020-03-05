package com.frog.veronika.search.searcherClass;

import com.frog.veronika.search.GenerateArray;
import com.frog.veronika.search.abstractClass.AbstractSearch;

public class SearchBinary extends AbstractSearch {

    @Override
    public int Search(GenerateArray arr, int key) {

        int index = -1;
        int high = arr.getArray().length - 1;
        int low = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr.getArray()[mid] < key) {        // поиск в "правой" половине массива
                low = mid + 1;
            } else if (arr.getArray()[mid] > key) { // поиск в "левой" половине массива
                high = mid - 1;
            } else if (arr.getArray()[mid] == key) { // если середина равна искомому значению
                index = mid;
                break;
            }
        }
        return index;
    }

}
