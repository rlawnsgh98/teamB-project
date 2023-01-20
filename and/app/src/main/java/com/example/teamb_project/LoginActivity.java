package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.student.StudentHomeActivity;
import com.example.teamb_project.teacher.TeacherHomeActivity;
import com.example.teamb_project.vo.MemberVO;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginActivity extends AppCompatActivity {
    TextView join_tv,login_tv,find_tv;
    EditText id_et, pw_et;

    Common common = new Common();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();



        new Common().changeStatusBarColor(this);


        // IP 설정
        ApiClient.setBASEURL("http://192.168.0.30/middle/");
        //집
//        ApiClient.setBASEURL("http://210.123.231.86/middle/");

        id_et = findViewById(R.id.id_et);
        pw_et = findViewById(R.id.et_pw);

        // 로그인 버튼
        login_tv = findViewById(R.id.login_tv);
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams("id", id_et.getText().toString())
                        .setParams("pw", pw_et.getText().toString())
                        .sendPost("login.mj", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                if(isResult) {
                                    MemberVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, MemberVO.class);
                                    //로그인 정보 저장
                                    common.loginInfo = vo;
                                    if (vo != null) {
                                        if(vo.getType().equals("STUD")){
                                            Intent intent = new Intent(LoginActivity.this, StudentHomeActivity.class);
                                            startActivity(intent);
                                        }else if(vo.getType().equals("TEACH")){
                                            Intent intent = new Intent(LoginActivity.this, TeacherHomeActivity.class);
                                            startActivity(intent);
                                        }

                                    } else {
                                        Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 틀립니다", Toast.LENGTH_SHORT).show();
                                    }
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
//        find_tv = findViewById(R.id.find_tv);
//        find_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, FindActivity.class);
//                startActivity(intent);
//            }
//        });
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