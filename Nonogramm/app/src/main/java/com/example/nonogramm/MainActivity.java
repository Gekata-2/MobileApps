package com.example.nonogramm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button continueGame;
    TextView victories, winStreak;

    public void UpdateMenu() {
        if (Levels.currentLevel != null)
            continueGame.setVisibility(View.VISIBLE);
        else
            continueGame.setVisibility(View.INVISIBLE);
        victories.setText("Всего побед: " + Levels.victories);
        winStreak.setText("Серия побед: " + Levels.winStreak);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueGame = findViewById(R.id.btn_continue);
        victories = findViewById(R.id.victories);
        winStreak = findViewById(R.id.winstreak);

    }

    @Override
    protected void onResume() {
        UpdateMenu();
        super.onResume();
    }

    public void NewGame(View v) {
        DifficultyDialog dialog = new DifficultyDialog(this);
        dialog.show(getFragmentManager(),
                "MyCustomDialog");
    }

    public void ContinueGame(View v) {
        Intent intent = new Intent(this, LevelNormal.class);
        intent.putExtra("new game", false);
        startActivity(intent);
    }
}