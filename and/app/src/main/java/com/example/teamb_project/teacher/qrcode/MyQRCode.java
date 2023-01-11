package com.example.teamb_project.teacher.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.google.zxing.integration.android.IntentIntegrator;

public class MyQRCode extends AppCompatActivity {
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qrcode);
    }
}