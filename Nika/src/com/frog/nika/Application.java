package com.frog.nika;

import com.frog.nika.search.RandomData;
import com.frog.nika.search.ManagerSearch;

import java.util.Arrays;

import static com.frog.nika.search.EnumSearch.searcherType;

public class Application {

    public static void main(String[] args) {// TODO: добавить логи
        ManagerSearch searchManager = new ManagerSearch();

        RandomData array = new RandomData();
        array.createArray();

        int searchKey = 48;

        int resultLinear = searchManager.Search(searcherType.LINEAR, array.getArray(), searchKey);
        System.out.println("Linear search works:");
        System.out.println(Arrays.toString(array.getArray()));
        System.out.println("Index of " + searchKey + " : " + resultLinear + "\n");

        array.createOrderedArray();
        int resultBinary = searchManager.Search(searcherType.BINARY, array.getArray(), searchKey);
        System.out.println("Binary search works:");
        System.out.println(Arrays.toString(array.getArray()));
        System.out.println("Index of " + searchKey + " : " + resultBinary + "\n");

        int resultError = searchManager.Search(searcherType.ERROR_CHECK, array.getArray(), 100);

    }

}
