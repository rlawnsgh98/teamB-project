package com.example.teamb_project.teacher.mylecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.teamb_project.LoginInfo;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.student.mylecture.stu_MyLectureActivity;
import com.example.teamb_project.student.mylecture.stu_MyLectureAdapter;
import com.example.teamb_project.vo.LectureVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MyLectureActivity extends AppCompatActivity {
    RecyclerView recv_mylecture;
    ArrayList<LectureVO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lecture);
        getSupportActionBar().hide();

        recv_mylecture = findViewById(R.id.recv_mylecture);

        selectLectureList();
        Log.d("TAG", "onCreate: "+ list);
    }

    private void selectLectureList(){
        new com.example.conn.CommonMethod()
                .setParams("id", Common.loginInfo.getMember_code())
                .sendPost("teacher_lecture_list.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        list = new Gson().fromJson(data, new TypeToken<List<LectureVO>>(){}.getType());

                        recv_mylecture.setAdapter(new MyLectureAdapter(getLayoutInflater(), MyLectureActivity.this, list));
                        recv_mylecture.setLayoutManager(CommonMethod.getManager(MyLectureActivity.this));
                    }
                });
    }
}