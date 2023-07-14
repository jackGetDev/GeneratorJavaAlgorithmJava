package org.example.structure;

import java.util.Stack;

public class DummyGridDFS {
    private static int rows = 5; // Number of rows in the grid
    private static int cols = 5; // Number of columns in the grid
    private static int[][] grid;
    private static boolean[][] visited;

    public static void main(String[] args) {
        generateDummyGrid();

        System.out.println("Generated Grid:");
        printGrid(grid);

        int startRow = 0;
        int startCol = 0;
        int targetRow = 4;
        int targetCol = 4;
        System.out.println("\nStarting Position: (" + startRow + ", " + startCol + ")");
        System.out.println("Target Position: (" + targetRow + ", " + targetCol + ")");

        System.out.println("\nDFS Path:");
        Stack<int[]> dfsPath = dfs(startRow, startCol, targetRow, targetCol);
        printPath(dfsPath);
    }

    public static void generateDummyGrid() {
        grid = new int[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = 1;
                visited[i][j] = false;
            }
        }
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Stack<int[]> dfs(int startRow, int startCol, int targetRow, int targetCol) {
        Stack<int[]> path = new Stack<>();
        dfsHelper(startRow, startCol, targetRow, targetCol, path);
        return path;
    }

    public static boolean dfsHelper(int row, int col, int targetRow, int targetCol, Stack<int[]> path) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        path.push(new int[]{row, col});

        if (row == targetRow && col == targetCol) {
            return true;
        }

        if (dfsHelper(row - 1, col, targetRow, targetCol, path)) { // Up
            return true;
        }
        if (dfsHelper(row + 1, col, targetRow, targetCol, path)) { // Down
            return true;
        }
        if (dfsHelper(row, col - 1, targetRow, targetCol, path)) { // Left
            return true;
        }
        if (dfsHelper(row, col + 1, targetRow, targetCol, path)) { // Right
            return true;
        }

        path.pop();
        return false;
    }

    public static void printPath(Stack<int[]> path) {
        while (!path.isEmpty()) {
            int[] position = path.pop();
            int row = position[0];
            int col = position[1];
            System.out.print("(" + row + ", " + col + ") ");
        }
        System.out.println();
    }
}
//
//OUTPUT:
//Generated Grid:
//1 1 1 1 1
//1 1 1 1 1
//1 1 1 1 1
//1 1 1 1 1
//1 1 1 1 1
//
//Starting Position: (0, 0)
//Target Position: (4, 4)
//
//DFS Path:
//(4, 4) (3, 4) (2, 4) (1, 4) (0, 4) (0, 3) (1, 3) (2, 3) (3, 3) (4, 3) (4, 2) (3, 2) (2, 2) (1, 2) (0, 2) (0, 1) (1, 1) (2, 1) (3, 1) (4, 1) (4, 0) (3, 0) (2, 0) (1, 0) (0, 0)
