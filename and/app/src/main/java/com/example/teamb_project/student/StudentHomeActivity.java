package com.example.teamb_project.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamb_project.LoginInfo;
import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityStudenthomeBinding;
import com.example.teamb_project.student.mylecture.stu_MyLectureActivity;
import com.example.teamb_project.teacher.TeacherHomeActivity;
import com.example.teamb_project.board.BoardActivity;
import com.example.teamb_project.notice.NoticeActivity;

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
                Log.d("๋ก๊ทธ", "LoginInfo.check_id: "+ LoginInfo.check_id);
            }
        });

        s.cvBoard.setOnClickListener(this);
        s.cvNotice.setOnClickListener(this);
        s.cvMylecture.setOnClickListener(this);
        s.cvConsult.setOnClickListener(this);
        s.cvAttendance.setOnClickListener(this);
        s.cvSchedule.setOnClickListener(this);

        //์์
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
            Intent intent = new Intent(this, stu_MyLectureActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_notice){
            Intent intent = new Intent(this, NoticeActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_board){
            Intent intent = new Intent(this, BoardActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_consult){

        }else if(v.getId()==R.id.cv_attendance){

        }else if(v.getId()==R.id.cv_schedule){

        }
    }
}