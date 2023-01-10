package com.example.teamb_project.teacher.mylecture.lecturehome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;

public class LectureHomeworkFragment extends Fragment {
    RecyclerView recv_lecture_homework;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_lecture_homework, container, false);
        recv_lecture_homework = v.findViewById(R.id.recv_lecture_homework);
        recv_lecture_homework.setAdapter(new LectureHomeworkAdapter(inflater, getContext()));
        recv_lecture_homework.setLayoutManager(CommonMethod.getManager(getContext()));
        return v;
    }
}