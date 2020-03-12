package com.frog.Ivan.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//TODO: in progress
public class MergeSort {

//    private static List<int[]> arrays = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/sort/mergesort.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();


        }
    }

}
