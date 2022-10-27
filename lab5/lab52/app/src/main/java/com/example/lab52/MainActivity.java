package com.example.lab52;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button next;
    Button prev;
    Button nextTask;
    TextView stack_counter;
    private int current_stack_depth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        nextTask = findViewById(R.id.next_task);
        stack_counter = findViewById(R.id.stack_counter);
        Intent intent = getIntent();

        int received_stack_depth = intent.getIntExtra("current_stack_depth", 0);

        current_stack_depth = received_stack_depth;
        stack_counter.setText(String.valueOf(current_stack_depth+1));
        if (current_stack_depth > 0) {
            nextTask.setEnabled(false);
        }

    }

    public void NextActivity(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("current_stack_depth", current_stack_depth + 1);
        startActivity(intent);
    }

    public void PrevActivity(View v) {
        this.finishAndRemoveTask();
    }

    public void NextTask(View v) {
        startActivity(new Intent(this, task2.class));
    }
}