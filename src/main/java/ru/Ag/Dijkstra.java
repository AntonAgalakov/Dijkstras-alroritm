package ru.Ag;

import java.util.Scanner;

public class Dijkstra {
    private int numberOfVertices;
    private int[][] linkMatrix;
    private int[] dictance;
    private int[] vertices;
    private int[] path;

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        linkMatrix = new int[numberOfVertices][numberOfVertices];
        dictance = new int[numberOfVertices];
        vertices = new int[numberOfVertices];
        path = new int[numberOfVertices];
    }

    public void matrixInitialization() {
        int maxValue = 2147483646;
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of vertices: ");
        setNumberOfVertices(sc.nextInt());

        System.out.println("Distance between");
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (i != j) {
                    System.out.print((i + 1) + " " + (j + 1) + ": ");
                    linkMatrix[i][j] = sc.nextInt();
                } else {
                    linkMatrix[i][j] = 0;
                }
            }
            dictance[i] = maxValue;
            vertices[i] = 1;
        }
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(linkMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void start() {
        int maxValue = 2147483646;
        int startIndex = 0;
        int minIndex, min;
        dictance[startIndex] = 0;
        do {
            minIndex = maxValue;
            min = maxValue;

            for (int i = 0; i < numberOfVertices; i++) {
                if (vertices[i] == 1 && dictance[i] < min) {
                    min = dictance[i];
                    minIndex = i;
                }
            }

            if (minIndex != maxValue) {
                for (int i = 0; i < numberOfVertices; i++) {
                    if (linkMatrix[minIndex][i] > 0) {
                        int temp = min + linkMatrix[minIndex][i];
                        if (temp < dictance[i])
                            dictance[i] = temp;
                    }
                }
                vertices[minIndex] = 0;
            }
        } while (minIndex < maxValue);

        int end = numberOfVertices - 2;
        path[0] = end + 1;
        int k = 1;
        int weight = dictance[end];

        while (end != startIndex) {
            for (int i = 0; i < numberOfVertices; i++) {
                if (linkMatrix[i][end] != 0) {
                    int temp = weight - linkMatrix[i][end];
                    if (temp == dictance[i]) {
                        weight = temp;
                        end = i;
                        path[k] = i + 1;
                        k++;
                    }
                }
            }
        }
        System.out.print("Dictance: ");
        for (int i = 0; i < numberOfVertices; i++)
            System.out.print(dictance[i] + " ");

        System.out.print("\nPath: ");
        for (int i = k - 1; i > 0; i--)
            System.out.print(path[i] + " -> ");
        System.out.println(path[0]);
    }

}