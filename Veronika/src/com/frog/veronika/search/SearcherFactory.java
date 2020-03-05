package com.frog.veronika.search;

import com.frog.veronika.search.abstractClass.AbstractSearch;
import com.frog.veronika.search.searcherClass.SearchBinary;
import com.frog.veronika.search.searcherClass.SearchLinear;


import static com.frog.veronika.search.EnumSearch.*;

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
