package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.vo.AttendanceVO;
import com.example.teamb_project.vo.HomeworkVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkFragment extends Fragment {
    int  lecture_code;
    String member_code;
    public StudentHomeworkFragment(String member_code, int lecture_code) {
        this.member_code = member_code;
        this.lecture_code = lecture_code;
    }

    RecyclerView recv_student_homework;
    ArrayList<HomeworkVO> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_student_homework, container, false);
        recv_student_homework = v.findViewById(R.id.recv_student_homework);

        selectHomework();
        return v;
    }

    void selectHomework(){
        new com.example.conn.CommonMethod().setParams("lecture_code", lecture_code)
                .setParams("member_code", member_code)
                .sendPost("student_homework.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<List<HomeworkVO>>(){}.getType());

                        recv_student_homework.setAdapter(new StudentHomeworkAdapter(getLayoutInflater(), getContext(), list));
                        recv_student_homework.setLayoutManager(CommonMethod.getManager(getContext()));
                    }
                });
    }
}