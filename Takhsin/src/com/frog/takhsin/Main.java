package com.frog.takhsin;

import com.frog.takhsin.classes.sorting.AbstractSort;
import com.frog.takhsin.classes.sorting.BubbleSort;
import com.frog.takhsin.classes.sorting.CountingSort;
import com.frog.takhsin.classes.sorting.InsertionSort;
import com.frog.takhsin.classes.sorting.MergingSort;
import com.frog.takhsin.classes.sorting.SelectionSort;
import com.frog.takhsin.classes.sorting.ShakerSort;
import com.frog.takhsin.classes.sorting.ShellSort;
import com.frog.takhsin.enums.SortDirection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {


    private static final int TEST_ARRAY_SIZE = 10000;
    private static final Random RANDOM = new Random((System.currentTimeMillis() * 13) % 1000);
    private static final int UPPER_BOUND = 500;
    private static final int LOWER_BOUND = 200;


    public static void main(String[] args) {
        // write your code here
        List<AbstractSort> sortingAlgorithms = Arrays.asList
                (new BubbleSort(),
                        new SelectionSort(),
                        new InsertionSort(),
                        new ShakerSort(),
                        new ShellSort(),
//                        new BogoSort(),
                        new CountingSort(),
                        new MergingSort());

        int[] randomNumbers = IntStream.generate(() -> RANDOM.nextInt(UPPER_BOUND) - LOWER_BOUND).limit(TEST_ARRAY_SIZE).toArray();

        for (AbstractSort algorithm : sortingAlgorithms) {
            System.out.println("\n" + algorithm.getName());
            System.out.print("ASC sorting: ");
            long tBefore = System.currentTimeMillis();
            algorithm.sort(randomNumbers.clone(), SortDirection.ASC);
            System.out.println(System.currentTimeMillis() - tBefore);
            System.out.print("DSC sorting: ");
            tBefore = System.currentTimeMillis();
            algorithm.sort(randomNumbers.clone(), SortDirection.DSC);
            System.out.println(System.currentTimeMillis() - tBefore);
        }

    }

}
