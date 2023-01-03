package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamb_project.databinding.ActivityBoardBinding;

public class BoardActivity extends AppCompatActivity {
    ActivityBoardBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());



    }
}