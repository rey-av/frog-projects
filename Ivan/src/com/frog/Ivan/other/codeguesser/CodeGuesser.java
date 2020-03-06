package com.frog.Ivan.other.codeguesser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGuesser {

    private static int[] result = new int[4];
    private static List<Probability> probabilities = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/other/codeguesser.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        Map<Integer, Integer> map = new HashMap<>();
        while ((s = br.readLine()) != null) {
            map.put(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]));
        }
        List<Integer> thousands = new ArrayList<>();
        List<Integer> hundreds = new ArrayList<>();
        List<Integer> tens = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            probabilities.add(new Probability(i, 1, 0));
            probabilities.add(new Probability(i, 2, 0));
            probabilities.add(new Probability(i, 3, 0));
            probabilities.add(new Probability(i, 4, 0));
            thousands.add(i);
            hundreds.add(i);
            tens.add(i);
            ones.add(i);
        }

        for (Map.Entry<Integer, Integer> a : map.entrySet()) {
            if (a.getValue() == 0) {
                if (ones.contains(a.getKey() % 10)) {
                    ones.remove(ones.indexOf(a.getKey() % 10));
                }
                if (tens.contains(a.getKey() / 10 % 10)) {
                    tens.remove(tens.indexOf(a.getKey() / 10 % 10));
                }
                if (hundreds.contains(a.getKey() / 100 % 10)) {
                    hundreds.remove(hundreds.indexOf(a.getKey() / 100 % 10));
                }
                if (thousands.contains(a.getKey() / 1000)) {
                    thousands.remove(thousands.indexOf(a.getKey() / 1000));
                }
            } else {
                int indexOfOnes = a.getKey() % 10 == 0 ? a.getKey() % 10 : a.getKey() % 10 * 4;
                probabilities.get(indexOfOnes).setProbability(probabilities.get(indexOfOnes).getProbability() + a.getValue());

                int indexOfTens = a.getKey() / 10 % 10 == 0 ? a.getKey() / 10 % 10 + 1 : a.getKey() / 10 % 10 * 4 + 1;
                probabilities.get(indexOfTens).setProbability(probabilities.get(indexOfTens).getProbability() + a.getValue());

                int indexOfHundreds = a.getKey() / 100 % 10 == 0 ? a.getKey() / 100 % 10 + 2 : a.getKey() / 100 % 10 * 4 + 2;
                probabilities.get(indexOfHundreds).setProbability(probabilities.get(indexOfHundreds).getProbability() + a.getValue());

                int indexOfThousands = a.getKey() / 1000 == 0 ? a.getKey() / 1000 + 3 : a.getKey() / 1000 * 4 + 3;
                probabilities.get(indexOfThousands).setProbability(probabilities.get(indexOfThousands).getProbability() + a.getValue());
            }
        }
        checkForZeros(ones, 3);
        checkForZeros(tens, 2);
        checkForZeros(hundreds, 1);
        checkForZeros(thousands, 0);

        finalCheck(ones, 3);
        finalCheck(tens, 2);
        finalCheck(hundreds, 1);
        finalCheck(thousands, 0);

        System.out.print("" + result[3] + result[2] + result[1] + result[0]);
    }


    private static void finalCheck(List<Integer> checked, int pos) {
        int maxIndex = findProbabilityWithZero();
        if (checked.size() > 1) {
            for (Integer a : checked) {
                if (probabilities.get(a * 4 + pos - 1).getProbability() > probabilities.get(maxIndex).getProbability()) {
                    maxIndex = probabilities.indexOf(probabilities.get(a * 4 + pos - 1));
                }
            }
            result[pos] = probabilities.get(maxIndex).getNumber();
        } else if (checked.size() == 0) {
            System.out.println("Something went wrong");
        }
    }


    private static int findProbabilityWithZero() {
        for (Probability p : probabilities) {
            if (p.getProbability() == 0) {
                return probabilities.indexOf(p);
            }
        }
        return 0;
    }


    private static void checkForZeros(List<Integer> list, int pos) {
        if (list.size() == 1) {
            result[pos] = list.get(0);
        }
    }

}
