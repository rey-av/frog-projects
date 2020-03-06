package com.frog.Andrey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class Benchmark {

    private static final int RUNS_FOR_AVG = 100;
    private static final long ITERATIONS = 1000000000000L; // 1,000,000,000,000


    public static void main(String[] args) {
        run(Benchmark::iterateEquals, "Iterate with      equals     ");
        run(Benchmark::iterateCompare, "Iterate with     compare     ");
        // Iterate with      equals      test result : 131824 ms
        // Iterate with     compare      test result : 131054 ms
    }


    private static void iterateEquals() {
        long i = ITERATIONS;
        while (i != 0L) {
            i--;
        }
    }


    private static void iterateCompare() {
        long i = 0L;
        while (i < ITERATIONS) {
            i++;
        }
    }


    private static void run(Runnable target, String name) {
        // assert

        long elapsed;

        ExecutorService executor = newSingleThreadExecutor();
        try {
            elapsed = executor.submit(() -> test(target)).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            elapsed = -1L;
        } finally {
            executor.shutdown();
        }

        out.println(name + " test result : " + elapsed + " ms");
    }


    private static long test(Runnable target) {
        // assert

        long avg = 0;

        long start;
        for (int i = 0; i < RUNS_FOR_AVG; i++) {
            start = currentTimeMillis();
            target.run();
            avg = (currentTimeMillis() - start + avg) / 2;
        }

        return avg;
    }

}
