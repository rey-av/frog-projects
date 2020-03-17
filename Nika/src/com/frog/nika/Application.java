package com.frog.nika;

import com.frog.nika.search.ManagerSearch;
import com.frog.nika.sort.EnumSort;
import com.frog.nika.sort.ManagerSort;

import java.util.Arrays;
import java.util.SortedMap;

import static com.frog.nika.search.EnumSearch.searcherType;

public class Application {

    public static void main(String[] args) {// TODO: добавить логи

        /// -------------------    ПОИСК    ------------------- ///
        ManagerSearch searchManager = new ManagerSearch();

        GetData array = new GetData();
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

        System.out.println(searchManager.Search(searcherType.ERROR_CHECK, array.getArray(), 100) + "\n");

        /// -------------------    СОРТИРОВКИ    ------------------- ///
        ManagerSort sortManager = new ManagerSort();
        int[] arr = array.createRandomArray(10, 1, 100);
        System.out.println("Unordered array: " + Arrays.toString(arr));
        sortManager.Sort(EnumSort.sortType.BUBBLE, arr); // упорядочили
        System.out.println("After BUBBLE SORT: " + Arrays.toString(arr) + "\n");

        arr = array.createRandomArray(10, 1, 100);  // перемешиваем заново
        System.out.println("Unordered array: " + Arrays.toString(arr));
        sortManager.Sort(EnumSort.sortType.INSERTION, arr);
        System.out.println("After INSERTION SORT: " + Arrays.toString(arr) + "\n");

        arr = array.createRandomArray(10, 1, 100);
        System.out.println("Unordered array: " + Arrays.toString(arr));
        sortManager.Sort(EnumSort.sortType.SELECTION, arr);
        System.out.println("After SELECTION SORT: " + Arrays.toString(arr) + "\n");

    }

}
