package ch.bbw.mf;

import static java.lang.Thread.sleep;

public class GameOfLife {

    public static void runSimulation(int[][] grid) throws InterruptedException {
        if (grid == null || grid.length == 0) return;

        long REFRESH_RATE = 225;
        int height = grid.length;
        int width = grid[0].length;
        OutputHandler outputHandler = new OutputHandler();

        while (true) {
            int[][] newGrid = new int[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int neighbours = livingNeighbours(grid, height, width, y, x);

                    if (grid[y][x] == 1 && (neighbours < 2 || neighbours > 3)) {
                        newGrid[y][x] = 0;
                    }else if (grid[y][x] == 0 && neighbours == 3) {
                        newGrid[y][x] = 1;
                    }else{
                        newGrid[y][x] = grid[y][x];
                    }
                }
            }

            grid = newGrid;
            outputHandler.draw(newGrid);
            sleep(REFRESH_RATE);
        }
    }

    public static int livingNeighbours(int[][] grid, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                if (grid[x][y] == 1) lives++;
            }
        }
        if (grid[i][j] == 1) lives--;
        return lives;
    }
}
