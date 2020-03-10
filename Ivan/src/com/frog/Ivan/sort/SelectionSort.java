package com.frog.Ivan.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/sort/selectionsort.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] init = s.split(" ");
            int[] array = Arrays.stream(init).mapToInt(Integer::parseInt).toArray();
            int max;
            int maxIndex;
            boolean swapped;
            for (int i = 0; i < array.length; i++) {
                swapped = false;
                max = 0;
                maxIndex = 0;
                for (int j = 0; j < array.length - i; j++) {
                    if (array[j] > max) {
                        swapped = true;
                        max = array[j];
                        maxIndex = j;
                    }
                }
                if (swapped) {
                    swap(array, maxIndex, array.length - i - 1);
//                    System.out.print(maxIndex + " "); // Show index of swapped element (CodeAbbey task)
                } else {
                    break;
                }
            }
            for (int i : array) {
                System.out.print(i + " ");
            }
        }
    }

    private static void swap(int[] array, int maxIndex, int i) {
        int temp = array[i];
        array[i] = array[maxIndex];
        array[maxIndex] = temp;
    }

}
