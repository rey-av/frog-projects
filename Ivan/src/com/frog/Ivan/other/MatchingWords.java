package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingWords {

    private static List<String> words = new ArrayList<>();
    private static List<String> duplicates = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/other/matchingwords.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] array = s.split(" ");
            for (String a: array) {
                if(!words.contains(a)) {
                    words.add(a);
                } else {
                    if(!duplicates.contains(a))
                    duplicates.add(a);
                }
            }
            Collections.sort(duplicates);
            for (String a: duplicates) {
                System.out.print(a + " ");
            }
        }
    }
}
