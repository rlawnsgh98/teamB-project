package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.teamb_project.counselling.CounselActivity;
import com.example.teamb_project.databinding.ActivityMainBinding;
import com.example.teamb_project.teacher.board.BoardActivity;
import com.example.teamb_project.teacher.board.BoardDetailActivity;
import com.example.teamb_project.teacher.notice.NoticeActivity;
import com.example.teamb_project.video_board.VideoBoardActivity;
import com.example.teamb_project.video_board.VideoDetailActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding b;
    final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        ApiClient.setBASEURL("http://192.168.0.115/middle/");

        b.btnBoard.setOnClickListener(this);
        b.btnNotice.setOnClickListener(this);
        b.btnVideo.setOnClickListener(this);
        b.btnBoardDetail.setOnClickListener(this);
        b.btnVideoBoard.setOnClickListener(this);
        b.btnCounsel.setOnClickListener(this);


        //스프링 연동
        b.tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CommonMethod().setParams("pw", "뿅").sendGet("and", (isResult, data) -> {
                    Log.d(TAG, "보냈다!" + data);
                });

            }
        });

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_notice){
            Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.btn_board){
            Intent intent = new Intent(MainActivity.this, BoardActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.btn_video){
            Intent intent = new Intent(MainActivity.this, VideoDetailActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.btn_board_detail){
            Intent intent = new Intent(MainActivity.this, BoardDetailActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.btn_video_board){
            Intent intent = new Intent(MainActivity.this, VideoBoardActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.btn_counsel){
            Intent intent = new Intent(MainActivity.this, CounselActivity.class);
            startActivity(intent);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}