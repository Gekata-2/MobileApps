package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
    public void NextActivity(View v)
    {
        startActivity(new Intent(this, Activity4.class));
    }
    public void PrevActivity(View v)
    {
        startActivity(new Intent(this, Activity2.class));
    }
}