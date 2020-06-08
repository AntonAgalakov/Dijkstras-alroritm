package ru.Ag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Dijkstra dijkstra = new Dijkstra();
        Scanner sc = new Scanner(System.in);
        int numberOfVertices;

        System.out.print("Number of vertices: ");
        numberOfVertices = sc.nextInt();
        dijkstra.setNumberOfVertices(numberOfVertices);

        System.out.println("Distance between");
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (i != j) {
                    System.out.print((i + 1) + " " + (j + 1) + ": ");
                    int tempDistance = sc.nextInt();
                    dijkstra.addDistance(i, j, tempDistance);
                }
                else
                    dijkstra.addDistance(i, j, 0);
            }
        }
        dijkstra.start();
    }
}