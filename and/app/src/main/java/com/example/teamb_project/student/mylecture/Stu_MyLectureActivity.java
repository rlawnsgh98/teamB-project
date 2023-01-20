package com.example.teamb_project.student.mylecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.student.StudentHomeActivity;
import com.example.teamb_project.vo.LectureVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Stu_MyLectureActivity extends AppCompatActivity {
    RecyclerView recv_mylecture;
    ArrayList<LectureVO> list;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_my_lecture);
        getSupportActionBar().hide();
        recv_mylecture = findViewById(R.id.recv_mylecture);
        back = findViewById(R.id.iv_back);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(Stu_MyLectureActivity.this, StudentHomeActivity.class);
            startActivity(intent);
        });

        MemberVO vo = Common.loginInfo;

        selectLectureList();
    }

    private void selectLectureList(){
        new com.example.conn.CommonMethod()
                .setParams("id", Integer.parseInt(Common.loginInfo.getMember_code()))
                .sendPost("stu_lecture_list.le", (isResult, data) -> {
                list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<List<LectureVO>>(){}.getType());

                recv_mylecture.setAdapter(new Stu_MyLectureAdapter(getLayoutInflater(), Stu_MyLectureActivity.this, list));
                recv_mylecture.setLayoutManager(CommonMethod.getManager(Stu_MyLectureActivity.this));

        });
    }
}