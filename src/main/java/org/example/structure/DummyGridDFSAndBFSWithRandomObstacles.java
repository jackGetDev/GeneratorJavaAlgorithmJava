package org.example.structure;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DummyGridDFSAndBFSWithRandomObstacles {
    private static int rows = 5; // Jumlah baris pada grid
    private static int cols = 5; // Jumlah kolom pada grid
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[][] obstacles;

    public static void main(String[] args) {
        generateDummyGrid();

        System.out.println("Generated Grid:");
        printGrid(grid);

        int startRow = getRandomNumber(rows);
        int startCol = getRandomNumber(cols);
        System.out.println("\nStarting Position: (" + startRow + ", " + startCol + ")");

        int targetRow = getRandomNumber(rows);
        int targetCol = getRandomNumber(cols);
        System.out.println("Target Position: (" + targetRow + ", " + targetCol + ")");

        System.out.println("\nDFS Path:");
        dfs(startRow, startCol, targetRow, targetCol);

        System.out.println("\nBFS Path:");
        bfs(startRow, startCol, targetRow, targetCol);
    }

    public static void generateDummyGrid() {
        grid = new int[rows][cols];
        visited = new boolean[rows][cols];
        obstacles = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextInt(10);
                visited[i][j] = false;
                obstacles[i][j] = random.nextInt(2);
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

    public static int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static void dfs(int row, int col, int targetRow, int targetCol) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || obstacles[row][col] == 1) {
            return;
        }

        visited[row][col] = true;

        if (row == targetRow && col == targetCol) {
            System.out.print("(" + row + ", " + col + ") ");
            return;
        }

        System.out.print("(" + row + ", " + col + ") ");

        dfs(row - 1, col, targetRow, targetCol); // Up
        dfs(row + 1, col, targetRow, targetCol); // Down
        dfs(row, col - 1, targetRow, targetCol); // Left
        dfs(row, col + 1, targetRow, targetCol); // Right

        visited[row][col] = false; // Reset visited untuk mencari jalur lain
    }


    public static void bfs(int startRow, int startCol, int targetRow, int targetCol) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];

            if (row == targetRow && col == targetCol) {
                System.out.print("(" + row + ", " + col + ") ");
                return;
            }

            System.out.print("(" + row + ", " + col + ") ");

            if (row - 1 >= 0 && !visited[row - 1][col] && obstacles[row - 1][col] != 1) {
                queue.offer(new int[]{row - 1, col}); // Atas
                visited[row - 1][col] = true;
            }

            if (row + 1 < rows && !visited[row + 1][col] && obstacles[row + 1][col] != 1) {
                queue.offer(new int[]{row + 1, col}); // Bawah
                visited[row + 1][col] = true;
            }

            if (col - 1 >= 0 && !visited[row][col - 1] && obstacles[row][col - 1] != 1) {
                queue.offer(new int[]{row, col - 1}); // Kiri
                visited[row][col - 1] = true;
            }

            if (col + 1 < cols && !visited[row][col + 1] && obstacles[row][col + 1] != 1) {
                queue.offer(new int[]{row, col + 1}); // Kanan
                visited[row][col + 1] = true;
            }
        }
    }
}
//
//OUTPUT:
//Generated Grid:
//2 3 5 9 3
//8 0 9 6 0
//0 4 7 1 8
//8 1 2 0 9
//1 3 5 6 7
//
//Starting Position: (4, 2)
//Target Position: (2, 1)
//
//DFS Path:
//(4, 2) (3, 2) (3, 1) (4, 1) (4, 0) (3, 0) (2, 0) (3, 0) (2, 0) (4, 0) (4, 1) (3, 3) (2, 3) (1, 3) (1, 4) (4, 1) (3, 1) (3, 0) (2, 0) (4, 0) (3, 2) (3, 3) (2, 3) (1, 3) (1, 4) (4, 0) (3, 0) (2, 0) (3, 1) (3, 2) (3, 3) (2, 3) (1, 3) (1, 4)
//BFS Path:
//(4, 2) (3, 2) (4, 1) (3, 1) (3, 3) (4, 0) (3, 0) (2, 3) (2, 0) (1, 3) (1, 4)