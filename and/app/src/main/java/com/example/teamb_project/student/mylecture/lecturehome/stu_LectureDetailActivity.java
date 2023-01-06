package com.example.teamb_project.student.mylecture.lecturehome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityLectureDetailBinding;
import com.example.teamb_project.databinding.ActivityStuLectureDetailBinding;
import com.example.teamb_project.databinding.ActivityStudentDetailBinding;
import com.example.teamb_project.databinding.ActivityStudenthomeBinding;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureHomeFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureHomeworkFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureStudentFragment;
import com.google.android.material.tabs.TabLayout;

public class stu_LectureDetailActivity extends AppCompatActivity {
    ActivityStuLectureDetailBinding d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = ActivityStuLectureDetailBinding.inflate(getLayoutInflater());
        setContentView(d.getRoot());

        d.tabLayout.addTab(d.tabLayout.newTab().setText("강의홈"));
        d.tabLayout.addTab(d.tabLayout.newTab().setText("강의영상"));

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new stu_LectureHomeFragment()).commit();

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
    }
    private void changeView(int index) {

        switch (index) {
            case 0 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new stu_LectureHomeFragment()).commit();
                break ;
            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new stu_LectureVideoFragment()).commit();
                break ;


        }
    }
}