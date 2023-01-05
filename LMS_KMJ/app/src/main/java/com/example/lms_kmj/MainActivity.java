package com.example.lms_kmj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar top_toolbar;
    Button tt_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 상단바
        top_toolbar = findViewById(R.id.top_toolbar);
        top_toolbar.setTitle("홈");
        top_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.top_toolbar_more:
                        //Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        Intent intent = new Intent(MainActivity.this, MenuMoveActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        // 상단바 뒤로가기 버튼
        top_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // 앱 종료 됨..
                //Intent intent = new Intent(MainActivity.this, LoginActivity.class);   // 다시 로그인 화면으로 감.
                //startActivity(intent);
            }
        });

        // 간편 메뉴 버튼 - 시간표
        tt_btn = findViewById(R.id.tt_btn);
        tt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TTActivity.class);
                startActivity(intent);
            }
        });
    }
}