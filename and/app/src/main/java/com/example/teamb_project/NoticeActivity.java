package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import com.example.teamb_project.databinding.ActivityBoardBinding;
import com.example.teamb_project.databinding.ActivityNoticeBinding;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNoticeBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNoticeBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //클릭이벤트
        b.ivBack.setOnClickListener(this);
        b.cardGoTop.setOnClickListener(this);

        //스크롤 내리면 최상단 이동 버튼 보이기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            b.scrNotice.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Log.d("log", "onScrollChange: "+b.scrNotice.getScrollY());
                    if(b.scrNotice.getScrollY()>100){
                        b.cardGoTop.setVisibility(View.VISIBLE);
                    }else{
                        b.cardGoTop.setVisibility(View.GONE);
                    }
                }
            });
        }

        //어댑터로 보내줄 공지사항 리스트
        ArrayList<Object> list = new ArrayList<>();
        //어댑터 설정
        b.recvNotice.setAdapter(new NoticeAdapter(getLayoutInflater(), list));
        b.recvNotice.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.iv_back){
            //뒤로가기 클릭시
            Intent intent = new Intent(NoticeActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.card_go_top){
            //스크롤 최상단으로 이동
            b.scrNotice.fullScroll(ScrollView.FOCUS_UP);
        }
    }
}