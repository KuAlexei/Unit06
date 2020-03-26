package com.epam.ld.javabasics30.unit06.skils.formation;

public class Task01 {
    public static void main(String[] args) {
        int sizeX = 5;
        int sizeY = 5;
        int[][] matrix = initMatrix(sizeX, sizeY);
        printMatrix(matrix);
    }

    public static int[][] initMatrix(int sizeX, int sizeY) {
        int[][] m = new int[sizeY][sizeX];
        int minusTwo = 0;
        int minusOne = 1;
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                m[i][j] = minusTwo + minusOne;
                minusTwo = minusOne;
                minusOne = m[i][j];
            }
        }
        return m;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] a:matrix) {
            for (int i:a) {
                System.out.printf("%9d ",i);
            }
            System.out.println();
        }
    }

}
