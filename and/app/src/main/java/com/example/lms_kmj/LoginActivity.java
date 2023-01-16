package com.example.lms_kmj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lms_kmj.common.Common;
import com.example.lms_kmj.member.MemberVO;
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
        //ApiClient.setBASEURL("http://192.168.0.19/smart/");   // at_home
        ApiClient.setBASEURL("http://192.168.0.122/smart/");    // seat_pick

        id_et = findViewById(R.id.id_et);
        pw_et = findViewById(R.id.id_pw);
        login_tv = findViewById(R.id.login_tv);
        join_tv = findViewById(R.id.join_tv);
        find_tv = findViewById(R.id.find_tv);

        // 로그인 버튼
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams("id", id_et.getText().toString())
                        .setParams("pw", pw_et.getText().toString())
                        .sendPost("login.mj", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                Log.d("로그", "result:" + data);
                                if(data.equals("null")){
                                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    Common common = new Common();
                                    MemberVO account = new Gson().fromJson(data, MemberVO.class);
                                    common.setLoginInfo(account); // 로그인 정보 담기
                                    LoginInfo.check_id = account.getId();
                                    intent.putExtra("account", account+"");
                                    setResult(RESULT_OK, intent);
                                    startActivity(intent);
                                    finish();   // finish 하고 다음 화면(MainActivity)으로 이동
                                }
                            }
                        });

                /*
                // 로그인 없이 테스트 하려면
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();*/
            }
        });

        // 회원가입 버튼
        join_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });

        // 비밀번호 찾기 버튼
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