package com.example.teamb_project.student.mylecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.teacher.mylecture.MyLectureAdapter;

public class stu_MyLectureActivity extends AppCompatActivity {
    RecyclerView recv_mylecture;
    Button logininfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_my_lecture);

        logininfo = findViewById(R.id.logininfo);
        logininfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();

                String s = intent.getStringExtra("logininfo");
                Log.d("TAG", "onClick: "+s);
            }
        });

        recv_mylecture = findViewById(R.id.recv_mylecture);

        recv_mylecture.setAdapter(new stu_MyLectureAdapter(getLayoutInflater(), this));
        recv_mylecture.setLayoutManager(CommonMethod.getManager(this));
    }
}