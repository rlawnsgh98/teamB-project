package com.example.teamb_project.student.mylecture.lecturehome.video_board;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityVideoBoardBinding;

public class VideoBoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityVideoBoardBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityVideoBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();


        getSupportFragmentManager().beginTransaction().replace(R.id.container, new VideoBoardFragment()).commit();

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