package com.example.teamb_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
    final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        Log.d(TAG, "onCreate: ");
        Common common = new Common();

        //리사이클러뷰에 들어갈 데이터 List
        ArrayList<Object> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add("");
        }

        //글이 11개 이상일 경우 더보기 보이게 하기
        b.linMore.setVisibility(View.GONE);
        if(list.size() > 10){
            b.linMore.setVisibility(View.VISIBLE);
        }

        //클릭이벤트
        b.ivSearch.setOnClickListener(this);
        b.cardGoTop.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);
        b.ivWrite.setOnClickListener(this);

        //리사이클러뷰 스크롤 이벤트
        b.scrBoard.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(@NonNull NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//               Log.d(TAG, "MaxScrollAmount: "+v.getMaxScrollAmount());   //최대 스크롤값
//                Log.d(TAG, "scrollY: "+scrollY);   //
//               if(b.recvBoard.canScrollVertically(1)) Log.d(TAG, "onScrollChange: 최하단ㅇㄴㅇㄹㄴㄷㄹ");;
                ViewGroup.LayoutParams params = b.scrBoard.getLayoutParams();
                int contentHeight = b.scrBoard.getHeight();
                if (scrollY + params.height >= contentHeight) {
                    // The user has reached the bottom of the scrollable view
                    Log.d(TAG, "최하단 입니당");
                }
            }
        });


        //스피너 설정
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.spinner_category, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        b.spinner.setAdapter(adapter);

        b.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //선택됐을때
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //선택x
            }
        });

        //EditText 입력이벤트
//        b.edtSearch.addTextChangedListener(common.getTextWatcher(b.ivTextRemove));

        //스크롤 내리면 아이콘 보이게
        common.scrollTop(b.scrBoard, b.cardGoTop);

        //어댑터 설정
        b.recvBoard.setAdapter(new BoardAdapter(getLayoutInflater(), list, this));
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