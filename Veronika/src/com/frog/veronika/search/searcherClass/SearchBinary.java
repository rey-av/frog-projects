package com.frog.veronika.search.searcherClass;

import com.frog.veronika.search.abstractClass.AbstractSearch;

public class SearchBinary extends AbstractSearch {

    /**
     * @param arr УПОРЯДОЧЕННЫЙ массив int[]
     * @param key искомое значение
     * @return
     */
    @Override
    public int Search(int[] arr, int key) {

        int index = -1;
        int high = arr.length - 1;
        int low = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] < key) {        // поиск в "правой" половине массива
                low = mid + 1;
            } else if (arr[mid] > key) { // поиск в "левой" половине массива
                high = mid - 1;
            } else if (arr[mid] == key) { // если середина равна искомому значению
                index = mid;
                break;
            }
        }
        return index;
    }

}
