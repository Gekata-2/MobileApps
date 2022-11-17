package com.a07_user_interface;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class Sekundomer extends AppCompatActivity {
    boolean isStopped = false;
    boolean isStarted = false;
    long totalTime = 0;
    private Chronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekundomer);

        mChronometer = findViewById(R.id.chronometer);
        mChronometer.setText("00:00:00");
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase() + totalTime;
                int h = (int) (time / 3600000);
                int m = (int) (time - h * 3600000) / 60000;
                int s = (int) (time - h * 3600000 - m * 60000) / 1000;
                String t = (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":" + (s < 10 ? "0" + s : s);
                chronometer.setText(t);
            }
        });
    }

    public void onStartClick(View view) {
        if (!isStarted) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
            mChronometer.start();
            isStarted = true;
        } else {
            if (!isStopped) {
                mChronometer.stop();
                totalTime += SystemClock.elapsedRealtime() - mChronometer.getBase();
                isStopped = true;
            } else {
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
                isStopped = false;
            }


        }
    }

    public void onResetClick(View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        isStopped = false;
        isStarted = false;
        totalTime = 0;
        mChronometer.stop();
        mChronometer.setText("00:00:00");
    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, PageStack.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, ButtonsBegin.class));
    }
}