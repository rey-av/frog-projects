package com.frog.Andrey.utils;

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

    private static final int NUMBER_OF_RUNS = 10;


    public static void run(Runnable target, String name) {
        if (target == null) throw new IllegalArgumentException("Action cannot be null");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be blank");

        (new Thread(() -> intercept(target), name)).start();
    }


    private static void intercept(Runnable target) {
        try {
            test(target);
        } catch (ExecutionException | InterruptedException e) {
            out.println("Cannot test due to: " + e.getMessage());
        }
    }


    private static void test(Runnable target) throws ExecutionException, InterruptedException {
        if (target == null) throw new IllegalArgumentException("Action cannot be null");

        String threadName = currentThread().getName();

        // preparing
        int availableProcessors = getRuntime().availableProcessors();
        ExecutorService executor = newFixedThreadPool(availableProcessors);

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

                out.println("Calculating " + threadName + "...");
                Thread.sleep(1000);
            }
        }
        executor.shutdown();

        long avg = total / NUMBER_OF_RUNS;
        out.println(threadName + "\tfinished with average of " + avg + "ms\tby " + NUMBER_OF_RUNS + " iterations");
    }


    private static Long calculate(Runnable target) {
        long start = currentTimeMillis();
        target.run();
        return currentTimeMillis() - start;
    }

}
