package com.example.teamb_project.counselling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityCounselDetailBinding;

public class CounselDetailActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityCounselDetailBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCounselDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //뒤로가기
        b.ivBack.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.iv_back){
            //뒤로가기 클릭
            Intent intent = new Intent(CounselDetailActivity.this, CounselActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}