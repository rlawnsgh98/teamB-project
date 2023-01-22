package com.example.teamb_project.counselling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityCounselBinding;
import com.example.teamb_project.databinding.FragmentCounselBinding;
import com.example.teamb_project.student.StudentHomeActivity;
import com.example.teamb_project.teacher.TeacherHomeActivity;
import com.example.teamb_project.vo.CounselVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class CounselFragment extends Fragment implements View.OnClickListener {
    FragmentCounselBinding b;
    CommonMethod commonMethod = new CommonMethod();
    Common common = new Common();
    CounselAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        b = FragmentCounselBinding.inflate(inflater,container,false);

        commonMethod.setParams("vo", common.getLoginInfo())
//                .setParams("type", common.getLoginInfo().getType())
                .sendPost("list.co", (isResult, data) -> {
                    Log.d("log", common.getLoginInfo().getMember_name() + "의 상담 목록");
                    //어댑터로 보내줄 ArrayList
                    ArrayList<CounselVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<CounselVO>>(){}.getType());
                    //어댑터 설정
                    adapter = new CounselAdapter(getLayoutInflater(), list, getActivity());
                    b.recvCounsel.setAdapter(adapter);
                    b.recvCounsel.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                });

        //클릭 이벤트
        b.ivPlus.setOnClickListener(this);
        return b.getRoot();
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.iv_plus){
            Intent intent = new Intent(getActivity(), NewCounselActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        b = null;
    }
}