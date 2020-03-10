package com.frog.takhsin;

import com.frog.takhsin.classes.sorting.AbstractSort;
import com.frog.takhsin.classes.sorting.BogoSort;
import com.frog.takhsin.classes.sorting.BubbleSort;
import com.frog.takhsin.classes.sorting.InsertionSort;
import com.frog.takhsin.classes.sorting.SelectionSort;
import com.frog.takhsin.classes.sorting.ShakerSort;
import com.frog.takhsin.classes.sorting.ShellSort;
import com.frog.takhsin.enums.SortDirection;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<AbstractSort> sortingAlgorithms = Arrays.asList(new BubbleSort(), new SelectionSort(), new InsertionSort(), new ShakerSort(), new ShellSort(), new BogoSort());

        int[] ints = {1, 4, 3, 2, 6, 5, -1,91,-5,10};
        for (AbstractSort algorithm : sortingAlgorithms) {
            System.out.println("\n\n" + algorithm.getName());
            System.out.println("ASC sorting: ");
            Arrays.stream(algorithm.sort(ints, SortDirection.ASC)).forEach(number -> System.out.print(number + " "));
            System.out.println("\nDSC sorting: ");
            Arrays.stream(algorithm.sort(ints, SortDirection.DSC)).forEach(number -> System.out.print(number + " "));
        }

    }

}
