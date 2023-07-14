package org.example.structure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TSPDummyDataGenerator {
    private static int numLocations = 5; // Number of locations
    private static List<String> locations;
    private static double[][] distances;

    public static void main(String[] args) {
        generateDummyData();

        List<Integer> shortestPath = findShortestPath(distances);
        List<Integer> longestPath = findLongestPath(distances);

        System.out.println("Locations:");
        for (String location : locations) {
            System.out.println(location);
        }
        System.out.println();
        System.out.println("Distances:");
        for (int i = 0; i < numLocations; i++) {
            for (int j = 0; j < numLocations; j++) {
                System.out.print(distances[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Shortest Path: " + shortestPath);
        System.out.println("Longest Path: " + longestPath);
    }

    public static void generateDummyData() {
        locations = generateDummyLocations(numLocations);
        distances = generateDummyDistances(locations);
    }

    public static List<String> generateDummyLocations(int numLocations) {
        List<String> locations = new ArrayList<>();
        for (int i = 1; i <= numLocations; i++) {
            locations.add("Location " + i);
        }
        return locations;
    }

    public static double[][] generateDummyDistances(List<String> locations) {
        int numLocations = locations.size();
        double[][] distances = new double[numLocations][numLocations];

        for (int i = 0; i < numLocations; i++) {
            for (int j = 0; j < numLocations; j++) {
                if (i == j) {
                    distances[i][j] = 0; // Distance from a location to itself is 0
                } else {
                    distances[i][j] = Math.random() * 100; // Random distance between 0 and 100
                }
            }
        }

        return distances;
    }

    public static List<Integer> findShortestPath(double[][] distances) {
        int numLocations = distances.length;
        boolean[] visited = new boolean[numLocations];
        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(0); // Start from location 0
        visited[0] = true;

        tspHelper(distances, 0, shortestPath, visited);

        shortestPath.add(0); // Return to location 0

        return shortestPath;
    }

    public static List<Integer> findLongestPath(double[][] distances) {
        int numLocations = distances.length;
        boolean[] visited = new boolean[numLocations];
        List<Integer> longestPath = new ArrayList<>();
        longestPath.add(0); // Start from location 0
        visited[0] = true;

        tspHelper(distances, 0, longestPath, visited);

        longestPath.add(0); // Return to location 0

        return longestPath;
    }

    public static void tspHelper(double[][] distances, int currentLocation, List<Integer> path, boolean[] visited) {
        if (path.size() == numLocations) {
            return; // All locations have been visited
        }

        double minDistance = Double.MAX_VALUE;
        int nextLocation = -1;

        for (int i = 0; i < numLocations; i++) {
            if (!visited[i] && distances[currentLocation][i] < minDistance) {
                minDistance = distances[currentLocation][i];
                nextLocation = i;
            }
        }

        path.add(nextLocation);
        visited[nextLocation] = true;

        tspHelper(distances, nextLocation, path, visited);
    }
}
//
//OUTPUT:
//Locations:
//Location 1
//Location 2
//Location 3
//Location 4
//Location 5
//
//Distances:
//0.0 30.440766260786134 51.56092694442385 94.82756506910336 40.889064377157936
//40.824884291305466 0.0 85.05636570967606 89.039191448205 57.35602362729124
//57.7967362666296 13.741759883271964 0.0 87.7218351481618 35.10955753488343
//49.67541060081035 34.1326107722893 71.4172544751474 0.0 20.142212779721568
//91.09748678957021 73.19236998300902 69.70041051162299 85.65754782333632 0.0
//
//Shortest Path: [0, 1, 4, 2, 3, 0]
//Longest Path: [0, 1, 4, 2, 3, 0]