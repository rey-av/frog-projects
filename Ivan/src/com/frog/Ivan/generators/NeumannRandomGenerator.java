package com.frog.Ivan.generators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeumannRandomGenerator {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/generators/neumannrandomgenerator.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] array = s.split(" ");
            int[] ints = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
            for (int i : ints) {
                int loop = 0;
                List<Integer> remember = new ArrayList<>();
                while (true) {
                    loop++;
                    i = (i * i) / 100 % 10000;
                    if(remember.contains(i)) {
                        break;
                    }
                    remember.add(i);
                }
                System.out.print(loop + " ");
            }
        }
    }

}
