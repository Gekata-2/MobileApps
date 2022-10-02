package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        PlayAnim();
    }
    public void NextActivity(View v)
    {
        startActivity(new Intent(this, Activity6.class));
    }
    public void PrevActivity(View v)
    {
        startActivity(new Intent(this, Activity4.class));
    }
    private  void PlayAnim()
    {
        View view = findViewById(R.id.square_red);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, 750);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setRepeatMode(Animation.REVERSE);


        ScaleAnimation scaleAnimation = new ScaleAnimation(view.getScaleX(), 1.5f, view.getScaleY(), 1.5f);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);


        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(1500);

        view.startAnimation(animationSet);
    }
}