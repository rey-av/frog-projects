package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/other/reversepolishnotation.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] array = s.split(" ");
            Stack<String> stack = new Stack<>();
            for (String a: array) {
                double what;
                double with;
                switch (a) {
                    case "add":
                        stack.push(String.valueOf(Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop())));
                        break;
                    case "sub":
                        with = Double.parseDouble(stack.pop());
                        what = Double.parseDouble(stack.pop());
                        stack.push(String.valueOf(what - with));
                        break;
                    case "mul":
                        stack.push(String.valueOf(Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop())));
                        break;
                    case "div":
                        with = Double.parseDouble(stack.pop());
                        what = Double.parseDouble(stack.pop());
                        stack.push(String.valueOf(what / with));
                        break;
                    case "mod":
                        with = Double.parseDouble(stack.pop());
                        what = Double.parseDouble(stack.pop());
                        stack.push(String.valueOf(Math.floorMod((int) what, (int) with)));
                        break;
                    case "sqrt":
                        stack.push(String.valueOf(Math.sqrt(Double.parseDouble(stack.pop()))));
                        break;
                    default:
                        stack.push(a);
                        break;
                }
            }
            System.out.println((int) Double.parseDouble(stack.pop()));
        }
    }
}
