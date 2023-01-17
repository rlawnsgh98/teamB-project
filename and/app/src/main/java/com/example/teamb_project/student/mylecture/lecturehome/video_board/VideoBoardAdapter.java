package com.example.teamb_project.student.mylecture.lecturehome.video_board;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

        //특정 강의영상 클릭
        h.video.setOnClickListener(v -> {
            Log.d("log", "강의영상 code : " + list.get(i).getBoard_code());
            Intent intent = new Intent(context, VideoDetailActivity.class);
            intent.putExtra("board_code", list.get(i).getBoard_code());
            context.startActivity(intent);
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
        LinearLayout video;
        public ViewHolder(@NonNull View v) {
            super(v);
            video = v.findViewById(R.id.lin_video);
        }

    }
}
