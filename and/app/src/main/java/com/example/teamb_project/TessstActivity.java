package com.example.teamb_project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamb_project.databinding.ActivityTessstBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class TessstActivity extends AppCompatActivity {
    VideoView vv;
    ActivityTessstBinding b;
    PlayerView playerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityTessstBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        Uri uri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

        playerView = b.videoView;

        ExoPlayer player = new SimpleExoPlayer.Builder(this).build();
        player.setMediaItem(new MediaItem.Builder().setUri(uri).build());
        playerView.setPlayer( player);


    }

    private void initPlayer() {

    }


}