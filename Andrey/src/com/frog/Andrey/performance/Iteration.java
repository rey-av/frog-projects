package com.frog.Andrey.performance;

import static com.frog.Andrey.utils.Benchmark.run;

public class Iteration {

    private static final long ITERATIONS = 1_000_000_000L;


    public static void main(String[] args) {
        testOperators();
    }


    private static void testOperators() {
        run(Iteration::iterateEquals, "Equals");
        run(Iteration::iterateCompare, "Compare");

        // Equals	finished with average of 1050ms	by 10 iterations
        // Compare	finished with average of 1387ms	by 10 iterations

        // Equals	finished with average of 1059ms	by 10 iterations
        // Compare	finished with average of 1369ms	by 10 iterations

        // Equals	finished with average of 982ms	by 10 iterations
        // Compare	finished with average of 1454ms	by 10 iterations
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

}
