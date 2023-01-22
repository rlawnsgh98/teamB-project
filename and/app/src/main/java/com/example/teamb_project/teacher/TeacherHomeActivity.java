package com.example.teamb_project.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.conn.CommonMethod;
import com.example.teamb_project.member.LoginActivity;
import com.example.teamb_project.teacher.notice.NoticeActivity;
import com.example.teamb_project.timetable.TTActivity;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.counselling.CounselActivity;
import com.example.teamb_project.databinding.ActivityTeacherhomeBinding;
import com.example.teamb_project.drawer.AcCalendarActivity;
import com.example.teamb_project.drawer.AcInfoActivity;
import com.example.teamb_project.board.BoardActivity;
import com.example.teamb_project.teacher.mylecture.MyLectureActivity;
import com.example.teamb_project.R;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.GsonBuilder;

public class TeacherHomeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityTeacherhomeBinding t;
    DrawerLayout drawerLayout;
    View drawerView;
    TextView myInfo_tv,acCalendar_tv,acInfo_tv,logout_tv;
    Toolbar top_toolbar;

    CommonMethod commonMethod = new CommonMethod();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        t= ActivityTeacherhomeBinding.inflate(getLayoutInflater());
        setContentView(t.getRoot());

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerView = findViewById(R.id.drawerView);
        top_toolbar = findViewById(R.id.top_toolbar);
        myInfo_tv = findViewById(R.id.myInfo_tv);
        acCalendar_tv = findViewById(R.id.acCalendar_tv);
        acInfo_tv = findViewById(R.id.acInfo_tv);
        logout_tv = findViewById(R.id.logout_tv);
        t.cvMylecture.setOnClickListener(this);
        t.cvNotice.setOnClickListener(this);
        t.cvBoard.setOnClickListener(this);
        t.cvConsult.setOnClickListener(this);
        t.cvAttendance.setOnClickListener(this);
        t.cvSchedule.setOnClickListener(this);

        //프로필사진 적용
        ImageView profile = drawerView.findViewById(R.id.iv_profile);
        commonMethod.setParams("member_code", Common.loginInfo.getMember_code())
                .sendPost("my_info_code", (isResult, data) -> {
                    MemberVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, MemberVO.class);
                    Common.loginInfo = vo;
                    Glide.with(this).load(Common.loginInfo.getProfilepath()).into(profile);
                });

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

            }
        });
        acCalendar_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherHomeActivity.this, AcCalendarActivity.class);
                startActivity(intent);
            }
        });
        acInfo_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherHomeActivity.this, AcInfoActivity.class);
                startActivity(intent);
            }
        });
        logout_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherHomeActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        //내강의 조회
        if(v.getId()==R.id.cv_mylecture){

            //학원공지사항
        }else if(v.getId()==R.id.cv_notice){

            //자유게시판
        }else if(v.getId()==R.id.cv_board){

        }else if(v.getId()==R.id.cv_consult){
            //상담화면 이동
            Intent intent = new Intent(TeacherHomeActivity.this, CounselActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.cv_attendance){

        }
        else if(v.getId()==R.id.cv_schedule){
            Intent intent = new Intent(TeacherHomeActivity.this, TTActivity.class);
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