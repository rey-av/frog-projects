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
//            for (int i = 0; i < mass.length; i++) {
//                isChanged = false;
//                for (int j = i; j < mass.length; j++) {
//                    if(mass[i] > mass[j]) {
//                        int temp = mass[i];
//                        mass[i] = mass[j];
//                        mass[j] = temp;
//                        change++;
//                        isChanged = true;
//                    }
//                }
//                if(!isChanged) {
//                    pass--;
//                    break;
//                }
//                pass++;
//            }
//                System.out.println(pass + " " + change);
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
