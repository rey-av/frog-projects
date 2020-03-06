package com.frog.Ivan.other;

public class MicroLife {

    static String[][] matrix = new String[10][10];

    public static void main(String[] args) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
