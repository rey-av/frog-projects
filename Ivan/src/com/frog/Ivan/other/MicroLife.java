package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TODO: in progress
public class MicroLife {

    static String[][] matrix = new String[11][11];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = "-";
            }
        }

        FileReader in = new FileReader("resources/other/microlife.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] init = s.split("");
            int matrixStart = 3;
            for (int i = matrixStart; i < matrix.length - 3; i++) {
                int k = 0;
                for (int j = 3; j < matrix[i].length - 3; j++) {
                    matrix[i][j] = init[k];
                    k++;
                }
                matrixStart++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
