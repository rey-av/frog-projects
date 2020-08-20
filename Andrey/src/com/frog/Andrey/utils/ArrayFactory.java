package com.frog.Andrey.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ArrayFactory {

    private static final int SIZE = 2000;
    private static final int L = -100;
    private static final int U = 100;


    public static List<Integer> generate() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            result.add(random.nextInt((U - L) + 1) + L);
        }
        return result;
    }

}
