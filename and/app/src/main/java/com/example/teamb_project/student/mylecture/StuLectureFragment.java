package com.example.teamb_project.student.mylecture;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.databinding.FragmentStuLectureBinding;
import com.example.teamb_project.vo.LectureVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class StuLectureFragment extends Fragment {
    FragmentStuLectureBinding b;
    ArrayList<LectureVO> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentStuLectureBinding.inflate(inflater,container,false);

        //"수강중인 강의 없습니다" 안보이게
        b.card.setVisibility(View.GONE);
        if(Common.loginInfo.getType().equals("TEACH")) b.tvLectureTitle.setText("진행중인 강의가 없습니다.");

        selectLectureList();
        return b.getRoot();
    }

    private void selectLectureList(){
        new com.example.conn.CommonMethod()
                .setParams("id", Common.loginInfo.getMember_code())
                .sendPost("stu_lecture_list.le", (isResult, data) -> {
                    list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<List<LectureVO>>(){}.getType());
                    if(list == null || list.size()==0){
                        b.card.setVisibility(View.VISIBLE);
                    }
                    b.recvMylecture.setAdapter(new Stu_MyLectureAdapter(getLayoutInflater(), getContext(), list));
                    b.recvMylecture.setLayoutManager(CommonMethod.getManager(getContext()));

                });
    }
}