package com.example.nonogramm;

public class Level {


    public String[][] grid;
    public int size = 10;
    public int background_id;

    public Level(int size, int id, String[][] grid) {
        this.size = size;
        this.grid = grid;
        background_id = id;
    }

    public boolean[][] ParseGrid() {
        boolean b_grid[][] = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == Levels.CROSS)
                    b_grid[i][j] = false;
                else
                    b_grid[i][j] = true;
            }
        }
        return b_grid;
    }

}
