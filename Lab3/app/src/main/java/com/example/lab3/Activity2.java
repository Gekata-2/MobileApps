package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    public void NextActivity(View v)
    {
        startActivity(new Intent(this, Activity2.class));
    }
    public void PrevActivity(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }
}