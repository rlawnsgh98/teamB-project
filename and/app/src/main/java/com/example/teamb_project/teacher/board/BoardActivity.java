package com.example.teamb_project.teacher.board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.teamb_project.MainActivity;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityBoardBinding;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBoardBinding b;
    final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        Log.d(TAG, "onCreate: ");
        Common common = new Common();
        CommonMethod commonMethod = new CommonMethod();
        //임시로그인
        common.setTempLoginInfo();

        ApiClient.setBASEURL("http://192.168.0.115/middle/");

        commonMethod.sendPost("list.bo", (isResult, data) -> {
            if(isResult){
                //리사이클러뷰에 들어갈 데이터 List
                ArrayList<BoardVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());

                //글이 11개 이상일 경우 더보기 보이게 하기 -> 보여줄 아이템이 남아있으면 보이게
                b.linMore.setVisibility(View.GONE);
                if(list == null){
                    if(list.size() > 10){
                        b.linMore.setVisibility(View.VISIBLE);
                    }
                }

                //어댑터 설정
                b.recvBoard.setAdapter(new BoardAdapter(getLayoutInflater(), list, this));
                b.recvBoard.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            }else{
                Log.d(TAG, " 실패 ");
            }


        });



        //클릭이벤트
        b.ivSearch.setOnClickListener(this);
        b.cardGoTop.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);
        b.ivWrite.setOnClickListener(this);


        //스피너 설정
        common.setSpinner(b.spinner, this);

        //EditText 입력이벤트
//        b.edtSearch.addTextChangedListener(common.getTextWatcher(b.ivTextRemove));

        //스크롤 내리면 아이콘 보이게
        common.scrollTop(b.scrBoard, b.cardGoTop);


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
            onBackPressed();
        }else if(v.getId()==R.id.iv_write){
            //글 작성
            Intent intent = new Intent(BoardActivity.this, NewBoardActivity.class);
            startActivity(intent);
        }
    }

    //onResume?
    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }

}