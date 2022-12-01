package com.example.nonogramm;

import android.util.Log;

import java.util.ArrayList;

class Board {
    public boolean[][] grid;
    public Integer size;

    Board(int size) {
        this.size = size;
        grid = new boolean[size][size];
    }

    Board(int size, boolean[][] booleans) {
        this.size = size;
        grid = booleans;
    }

    public static boolean[][] GenerateBoard(int size) {
        boolean[][] grid = new boolean[size][size];
        ;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0 &&j % 2 == 0)
                    grid[i][j] = true;
                else
                    grid[i][j] = false;
            }
        return grid;
    }

    public ArrayList<Integer> GetNumberOfFilledTilesRow(int i) {
        ArrayList<Integer> numbers = new ArrayList<>();
        if (i < size) {
            int cur = 0;
            for (int l = 0; l < size; l++) {
                while ( l < size &&grid[i][l] == true ) {
                    cur++;
                    l++;
                }
                if (cur > 0) {
                    numbers.add(cur);
                }
                cur = 0;
            }
        }
        return numbers;
    }

    public ArrayList<Integer> GetNumberOfFilledTilesColumn(int j) {
        ArrayList<Integer> numbers = new ArrayList<>();
        if (j < size) {
            int cur = 0;
            for (int l = 0; l < size; l++) {
                while (l < size &&grid[l][j] == true ) {
                    cur++;
                    l++;
                }
                if (cur > 0) {
                    numbers.add(cur);
                }
                cur = 0;
            }
        }
        if (numbers.isEmpty())
            numbers.add(0);
        return numbers;
    }

}