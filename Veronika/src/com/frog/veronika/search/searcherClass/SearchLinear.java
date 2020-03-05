package com.frog.veronika.search.searcherClass;

import com.frog.veronika.search.GenerateArray;
import com.frog.veronika.search.abstractClass.AbstractSearch;


public class SearchLinear extends AbstractSearch {

    @Override
    public int Search(GenerateArray array, int key) {
        for (int index = 0; index < array.getArray().length; index++) {
            if (array.getArray()[index] == key) {
                return index;
            }
        }
        return -1;
    }

}
