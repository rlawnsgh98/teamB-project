package com.example.teamb_project.teacher.mylecture.lecturehome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.vo.LectureBoardVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class LectureHomeFragment extends Fragment {
    int lecture_code;

    public LectureHomeFragment(int lecture_code) {
        this.lecture_code = lecture_code;
    }

    TextView tv_lecture_teacher;
    MemberVO info;
    ArrayList<LectureBoardVO> list;
    RecyclerView recv_lecture_notice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lecture_home, container, false);

        tv_lecture_teacher = v.findViewById(R.id.tv_lecture_teacher);
        recv_lecture_notice = v.findViewById(R.id.recv_lecture_notice);
        selectTeacher(lecture_code);
        selectNotice();

        return v;

    }

    private void selectNotice() {
        new com.example.conn.CommonMethod().setParams("lecture_code", lecture_code)
                .sendPost("lecture_notice.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<List<LectureBoardVO>>() {
                        }.getType());

                        recv_lecture_notice.setAdapter(new LectureHomeAdapter(getLayoutInflater(), getContext(), list));
                        recv_lecture_notice.setLayoutManager(CommonMethod.getManager(getContext()));
                    }
                });
    }

    private void selectTeacher(int lecture_code) {
        new com.example.conn.CommonMethod().setParams("lecture_code", lecture_code)
                .sendPost("teacher_info.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        info = new Gson().fromJson(data, MemberVO.class);
                        tv_lecture_teacher.setText(info.getMember_name());
                    }
                });
    }

}