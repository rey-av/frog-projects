package com.frog.takhsin.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EasterEggs {


    private static ArrayList<String> solutions = new ArrayList<>();
    private static int desiredResult;
    private static Map<String, Integer> variantsMap;
    private static List<String> variants;


    public static void main(String[] args) {
//        int[] input = {1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1};
        //0 1 4 5 7 10 13 15 19
        int[] input = {1, 0, 1, 0, 1, 1};
        desiredResult = 0;

        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            if (number == 1) {
                desiredResult += Math.pow(2, i);
            }
        }

//        variants = Arrays.asList(
//                "0 4 8",
//                "1 10 17",
//                "2 11 17",
//                "3 7 11",
//                "4 9 12",
//                "5 9 13",
//                "6 16",
//                "7 13 16",
//                "1 8 13",
//                "4 6 9",
//                "5 10 12",
//                "2 9 11",
//                "1 5 12",
//                "12 13",
//                "1 3 14",
//                "5 11 15",
//                "3 8 16",
//                "3 4 17",
//                "10 17 18",
//                "4 8 19"
//        );

        variants = Arrays.asList(
                "0 5",
                "1 4",
                "2 4",
                "2 3 5",
                "1 4",
                "2 3 5"
        );

        // Map index decimal representation with variant
        variantsMap = new HashMap<>();
        for (String s : variants) {
            String[] arr = s.split(" ");
            int decimal = 0;
            for (String st : arr) {
                decimal += Math.pow(2, Integer.parseInt(st));
            }
            variantsMap.put(s, decimal);
        }

        List<Map.Entry<String, Integer>> collect = variantsMap.entrySet().stream().collect(Collectors.toList());
        findCombination(collect, 0, collect.get(0).getValue(), null);


        System.out.println();


    }


    // find best solution
    private static void findCombination(List<Map.Entry<String, Integer>> entries, int iteration, int aux, List<Integer> callSeq) {
        if (iteration == entries.size()) {
            return;
        }

        Map.Entry<String, Integer> entry = entries.get(iteration);

        aux = desiredResult ^ aux;


        if (variantsMap.containsValue(aux)) {
            if (callSeq == null) {
                callSeq = new ArrayList<>();
            }
            callSeq.add(aux);
            if ((callSeq.stream().mapToInt(value -> value).sum() ^ desiredResult) == 0) {
                AtomicReference<String> res = new AtomicReference<>("");
                callSeq.stream().mapToInt(value -> value).forEach(value -> res.updateAndGet(v -> v + value+" "));
                solutions.add(res.get());
            }
            findCombination(entries, iteration + 1, aux, callSeq);
        } else {
            iteration++;
            findCombination(entries, iteration, entries.get(iteration).getValue(), null);
        }

    }

}





