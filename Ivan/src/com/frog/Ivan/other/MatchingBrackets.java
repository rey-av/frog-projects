package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

//1 if match, zero if no
public class MatchingBrackets {

    private static Stack<String> brackets = new Stack<>();

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/other/matchingbrackets.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] array = s.split("");
            boolean isMatch = true;
            for (String value : array) {
                switch (value) {
                    case "{":
                        brackets.push("{");
                        break;
                    case "(":
                        brackets.push("(");
                        break;
                    case "[":
                        brackets.push("[");
                        break;
                    case "<":
                        brackets.push("<");
                        break;
                    case "}":
                        isMatch = isMatch("{");
                        break;
                    case ")":
                        isMatch = isMatch("(");
                        break;
                    case "]":
                        isMatch = isMatch("[");
                        break;
                    case ">":
                        isMatch = isMatch("<");
                        break;
                    default:
                        break;
                }
                if (!isMatch) {
                    System.out.print(0 + " ");
                    break;
                }
            }
            if (isMatch) {
                System.out.print(1 + " ");
            }
        }
    }

    private static boolean isMatch(String bracket) {
        boolean isMatch = true;
        try {
            if (!brackets.pop().equals(bracket)) {
                isMatch = false;
            }
        } catch (EmptyStackException e) {
            isMatch = false;
        }
        return isMatch;
    }
}
