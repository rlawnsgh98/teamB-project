package com.example.teamb_project.counselling;

<<<<<<< HEAD
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

=======
>>>>>>> main
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.board.BoardActivity;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityCounselBinding;
import com.example.teamb_project.student.StudentHomeActivity;
import com.example.teamb_project.teacher.TeacherHomeActivity;
import com.example.teamb_project.vo.CounselVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityCounselBinding;
>>>>>>> main

import java.util.ArrayList;

public class CounselActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityCounselBinding b;
<<<<<<< HEAD
    CommonMethod commonMethod = new CommonMethod();
    Common common = new Common();
    CounselAdapter adapter;
=======
>>>>>>> main

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCounselBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

<<<<<<< HEAD
        //상담 목록 조회
        commonMethod.setParams("vo", common.getLoginInfo())
//                .setParams("type", common.getLoginInfo().getType())
                .sendPost("list.co", (isResult, data) -> {
                    Log.d("log", common.getLoginInfo().getMember_name() + "의 상담 목록");
                    //어댑터로 보내줄 ArrayList
                    ArrayList<CounselVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<CounselVO>>(){}.getType());
                    //어댑터 설정
                    adapter = new CounselAdapter(getLayoutInflater(), list, this);
                    b.recvCounsel.setAdapter(adapter);
                    b.recvCounsel.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
                });

        //클릭 이벤트
        b.ivPlus.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);
=======
        //어댑터로 보내줄 ArrayList
        ArrayList<Object> list = new ArrayList<>();

        //어댑터 설정
        b.recvCounsel.setAdapter(new CounselAdapter(getLayoutInflater(), list, this));
        b.recvCounsel.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        //클릭 이벤트
        b.ivPlus.setOnClickListener(this);

>>>>>>> main

    }

    @Override
    public void onClick(View v) {
<<<<<<< HEAD
        if(v.getId()==R.id.iv_plus){
            Intent intent = new Intent(CounselActivity.this, NewCounselActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.iv_back){
            //메인화면으로 이동
            Activity activity;
            if(common.getLoginInfo().getType()=="STUD") activity = new StudentHomeActivity();
            else activity = new TeacherHomeActivity();
            Intent intent = new Intent(CounselActivity.this, activity.getClass());
            startActivity(intent);
=======

        if(v.getId()==R.id.iv_plus){
            Intent intent = new Intent(CounselActivity.this, NewCounselActivity.class);
            startActivity(intent);
>>>>>>> main
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }


}