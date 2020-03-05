package com.frog.veronika;

import com.frog.veronika.search.GenerateArray;
import com.frog.veronika.search.ManagerSearch;

import java.util.Arrays;

import static com.frog.veronika.search.EnumSearch.searcherType;

public class Application {

    public static void main(String[] args) {// TODO: добавить логи
        ManagerSearch searchManager = new ManagerSearch();

        GenerateArray array = new GenerateArray();
        array.createArray();

        int searchKey = 48;

        int resultLinear = searchManager.Search(searcherType.LINEAR, array, searchKey);
        System.out.println("Linear search works:");
        System.out.println(Arrays.toString(array.getArray()));
        System.out.println("Index of " + searchKey + " : " + resultLinear + "\n");

        array.createOrderedArray();
        int resultBinary = searchManager.Search(searcherType.BINARY, array, searchKey);
        System.out.println("Binary search works:");
        System.out.println(Arrays.toString(array.getArray()));
        System.out.println("Index of " + searchKey + " : " + resultBinary + "\n");

        int resultError = searchManager.Search(searcherType.ERROR_CHECK, array, 100);

    }

}
