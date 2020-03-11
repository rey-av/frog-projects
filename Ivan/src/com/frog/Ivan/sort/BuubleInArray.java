package com.frog.Ivan.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BuubleInArray {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/sort/bubbleinarray.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            int[] array = Arrays.stream(s.substring(0, s.length() - 3).split(" ")).mapToInt(Integer::parseInt).toArray();
            int swaps = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swaps++;
                }
            }
            long sum = 0;
            for (int value : array) {
                sum = (sum + value) * 113;
                if (sum > 10000007) {
                    sum = sum % 10000007;
                }
            }
            System.out.println(swaps + " " + sum);
        }
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }
}
