package com.example.a09_canvas;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView MyVideo = findViewById(R.id.MyVideo);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory() + "/Movies/str.mp4");
        MyVideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        MyVideo.setMediaController(mediaController);
        mediaController.setAnchorView(MyVideo);

    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, MusicActivity.class));
    }
}