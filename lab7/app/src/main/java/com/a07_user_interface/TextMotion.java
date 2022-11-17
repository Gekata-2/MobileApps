package com.a07_user_interface;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TextMotion extends AppCompatActivity {
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_motion);
        TextView txt = findViewById(R.id.textView);
        txt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @SuppressLint("ResourceType")
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        txt.setTextColor(Color.parseColor(getString(R.color.blue)));
                        Animation descend = AnimationUtils.loadAnimation(TextMotion.this, R.anim.text_descend);
                        txt.startAnimation(descend);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        Animation ascend = AnimationUtils.loadAnimation(TextMotion.this, R.anim.text_ascend);
                        txt.startAnimation(ascend);
                        txt.setTextColor(Color.parseColor(getString(R.color.black)));
                        break;
                    }
                }
                return true;
            }
        });

    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, ButtonsBegin.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}