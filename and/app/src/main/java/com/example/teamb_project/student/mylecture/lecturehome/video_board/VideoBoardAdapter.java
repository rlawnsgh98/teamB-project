package com.example.teamb_project.student.mylecture.lecturehome.video_board;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        final int idx = i;
        //h.tv_title.setText(list.get(idx).getTitle());

        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoDetailActivity.class);
                intent.putExtra("board_code", list.get(idx).getBoard_code());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_writer, tv_writedate;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_title = v.findViewById(R.id.tv_title);
            tv_writer = v.findViewById(R.id.tv_writer);
            tv_writedate = v.findViewById(R.id.tv_writedate);

        }
    }
}
