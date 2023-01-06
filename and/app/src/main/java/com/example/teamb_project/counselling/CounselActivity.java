package com.example.teamb_project.counselling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityCounselBinding;

public class CounselActivity extends AppCompatActivity {
    ActivityCounselBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCounselBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //어댑터 설정


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}