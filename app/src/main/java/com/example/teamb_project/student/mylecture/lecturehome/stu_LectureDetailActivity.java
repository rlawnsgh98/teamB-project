package com.example.teamb_project.student.mylecture.lecturehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityStuLectureDetailBinding;
import com.example.teamb_project.student.mylecture.Stu_MyLectureActivity;
import com.example.teamb_project.student.mylecture.lecturehome.video_board.VideoBoardFragment;
import com.google.android.material.tabs.TabLayout;

public class Stu_LectureDetailActivity extends AppCompatActivity {
    ActivityStuLectureDetailBinding d;
    //stu_Mylecture 에서 lecture_code를 받아준 후 fragment에 전달
    int lecture_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = ActivityStuLectureDetailBinding.inflate(getLayoutInflater());
        setContentView(d.getRoot());


        lecture_code = getIntent().getIntExtra("lecture_code", 0);

        //탭레이아웃-프래그먼트전환
        d.tabLayout.addTab(d.tabLayout.newTab().setText("공지사항"));
        d.tabLayout.addTab(d.tabLayout.newTab().setText("출결관리"));
        d.tabLayout.addTab(d.tabLayout.newTab().setText("강의영상"));

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Stu_LectureHomeFragment(lecture_code)).commit();
        d.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int idx = d.tabLayout.getSelectedTabPosition();
                changeView(idx);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        d.ivBack.setOnClickListener(v -> {
            //강의목록으로 이동
            Intent intent = new Intent(Stu_LectureDetailActivity.this, Stu_MyLectureActivity.class);
            startActivity(intent);
        });

    }
    private void changeView(int index) {
        switch (index) {
            case 0 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Stu_LectureHomeFragment(lecture_code)).commit();
                break ;
            case 1 :
                //출결 관리
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Stu_AttendanceFragment(lecture_code)).commit();
                break ;
            case 2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new VideoBoardFragment(lecture_code)).commit();
                break ;

        }
    }



}