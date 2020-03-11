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


    private static final int TEST_ARRAY_SIZE = 60_000;
    private static final Random RANDOM = new Random((System.currentTimeMillis() * 13) % 1000);


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

        int[] randomNumbers = IntStream.generate(() -> RANDOM.nextInt(1000) - 1000).limit(TEST_ARRAY_SIZE).toArray();

        for (AbstractSort algorithm : sortingAlgorithms) {
            System.out.println("\n\n" + algorithm.getName());
            System.out.println("ASC sorting: ");
            long tBefore = System.currentTimeMillis();
//            Arrays.stream(algorithm.sort(randomNumbers, SortDirection.ASC)).forEach(number -> System.out.print(number + " "));
            Arrays.stream(algorithm.sort(randomNumbers, SortDirection.ASC));
            System.out.println("Time: " + (System.currentTimeMillis() - tBefore));
            System.out.println("\nDSC sorting: ");
            tBefore = System.currentTimeMillis();
//            Arrays.stream(algorithm.sort(randomNumbers, SortDirection.DSC)).forEach(number -> System.out.print(number + " "));
            Arrays.stream(algorithm.sort(randomNumbers, SortDirection.DSC));
            System.out.println("Time: " + (System.currentTimeMillis() - tBefore));
        }

    }

}
