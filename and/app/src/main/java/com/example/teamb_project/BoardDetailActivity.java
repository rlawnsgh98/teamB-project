package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.databinding.ActivityBoardDetailBinding;

import java.util.ArrayList;

public class BoardDetailActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBoardDetailBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //클릭이벤트
        b.ivBack.setOnClickListener(this);

        //댓글 리스트
        ArrayList<Object> list = new ArrayList<>();
        //어댑터 설정 - 댓글
        b.recvReply.setAdapter(new ReplyAdapter(getLayoutInflater(), list));
        b.recvReply.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }

    //클릭
    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.iv_back){
            Intent intent = new Intent(BoardDetailActivity.this, BoardActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }


}