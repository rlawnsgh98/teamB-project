package com.example.teamb_project.teacher.mylecture.lecturehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teamb_project.R;
import com.example.teamb_project.teacher.mylecture.MyLectureActivity;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureHomeFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureHomeworkFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureStudentFragment;
import com.google.android.material.tabs.TabLayout;

public class LectureDetailActivity extends AppCompatActivity {
    int lecture_code;
    TabLayout tab_layout;
    ImageView back;
    TextView lecture_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_detail);

        back = findViewById(R.id.imgv_back);
        lecture_name = findViewById(R.id.tv_lecture_name);
        lecture_name.setText(getIntent().getStringExtra("lecture_name"));

        lecture_code = getIntent().getIntExtra("lecture_code", 0);

        /*탭 레이아웃*/
        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("공지사항"));
        tab_layout.addTab(tab_layout.newTab().setText("수강생목록"));
        tab_layout.addTab(tab_layout.newTab().setText("과제관리"));

        //프래그먼트처음 화면
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureHomeFragment(lecture_code)).commit();

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

        //돌아가기
        back.setOnClickListener(v -> {
            Intent intent = new Intent(LectureDetailActivity.this, MyLectureActivity.class);
            startActivity(intent);
        });

    }

    private void changeView(int index) {

        switch (index) {
            case 0 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureHomeFragment(lecture_code)).commit();
                break ;
            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureStudentFragment(lecture_code)).commit();
                break ;
            case 2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureHomeworkFragment(lecture_code)).commit();
                break ;

        }
    }
}