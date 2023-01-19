package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.vo.ExamVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class StudentTestresultFragment extends Fragment {
    RecyclerView recv_student_testresult;
    String member_code;
    int lecture_code;
    ArrayList<ExamVO> list;

    public StudentTestresultFragment(String member_code, int lecture_code) {
        this.member_code = member_code;
        this.lecture_code = lecture_code;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student_test, container, false);

        recv_student_testresult = v.findViewById(R.id.recv_student_testresult);

        selectExam();
        return v;
    }

    void selectExam(){
        new com.example.conn.CommonMethod().setParams("member_code", member_code)
                .setParams("lecture_code", lecture_code)
                .sendPost("student_exam.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<List<ExamVO>>(){}.getType());

                        recv_student_testresult.setAdapter(new StudentTestresultAdapter(getLayoutInflater(), getContext(), list));
                        recv_student_testresult.setLayoutManager(CommonMethod.getManager(getContext()));
                    }
                });
    }
}