package com.example.teamb_project.student.mylecture.lecturehome.video_board;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityVideoDetailBinding;
import com.example.teamb_project.vo.BoardVO;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.gson.GsonBuilder;

public class VideoDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityVideoDetailBinding b;
    final String TAG = "log";

    CommonMethod commonMethod = new CommonMethod();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityVideoDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //강의영상 상세 정보 조회
        commonMethod.setParams("board_code", getIntent().getIntExtra("board_code", -1))
                .sendPost("info.vi", (isResult, data) -> {
                    Log.d(TAG, "강의영상 data : " + data);

                    //DB 조회해온 강의영상 객체
                    BoardVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, BoardVO.class);
                    b.tvTitle.setText(vo.getTitle());
                    b.tvContent.setText(vo.getContent());
                    b.tvWriter.setText(vo.getMember_name());
                    b.tvWritedate.setText(vo.getWritedate().toString());
                    b.tvReadcnt.setText(vo.getReadcnt()+"");

//                    Uri uri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
                    Uri uri = Uri.parse(vo.getFileList().get(0).getPath());

                    ExoPlayer player = new SimpleExoPlayer.Builder(this).build();
                    player.setMediaItem(new MediaItem.Builder().setUri(uri).build());
                    b.videoView.setPlayer( player);

                });

        //클릭
        b.ivBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.iv_back){
            //뒤로가기
            onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}