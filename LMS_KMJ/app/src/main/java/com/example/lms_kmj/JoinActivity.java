package com.example.lms_kmj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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
    TextInputEditText editDate_et;
    Toolbar top_toolbar;
    Button cancel_btn, confirm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //상단바
        top_toolbar = findViewById(R.id.top_toolbar);
        top_toolbar.setTitle("회원가입");
        top_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.top_toolbar_more:
                        Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        top_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //생년월일
        editDate_et = findViewById(R.id.editDate_et);
        editDate_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(JoinActivity.this,
                        setDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // 취소 버튼
        cancel_btn = findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // 확인 버튼
        confirm_btn = findViewById(R.id.confirm_btn);
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }//onCreate()

    //날짜 형식 변환
    public void updateDate(){
        String format = "YYYY/MM/dd";
        SimpleDateFormat simpleDateFormat = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
        }
        editDate_et.setText(simpleDateFormat.format(myCalendar.getTime()));
    }//updateDate()
}