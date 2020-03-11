package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//Generator of two dices according to input parameters
public class DoubleDiceThrow {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/other/doubledicethrow.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] init = s.split(" ");
            double[] array = Arrays.stream(init).mapToDouble(Double::parseDouble).toArray();
            array[0] = Math.round(-(Math.floor(array[0] / 6) - array[0] / 6) * 6) + 1; // 6 represents sides of dice
            array[1] = Math.round(-(Math.floor(array[1] / 6) - array[1] / 6) * 6) + 1;
            int result = (int) (array[0] + array[1]);
            System.out.print(result + " ");
        }
    }
}
