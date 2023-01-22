package com.example.teamb_project.teacher;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.databinding.FragmentMyLectureBinding;
import com.example.teamb_project.teacher.mylecture.MyLectureActivity;
import com.example.teamb_project.teacher.mylecture.MyLectureAdapter;
import com.example.teamb_project.vo.LectureVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MyLectureFragment extends Fragment {
    FragmentMyLectureBinding b;
    ArrayList<LectureVO> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentMyLectureBinding.inflate(inflater,container,false);
        selectLectureList();
        return b.getRoot();
    }
    private void selectLectureList(){
        new com.example.conn.CommonMethod()
                .setParams("id", Common.loginInfo.getMember_code())
                .sendPost("teacher_lecture_list.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<List<LectureVO>>(){}.getType());

                        b.recvMylecture.setAdapter(new MyLectureAdapter(getLayoutInflater(), getContext(), list));
                        b.recvMylecture.setLayoutManager(CommonMethod.getManager(getContext()));
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        b = null;
    }
}