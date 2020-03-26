package com.epam.ld.javabasics30.unit06.skils.consolidation;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите матрицу NxM.");
        int n = readNaturalNumberFromConsole(sc, "Введите размер матрицы N: ");
        int m = readNaturalNumberFromConsole(sc, "Введите размер матрицы M: ");
        int[][] matrix = new int[n][m];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = readIntFromConsole(sc, String.format("Введите элемент матрицы [%d,%d] :", i , j));
            }
        }
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int[][] negSum = new int[n][1];
        int[][] max = new int[n][1];
        int iMin = 0;
        int iMax = 0;
        int jMin = 0;
        int jMax = 0;
        for (int i = 0 ; i < n; i++) {
            negSum[i][0] = 0;
            max[i][0]=matrix[i][0];
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < 0) {
                    negSum[i][0] += matrix[i][j];
                }
                if (matrix[i][j] > max[i][0]) {
                    max[i][0] = matrix[i][j];
                }
                if (matrix[iMin][jMin] > matrix[i][j]) {
                    iMin = i;
                    jMin = j;
                }
                if (matrix[iMax][jMax] < matrix[i][j]) {
                    iMax = i;
                    jMax = j;
                }
            }
        }

        System.out.println("Сумма отрицательных элементов в каждой строке:");
        printMatrix(negSum);

        System.out.println("Максимальный элемент в каждой строке:");
        printMatrix(max);

        System.out.println("Матрица с переставленными максимальным и минимальным элементами:");
        int tmp = matrix[iMin][jMin];
        matrix[iMin][jMin] = matrix[iMax][jMax];
        matrix[iMax][jMax] = tmp;
        printMatrix(matrix);
    }

    public static int readIntFromConsole(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        return sc.nextInt();
    }

    public static int readNaturalNumberFromConsole(Scanner sc, String message) {
        int n = 0;
        do {
            n = readIntFromConsole(sc, message);
        } while (n <= 0);
        return n;
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
