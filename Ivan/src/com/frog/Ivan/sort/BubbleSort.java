package com.frog.Ivan.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/sort/bubblesort.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            int pass = 0;
            int change = 0;
            boolean isChanged;
            String[] init = s.split(" ");
            int[] mass = Arrays.stream(init).mapToInt(Integer::parseInt).toArray();
            bubbleSort(mass);
            for (int value : mass) {
                System.out.print(value + " ");
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

}
