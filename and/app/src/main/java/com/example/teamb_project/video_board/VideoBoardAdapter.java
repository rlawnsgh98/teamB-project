package com.example.teamb_project.video_board;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardVO;

import java.util.ArrayList;

public class VideoBoardAdapter extends RecyclerView.Adapter<VideoBoardAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<BoardVO> list;
    Context context;

    public VideoBoardAdapter(LayoutInflater inflater, ArrayList<BoardVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_video_board, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        //특정 강의영상 게시글 클릭
        h.board.setOnClickListener(v -> {
            Intent intent = new Intent();
        });
    }

    @Override
    public int getItemCount() {
        return 12;
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout board;
        public ViewHolder(@NonNull View v) {
            super(v);
            board = v.findViewById(R.id.lin_board);
        }
    }
}
