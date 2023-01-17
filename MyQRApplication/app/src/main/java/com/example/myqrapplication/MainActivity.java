package com.example.myqrapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TimePicker;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button createQRBtn;
    private Button scanQRBtn;
    Button btn_selectDate, btn_selectTime;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextClock textClock;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiClient.setBASEURL("http://192.168.0.10/middle/");
        CommonMethod commonMethod = new CommonMethod();

        createQRBtn = (Button) findViewById(R.id.createQR);
        scanQRBtn = (Button) findViewById(R.id.scanQR);
        btn_selectTime = findViewById(R.id.btn_selectTime);
        btn_selectDate = findViewById(R.id.btn_selectDate);
        textClock = findViewById(R.id.textClock);

        createQRBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CreateQR.class);
                startActivity(intent);
            }
        });

        scanQRBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

        btn_selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btn_selectTime) {
                    final Calendar c = Calendar.getInstance();
                    int a = c.get(Calendar.HOUR);
                    int b = c.get(Calendar.MINUTE);

                    TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    btn_selectTime.setText(String.format("%02d:%02d",hourOfDay, minute));
                                }
                            },a, b, false);
                    timePickerDialog.show();


                }
            }
        });

    }



}