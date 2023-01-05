package com.example.teamb_project.teacher.mylecture.lecturehome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureHomeFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureHomeworkFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureStudentFragment;
import com.google.android.material.tabs.TabLayout;

public class LectureDetailActivity extends AppCompatActivity {

    TabLayout tab_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_detail);


        /*탭 레이아웃*/
        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("강의홈"));
        tab_layout.addTab(tab_layout.newTab().setText("수강생목록"));
        tab_layout.addTab(tab_layout.newTab().setText("과제관리"));

        //프래그먼트처음 화면
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureHomeFragment()).commit();

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int idx = tab_layout.getSelectedTabPosition();
                changeView(idx);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void changeView(int index) {

        switch (index) {
            case 0 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureHomeFragment()).commit();
                break ;
            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureStudentFragment()).commit();
                break ;
            case 2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureHomeworkFragment()).commit();
                break ;

        }
    }
}