package ch.bbw.mf;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int HEIGHT = 25;
        int WIDTH = 100;
        int[][] grid = new int[HEIGHT][WIDTH];

        Random rand = new Random();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                grid[y][x] = rand.nextBoolean() ? 1 : 0;
            }
        }

        try {
            GameOfLife.runSimulation(grid);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}