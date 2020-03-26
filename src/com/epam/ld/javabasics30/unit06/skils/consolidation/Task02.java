package com.epam.ld.javabasics30.unit06.skils.consolidation;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = readEvenNaturalNumberFromConsole(sc, "Введите размерность матрицы (четное число): ");
        int[][] matrix = new int[n][n];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (n-i > j)?i+1:0;
            }
        }
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

    public static int readEvenNaturalNumberFromConsole(Scanner sc, String message) {
        int n = 0;
        do {
            n = readNaturalNumberFromConsole(sc, message);
        } while (n % 2 != 0);
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
