package com.example.teamb_project.student.mylecture.lecturehome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityStuLectureDetailBinding;
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
        getSupportActionBar().hide();


        lecture_code = getIntent().getIntExtra("lecture_code", 0);

        //탭레이아웃-프래그먼트전환
        d.tabLayout.addTab(d.tabLayout.newTab().setText("강의홈"));
        d.tabLayout.addTab(d.tabLayout.newTab().setText("강의영상"));

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new stu_LectureHomeFragment(lecture_code)).commit();
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
            //돌아가기
            onBackPressed();
        });

    }
    private void changeView(int index) {
        switch (index) {
            case 0 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new stu_LectureHomeFragment(lecture_code)).commit();
                break ;
            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new VideoBoardFragment(lecture_code)).commit();
                break ;

        }
    }



}