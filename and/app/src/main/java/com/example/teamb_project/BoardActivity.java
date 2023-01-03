package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityBoardBinding;

import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBoardBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        Common common = new Common();

        //클릭이벤트
        b.ivSearch.setOnClickListener(this);
        b.cardGoTop.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);

        //EditText 입력이벤트
//        b.edtSearch.addTextChangedListener(common.getTextWatcher(b.ivTextRemove));

        //스크롤 내리면 아이콘 보이게
        common.scrollTop(b.scrBoard, b.cardGoTop);

        //리사이클러뷰에 들어갈 데이터 List
        ArrayList<Object> list = new ArrayList<>();
        //어댑터 설정
        b.recvBoard.setAdapter(new BoardAdapter(getLayoutInflater(), list));
        b.recvBoard.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    @Override
    public void onClick(View v) {
        b.edtSearch.clearFocus();

        if(v.getId()==R.id.iv_search){
            //검색처리
        }else if(v.getId()==R.id.card_go_top){
            //스크롤 최상단으로 이동
            b.scrBoard.fullScroll(ScrollView.FOCUS_UP);
        }else if(v.getId()==R.id.iv_back){
            //돌아가기
            Intent intent = new Intent(BoardActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }


}