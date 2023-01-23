package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentAttendanceFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentHomeworkFragment;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentTestresultFragment;
import com.example.teamb_project.vo.MemberVO;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class StudentDetailActivity extends AppCompatActivity {
    int lecture_code;
    String student_code;
    TabLayout tab_layout;
    TextView tv_student_name, tv_student_phone;
    MemberVO info;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        back = findViewById(R.id.iv_back);
        back.setOnClickListener( v -> {
            onBackPressed();
        });

        //선택한 학생의 멤버코드
        student_code = getIntent().getStringExtra("student_code");
        lecture_code = getIntent().getIntExtra("lecture_code", -1);

        tv_student_name = findViewById(R.id.tv_student_name);
        tv_student_phone = findViewById(R.id.tv_student_phone);

        new CommonMethod().setParams("member_code", student_code).sendPost("member_info", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
//                info = new Gson().fromJson(data, new TypeToken<MemberVO>(){}.getType());
                info = new Gson().fromJson(data, MemberVO.class);
                tv_student_name.setText(info.getMember_name());
                tv_student_phone.setText(info.getPhone());
            }
        });

        /*탭 레이아웃*/
        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("출결"));
        tab_layout.addTab(tab_layout.newTab().setText("과제"));
        tab_layout.addTab(tab_layout.newTab().setText("시험성적"));

        //프래그먼트처음 화면
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentAttendanceFragment(student_code,lecture_code)).commit();

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
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentAttendanceFragment(student_code, lecture_code)).commit();
                break ;
            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentHomeworkFragment(student_code, lecture_code)).commit();
                break ;
            case 2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new StudentTestresultFragment(student_code, lecture_code)).commit();
                break ;

        }
    }

}