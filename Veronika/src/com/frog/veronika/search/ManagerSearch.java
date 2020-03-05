package com.frog.veronika.search;

import com.frog.veronika.search.EnumSearch.searcherType;
import com.frog.veronika.search.abstractClass.AbstractSearch;

public class ManagerSearch {


    private SearcherFactory fact;

    public ManagerSearch()
    {
        fact = new SearcherFactory();
    }


    public void Search(searcherType type) {
        AbstractSearch searcher = fact.SelectSearcher(type);
        if(searcher == null) {
            System.out.println("Invalid searcher type. Search was interrupted. Current search type: " + type);
            return;
        }
        searcher.Search();
    }

}
