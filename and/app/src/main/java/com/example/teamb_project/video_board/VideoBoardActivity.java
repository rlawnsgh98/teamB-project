package com.example.teamb_project.video_board;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.databinding.ActivityVideoBoardBinding;

public class VideoBoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityVideoBoardBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityVideoBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        CommonMethod common = new CommonMethod();

        common.setSpinner(b.spinner, this);


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