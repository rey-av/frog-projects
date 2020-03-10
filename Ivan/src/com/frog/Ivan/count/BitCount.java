package com.frog.Ivan.count;

import java.io.BufferedReader;
import java.io.FileReader;

public class BitCount {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/count/bitcount.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                for (String s : split) {
                    int counter = 0;
                    String s1 = Integer.toBinaryString(Integer.parseInt(s));
                    for (int i = 0; i < s1.length(); i++) {
                        if (Integer.parseInt(s1.substring(i, i + 1)) == 1)
                            counter++;
                    }
                    System.out.print(counter + " ");
                }
            }

        }
    }

}
