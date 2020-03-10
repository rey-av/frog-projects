package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MicroLife {

    private static final int MOVES = 40;
    private static final int MATRIX_SIZE = 41; // should be odd
    private static final String ALIVE = "X";
    private static final String DEAD = "-";
    private static String[][] matrix = new String[MATRIX_SIZE][MATRIX_SIZE];


    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = DEAD;
            }
        }

        FileReader in = new FileReader("resources/other/microlife.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        int matrixStart = (MATRIX_SIZE - 7) / 2;
        while ((s = br.readLine()) != null) { // init draw
            String[] init = s.split("");
            int k = 0;
            for (int j = (MATRIX_SIZE - 7) / 2; j < matrix[matrixStart].length - (MATRIX_SIZE - 7) / 2; j++) {
                matrix[matrixStart][j] = init[k];
                k++;
            }
            matrixStart++;
        }

        //Init print
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

        String[][] newMatrix;
        int quantity;
        for (int i = 0; i < MOVES; i++) { // Generating MOVES moves
            Thread.sleep(500);
            newMatrix = new String[MATRIX_SIZE][MATRIX_SIZE]; // Clear new turn matrix
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    quantity = 0;
                    quantity += checkNeighbor(j, k, -1, 0, matrix); // North
                    quantity += checkNeighbor(j, k, -1, 1, matrix); // North-East
                    quantity += checkNeighbor(j, k, 0, 1, matrix); // East
                    quantity += checkNeighbor(j, k, 1, 1, matrix); // South-East
                    quantity += checkNeighbor(j, k, 1, 0, matrix); // South
                    quantity += checkNeighbor(j, k, 1, -1, matrix); // South-West
                    quantity += checkNeighbor(j, k, 0, -1, matrix); // West
                    quantity += checkNeighbor(j, k, -1, -1, matrix); // North-West
                    if (matrix[j][k].equals(DEAD)) {
                        if (quantity == 3) {
                            newMatrix[j][k] = ALIVE;
                        } else {
                            newMatrix[j][k] = DEAD;
                        }
                    } else if (matrix[j][k].equals(ALIVE)) {
                        if (quantity == 2 || quantity == 3) {
                            newMatrix[j][k] = ALIVE;
                        } else {
                            newMatrix[j][k] = DEAD;
                        }
                    }
                }
            }
            System.out.println();
            System.out.println();
            matrix = newMatrix;
            int cellsAlive = 0;
            for (String[] strings : newMatrix) {
                for (String string : strings) {
                    System.out.print(string);
                    if (string.equals(ALIVE)) {
                        cellsAlive++;
                    }
                }
                System.out.println();
            }
            System.out.print("moves: " + (i + 1) + "; ");
            System.out.println("Cells alive: " + cellsAlive);
        }
    }


    private static int checkNeighbor(int posX, int posY, int plusV, int plusH, String[][] array) {
        try {
            if (array[posX + plusV][posY + plusH].equals(ALIVE)) {
                return 1;
            } else if (array[posX + plusV][posY + plusH].equals(DEAD)) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

}