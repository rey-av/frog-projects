package com.frog.Andrey.scratch.finder.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class BulbFinder {

    //  input data:
    //  1 0 1 0 1 1
    //  0: 0 5
    //  1: 1 4
    //  2: 2 4
    //  3: 2 3 5
    //  4: 1 4
    //  5: 2 3 5
    //  
    //  answer:
    //  0 2

    private static final List<Boolean> BULBS = new ArrayList<>(asList(false, true, false, true, false, false));
    private static final Map<Integer, List<Integer>> MAP = new HashMap<>(BULBS.size());


    static {
        MAP.put(0, asList(0, 5));       // true
        MAP.put(1, asList(1, 4));       // false
        MAP.put(2, asList(2, 4));       // true
        MAP.put(3, asList(2, 3, 5));    // false
        MAP.put(4, asList(1, 4));       // true
        MAP.put(5, asList(2, 3, 5));    // true
    }


    public static void main(String[] args) {
//        turn(0);
//        turn(2);
//        makeSure();

        iterate(0);
    }


    public static void iterate(int index) {
        if (BULBS.get(index)) return;
    }


    private static void turn(int index) {
        List<Integer> indices = MAP.get(index);
        indices.forEach(i -> BULBS.set(i, !BULBS.get(i)));
    }


    private static void makeSure() {
        for (boolean f : BULBS)
            if (!f) {
                System.out.println("Some bulbs are still off.");
                return;
            }
        System.out.println("Every bulb is on!");
    }


//    private static void check() {
//        BULBS.forEach(System.out::println);
//    }

}
