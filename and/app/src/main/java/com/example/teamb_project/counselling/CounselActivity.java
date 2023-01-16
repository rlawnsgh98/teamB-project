package com.example.teamb_project.counselling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityCounselBinding;
import com.example.teamb_project.vo.BoardVO;
import com.example.teamb_project.vo.CounselVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CounselActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityCounselBinding b;
    CommonMethod commonMethod = new CommonMethod();
    Common common = new Common();
    CounselAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCounselBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        commonMethod.setParams("member_code", common.getLoginInfo().getMember_code())
                .setParams("type", common.getLoginInfo().getType())
                .sendPost("list.co", (isResult, data) -> {
//                    Log.d("log", common.getLoginInfo().getMember_name() + "의 상담 목록");
                    //어댑터로 보내줄 ArrayList
                    ArrayList<CounselVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<CounselVO>>(){}.getType());
                    //어댑터 설정
                    adapter = new CounselAdapter(getLayoutInflater(), list, this);
                    b.recvCounsel.setAdapter(adapter);
                    b.recvCounsel.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
                });

        //클릭 이벤트
        b.ivPlus.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.iv_plus){
            Intent intent = new Intent(CounselActivity.this, NewCounselActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }


}