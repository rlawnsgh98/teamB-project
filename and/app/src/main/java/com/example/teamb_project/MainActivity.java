package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        b.btnBoard.setOnClickListener(this);
        b.btnNotice.setOnClickListener(this);
        b.btnVideo.setOnClickListener(this);
        b.btnBoardDetail.setOnClickListener(this);

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
            Intent intent = new Intent(MainActivity.this, TessstActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.btn_board_detail){
            Intent intent = new Intent(MainActivity.this, BoardDetailActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}