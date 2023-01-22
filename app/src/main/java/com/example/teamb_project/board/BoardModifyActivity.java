package com.example.teamb_project.board;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityBoardModifyBinding;

public class BoardModifyActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBoardModifyBinding b;
    final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardModifyBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        Intent getIntent = getIntent();
        //원글 정보 저장
        b.edtTitle.setText(getIntent.getStringExtra("title"));
        b.edtContent.setText(getIntent.getStringExtra("content"));

        //클릭이벤트
        b.ivBack.setOnClickListener(this);
        b.cardBack.setOnClickListener(this);
        b.cardInsert.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //자유게시판으로 이동하는 Intent
        Intent board_intent = new Intent(BoardModifyActivity.this, BoardActivity.class);
        Intent getIntent = getIntent();

        CommonMethod commonMethod = new CommonMethod();

        if(v.getId()== R.id.iv_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_insert){
            //글 등록처리
            if(!TextUtils.isEmpty(b.edtTitle.getText().toString()) && !TextUtils.isEmpty(b.edtContent.getText().toString())){
                //제목, 내용 입력함
                commonMethod.setParams("board_code", getIntent.getIntExtra("board_code", -1))
                        .setParams("title", b.edtTitle.getText().toString())
                        .setParams("content", b.edtContent.getText().toString())
                        .sendPost("update.bo", (isResult, data) -> {
                            if(isResult){
                                Toast.makeText(this, "수정 완료", Toast.LENGTH_SHORT).show();
                                startActivity(board_intent);
                            }else{
                                Log.d(TAG, " update 실패 ");
                            }
                        });
            }else{
                Log.d(TAG, "값 입력 필요");
                Toast.makeText(this, "제목, 내용을 모두 입력하세요", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}