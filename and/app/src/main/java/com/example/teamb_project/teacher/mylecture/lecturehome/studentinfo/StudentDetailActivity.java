package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentAttendanceFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentHomeworkFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentTestresultFragment;
import com.google.android.material.tabs.TabLayout;

public class StudentDetailActivity extends AppCompatActivity {
    TabLayout tab_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        /*탭 레이아웃*/
        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("출결"));
        tab_layout.addTab(tab_layout.newTab().setText("과제"));
        tab_layout.addTab(tab_layout.newTab().setText("시험성적"));

        //프래그먼트처음 화면
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentAttendanceFragment()).commit();

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
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentAttendanceFragment()).commit();
                break ;
            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentHomeworkFragment()).commit();
                break ;
            case 2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentTestresultFragment()).commit();
                break ;

        }
    }

}