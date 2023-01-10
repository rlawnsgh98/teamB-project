package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;


public class StudentTestresultFragment extends Fragment {
    RecyclerView recv_student_testresult;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student_test, container, false);

        recv_student_testresult = v.findViewById(R.id.recv_student_testresult);
        recv_student_testresult.setAdapter(new StudentTestresultAdapter(inflater, getContext()));
        recv_student_testresult.setLayoutManager(CommonMethod.getManager(getContext()));
        return v;
    }
}