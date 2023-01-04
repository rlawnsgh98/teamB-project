package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.databinding.ActivityNewBoardBinding;

public class NewBoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewBoardBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());


        //글 등록 버튼 클릭
        b.cardInsert.setOnClickListener(this);

        //뒤로가기
        b.ivBack.setOnClickListener(this);
        b.cardBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //자유게시판으로 이동하는 Intent
        Intent board_intent = new Intent(NewBoardActivity.this, BoardActivity.class);

        if(v.getId()==R.id.iv_back){
            startActivity(board_intent);
        }else if(v.getId()==R.id.card_back){
            startActivity(board_intent);
        }else if(v.getId()==R.id.card_insert){
            //글 등록처리
        }

    }


    //바인딩 비우기
    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }

}