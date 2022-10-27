package com.example.lab52;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class task2 extends AppCompatActivity {

    final String PAGE_ADDED = "Страница добавлена!";
    final String PAGE_DELETED = "Страница удалена!";
    final String PAGE_NOT_EXIST = "Страницы не существует!";
    TextView pageState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        pageState = findViewById(R.id.page_state);
    }

    public void AddPage(View v) {

        pageState.setText(PAGE_ADDED);
        startActivity(new Intent(this, Activity2.class));


    }

    public void DeletePage(View v) {

        if (Activity2.activity != null) {

            pageState.setText(PAGE_DELETED);
            Activity2.activity.finish();
            Activity2.activity = null;
        } else {
            pageState.setText(PAGE_NOT_EXIST);
        }
    }
}