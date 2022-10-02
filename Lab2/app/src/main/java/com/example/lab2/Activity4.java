package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        TransformSquare();
    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, Activity5.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, Activity3.class));
    }

    private void TransformSquare() {
        View squareNormal = findViewById(R.id.square_normal);
        View viewChanged = findViewById(R.id.square_changed);
        Drawable backgroundNormal = squareNormal.getBackground();
        viewChanged.setBackground(backgroundNormal);
        viewChanged.setScaleX(0.33f);

        viewChanged.setRotation(45.0f);

    }
}