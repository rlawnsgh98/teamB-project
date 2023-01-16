package com.example.teamb_project.teacher.notice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityNoticeBinding;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNoticeBinding b;
    ArrayList<BoardVO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNoticeBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //메소드 재활용
        Common common = new Common();

        //클릭이벤트
        b.ivBack.setOnClickListener(this);
        b.cardGoTop.setOnClickListener(this);

        //스크롤 내리면 최상단 이동 버튼 보이기
        common.scrollTop(b.scrNotice, b.cardGoTop);

        selectNotice();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.iv_back){
            //뒤로가기 클릭시
            onBackPressed();
        }else if(v.getId()==R.id.card_go_top){
            //스크롤 최상단으로 이동
            b.scrNotice.fullScroll(ScrollView.FOCUS_UP);
        }
    }

    void selectNotice(){
        new CommonMethod().sendPost("notice_list.bo", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());

                b.recvNotice.setAdapter(new NoticeAdapter(getLayoutInflater(), list));
                b.recvNotice.setLayoutManager(com.example.teamb_project.common.CommonMethod.getManager(b.getRoot().getContext()));
            }
        });
    }

}