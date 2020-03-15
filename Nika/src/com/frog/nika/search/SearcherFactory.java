package com.frog.nika.search;

import com.frog.nika.abstractClass.AbstractSearch;
import com.frog.nika.search.searcherClass.SearchBinary;
import com.frog.nika.search.searcherClass.SearchLinear;


import static com.frog.nika.search.EnumSearch.*;

public class SearcherFactory {

    public AbstractSearch SelectSearcher(searcherType type) {
        switch (type) {
            case BINARY:
                return new SearchBinary();
            case LINEAR:
                return new SearchLinear();
        }
        return null;
    }

}
