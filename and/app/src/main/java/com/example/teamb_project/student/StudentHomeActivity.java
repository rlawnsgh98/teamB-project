package com.example.teamb_project.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityStudenthomeBinding;
import com.example.teamb_project.student.chulhuyn.ChulActivity;
import com.example.teamb_project.student.mylecture.stu_MyLectureActivity;
import com.example.teamb_project.teacher.TeacherHomeActivity;
import com.example.teamb_project.teacher.board.BoardActivity;
import com.example.teamb_project.teacher.notice.NoticeActivity;

public class StudentHomeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityStudenthomeBinding s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        s= ActivityStudenthomeBinding.inflate(getLayoutInflater());
        setContentView(s.getRoot());

        s.logininfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();

                String s = intent.getStringExtra("logininfo");
                Log.d("TAG", "onClick: "+s);
            }
        });

        s.cvBoard.setOnClickListener(this);
        s.cvNotice.setOnClickListener(this);
        s.cvMylecture.setOnClickListener(this);
        s.cvConsult.setOnClickListener(this);
        s.cvAttendance.setOnClickListener(this);
        s.cvSchedule.setOnClickListener(this);


        s.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TeacherHomeActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cv_mylecture){
            Intent i = getIntent();
            String logininfo = i.getStringExtra("logininfo");

            Intent intent = new Intent(this, stu_MyLectureActivity.class);
            intent.putExtra("logininfo", logininfo);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_notice){
            Intent intent = new Intent(this, NoticeActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_board){
            Intent intent = new Intent(this, BoardActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_consult){

        }else if(v.getId()==R.id.cv_attendance){
            Intent intent = new Intent(this, ChulActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_schedule){

        }
    }
}