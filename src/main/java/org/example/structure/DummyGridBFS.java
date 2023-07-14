package org.example.structure;
import java.util.LinkedList;
import java.util.Queue;

public class DummyGridBFS {
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

        System.out.println("\nBFS Path:");
        Queue<int[]> bfsPath = bfs(startRow, startCol, targetRow, targetCol);
        printPath(bfsPath);
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

    public static Queue<int[]> bfs(int startRow, int startCol, int targetRow, int targetCol) {
        Queue<int[]> path = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];
            path.offer(new int[]{row, col});

            if (row == targetRow && col == targetCol) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (isValidCell(newRow, newCol) && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return path;
    }

    public static boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void printPath(Queue<int[]> path) {
        while (!path.isEmpty()) {
            int[] position = path.poll();
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
//BFS Path:
//(0, 0) (1, 0) (0, 1) (2, 0) (1, 1) (0, 2) (3, 0) (2, 1) (1, 2) (0, 3) (4, 0) (3, 1) (2, 2) (1, 3) (0, 4) (4, 1) (3, 2) (2, 3) (1, 4) (4, 2) (3, 3) (2, 4) (4, 3) (3, 4) (4, 4)
