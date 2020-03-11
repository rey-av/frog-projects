package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//Prints km when two cyclists will meet each other
public class BicycleRace {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/other/bicyclerace.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            double[] array = Arrays.stream(s.split(" ")).mapToDouble(Double::parseDouble).toArray();
            double timeBetween = array[0] / (array[1] + array[2]);
            double distance = timeBetween * array[1];
            System.out.print(distance + " ");

        }
    }
}
