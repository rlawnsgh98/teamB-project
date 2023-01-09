package com.example.teamb_project.teacher.board;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityBoardDetailBinding;
import com.example.teamb_project.vo.BoardVO;
import com.example.teamb_project.vo.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BoardDetailActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBoardDetailBinding b;
    final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        b.linModify.setVisibility(View.GONE);   //수정,삭제 가리기
        Common common = new Common();
        CommonMethod commonMethod = new CommonMethod();
        Intent intent = getIntent();
        ApiClient.setBASEURL("http://192.168.0.115/middle/");

        //특정 게시판 정보 조회
        commonMethod.setParams("board_code", intent.getIntExtra("board_code", -1))
                .sendPost("info.bo", (isResult, data) -> {
                    if(isResult){
                        Log.d(TAG, "data : " + data);
                        BoardVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, BoardVO.class);
                        b.tvTitle.setText(vo.getTitle());
                        b.tvContent.setText(vo.getContent());
                        b.tvWriter.setText(vo.getMember_name());
                        b.tvWritedate.setText(vo.getWritedate().toString());
                        b.tvReadcnt.setText(vo.getReadcnt()+"");
                    }else{
                        Log.d(TAG, "조회 실패");
                    }
                });

        //해당 게시판 댓글 목록 조회
        commonMethod.setParams("board_code", intent.getIntExtra("board_code", -1))
                .sendPost("list.re", (isResult, data) -> {
                    if(isResult){
                        Log.d(TAG, "댓글 data : " + data);
                        //댓글 리스트 ArrayList
                        ArrayList<ReplyVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<ReplyVO>>(){}.getType());


                        //댓글 11개 이상일 경우 더보기 보이게 하기
                        b.linMore.setVisibility(View.GONE);
                        if(list.size() > 10){
                            b.linMore.setVisibility(View.VISIBLE);
                        }

                        //어댑터 설정 - 댓글
                        b.recvReply.setAdapter(new ReplyAdapter(getLayoutInflater(), list));
                        b.recvReply.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
                    }else{
                        Log.d(TAG, "댓글 목록 조회 실패");
                    }
                });

        //클릭이벤트
        b.ivBack.setOnClickListener(this);
        b.ivMore.setOnClickListener(this);
        b.tvDelete.setOnClickListener(this);
        b.tvModify.setOnClickListener(this);


    }

    //클릭
    @Override
    public void onClick(View v) {
        CommonMethod commonMethod = new CommonMethod();
        Intent intent = getIntent();    //BoardActivity 에서 받은 intent
        Intent board_intent = new Intent(BoardDetailActivity.this, BoardActivity.class);

        if(v.getId()== R.id.iv_back){
            onBackPressed();
        }else if(v.getId()==R.id.iv_more) {
            b.linModify.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.tv_delete){
            //삭제 처리 --> Dialog 써서 한번 더 묻기!!!! 나중에
            commonMethod.setParams("board_code", intent.getIntExtra("board_code", -1))
                    .sendPost("delete.bo", (isResult, data) -> {
                        if(isResult){
                            Log.d(TAG, "data : " + data);
                            startActivity(board_intent);
                        }else{
                            Log.d(TAG, " 삭제 실패 ");
                        }
                    });
        }else if(v.getId()==R.id.tv_modify){
            //수정할 페이지로 이동
            Intent modify_intent = new Intent(BoardDetailActivity.this, BoardModifyActivity.class);
            modify_intent.putExtra("title", b.tvTitle.getText().toString());
            modify_intent.putExtra("content", b.tvContent.getText().toString());
            modify_intent.putExtra("board_code", intent.getIntExtra("board_code", -1));
            startActivity(modify_intent);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }


}