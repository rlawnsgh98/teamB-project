package com.example.teamb_project.notice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityNewNoticeBinding;

public class NewNoticeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewNoticeBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewNoticeBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());


    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }


}