package com.example.teamb_project.student.mylecture.lecturehome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.databinding.FragmentStuLectureHomeBinding;


public class stu_LectureHomeFragment extends Fragment {
    FragmentStuLectureHomeBinding h;
    RecyclerView recv_lecture_notice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        h=FragmentStuLectureHomeBinding.inflate(inflater);
        View v = inflater.inflate(R.layout.fragment_stu__lecture_home, container, false);

        recv_lecture_notice = v.findViewById(R.id.recv_lecture_notice);
        recv_lecture_notice.setAdapter(new stu_LectureHomeAdapter(inflater, getContext()));
        recv_lecture_notice.setLayoutManager(CommonMethod.getManager(getContext()));
//        h.recvLectureNotice.setAdapter(new stu_LectureHomeAdapter(inflater, getContext()));
//        h.recvLectureNotice.setLayoutManager(CommonMethod.getManager(getContext()));

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        h=null;
    }
}