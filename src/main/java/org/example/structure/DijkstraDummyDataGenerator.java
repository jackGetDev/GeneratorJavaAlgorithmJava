package org.example.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import java.util.*;

public class DijkstraDummyDataGenerator {
    private static int numVertices = 5; // Number of vertices
    private static List<String> vertices;
    private static Map<String, Map<String, Integer>> adjacencyMap;

    public static void main(String[] args) {
        generateDummyData();

        String sourceVertex = "Vertex 1";
        Map<String, Integer> shortestPath = findShortestPath(sourceVertex);
        Map<String, Integer> longestPath = findLongestPath(sourceVertex);

        System.out.println("Vertices:");
        for (String vertex : vertices) {
            System.out.println(vertex);
        }
        System.out.println();
        System.out.println("Adjacency Map:");
        for (Map.Entry<String, Map<String, Integer>> entry : adjacencyMap.entrySet()) {
            String vertex = entry.getKey();
            Map<String, Integer> neighbors = entry.getValue();
            System.out.println(vertex + ": " + neighbors);
        }
        System.out.println();
        System.out.println("Shortest Path from " + sourceVertex + ": " + shortestPath);
        System.out.println("Longest Path from " + sourceVertex + ": " + longestPath);
    }

    public static void generateDummyData() {
        vertices = generateDummyVertices(numVertices);
        adjacencyMap = generateDummyAdjacencyMap(vertices);
    }

    public static List<String> generateDummyVertices(int numVertices) {
        List<String> vertices = new ArrayList<>();
        for (int i = 1; i <= numVertices; i++) {
            vertices.add("Vertex " + i);
        }
        return vertices;
    }

    public static Map<String, Map<String, Integer>> generateDummyAdjacencyMap(List<String> vertices) {
        Map<String, Map<String, Integer>> adjacencyMap = new HashMap<>();
        Random random = new Random();

        for (String vertex : vertices) {
            Map<String, Integer> neighbors = new HashMap<>();
            for (String otherVertex : vertices) {
                if (!vertex.equals(otherVertex)) {
                    int weight = random.nextInt(10) + 1; // Random weight between 1 and 10
                    neighbors.put(otherVertex, weight);
                }
            }
            adjacencyMap.put(vertex, neighbors);
        }

        return adjacencyMap;
    }

    public static Map<String, Integer> findShortestPath(String sourceVertex) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<VertexDistancePair> pq = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();

        for (String vertex : vertices) {
            if (vertex.equals(sourceVertex)) {
                distances.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
        }

        pq.offer(new VertexDistancePair(sourceVertex, 0));

        while (!pq.isEmpty()) {
            VertexDistancePair current = pq.poll();
            String currentVertex = current.getVertex();

            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            Map<String, Integer> neighbors = adjacencyMap.get(currentVertex);
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                String neighborVertex = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDistance = distances.get(currentVertex) + weight;

                if (newDistance < distances.get(neighborVertex)) {
                    distances.put(neighborVertex, newDistance);
                    pq.offer(new VertexDistancePair(neighborVertex, newDistance));
                }
            }
        }

        return distances;
    }

    public static Map<String, Integer> findLongestPath(String sourceVertex) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<VertexDistancePair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Set<String> visited = new HashSet<>();

        for (String vertex : vertices) {
            if (vertex.equals(sourceVertex)) {
                distances.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MIN_VALUE);
            }
        }

        pq.offer(new VertexDistancePair(sourceVertex, 0));

        while (!pq.isEmpty()) {
            VertexDistancePair current = pq.poll();
            String currentVertex = current.getVertex();

            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            Map<String, Integer> neighbors = adjacencyMap.get(currentVertex);
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                String neighborVertex = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDistance = distances.get(currentVertex) + weight;

                if (newDistance > distances.get(neighborVertex)) {
                    distances.put(neighborVertex, newDistance);
                    pq.offer(new VertexDistancePair(neighborVertex, newDistance));
                }
            }
        }

        return distances;
    }

    static class VertexDistancePair implements Comparable<VertexDistancePair> {
        private String vertex;
        private int distance;

        public VertexDistancePair(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public String getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(VertexDistancePair other) {
            return Integer.compare(distance, other.distance);
        }
    }
}

//OUTPUT:
//Vertices:
//Vertex 1
//Vertex 2
//Vertex 3
//Vertex 4
//Vertex 5
//
//Adjacency Map:
//Vertex 1: {Vertex 3=3, Vertex 2=6, Vertex 5=3, Vertex 4=4}
//Vertex 3: {Vertex 1=6, Vertex 2=7, Vertex 5=4, Vertex 4=1}
//Vertex 2: {Vertex 1=9, Vertex 3=3, Vertex 5=3, Vertex 4=7}
//Vertex 5: {Vertex 1=10, Vertex 3=8, Vertex 2=5, Vertex 4=2}
//Vertex 4: {Vertex 1=9, Vertex 3=2, Vertex 2=6, Vertex 5=7}
//
//Shortest Path from Vertex 1: {Vertex 1=0, Vertex 3=3, Vertex 2=6, Vertex 5=3, Vertex 4=4}
//Longest Path from Vertex 1: {Vertex 1=34, Vertex 3=28, Vertex 2=35, Vertex 5=32, Vertex 4=29}
