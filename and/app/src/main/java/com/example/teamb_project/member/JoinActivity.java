package com.example.teamb_project.member;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDate();
        }
    };
    EditText id_et, pw_et, pw_ck_et, name_et, email_et,  phone_et;

    Toolbar top_toolbar;
    RadioGroup radioGroup2;
    TextView cancel_btn, confirm_btn, id_ck_tv , stud_tv ,teach_tv ,birth_tv;
    RadioButton  male_rd, female_rd;
    String type_result ="STUD", gender_result="남";
    int id_ck_cnt = 0;
    Pattern emailPatttern = Patterns.EMAIL_ADDRESS;
    ImageView imgv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //getSupportActionBar().hide();
        new Common().changeStatusBarColor(this);


        // 회원 정보
//        radioGroup1 = findViewById(R.id.radioGroup1);
//        stud_rd = findViewById(R.id.stud_rd);
//        teach_rd = findViewById(R.id.teach_rd);
        id_et = findViewById(R.id.id_et);
        pw_et = findViewById(R.id.pw_et);
        pw_ck_et = findViewById(R.id.pw_ck_et);
        name_et = findViewById(R.id.name_et);
        radioGroup2 = findViewById(R.id.radioGroup2);
        male_rd = findViewById(R.id.male_rd);
        female_rd = findViewById(R.id.female_rd);
        email_et = findViewById(R.id.email_et);
        birth_tv = findViewById(R.id.birth_tv);
        stud_tv = findViewById(R.id.stud_tv);
        teach_tv = findViewById(R.id.teach_tv);
        phone_et = findViewById(R.id.phone_et);
        imgv_back = findViewById(R.id.imgv_back);

        // 취소/확인 버튼
        cancel_btn = findViewById(R.id.cancel_btn);
        confirm_btn = findViewById(R.id.confirm_btn);
        stud_tv.setOnClickListener(v->{
            stud_tv.setTextColor(getResources().getColor(R.color.blue));
            teach_tv.setTextColor(getResources().getColor(R.color.grey));
            type_result = "STUD";
        });
        teach_tv.setOnClickListener(v->{
            teach_tv.setTextColor(getResources().getColor(R.color.blue));
            stud_tv.setTextColor(getResources().getColor(R.color.grey));
            type_result = "TEACH";
        });
        imgv_back.setOnClickListener(v->{
            finish();
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.male_rd){
                    gender_result = male_rd.getText().toString();
                }else if(checkedId == R.id.female_rd){
                    gender_result = female_rd.getText().toString();
                }
            }
        });

        birth_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(JoinActivity.this,
                        setDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // 취소 버튼
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // 확인 버튼
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("로그", "회원가입 확인버튼 누름 id_ck_cnt: " + id_ck_cnt);
                // 아이디 입력 확인
                if(id_et.getText().toString().isEmpty()){
                    Toast.makeText(JoinActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 입력한 비밀번호와 비밀번호 확인란 비교
                if(pw_et.getText().toString().isEmpty() || pw_ck_et.getText().toString().isEmpty()) {
                    Toast.makeText(JoinActivity.this, "비밀번호 또는 비밀번호 확인란를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if(! pw_et.getText().toString().equals(pw_ck_et.getText().toString())){
                        Toast.makeText(JoinActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                // 이름 입력 확인
                if(name_et.getText().toString().isEmpty()){
                    Toast.makeText(JoinActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 이메일 형식 확인
                if(! email_et.getText().toString().isEmpty()){
                    if(!emailPatttern.matcher(email_et.getText().toString()).matches()){
                        Toast.makeText(JoinActivity.this, "이메일형식이 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                        email_et.requestFocus();
                        return;
                    }
                }

                // 아이디 중복 확인 후 데이터 전송
                if(id_ck_cnt == 5){
                    MemberVO vo = new MemberVO();
                    vo.setType(type_result);
                    vo.setId(id_et.getText().toString());
                    vo.setPw(pw_et.getText().toString());
                    vo.setMember_name(name_et.getText().toString());
                    vo.setGender(gender_result);
                    vo.setEmail(email_et.getText().toString());
                    vo.setBirth(birth_tv.getText().toString());
                    vo.setPhone(phone_et.getText().toString());


                    new CommonMethod().setParams("member", new Gson().toJson(vo))
                            .sendPost("join.mj", new CommonMethod.CallBackResult() {
                                @Override
                                public void result(boolean isResult, String data) {
                                    Log.d("로그", "회원가입 확인버튼 누름 data 출력 : " + data);
                                    if(data == null || data.equals("null")){
                                        Toast.makeText(JoinActivity.this, "입력 값을 확인해주세요!", Toast.LENGTH_SHORT).show();
                                    } else{
                                        Toast.makeText(JoinActivity.this, "회원가입 완료!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                }//if()
                else{
                    Toast.makeText(JoinActivity.this, "아이디 중복확인을 해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 아이디 중복확인 버튼
        id_ck_tv = findViewById(R.id.id_ck_tv);
        id_ck_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이디 입력 안하고 아이디 중복확인 누르면
                if(id_et.getText().toString().length() < 1 ){
                    Toast.makeText(JoinActivity.this, "아이디를 입력 하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }//if()
                new CommonMethod().setParams("id",id_et.getText().toString())
                        .sendPost("idCheck.mj", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                Log.d("로그", "중복확인데이터: " + data);
                                if(data.equals("5") && id_et.getText() != null){
                                    Toast.makeText(JoinActivity.this, "사용가능한 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                    id_ck_cnt = 5;    // 아이디 중복 버튼 눌렀는지 확인
                                }else if(data.equals("-1")){
                                    Toast.makeText(JoinActivity.this, "중복된 아이디가 존재합니다.", Toast.LENGTH_SHORT).show();
                                    id_et.setText("");
                                }else {
                                    Log.d("로그", "오류");
                                }
                            }
                        });
            }
        });
    }//onCreate()

    // 날짜 형식 변환
    public void updateDate(){
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
        }
        birth_tv.setText(simpleDateFormat.format(myCalendar.getTime()));
    }//updateDate(
}