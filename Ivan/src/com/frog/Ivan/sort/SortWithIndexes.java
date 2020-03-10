package com.frog.Ivan.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortWithIndexes {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/sort/sortwithindexes.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] array = s.split(" ");
            Map<Integer, Integer> ints = new LinkedHashMap<>();
            for (int i = 0; i < array.length; i++) {
                ints.put(i + 1, Integer.parseInt(array[i]));
            }

            Map<Integer, Integer> sortedInts = ints.entrySet().stream().sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            for (Map.Entry<Integer, Integer> i : sortedInts.entrySet()) {
                System.out.print(i.getKey() + " ");
            }
        }
    }

}
