package ch.bbw.mf;


import java.io.IOException;

public class OutputHandler {
    private String CHAR_LIVING_CELL = "X";
    private String CHAR_DEAD_CELL = "O";

    public void draw(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int y = 0; y < height; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < width; x++) {
                line.append(grid[y][x] == 1 ? CHAR_LIVING_CELL : CHAR_DEAD_CELL);
            }
            System.out.println(line);
        }
    }
}
