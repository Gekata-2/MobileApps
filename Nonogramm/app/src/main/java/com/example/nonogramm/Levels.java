package com.example.nonogramm;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

enum EDifficulty {
    NORMAL,
    EASY
}

public class Levels {
    public static int winStreak = 0;
    public static int victories = 0;

    public static String CROSS = "X";
    public static String FILL = "O";
    public static String NOT_CLICKED = ".";
    public static int Lives = 3;
    public static boolean mode = true;
    public static ImageView[] livesIcons = new ImageView[3];
    public static Activity currentActivity;

    public static TextView victory;

    public static Level[] levelsNormal = new Level[]{
            new Level(10, R.drawable.bungalo, //Level 1 - Bungalo
                    new String[][]{
                            // 1    2    3    4    5    6    7    8    9    10
                            {"X", "X", "X", "X", "O", "O", "X", "X", "X", "X"}, // 1
                            {"X", "X", "X", "O", "O", "O", "O", "X", "X", "X"}, // 2
                            {"X", "X", "O", "O", "O", "O", "O", "O", "X", "X"}, // 3
                            {"X", "O", "O", "O", "O", "O", "O", "O", "O", "X"}, // 4
                            {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}, // 5
                            {"X", "X", "O", "O", "O", "X", "X", "O", "X", "X"}, // 6
                            {"X", "X", "O", "O", "O", "X", "X", "O", "X", "X"}, // 7
                            {"X", "X", "O", "O", "O", "X", "X", "O", "X", "X"}, // 8
                            {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}, // 9
                            {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}  // 10
                    }),
            new Level(10, R.drawable.pyramid, //Level 2 - Pyramid
                    new String[][]{
                            // 1    2    3    4    5    6    7    8    9    10
                            {"X", "X", "X", "X", "X", "X", "X", "X", "O", "X"}, // 1
                            {"X", "X", "X", "X", "X", "X", "X", "O", "O", "O"}, // 2
                            {"X", "X", "X", "X", "X", "X", "X", "X", "O", "X"}, // 3
                            {"X", "X", "X", "X", "O", "O", "X", "X", "X", "X"}, // 4
                            {"X", "X", "X", "O", "O", "O", "O", "X", "X", "X"}, // 5
                            {"X", "X", "O", "O", "O", "O", "O", "O", "X", "X"}, // 6
                            {"X", "O", "O", "O", "O", "O", "O", "O", "O", "X"}, // 7
                            {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}, // 8
                            {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}, // 9
                            {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}  // 10
                    }),
            new Level(10, R.drawable.dawn, //Level 3 - Dawn
                    new String[][]{
                            // 1    2    3    4    5    6    7    8    9    10
                            {"O", "X", "O", "X", "O", "O", "X", "O", "X", "O"}, // 1
                            {"X", "O", "X", "O", "X", "O", "O", "X", "O", "X"}, // 2
                            {"X", "X", "O", "X", "O", "X", "O", "O", "X", "O"}, // 3
                            {"X", "X", "X", "O", "O", "O", "O", "X", "O", "X"}, // 4
                            {"X", "X", "X", "X", "X", "P", "O", "O", "X", "X"}, // 9
                            {"X", "X", "X", "X", "X", "X", "O", "X", "X", "X"}, // 9
                            {"X", "X", "X", "X", "X", "X", "O", "X", "X", "X"}, // 9
                            {"X", "X", "X", "X", "X", "X", "O", "X", "X", "X"}, // 9
                            {"X", "X", "X", "X", "X", "X", "O", "X", "X", "X"}, // 9
                            {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}  // 10
                    }),
            new Level(10, R.drawable.heart_t, //Level 4 - test
                    new String[][]{
                            // 1    2    3    4    5    6    7    8    9    10
                            {"O", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 1
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 2
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 3
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 4
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 5
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 6
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 7
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 8
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 9
                            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}  // 10
                    })
    };
    public static Level currentLevel = null;
    public static Level currentLevelProgress = null;
    public static Level notClickedLevel = new Level(10, R.drawable.ic_launcher_background,
            new String[][]{
                    // 1    2    3    4    5    6    7    8    9    10
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 1
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 2
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 3
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 4
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 5
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 6
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 7
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 8
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}, // 9
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}  // 10
            });
    public static int currentLvl = -1;
    private static int sizeNormal = 10;
    private static Level emptyLevel = new Level(10, R.drawable.ic_launcher_background,
            new String[][]{
                    // 1    2    3    4    5    6    7    8    9    10
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 1
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 2
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 3
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 4
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 5
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 6
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 7
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 8
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}, // 9
                    {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}  // 10
            });

    public static void InitLives(ImageView life1, ImageView life2, ImageView life3) {
        livesIcons[0] = life1;
        livesIcons[1] = life2;
        livesIcons[2] = life3;
    }

    public static boolean[][] ChooseLevel(int i, EDifficulty difficulty) {
        Lives = 3;
        mode = true;
        currentLevelProgress = new Level(10, R.drawable.ic_launcher_background, notClickedLevel.grid);
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                currentLevelProgress.grid[j][k] = ".";
            }
        }
        if (i < levelsNormal.length) {
            currentLevel = new Level(10,levelsNormal[i].background_id, levelsNormal[i].grid);
            currentLvl = i;
            return levelsNormal[i].ParseGrid();
        } else {
            currentLevel = new Level(10, R.drawable.heart_t, emptyLevel.grid);
            return emptyLevel.ParseGrid();
        }
    }

    public static boolean[][] ChooseRandomLevel(EDifficulty difficulty) {
        Random random = new Random();
        return ChooseLevel(random.nextInt(levelsNormal.length), difficulty);
    }

    public static boolean[][] GetCurrentLevelProgress() {
        return currentLevelProgress.ParseGrid();
    }

    public static boolean[][] getCurrentLevel() {
        return currentLevel.ParseGrid();
    }

    public static void UpdateLives() {
        Log.d("Lives", String.valueOf(Levels.Lives));
        switch (Levels.Lives) {
            case 3:
                livesIcons[0].setImageResource(R.drawable.heart_t);
                livesIcons[1].setImageResource(R.drawable.heart_t);
                livesIcons[2].setImageResource(R.drawable.heart_t);
                break;
            case 2:
                livesIcons[0].setImageResource(R.drawable.heart_t);
                livesIcons[1].setImageResource(R.drawable.heart_t);
                livesIcons[2].setImageResource(R.drawable.heart_empy_t);
                break;
            case 1: {
                livesIcons[0].setImageResource(R.drawable.heart_t);
                livesIcons[1].setImageResource(R.drawable.heart_empy_t);
                livesIcons[2].setImageResource(R.drawable.heart_empy_t);
                break;
            }
            case 0: {
                livesIcons[0].setImageResource(R.drawable.heart_empy_t);
                livesIcons[1].setImageResource(R.drawable.heart_empy_t);
                livesIcons[2].setImageResource(R.drawable.heart_empy_t);
                break;
            }
            default:
                break;
        }
    }
};

