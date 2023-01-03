package com.example.teamb_project.Lecture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;


public class LectureStudentFragment extends Fragment {
    RecyclerView recv_student;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lecture_student, container, false);

        recv_student = v.findViewById(R.id.recv_student);
        recv_student.setAdapter(new LectureStudentAdapter(inflater, getContext()));
        recv_student.setLayoutManager(CommonMethod.getManager(getContext()));

        return v;

    }
}