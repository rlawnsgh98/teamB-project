package com.example.teamb_project.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.board.BoardFragment;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.FragmentHomeBinding;
import com.example.teamb_project.notice.NoticeFragment;
import com.example.teamb_project.student.mylecture.StuLectureFragment;
import com.example.teamb_project.teacher.MyLectureFragment;
import com.example.teamb_project.vo.BoardVO;
import com.example.teamb_project.vo.LectureVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding b;
    HomeActivity activity;
    CommonMethod commonMethod = new CommonMethod();
    ArrayList<LectureVO> lecture_list;
    ArrayList<BoardVO> board_list;

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
            Fragment fragment = null;
            if(Common.loginInfo.getType().equals("STUD")) fragment = new StuLectureFragment();
            else fragment = new MyLectureFragment();
            activity.changeFragment(fragment, "내 강의");
        });
        b.tvCheck.setOnClickListener(v->{
            //출석 체크 연결
        });


        //자유게시판 리사이클러뷰
        commonMethod.sendPost("board_num.bo", (isResult, data) -> {

            board_list = new GsonBuilder().setDateFormat("yyyy.MM.dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
            b.recvBoard.setAdapter(new HomeBoardAdapter(inflater, board_list, getActivity()));
            b.recvBoard.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        });



        //내 강의 리사이클러뷰
        if(Common.loginInfo.getType().equals("STUD")){
            //학생
            commonMethod.setParams("id", Common.loginInfo.getMember_code())
                    .sendPost("stu_lecture_list.le", (isResult, data) -> {

                        lecture_list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<LectureVO>>(){}.getType());
                        b.recvLecture.setAdapter(new HomeLectureAdapter(inflater, lecture_list, getActivity()));
                        b.recvLecture.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
                    });
        }else if(Common.loginInfo.getType().equals("TEACH")){
            //강사
            commonMethod.setParams("id", Common.loginInfo.getMember_code())
                    .sendPost("teacher_lecture_list.le", (isResult, data) -> {

                        lecture_list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<LectureVO>>(){}.getType());
                        b.recvLecture.setAdapter(new HomeLectureAdapter(inflater, lecture_list, getActivity()));
                        b.recvLecture.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
                    });
        }


        return b.getRoot();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        b= null;
    }
}