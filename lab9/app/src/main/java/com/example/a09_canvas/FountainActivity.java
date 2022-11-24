package com.example.a09_canvas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.tutorials.android.particles.ParticlesGenerator;
import com.tutorials.android.particles.ParticlesManager;
import com.tutorials.android.particles.ParticlesSource;
import com.tutorials.android.particles.Utils;
import com.tutorials.android.particles.particles.BitmapParticles;
import com.tutorials.android.particles.particles.Particles;

import java.util.Random;

public class FountainActivity extends AppCompatActivity {
    ViewGroup main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fontain);
        main = findViewById(R.id.Fontain);


        playAnim();

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAnim();
            }
        });
        main.performClick();
        main.performContextClick();
        main.performLongClick();
    }


    public void playAnim() {
        Bitmap allPossibleParticles = Utils.createCircleBitmap(Color.YELLOW, 12);
        ParticlesGenerator particlesGenerator = new ParticlesGenerator() {
            @Override
            public Particles generateParticles(Random random) {
                Bitmap bitmap = allPossibleParticles;
                return new BitmapParticles(bitmap);
            }
        };

        int containerMiddleX = main.getWidth() / 2;
        int containerMiddleY = main.getHeight() * 5 / 6;
        ParticlesSource particlesSource = new ParticlesSource(containerMiddleX, containerMiddleY);

        ParticlesManager particlesManager = new ParticlesManager(FountainActivity.this, particlesGenerator, particlesSource, main)
                .setEmissionDuration(4000)
                .setEmissionRate(250)
                .setVelocityX(0)
                .setVelocityY(-920)
                .setAccelerationX(0, 200)
                .setAccelerationY(500)
                .setRotationalVelocity(360, 720)
                .animate();

    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, MusicActivity.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, ParticlesActivity.class));
    }
}