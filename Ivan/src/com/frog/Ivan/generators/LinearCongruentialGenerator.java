package com.frog.Ivan.generators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LinearCongruentialGenerator {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/generators/linearcongruentialgenerator.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] init = s.split(" ");
            int[] array = Arrays.stream(init).mapToInt(Integer::parseInt).toArray();

            int a = array[0];
            int c = array[1];
            int m = array[2];
            int x = array[3];
            for (int i = 0; i < array[4]; i++) {
                x = (a * x + c) % m;
            }
            System.out.print(x + " ");
        }
    }

}
