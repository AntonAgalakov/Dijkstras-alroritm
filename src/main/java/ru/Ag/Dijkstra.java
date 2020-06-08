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
        int infinity = 2147483647;

        for (int i = 0; i < numberOfVertices; i++) {
            dictance[i] = infinity;
            vertices[i] = 1;
        }
    }


    public void addDistance(int i, int j, int tempDistance) {
        linkMatrix[i][j] = tempDistance;
    }

    public void printMatrix() {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(linkMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }


    public void start() {
        int infinity = 2147483647;
        int startIndex = 0;
        int minIndex, min;
        dictance[startIndex] = 0;
        do {
            minIndex = infinity;
            min = infinity;

            for (int i = 0; i < numberOfVertices; i++) {
                if (vertices[i] == 1 && dictance[i] < min) {
                    min = dictance[i];
                    minIndex = i;
                }
            }

            if (minIndex != infinity) {
                for (int i = 0; i < numberOfVertices; i++) {
                    if (linkMatrix[minIndex][i] > 0) {
                        int temp = min + linkMatrix[minIndex][i];
                        if (temp < dictance[i])
                            dictance[i] = temp;
                    }
                }
                vertices[minIndex] = 0;
            }
        } while (minIndex < infinity);

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