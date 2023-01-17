package com.example.teamb_project.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.teamb_project.LoginActivity;
import com.example.teamb_project.LoginInfo;
import com.example.teamb_project.R;
import com.example.teamb_project.TTActivity;
import com.example.teamb_project.counselling.CounselActivity;
import com.example.teamb_project.databinding.ActivityStudenthomeBinding;
import com.example.teamb_project.drawer.AcCalendarActivity;
import com.example.teamb_project.drawer.AcInfoActivity;
import com.example.teamb_project.drawer.MyInfoActivity;
import com.example.teamb_project.student.mylecture.stu_MyLectureActivity;
import com.example.teamb_project.teacher.TeacherHomeActivity;
import com.example.teamb_project.board.BoardActivity;
import com.example.teamb_project.notice.NoticeActivity;

public class StudentHomeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityStudenthomeBinding s;
    Toolbar top_toolbar;
    DrawerLayout drawerLayout;
    View drawerView;
    TextView myInfo_tv,acCalendar_tv,acInfo_tv,logout_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        s= ActivityStudenthomeBinding.inflate(getLayoutInflater());
        setContentView(s.getRoot());
        getSupportActionBar().hide();

//        s.logininfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("로그", "LoginInfo.check_id: "+ LoginInfo.check_id);
//            }
//        });
        top_toolbar = findViewById(R.id.top_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerView = findViewById(R.id.drawerView);
        myInfo_tv = findViewById(R.id.myInfo_tv);
        acCalendar_tv = findViewById(R.id.acCalendar_tv);
        acInfo_tv = findViewById(R.id.acInfo_tv);
        logout_tv = findViewById(R.id.logout_tv);
        s.cvBoard.setOnClickListener(this);
        s.cvNotice.setOnClickListener(this);
        s.cvMylecture.setOnClickListener(this);
        s.cvConsult.setOnClickListener(this);
        s.cvAttendance.setOnClickListener(this);
        s.cvSchedule.setOnClickListener(this);

        // 상단바
        top_toolbar.setTitle("홈");
        top_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.top_toolbar_more) {
                    drawerLayout.openDrawer(drawerView);
                }
                return true;
            }
        });

        // 서랍
        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        // 서랍 목록 - 내 정보, 학원 일정, 학원 소개, 로그아웃
        myInfo_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomeActivity.this, MyInfoActivity.class);
                startActivity(intent);
            }
        });
        acCalendar_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomeActivity.this, AcCalendarActivity.class);
                startActivity(intent);
            }
        });
        acInfo_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomeActivity.this, AcInfoActivity.class);
                startActivity(intent);
            }
        });
        logout_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomeActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //임시
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
            //상담화면 이동
            Intent intent = new Intent(StudentHomeActivity.this, CounselActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_attendance){

        }else if(v.getId()==R.id.cv_schedule){
            Intent intent = new Intent(StudentHomeActivity.this, TTActivity.class);
            startActivity(intent);
        }
    }

    // 서랍
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}