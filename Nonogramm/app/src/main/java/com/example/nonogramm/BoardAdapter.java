package com.example.nonogramm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class BoardAdapter extends BaseAdapter {
    public Integer size;
    private Context mContext;
    private Board board;
    private Board playerBoard;
    private int difficulty;
    private View[][] buttons;

    public BoardAdapter(Context c, int size, Board board, int difficulty) {
        mContext = c;
        this.size = size;
        this.board = board;
        this.playerBoard = new Board(10);
        this.difficulty = difficulty;
        buttons = new View[size][size];
    }

    public boolean CheckWin() {
        boolean win = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playerBoard.grid[i][j] != board.grid[i][j])
                    win = false;
            }
        }
        return win;
    }

    public boolean CheckRow(int row) {
        boolean full = true;
        for (int j = 0; j < size; j++) {
            if ((board.grid[row][j] == true) && (playerBoard.grid[row][j] == false))
                full = false;
        }
        return full;
    }

    public boolean CheckColumn(int col) {
        boolean full = true;
        for (int j = 0; j < size; j++) {
            if ((board.grid[j][col] == true) && (playerBoard.grid[j][col] == false))
                full = false;
        }
        return full;
    }

    private void FillRow(int row) {
        for (int j = 0; j < size; j++) {
            if (Levels.currentLevel.grid[row][j] == "X") {
                Levels.currentLevelProgress.grid[row][j] = "X";
                ((ImageView) buttons[row][j]).setImageResource(R.drawable.cross);
                buttons[row][j].setBackgroundResource(R.drawable.cross_back);
                buttons[row][j].setEnabled(false);
            }
        }
    }

    private void FillColumn(int col) {
        for (int j = 0; j < size; j++) {
            if (Levels.currentLevel.grid[j][col] == "X") {
                Levels.currentLevelProgress.grid[j][col] = "X";
                ((ImageView) buttons[j][col]).setImageResource(R.drawable.cross);
                buttons[j][col].setBackgroundResource(R.drawable.cross_back);
                buttons[j][col].setEnabled(false);
            }
        }
    }

    public boolean PlayerAction(int i) {
        playerBoard.grid[i / size][i % size] = true;
        return CheckWin();
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public int getCount() {
        return size * size;
    }

    @Override
    public Boolean getItem(int i) {
        return board.grid[i / size][i % size];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView button = new ImageView(mContext);

        button.setPadding(1, 1, 1, 1);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @SuppressLint({"ResourceType"})
            public boolean onTouch(View view, MotionEvent event) {
                Log.d("Action", String.valueOf(event.getAction()));
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if (getItem(i) == true) {
                            view.setBackgroundResource(R.drawable.fill);

                            Levels.currentLevelProgress.grid[i / size][i % size] = "O";

                            boolean win = PlayerAction(i);
                            boolean row_filled = CheckRow(i / size);
                            Log.d("Filled row", String.valueOf(row_filled));
                            if (row_filled)
                                FillRow(i / size);

                            boolean col_filled = CheckColumn(i % size);
                            Log.d("Filled col", String.valueOf(col_filled));
                            if (col_filled)
                                FillColumn(i % size);
                            if (win) {

                                Levels.winStreak++;
                                Levels.victories++;
                                ImageDialog dialog = new ImageDialog(mContext);
                                dialog.show(((AppCompatActivity) mContext).getFragmentManager(),
                                        "MyCustomDialog");

                            }


                        } else {
                            view.setBackgroundResource(R.drawable.cross_back);
                            ((ImageView) view).setImageResource(R.drawable.cross);
                            Levels.currentLevelProgress.grid[i / size][i % size] = "X";
                        }
                        if (Levels.mode != getItem(i)) {
                            Levels.Lives--;
                            if (Levels.Lives <= 0) {
                                Levels.winStreak = 0;
                                DefeatDialog dialog = new DefeatDialog(mContext);
                                dialog.show(((AppCompatActivity) mContext).getFragmentManager(),
                                        "MyCustomDialog");
                            }
                            Levels.UpdateLives();
                        }
                        button.setEnabled(false);
                        break;
                    }

                }
                return true;
            }
        });

//        button.setOnHoverListener(new View.OnHoverListener() {
//            @Override
//            public boolean onHover(View v, MotionEvent event) {
//                Log.d("Action", String.valueOf(event.getAction()));
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_HOVER_MOVE:
//                    case MotionEvent.ACTION_HOVER_EXIT:
//                    case MotionEvent.ACTION_HOVER_ENTER:
//                        if (getItem(i) == true) {
//                            view.setBackgroundResource(R.drawable.fill);
//                            PlayerAction(i);
//                            Levels.currentLevelProgress.grid[i / size][i % size] = "O";
//
//                        } else {
//                            view.setBackgroundResource(R.drawable.cross);
//                            Levels.currentLevelProgress.grid[i / size][i % size] = "X";
//                        }
//                        break;
//
//                }
//                return true;
//            }
//        });

        if (Levels.currentLevelProgress.grid[i / size][i % size] == "O") {
            button.setBackgroundResource(R.drawable.fill);
            PlayerAction(i);
            button.setEnabled(false);
        } else if (Levels.currentLevelProgress.grid[i / size][i % size] == "X") {
            button.setBackgroundResource(R.drawable.cross_back);
            button.setImageResource(R.drawable.cross);
            button.setEnabled(false);
        } else {
            button.setBackgroundResource(R.drawable.nothing);
        }

        if (difficulty == EDifficulty.EASY.ordinal() && Levels.currentLevel.grid[i / size][i % size] == "X") {
            Random random = new Random();
            if (random.nextFloat() < 0.2) {
                button.setBackgroundResource(R.drawable.cross_back);
                button.setImageResource(R.drawable.cross);
                button.setEnabled(false);
				Levels.currentLevelProgress.grid[i / size][i % size] = "X";
            }
        }
        buttons[i / size][i % size] = button;
        return button;
    }
}
