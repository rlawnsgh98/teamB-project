package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class TessstActivity extends AppCompatActivity {
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tessst);

        vv = findViewById(R.id.video);

        Uri vUri = Uri.parse("https://youtu.be/p3RqpJQ6FXo");

        vv.setMediaController(new MediaController(this));
        vv.setVideoURI(vUri);
        vv.requestFocus();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                vv.start();
            }
        });

    }
}