package com.frog.Andrey.utils;

import static java.lang.System.out;

public abstract class Benchmark {

    public static void test(Runnable exe) {
        test(exe, "Action");
    }


    public static void test(Runnable exe, String name) {
        if (exe == null) {
            throw new IllegalArgumentException("No executable was found to test");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("No name was given for test");
        }

        long start = System.currentTimeMillis();
        exe.run();
        long elapsed = System.currentTimeMillis() - start;
        out.println(name + " took " + elapsed + "ms to pass.");
    }

}
