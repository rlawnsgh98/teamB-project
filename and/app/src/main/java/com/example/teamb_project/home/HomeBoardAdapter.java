package com.example.teamb_project.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.board.BoardDetailActivity;
import com.example.teamb_project.vo.BoardVO;

import java.util.ArrayList;

public class HomeBoardAdapter extends RecyclerView.Adapter<HomeBoardAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<BoardVO> list;
    Activity activity;

    public HomeBoardAdapter(LayoutInflater inflater, ArrayList<BoardVO> list, Activity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_home_board, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.title.setText(list.get(i).getTitle());
        h.writer.setText(list.get(i).getMember_name());
        h.writeDate.setText(list.get(i).getWritedate().toString());
        //게시판 상세화면 이동
        h.board.setOnClickListener(v -> {
            Intent intent = new Intent(activity, new BoardDetailActivity().getClass());
            intent.putExtra("board_code", list.get(i).getBoard_code());
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, writer, writeDate;
        LinearLayout board;

        public ViewHolder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.title);
            writer = v.findViewById(R.id.writer);
            writeDate = v.findViewById(R.id.writeDate);
            board = v.findViewById(R.id.lin_board);
        }
    }
}
