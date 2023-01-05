package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;

public class StudentHomeworkFragment extends Fragment {
    RecyclerView recv_student_homework;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_student_homework, container, false);
        recv_student_homework = v.findViewById(R.id.recv_student_homework);
        recv_student_homework.setAdapter(new StudentHomeworkAdapter(inflater, getContext()));
        recv_student_homework.setLayoutManager(CommonMethod.getManager(getContext()));

        return v;
    }
}