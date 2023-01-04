package com.example.teamb_project.Lecture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;


public class LectureHomeFragment extends Fragment {

    RecyclerView recv_lecture_notice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lecture_home, container, false);


        recv_lecture_notice = v.findViewById(R.id.recv_lecture_notice);
        recv_lecture_notice.setAdapter(new LectureHomeAdapter(inflater, getContext()));
        recv_lecture_notice.setLayoutManager(CommonMethod.getManager(getContext()));

        return v;

    }
}