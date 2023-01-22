package com.example.teamb_project.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamb_project.R;
import com.example.teamb_project.board.BoardFragment;
import com.example.teamb_project.databinding.FragmentHomeBinding;
import com.example.teamb_project.notice.NoticeFragment;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding b;
    HomeActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentHomeBinding.inflate(inflater,container,false);
        activity = (HomeActivity) getActivity();
        b.tvNotice.setOnClickListener(v->{
            //공지사항 연결
            activity.changeFragment(new NoticeFragment() , "공지사항");
        });

        b.tvBoard.setOnClickListener(v->{
            //자유게시판 연결
            activity.changeFragment(new BoardFragment() , "자유게시판");
        });

        b.cardVideo.setOnClickListener(v->{
            //동영상 강의 연결
        });
        b.tvCheck.setOnClickListener(v->{
            //출석 체크 연결
        });

        return b.getRoot();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        b= null;
    }
}