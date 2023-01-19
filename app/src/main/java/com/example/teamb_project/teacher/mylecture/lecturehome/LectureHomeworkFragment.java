package com.example.teamb_project.teacher.mylecture.lecturehome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentHomeworkAdapter;
import com.example.teamb_project.vo.HomeworkVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class LectureHomeworkFragment extends Fragment {
    RecyclerView recv_lecture_homework;
    int lecture_code;
    ArrayList<HomeworkVO> list;

    public LectureHomeworkFragment(int lecture_code) {
        this.lecture_code = lecture_code;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_lecture_homework, container, false);
        recv_lecture_homework = v.findViewById(R.id.recv_lecture_homework);
        selectHomework();

        return v;
    }

    void selectHomework(){
        new com.example.conn.CommonMethod().setParams("lecture_code", lecture_code)
                .sendPost("lecture_homework.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<List<HomeworkVO>>(){}.getType());

                        recv_lecture_homework.setAdapter(new LectureHomeworkAdapter(getLayoutInflater(), getContext(), list));
                        recv_lecture_homework.setLayoutManager(CommonMethod.getManager(getContext()));
                    }
                });
    }
}