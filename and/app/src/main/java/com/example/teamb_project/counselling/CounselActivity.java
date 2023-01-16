package com.example.teamb_project.counselling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityCounselBinding;

import java.util.ArrayList;

public class CounselActivity extends AppCompatActivity implements View.OnClickListener{
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
        b.recvCounsel.setAdapter(new CounselAdapter(getLayoutInflater(), list, this));
        b.recvCounsel.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

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