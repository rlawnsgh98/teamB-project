package com.example.teamb_project.video_board;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.CommonMethod;
import com.example.teamb_project.databinding.ActivityVideoDetailBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityVideoDetailBinding b;
    YouTubePlayerView yPlayerView;
    YouTubePlayer yPlayer;
    final String TAG = "log";

//    String API_KEY = "AIzaSyARwP_xzcQggI8KGVkocJdk5W0TdDdk0M8";
//    String videoId = "ViuzCw1nGvE";

    CommonMethod commonMethod = new CommonMethod();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityVideoDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
//        getSupportActionBar().hide();


        Uri uri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

        ExoPlayer player = new SimpleExoPlayer.Builder(this).build();
        player.setMediaItem(new MediaItem.Builder().setUri(uri).build());
        b.videoView.setPlayer( player);

        //해당 영상 Uri 조회
        commonMethod.setParams("board_code", getIntent())
                .sendPost("selectVideo", (isResult, data) -> {
                    Log.d(TAG, "가져온 uri : " + data);
                    Uri uri1 = Uri.parse(data);
                    //exoPlayer 에 setUri
                });

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}