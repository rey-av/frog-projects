package com.frog.takhsin;

import com.frog.takhsin.classes.sorting.AbstractSort;
import com.frog.takhsin.classes.sorting.BubbleSort;
import com.frog.takhsin.classes.sorting.CountingSort;
import com.frog.takhsin.classes.sorting.InsertionSort;
import com.frog.takhsin.classes.sorting.SelectionSort;
import com.frog.takhsin.classes.sorting.ShakerSort;
import com.frog.takhsin.classes.sorting.ShellSort;
import com.frog.takhsin.enums.SortDirection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<AbstractSort> sortingAlgorithms = Arrays.asList
                (new BubbleSort(),
                        new SelectionSort(),
                        new InsertionSort(),
                        new ShakerSort(),
                        new ShellSort(),
//                        new BogoSort(),
                        new CountingSort());

        Random random = new Random((System.currentTimeMillis() * 13) % 1000);
        int[] ints = IntStream.generate(() -> random.nextInt(1000) - 1000).limit(100000).toArray();

        for (AbstractSort algorithm : sortingAlgorithms) {
            System.out.println("\n\n" + algorithm.getName());
            System.out.println("ASC sorting: ");
            long tBefore = System.currentTimeMillis();
//            Arrays.stream(algorithm.sort(ints, SortDirection.ASC)).forEach(number -> System.out.print(number + " "));
            Arrays.stream(algorithm.sort(ints, SortDirection.ASC));
            System.out.println("Time: " + (System.currentTimeMillis() - tBefore));
            System.out.println("\nDSC sorting: ");
            tBefore = System.currentTimeMillis();
//            Arrays.stream(algorithm.sort(ints, SortDirection.DSC)).forEach(number -> System.out.print(number + " "));
            Arrays.stream(algorithm.sort(ints, SortDirection.DSC));
            System.out.println("Time: " + (System.currentTimeMillis() - tBefore));
        }

    }

}
