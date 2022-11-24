package com.example.a09_canvas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SpriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprite);

    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, ParticlesActivity.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}