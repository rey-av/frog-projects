package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TODO: in progress
public class MicroLife {

    static String[][] matrix = new String[13][13];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = "-";
            }
        }

        FileReader in = new FileReader("resources/other/microlife.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        int matrixStart = 3;
        while ((s = br.readLine()) != null) {
            String[] init = s.split("");
            int k = 0;
            for (int j = 3; j < matrix[matrixStart].length - 3; j++) {
                matrix[matrixStart][j] = init[k];
                k++;
            }
            matrixStart++;
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        String[][] newMatrix = new String[13][13];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    int quantity = 0;
                    quantity += checkNeighbor(j, k, -1, 0, matrix); // North
                    quantity += checkNeighbor(j, k, -1, 1, matrix); // North-East
                    quantity += checkNeighbor(j, k, 0, 1, matrix); // East
                    quantity += checkNeighbor(j, k, 1, 1, matrix); // South-East
                    quantity += checkNeighbor(j, k, 1, 0, matrix); // South
                    quantity += checkNeighbor(j, k, 1, -1, matrix); // South-West
                    quantity += checkNeighbor(j, k, 0, -1, matrix); // West
                    quantity += checkNeighbor(j, k, -1, -1, matrix); // North-West
                    if (matrix[j][k].equals("-")) {
                        if(quantity == 3) {
                            newMatrix[j][k] = "X";
                        } else {
                            newMatrix[j][k] = "-";
                        }
                    } else if (matrix[j][k].equals("X")) {
                        if(quantity == 2 || quantity == 3) {
                            newMatrix[j][k] = "X";
                        } else {
                            newMatrix[j][k] = "-";
                        }
                    }
                }
            }
            System.out.println();
            System.out.println();
            matrix = newMatrix;
            int xs = 0;
            for (String[] strings : newMatrix) {
                for (String string : strings) {
                    System.out.print(string);
                    if(string.equals("X")) {
                        xs++;
                    }
                }
                System.out.println();
            }
            System.out.print(xs + " ");
        }

        //Print matrix
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static int checkNeighbor(int posX, int posY, int plusX, int plusY, String[][] array) {
        try {
            if (array[posX + plusX][posY + plusY].equals("X")) {
                return 1;
            } else if (array[posX + plusX][posY + plusY].equals("-")) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

}
