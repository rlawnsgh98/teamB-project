package com.example.teamb_project.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.Lecture.MyLectureActivity;
import com.example.teamb_project.R;

public class TeacherHomeActivity extends AppCompatActivity {
    CardView cv_mylecture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherhome);

        cv_mylecture = findViewById(R.id.cv_mylecture);

        cv_mylecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MyLectureActivity.class));
            }
        });

    }
}