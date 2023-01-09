package com.example.teamb_project.teacher.board;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityNewBoardBinding;

public class NewBoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewBoardBinding b;
    final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        Common common = new Common();
        //임시로그인 - user1
        common.setTempLoginInfo();

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
        CommonMethod commonMethod = new CommonMethod();
        Common common = new Common();
//        ApiClient.setBASEURL("http://192.168.0.115/middle/");


        if(v.getId()== R.id.iv_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_insert){
            //글 등록처리
            if(!TextUtils.isEmpty(b.edtTitle.getText().toString()) && !TextUtils.isEmpty(b.edtContent.getText().toString())){
                Log.d(TAG, "글 등록 가능");
                commonMethod.setParams("writer", common.getLoginInfo().getMember_code())
                        .setParams("title", b.edtTitle.getText().toString())
                        .setParams("content", b.edtContent.getText().toString())
                        .sendPost("insert.bo", (isResult, data) -> {
                    if(isResult){
                        Toast.makeText(this, "글 등록 완료", Toast.LENGTH_SHORT).show();
                        startActivity(board_intent);
                    }else{
                        Log.d(TAG, " insert 실패 ");
                    }
                });
            }else{
                Log.d(TAG, "값 입력 필요");
                Toast.makeText(this, "제목, 내용을 모두 입력하세요", Toast.LENGTH_LONG).show();
            }
        }

    }


    //바인딩 비우기
    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }

}