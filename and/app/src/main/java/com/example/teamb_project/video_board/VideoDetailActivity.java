package com.example.teamb_project.video_board;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityVideoDetailBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

public class VideoDetailActivity extends AppCompatActivity {
    ActivityVideoDetailBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityVideoDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();


        Uri uri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

        ExoPlayer player = new SimpleExoPlayer.Builder(this).build();
        player.setMediaItem(new MediaItem.Builder().setUri(uri).build());
        b.videoView.setPlayer( player);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}