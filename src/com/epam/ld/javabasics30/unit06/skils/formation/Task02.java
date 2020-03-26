package com.epam.ld.javabasics30.unit06.skils.formation;

import java.util.Random;

public class Task02 {
    public static void main(String[] args) {
        int sizeX = 5;
        int sizeY = 5;
        int[][] matrix = initMatrixRandom(sizeX, sizeY);
        printMatrix(matrix);
        sort(matrix, sizeX, sizeY);
        System.out.println("Сортированая матрица:");
        printMatrix(matrix);
    }

    public static int[][] initMatrixRandom(int sizeX, int sizeY) {
        int[][] m = new int[sizeY][sizeX];
        Random rnd = new Random();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                m[i][j] = rnd.nextInt(100);
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

    public static void sort(int[][] matrix, int sizeX, int sizeY) {
        for (int j = 0; j < sizeX; j++) {
            for (int i = 0; i < sizeY-1; i++) {
                int a = i;
                for (int b = i+1; b < sizeY; b++) {
                    if (matrix[a][j] > matrix[b][j]) {
                        a = b;
                    }
                }
                if (a != i) {
                    int tmp = matrix[a][j];
                    matrix[a][j] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
        }
    }

}
