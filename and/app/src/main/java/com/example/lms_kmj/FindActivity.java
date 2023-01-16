package com.example.lms_kmj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lms_kmj.member.MemberVO;

public class FindActivity extends AppCompatActivity {
    Toolbar top_toolbar;
    EditText pw_find_et1, pw_find_et2;
    TextView pw_find_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        top_toolbar = findViewById(R.id.top_toolbar);
        pw_find_et1 = findViewById(R.id.pw_find_et1);
        pw_find_et2 = findViewById(R.id.pw_find_et2);
        pw_find_tv = findViewById(R.id.pw_find_tv);

        top_toolbar.setTitle("");

        // 상단바 뒤로가기 버튼
        top_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        pw_find_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemberVO vo = new MemberVO();
                vo.setId(pw_find_et1.getText().toString());
                vo.setEmail(pw_find_et2.getText().toString());
            }
        });
    }
}