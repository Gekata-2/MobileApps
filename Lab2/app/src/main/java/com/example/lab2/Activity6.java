package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, Activity5.class));
    }

    public void onClickSum(View view) {
        EditText number1 = findViewById(R.id.n1);
        EditText number2 = findViewById(R.id.n2);
        EditText result = findViewById(R.id.result);

        result.setText(String.valueOf(Double.valueOf(number1.getText().toString()) + Double.valueOf(number2.getText().toString())));
    }

}