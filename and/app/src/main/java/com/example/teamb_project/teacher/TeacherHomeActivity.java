package com.example.teamb_project.teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.MainActivity;
import com.example.teamb_project.TessstActivity;
import com.example.teamb_project.databinding.ActivityTeacherhomeBinding;
import com.example.teamb_project.teacher.board.BoardActivity;
import com.example.teamb_project.teacher.board.BoardDetailActivity;
import com.example.teamb_project.teacher.mylecture.MyLectureActivity;
import com.example.teamb_project.R;
import com.example.teamb_project.teacher.notice.NoticeActivity;

public class TeacherHomeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityTeacherhomeBinding t;
   //CardView cv_mylecture, cv_notice, cv_board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        t=ActivityTeacherhomeBinding.inflate(getLayoutInflater());
        setContentView(t.getRoot());

        t.cvBoard.setOnClickListener(this);
        t.cvNotice.setOnClickListener(this);
        t.cvMylecture.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cv_mylecture){
            Intent intent = new Intent(this, MyLectureActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_notice){
            Intent intent = new Intent(this, NoticeActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_board){
            Intent intent = new Intent(this, BoardActivity.class);
            startActivity(intent);
        }
    }
}