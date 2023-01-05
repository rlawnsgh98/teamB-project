package com.example.teamb_project.teacher.mylecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;

public class MyLectureActivity extends AppCompatActivity {
    RecyclerView recv_mylecture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lecture);

        recv_mylecture = findViewById(R.id.recv_mylecture);

        recv_mylecture.setAdapter(new MyLectureAdapter(getLayoutInflater(), this));
        recv_mylecture.setLayoutManager(CommonMethod.getManager(this));
    }
}