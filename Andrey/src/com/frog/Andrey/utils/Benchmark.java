package com.frog.Andrey.utils;

import com.frog.Andrey.sort.BubbleSort;
import com.frog.Andrey.sort.SelectionSort;
import com.frog.Andrey.sort.SimplifiedCountingSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.Executors.newFixedThreadPool;

public abstract class Benchmark {

    private static final int NUMBER_OF_RUNS = 100;


    public static void main(String[] args) {
        List<Integer> list = ArrayFactory.generate();
        int[] array = list.stream().mapToInt(value -> value).toArray();

        Runnable bubbleSort = () -> BubbleSort.sort(array);
        run(bubbleSort, "Bubble");

        Runnable selectionSort = () -> SelectionSort.sort(array);
        run(selectionSort, "Selection");

        Runnable simplifiedCountingSort = () -> SimplifiedCountingSort.sort(list);
        run(simplifiedCountingSort, "Counting");
    }


    public static void run(Runnable target, String name) {
        // assert

        // should be (N of logical cores - 1) threads at a time
        // parallel work for all sorts is incorrect as processor can make priority
        intercept(target, name);
    }


    private static void intercept(Runnable target, String name) {
        try {
            test(target, name);
        } catch (ExecutionException | InterruptedException e) {
            out.println("Cannot test due to: " + e.getMessage());
        }
    }


    private static void test(Runnable target, String name) throws ExecutionException, InterruptedException {
        // assert

        // preparing
        int cores = getRuntime().availableProcessors();
        ExecutorService executor = newFixedThreadPool(cores > 1 ? cores - 1 : cores);

        // pooling
        List<Future<Long>> futures = new ArrayList<>(NUMBER_OF_RUNS);
        for (int i = 0; i < NUMBER_OF_RUNS; i++) futures.add(executor.submit(() -> calculate(target)));

        // collecting
        long total = 0;
        while (!futures.isEmpty()) {
            for (Future<Long> future : futures) {
                if (future.isDone()) {
                    total += future.get();
                    futures.remove(future);
                    break;
                }
            }
        }
        executor.shutdown();

        long ms = total / NUMBER_OF_RUNS;
        out.println(name + "\tfinished with " + ms + "ms\tby " + NUMBER_OF_RUNS + " iterations");
    }


    private static Long calculate(Runnable target) {
        // assert
        long start = currentTimeMillis();
        target.run();
        return currentTimeMillis() - start;
    }

}
