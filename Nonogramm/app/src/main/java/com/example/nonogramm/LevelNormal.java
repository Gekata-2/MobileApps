package com.example.nonogramm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LevelNormal extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {


    BoardAdapter boardAdapter;
    HintAdapter hintUpper;
    HintAdapter hintLeft;
    GridView gridView;
    GridView upper;
    GridView left;
    Board board;
    Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_normal);


        Intent intent = getIntent();
        boolean newGame = intent.getBooleanExtra("new game", true);
        boolean sameLevel = intent.getBooleanExtra("same level", false);
        int difficulty = intent.getIntExtra("Difficulty", EDifficulty.NORMAL.ordinal());

        Log.d("New?", String.valueOf(newGame));

        if (Levels.currentActivity != null) {
            Levels.currentActivity.finish();
            Levels.currentActivity = null;
        }

        gridView = findViewById(R.id.grid);
        upper = findViewById(R.id.upper);
        left = findViewById(R.id.left);

        Levels.InitLives(findViewById(R.id.life1), findViewById(R.id.life2), findViewById(R.id.life3));

        aSwitch = findViewById(R.id.mode);
        aSwitch.setChecked(true);


        if (newGame) {
            if (sameLevel)
                board = new Board(10, Levels.ChooseLevel(Levels.currentLvl, EDifficulty.NORMAL));
            else
                board = new Board(10, Levels.ChooseRandomLevel(EDifficulty.NORMAL));
        } else {
            board = new Board(10, Levels.getCurrentLevel());
            Levels.mode = true;
        }

        Levels.UpdateLives();

        boardAdapter = new BoardAdapter(this, 10, board, difficulty);
        gridView.setAdapter(boardAdapter);


        hintUpper = new HintAdapter(this, ParseUpperHint(), EHintType.UPPER);
        upper.setAdapter(hintUpper);

        hintLeft = new HintAdapter(this, ParseLeftHint(), EHintType.LEFT);
        left.setAdapter(hintLeft);


        Levels.currentActivity = this;
    }

    private String ParseRow(int row) {
        String res = "";
        ArrayList<Integer> numbers = board.GetNumberOfFilledTilesRow(row);

        for (int i = 0; i < numbers.size(); i++) {
            if (i < numbers.size() - 1)
                res += numbers.get(i) + " ";
            else
                res += numbers.get(i);
        }
        if (numbers.isEmpty())
            res += "0";

        return res;
    }

    private String ParseColumn(int col) {
        String res = "";
        ArrayList<Integer> numbers = board.GetNumberOfFilledTilesColumn(col);
        for (int i = 0; i < numbers.size(); i++) {

            if (i < numbers.size() - 1)
                res += numbers.get(i).toString() + "\n";
            else
                res += numbers.get(i).toString();
        }
        if (numbers.isEmpty())
            res += "0";

        return res;
    }

    public void onSwitcherPressed(View v) {
        if (Levels.mode == false) {
            Levels.mode = true;
        } else {
            Levels.mode = false;
        }
    }

    private ArrayList<String> ParseUpperHint() {
        ArrayList<String> upperHints = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String col = ParseColumn(i);
            upperHints.add(col);
        }

        return upperHints;
    }

    private ArrayList<String> ParseLeftHint() {
        ArrayList<String> leftHints = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String row = ParseRow(i);
            leftHints.add(row);
        }

        return leftHints;
    }


    public void BackToMenu(View v) {


        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}