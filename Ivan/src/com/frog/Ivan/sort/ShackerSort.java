package com.frog.Ivan.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//TODO: in progress
public class ShackerSort {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/sort/shackersort.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] init = s.split(" ");
            int[] array = Arrays.stream(init).mapToInt(Integer::parseInt).toArray();
            while (true) {
                boolean isSorted = false;
                for (int i = 0; i < array.length; i++) {
                    for (int j = i; j < array.length; j++) {
                        if (array[i] > array[j]) {
                            sortAsc(array, i, j);
                            isSorted = true;
                        }
                    }

                    if (!isSorted) {
                        break;
                    }
                }
            }
//            for (int i = 0; i < array.length; i++) {
//                System.out.print(array[i] + " ");
//            }
        }
    }

    private static void sortAsc(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

}