package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JosephusProblem {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/other/josephusproblem.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] deadmans = new int[array[0]];

            for (int i = 0; i < deadmans.length; i++) {
                deadmans[i] = i+1;
            }

            int pointer = 0;
            int step = 0;
            while (deadmans.length != 1) {
                while (step != array[1] - 1) {
                    pointer++;
                    step++;
                    pointer = getPointer(deadmans, pointer);
                }
                step = 0;
                deadmans = kill(deadmans, pointer);
                pointer = getPointer(deadmans, pointer);
            }
            System.out.println(deadmans[0]);
        }
    }


    private static int getPointer(int[] deadmans, int pointer) {
        if (pointer == deadmans.length) {
            pointer = 0;
        }
        return pointer;
    }


    private static int[] kill(int[] array, int index) {
        List<Integer> aliveMan = new LinkedList<>();

        for (int item: array) {
            if(!(array[index] == item)) {
                aliveMan.add(item);
            }
        }
        return aliveMan.stream().mapToInt(i->i).toArray();
    }

}
