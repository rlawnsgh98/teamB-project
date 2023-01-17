package com.example.teamb_project.drawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.teamb_project.R;


public class AcInfoActivity extends AppCompatActivity {
    ImageView link_btn1,link_btn2;
    Toolbar top_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_info);
        getSupportActionBar().hide();

        top_toolbar = findViewById(R.id.top_toolbar);
        link_btn1 = findViewById(R.id.link_btn1);
        link_btn2 = findViewById(R.id.link_btn2);

        // 상단바
        top_toolbar.setTitle("학원 소개");

        // 상단바 뒤로가기 버튼
        top_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        link_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(myIntent);
            }
        });
        link_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/100"));
                startActivity(myIntent);
            }
        });
    }
}