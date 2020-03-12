package com.frog.Ivan.count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class CombinationsCounting {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/count/combinationscounting.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            BigInteger nFactor = new BigInteger("1");
            BigInteger kFactor = new BigInteger("1");
            BigInteger nSubKFactor = new BigInteger("1");
            int nSubKFactorMax = array[0] - array[1];
            for (int i = 1; i < array[0] + 1; i++) {
                nFactor = nFactor.multiply(new BigInteger(i + ""));
            }
            for (int i = 1; i < array[1] + 1; i++) {
                kFactor = kFactor.multiply(new BigInteger(i + ""));
            }
            for (int i = 1; i < nSubKFactorMax + 1; i++) {
                nSubKFactor = nSubKFactor.multiply(new BigInteger(i + ""));
            }
            BigInteger result;
            result = nFactor.divide(kFactor.multiply(nSubKFactor));
            System.out.print(result + " ");
        }
    }
}
