package com.example.teamb_project.student.chulhuyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.teamb_project.R;

public class ChulActivity extends AppCompatActivity {


    Button chul, chulhuyn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chul);

        chul = findViewById(R.id.chul);
        chulhuyn = findViewById(R.id.chulhuyn);
        getSupportFragmentManager().beginTransaction().replace(R.id.chulfrg, new ChulFragment()).commit();


        chul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChulActivity.this, ScanQR.class);
                startActivity(intent);
            }
        });
        chulhuyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.chulfrg, new ChulFragment()).commit();
            }
        });

    }
}