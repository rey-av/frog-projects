package com.frog.veronika.search.searcherClass;

import com.frog.veronika.search.abstractClass.AbstractSearch;


public class SearchLinear extends AbstractSearch {

    @Override
    public int Search(int[] array, int key) {
        if (array == null) {
            System.out.println("Array cannot be null.Search was interrupted.");
            return -1;
        }

        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return index;
            }
        }
        return -1;
    }

}
