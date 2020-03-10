package com.frog.takhsin.classes.sorting;

import com.frog.takhsin.enums.SortDirection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BogoSort extends AbstractSort {

    public BogoSort() {
        super("Bogo sort");
    }


    @Override
    public int[] sort(int[] arr, SortDirection direction) {
        super.sort(arr, direction);

        if (arr.length == 1) {
            return arr;
        }

        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        while (!isSorted(integerList, direction)) {
            Collections.shuffle(integerList);
        }

        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static boolean isSorted(List<Integer> listOfIntegers, SortDirection direction) {
        Iterator<Integer> iter = listOfIntegers.iterator();
        Integer current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (SortDirection.ASC.equals(direction)) {
                if (previous.compareTo(current) > 0) {
                    return false;
                }
            } else {
                if (previous.compareTo(current) < 0) {
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }

}
