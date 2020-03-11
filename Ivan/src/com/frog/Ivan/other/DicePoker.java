package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//According to input params
public class DicePoker {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/other/dicepocker.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] init = s.split(" ");
            int[] arrayInt = Arrays.stream(init).mapToInt(Integer::parseInt).toArray();
            List<Integer> array = new ArrayList<>();
            for (Integer i : arrayInt) {
                array.add(i);
            }
            if (array.contains(6) && array.contains(2) && array.contains(3) && array.contains(4) && array.contains(5)) {
                System.out.print("big-straight ");
            } else if (array.contains(1) && array.contains(2) && array.contains(3) && array.contains(4) && array.contains(5)) {
                System.out.print("small-straight ");
            } else if (isFullHouse(array)) {
                System.out.print("full-house ");
            } else if (isTwoPairs(array)) {
                System.out.print("two-pairs ");
            } else if (isMultiple(array, 5)) {
                System.out.print("yacht ");
            } else if (isMultiple(array, 4)) {
                System.out.print("four ");
            } else if (isMultiple(array, 3)) {
                System.out.print("three ");
            } else if (isMultiple(array, 2)) {
                System.out.print("pair ");
            } else {
                System.out.println("none ");
            }
        }
    }


    private static boolean isMultiple(List<Integer> list, int quantity) {
        int firstCount;
        for (int i = 1; i < 7; i++) {
            firstCount = 0;
            for (Integer k : list) {
                if (k == i) {
                    firstCount++;
                }
            }
            if ((firstCount == quantity)) {
                return true;
            }
        }
        return false;
    }


    private static boolean isTwoPairs(List<Integer> list) {
        int firstCount;
        int secondCount;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (i == j) {
                    continue;
                }
                firstCount = 0;
                secondCount = 0;
                for (Integer k : list) {
                    if (k == i) {
                        firstCount++;
                    }
                    if (k == j) {
                        secondCount++;
                    }
                }
                if ((firstCount == 2 && secondCount == 2)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean isFullHouse(List<Integer> list) {
        int firstCount;
        int secondCount;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                firstCount = 0;
                secondCount = 0;
                for (Integer k : list) {
                    if (k == i) {
                        firstCount++;
                    }
                    if (k == j) {
                        secondCount++;
                    }
                }
                if ((firstCount == 2 && secondCount == 3) || (firstCount == 3 && secondCount == 2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
