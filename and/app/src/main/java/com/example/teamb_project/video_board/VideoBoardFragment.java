package com.example.teamb_project.video_board;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.FragmentVideoBoardBinding;

import java.util.ArrayList;

public class VideoBoardFragment extends Fragment {
    FragmentVideoBoardBinding b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentVideoBoardBinding.inflate(inflater);

        Common common = new Common();
        common.setSpinner(b.spinner, getContext());

        //어댑터에 보낼 ArrayList
        ArrayList<Object> list = new ArrayList<>();

        //어댑터 설정
        b.recvVideoBoard.setAdapter(new VideoBoardAdapter(inflater, list));
        b.recvVideoBoard.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        return b.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        b = null;
    }
}