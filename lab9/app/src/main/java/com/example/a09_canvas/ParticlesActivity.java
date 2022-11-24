package com.example.a09_canvas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
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

public class ParticlesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particles_on_touch);

        ViewGroup main = findViewById(R.id.ParticlesOnTouch);

        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        final Bitmap allPossibleParticles = Utils.createCircleBitmap(Color.GREEN, 27);
                        final ParticlesGenerator particlesGenerator = new ParticlesGenerator() {
                            @Override
                            public Particles generateParticles(Random random) {
                                final Bitmap bitmap = allPossibleParticles;
                                return new BitmapParticles(bitmap);
                            }
                        };
                        final int containerMiddleX = x;
                        final int containerMiddleY = y;
                        final ParticlesSource particlesSource = new ParticlesSource(containerMiddleX, containerMiddleY);
                        float length = 320.0f;

                        for (int i = 0; i < 720; i += 10) {
                            new ParticlesManager(ParticlesActivity.this, particlesGenerator, particlesSource, main)
                                    .setNumInitialCount(3)
                                    .setVelocityX((float) (length * Math.cos(i)))
                                    .setVelocityY((float) (length * Math.sin(i)))
                                    .animate();
                        }
                    }

                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                }
                return false;
            }
        });

    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, FountainActivity.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, SpriteActivity.class));
    }
}