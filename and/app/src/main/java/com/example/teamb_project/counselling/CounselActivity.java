package com.example.teamb_project.counselling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityCounselBinding;

import java.util.ArrayList;

public class CounselActivity extends AppCompatActivity {
    ActivityCounselBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCounselBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //어댑터로 보내줄 ArrayList
        ArrayList<Object> list = new ArrayList<>();

        //어댑터 설정
        b.recvCounsel.setAdapter(new CounselAdapter(getLayoutInflater(), list));
        b.recvCounsel.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}