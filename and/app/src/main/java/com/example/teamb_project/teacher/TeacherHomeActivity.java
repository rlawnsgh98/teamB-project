package com.example.teamb_project.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.databinding.ActivityTeacherhomeBinding;
import com.example.teamb_project.student.StudentHomeActivity;
import com.example.teamb_project.board.BoardActivity;
import com.example.teamb_project.teacher.mylecture.MyLectureActivity;
import com.example.teamb_project.R;
import com.example.teamb_project.notice.NoticeActivity;

public class TeacherHomeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityTeacherhomeBinding t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        t= ActivityTeacherhomeBinding.inflate(getLayoutInflater());
        setContentView(t.getRoot());
        getSupportActionBar().hide();

        t.cvMylecture.setOnClickListener(this);
        t.cvNotice.setOnClickListener(this);
        t.cvBoard.setOnClickListener(this);
        t.cvConsult.setOnClickListener(this);
        t.cvAttendance.setOnClickListener(this);
        t.cvSchedule.setOnClickListener(this);

        t.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), StudentHomeActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        //내강의 조회
        if(v.getId()==R.id.cv_mylecture){
            Intent intent = new Intent(this, MyLectureActivity.class);
            startActivity(intent);
            //학원공지사항
        }else if(v.getId()==R.id.cv_notice){
            Intent intent = new Intent(this, NoticeActivity.class);
            startActivity(intent);
            //자유게시판
        }else if(v.getId()==R.id.cv_board){
            Intent intent = new Intent(this, BoardActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_consult){

        }else if(v.getId()==R.id.cv_attendance){

        }
        else if(v.getId()==R.id.cv_schedule){

        }
    }
}