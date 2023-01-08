package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.teamb_project.student.StudentHomeActivity;
import com.example.teamb_project.vo.MemberVO;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
    TextView join_tv,login_tv,find_tv;
    TextInputEditText id_et, pw_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // IP 설정
        ApiClient.setBASEURL("http://210.123.231.86//smart/");

        id_et = findViewById(R.id.id_et);
        pw_et = findViewById(R.id.id_pw);

        // 로그인 버튼
        login_tv = findViewById(R.id.login_tv);
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams("id", id_et.getText().toString())
                        .setParams("pw", pw_et.getText().toString())
                        .sendPost("login1.mj", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                MemberVO vo = new Gson().fromJson(data, MemberVO.class);
                                Log.d("로그", "result:" + vo.getPw());

                                if(pw_et.getText().toString().equals(vo.getPw())){
                                    Intent intent = new Intent(LoginActivity.this, StudentHomeActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 틀립니다", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        // 회원가입 버튼
        join_tv = findViewById(R.id.join_tv);
        join_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });

        // 비밀번호 찾기 버튼
        find_tv = findViewById(R.id.find_tv);
        find_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, FindActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate()

    // 앱 종료 : 뒤로가기 버튼 연속 2번 누르면
    long pressedTime = 0;
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() > pressedTime + 2000){
            pressedTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "'뒤로'한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        }
    }
}