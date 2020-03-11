package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

//Prints index of number from fibonacci sequence
public class FibonacciSequence {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/other/fibonaccisequence.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] init = s.split(" ");
            BigInteger[] array = new BigInteger[init.length];
            for (int i = 0; i < init.length; i++) {
                array[i] = new BigInteger(init[i]);
            }
            for (BigInteger a : array) {
                BigInteger result = new BigInteger("0");
                BigInteger currentValue = new BigInteger("0");
                int pos = 1;
                BigInteger previousValue = new BigInteger("1");
                while (!result.equals(a)) {
                    result = currentValue.add(previousValue);
                    currentValue = previousValue;
                    previousValue = result;
                    pos++;
                }
                System.out.print(pos + " ");
            }
        }
    }

}
