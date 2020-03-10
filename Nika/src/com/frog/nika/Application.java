package com.frog.nika;

import com.frog.nika.search.ManagerSearch;
import com.frog.nika.sort.EnumSort;
import com.frog.nika.sort.ManagerSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

        /// -------------------    МАПЫ    ------------------- ///
        HashMap<String, String> stringHashMap = new HashMap<String, String>();

        // положить значения
        stringHashMap.put("Vasy", "12.12.1998"); // 1-key, 2-value
        stringHashMap.put("Pety", "05.06.1996");
        stringHashMap.put("Toly", "18.09.1997");

        showHashMap(stringHashMap);

        String key = "Vasy";

        // значение по ключу
        System.out.println("Value from key Vasy: " + stringHashMap.get(key) + "\n");

        // удалить по ключу
        stringHashMap.remove(key);
        System.out.println("After remove value from key: " + key);
        showHashMap(stringHashMap);
    }

    private static void showHashMap(HashMap<String, String> map) {
        // показать все запись в виде ключ-значение
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " - " + value);
        }
        System.out.println();
    }
}
