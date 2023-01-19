package com.example.teamb_project.counselling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityNewCounselBinding;

public class NewCounselActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewCounselBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewCounselBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //클릭이벤트
        b.cardBack.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //상담목록으로
        Intent intent_counsel = new Intent(NewCounselActivity.this, CounselActivity.class);

        if(v.getId()== R.id.iv_back){
            //뒤로가기 클릭시
            startActivity(intent_counsel);
        }else if(v.getId()==R.id.card_back){
            //취소 클릭시
            startActivity(intent_counsel);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }


}