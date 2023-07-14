package org.example.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphStructureGenerator {
    public static void main(String[] args) {
        int numVertices = 7; // Number of vertices in the graph

        // Generate dummy data list
        List<String> dummyData = generateDummyData(numVertices);

        // Generate the adjacency list representation of the graph
        List<List<Integer>> adjacencyList = generateAdjacencyList(numVertices);

        // Print the adjacency list
        System.out.println("Graph Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(dummyData.get(i) + " -> ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(dummyData.get(neighbor) + " ");
            }
            System.out.println();
        }
    }

    public static List<String> generateDummyData(int numVertices) {
        List<String> dummyData = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            dummyData.add("Vertex " + i);
        }
        return dummyData;
    }

    public static List<List<Integer>> generateAdjacencyList(int numVertices) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numVertices; i++) {
            List<Integer> neighbors = new ArrayList<>();
            int numConnections = random.nextInt(numVertices); // Randomly generate number of connections

            while (neighbors.size() < numConnections) {
                int randomNeighbor = random.nextInt(numVertices);
                if (randomNeighbor != i && !neighbors.contains(randomNeighbor)) {
                    neighbors.add(randomNeighbor);
                }
            }

            adjacencyList.add(neighbors);
        }

        return adjacencyList;
    }
}

//
//OUTPUT:
//Graph Adjacency List:
//Vertex 0 -> Vertex 1 Vertex 6 Vertex 2 Vertex 3 Vertex 5
//Vertex 1 -> Vertex 2 Vertex 5
//Vertex 2 ->
//Vertex 3 -> Vertex 4
//Vertex 4 -> Vertex 0 Vertex 5 Vertex 1 Vertex 6 Vertex 3
//Vertex 5 -> Vertex 4 Vertex 1 Vertex 6 Vertex 0 Vertex 2
//Vertex 6 -> Vertex 0 Vertex 1